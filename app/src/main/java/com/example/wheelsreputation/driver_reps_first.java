package com.example.wheelsreputation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.startapp.sdk.ads.nativead.NativeAdDetails;
import com.startapp.sdk.ads.nativead.NativeAdPreferences;
import com.startapp.sdk.ads.nativead.StartAppNativeAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.StartAppSDK;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;

import java.util.ArrayList;
import java.util.List;




public class driver_reps_first extends Fragment {

    List<Model_class> test_class = new ArrayList<>();

    RecyclerView recyclerReputation;

    adapter_reputation_list mAdapterReputation;

    RecyclerView.LayoutManager layoutManagerReputation;

    StartAppNativeAd startAppNativeAd;


    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_driver_reps_first , container , false);

        //declaration of components

        recyclerReputation = view.findViewById(R.id.reputataion_list_recyclerView);


        fillNativeAdvertList();
        test_class.add(new Model_class(Model_class.layout_one_reputation_list_layout , "Mohamed Brahi" , "Tygervalley" , R.drawable.reputation_clipart , 4.5f));
        test_class.add(new Model_class(Model_class.layout_one_reputation_list_layout , "Jean Jacques" , "Pinelands" , R.drawable.backgroung_reputation , 2.0f));
        test_class.add(new Model_class(Model_class.layout_one_reputation_list_layout , "Alain Mpela" , "Constantia" , R.drawable.reputation_sticker , 3.3f));


        //recycle view of the drivers reputation

        recyclerReputation.setHasFixedSize(true);

        layoutManagerReputation = new LinearLayoutManager(getContext());

        recyclerReputation.setLayoutManager(layoutManagerReputation);

        mAdapterReputation = new adapter_reputation_list(getContext() , test_class);

        recyclerReputation.setAdapter(mAdapterReputation);

        return view;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //declaration of attributes

        getActivity().setTitle("Drivers Reputation");


    }

    private List<Model_class> getListData() {

        //test_class.clear(); // Cleared

        ArrayList<NativeAdDetails> nativeAdsList = startAppNativeAd.getNativeAds();
        if (nativeAdsList.size() > 0) {

            for (int x = 0; x <= nativeAdsList.size(); x++) {

                NativeAdDetails nativeAd = nativeAdsList.get(x);

                // Adding
                test_class.add(new Model_class(Model_class.layout_two_reputation_list_advert_layout , nativeAd));
                Log.i("test class adv" , String.valueOf(test_class.size()));

                mAdapterReputation.notifyDataSetChanged(); // Notify

            }

        }


        return test_class;
    }

    public void fillNativeAdvertList() {


        StartAppSDK.init(getContext() , "202574047" , false);
        StartAppSDK.setTestAdsEnabled(false);

        startAppNativeAd = new StartAppNativeAd(getContext());

        // Declare Native Ad Preferences
        NativeAdPreferences nativePrefs = new NativeAdPreferences()
                .setAdsNumber(3)                // Load 3 Native Ads
                .setAutoBitmapDownload(true)    // Retrieve Images object
                // secondary image gives the icon adn primary image gives the background picture
                .setSecondaryImageSize(3);      // 340x340 image

        // Declare Ad Callbacks Listener
        AdEventListener adListener = new AdEventListener() { // Callback Listener
            @Override
            public void onReceiveAd(@NonNull Ad ad) {
                // Native Ad received

                getListData();

            }

            @Override
            public void onFailedToReceiveAd(@Nullable Ad ad) {

                // Native Ad failed to receive
                Log.e("advert falied!!" , "Error while loading Ad");
            }


        };

        // Load Native Ads
        startAppNativeAd.loadAd(nativePrefs , adListener);


    }



}