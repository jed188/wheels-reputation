package com.example.wheelsreputation;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Objects;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Workshop_Maps_Fragment extends Fragment {

    GoogleMap googleMap;

    LocationManager locationManager;

    LocationListener locationListener;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {


        @Override
        public void onMapReady(GoogleMap googleMap) {

            locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);

            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(@NonNull Location location) {
                    if(getContext()!= null) {

                        googleMap.clear();
                        LatLng sydney = new LatLng(location.getLatitude() , location.getLongitude());
                        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").icon(bitmapDescriptorworkshop(getContext() , R.drawable.mobile_mecanic)));
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney , 15));

                    }
                }
            };

                googleMap.clear();
                LatLng sydney = new LatLng(-33.937618 , 18.605192);
                googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").icon(bitmapDescriptorworkshop(getContext() , R.drawable.mobile_mecanic)));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney , 15));


            if (ContextCompat.checkSelfPermission(getContext() , Manifest.permission.ACCESS_FINE_LOCATION)
                    == (PackageManager.PERMISSION_GRANTED)) {



                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER , 5000 , 3 , locationListener);


            } else if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)){

                showReasonForPermission("Permission Needed!","we need this permission to provide the best service near you.\n\r  \n\r Do you accept?",Manifest.permission.ACCESS_FINE_LOCATION);


            } else {

                requestPermissionLauncher.launch(new String[]{Manifest.permission.ACCESS_FINE_LOCATION ,
                        Manifest.permission.ACCESS_COARSE_LOCATION});

            }

        }


    };

    private BitmapDescriptor bitmapDescriptorworkshop(Context context , int mobile_mecanic) {

        Drawable drawableVector = ContextCompat.getDrawable(getContext() , mobile_mecanic);

        Objects.requireNonNull(drawableVector).setBounds(0 , 0 , drawableVector.getIntrinsicWidth() , drawableVector.getIntrinsicHeight());

        Bitmap bitmap = Bitmap.createBitmap(drawableVector.getIntrinsicWidth() , drawableVector.getIntrinsicHeight() , Bitmap.Config.ARGB_8888);

        Canvas canva = new Canvas(bitmap);

        drawableVector.draw(canva);

        return BitmapDescriptorFactory.fromBitmap(bitmap);

    }

    @SuppressLint("MissingPermission")
    private ActivityResultLauncher<String[]> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions() ,
            result -> {

                Boolean fineLocationGranted = result.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION , false);
                Boolean coarseLocationGranted = result.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION , false);


                if (fineLocationGranted && coarseLocationGranted) {

                    // continue the action in your app

                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER , 5000 , 3 , locationListener);



                } else{

            // explain that the permission is needed
            // to access a feature required by the user but dont block him out

                    ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),Manifest.permission.ACCESS_FINE_LOCATION);
                }

    });

    public void showReasonForPermission(String title,String message,String permission){

        new AlertDialog.Builder(getContext()).setIcon(android.R.drawable.ic_dialog_alert).
                setTitle(title). setMessage(message).
                setPositiveButton("YES" , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface , int i) {

                        requestPermissionLauncher.launch(new String[]{permission,
                                Manifest.permission.ACCESS_COARSE_LOCATION});

                        Toast.makeText(getContext() , "Thank You! :)",Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("NO",null).show();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater ,
                             @Nullable ViewGroup container ,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_workshop__maps_ , container , false);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view , @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view , savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}