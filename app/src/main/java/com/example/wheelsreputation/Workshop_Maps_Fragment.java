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

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
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
                    if (getContext() != null) {

                        googleMap.clear();
                        LatLng sydney = new LatLng(location.getLatitude() , location.getLongitude());
                        googleMap.addMarker(new MarkerOptions().position(sydney).title("Your location").icon(bitmapDescriptorworkshop(getContext() , R.drawable.bikers_image)));
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney , 15));

                        // team of helpers for bikers

                        LatLng mobileMec1 = new LatLng(-33.938618 , 18.704792);
                        googleMap.addMarker(new MarkerOptions().position(mobileMec1).title("your mecanic").icon(bitmapDescriptorworkshop(getContext() , R.drawable.mecanic)));


                        LatLng workshop1 = new LatLng(-33.931698 , 18.704492);
                        googleMap.addMarker(new MarkerOptions().position(workshop1).title("your workshop").icon(bitmapDescriptorworkshop(getContext() , R.drawable.worksshop_icon_map)));


                        LatLng sellerPoint1 = new LatLng(-33.939798 , 18.704292);
                        googleMap.addMarker(new MarkerOptions().position(sellerPoint1).title("shop").icon(bitmapDescriptorworkshop(getContext() , R.drawable.ic_baseline_storefront_24)));

                        LatLng pickUpDrivers = new LatLng(-33.935798 , 18.704992);
                        googleMap.addMarker(new MarkerOptions().position(pickUpDrivers).title("pick up truck").icon(bitmapDescriptorworkshop(getContext() , R.drawable.pick_up_drivers)));

                    }
                }
            };

            googleMap.clear();
            LatLng sydney = new LatLng(-33.937618 , 18.705192);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("here is your location").icon(bitmapDescriptorworkshop(getContext() , R.drawable.bikers_image)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney , 15));



            if (ContextCompat.checkSelfPermission(getContext() , Manifest.permission.ACCESS_FINE_LOCATION)
                    == (PackageManager.PERMISSION_GRANTED)) {


                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER , 60000 , 5 , locationListener);


            } else if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {

                showReasonForPermission("Permission Needed!" , "This spermission is needed to provide the services around your location for quick response.\n\r  \n\r Do you accept?" , Manifest.permission.ACCESS_FINE_LOCATION);


            } else {

                requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION);

            }

  /*
            // only activate this if ther eis no data ana dlocation servies actif
            showReasonForPermission("Permission needed!","Please activate your data and location for better experience.\n\r Do you want to activate? ",Manifest.permission.ACCESS_FINE_LOCATION);

   */
        }

    };


        //multiple pointers in one screen (not working yet)
        public void pointers(LatLng sydney) {


            LatLng mecanic = new LatLng(-33.937918 , 18.605492);


            ArrayList<Marker> markers = new ArrayList<>();

            markers.add(
                    googleMap.addMarker(new MarkerOptions().position(sydney).title("mobile mecanic")
                            .icon(bitmapDescriptorworkshop(getContext() , R.drawable.bikers_image))));
            markers.add(
                    googleMap.addMarker(new MarkerOptions().position(mecanic).title("workshop")
                            .icon(bitmapDescriptorworkshop(getContext() , R.drawable.worksshop_icon_map))));

            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (Marker marker : markers) {

                builder.include(marker.getPosition());

            }
            LatLngBounds bounds = builder.build();

            int padding = 100;

            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds , padding);

            googleMap.animateCamera(cameraUpdate);
        }


        //image descriptor for markers
        private BitmapDescriptor bitmapDescriptorworkshop(Context context , int mobile_mecanic) {

            Drawable drawableVector = ContextCompat.getDrawable(getContext() , mobile_mecanic);

            Objects.requireNonNull(drawableVector).setBounds(0 , 0 , drawableVector.getIntrinsicWidth() , drawableVector.getIntrinsicHeight());

            Bitmap bitmap = Bitmap.createBitmap(drawableVector.getIntrinsicWidth() , drawableVector.getIntrinsicHeight() , Bitmap.Config.ARGB_8888);

            Canvas canva = new Canvas(bitmap);

            drawableVector.draw(canva);

            return BitmapDescriptorFactory.fromBitmap(bitmap);

        }

        @SuppressLint("MissingPermission")
        private ActivityResultLauncher<String> requestPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission() ,
                isGranted -> {

                    if (isGranted) {

                        // continue the action in your app

                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER , 5000 , 5 , locationListener);



                    } else {

                        // explain that the permission is needed
                        // to access a feature required by the user but dont block him out

                        ActivityCompat.shouldShowRequestPermissionRationale(getActivity() , Manifest.permission.ACCESS_FINE_LOCATION);
                    }

                });

        public void showReasonForPermission(String title , String message , String permission) {

            new AlertDialog.Builder(getContext()).setIcon(android.R.drawable.ic_dialog_alert).
                    setTitle(title).setMessage(message).
                    setPositiveButton("YES" , new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface , int i) {

                            requestPermissionLauncher.launch(permission);

                            Toast.makeText(getContext() , "Thank You! :)" , Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("NO" , null).show();

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