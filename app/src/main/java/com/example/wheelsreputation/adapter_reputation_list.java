package com.example.wheelsreputation;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.startapp.sdk.ads.nativead.NativeAd;
import com.startapp.sdk.ads.nativead.NativeAdDetails;
import com.startapp.sdk.ads.nativead.StartAppNativeAd;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.wheelsreputation.Model_class.layout_five_stolen_bike_layout;
import static com.example.wheelsreputation.Model_class.layout_four_spare_part_advert_layout;
import static com.example.wheelsreputation.Model_class.layout_nine_no_value_layout;
import static com.example.wheelsreputation.Model_class.layout_one_reputation_list_layout;
import static com.example.wheelsreputation.Model_class.layout_seven_driver_history_advert_layout;
import static com.example.wheelsreputation.Model_class.layout_six_stolen_bike_advert_layout;
import static com.example.wheelsreputation.Model_class.layout_three_spare_part_layout;
import static com.example.wheelsreputation.Model_class.layout_two_reputation_list_advert_layout;

public class adapter_reputation_list extends RecyclerView.Adapter {

    Context context;

   // static List<NativeAdDetails> nativeAdDetailsList;

    List<Model_class> list_of_data;


    public adapter_reputation_list(Context context , List<Model_class> list_of_data) {
        this.context = context;
        this.list_of_data = list_of_data;
    }


    @Override
    public int getItemViewType(int position) {
        switch (list_of_data.get(position).getViewType()) {

            case 1:
                return layout_one_reputation_list_layout;


            case 2:
                return layout_two_reputation_list_advert_layout;


            default:
                return -2; // this value will never be used
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        switch (viewType) {

            case layout_one_reputation_list_layout:
                View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.reputation_list_layout , parent , false);
                return new MyReputationListHolder(rowView);

            case layout_two_reputation_list_advert_layout:
                View rowView1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.reputation_list_advert_layout , parent , false);
                return new MyReputationListAdvertHolder(rowView1);

            default:
                return new BaseAdapter(new View(context));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder , int position) {

        switch (list_of_data.get(position).getViewType()) {

            case layout_one_reputation_list_layout:
                String text = list_of_data.get(position).getDriver_name();
                String text1 = list_of_data.get(position).getDriver_location();
                Float rating = list_of_data.get(position).getDriver_rating();
                int face = list_of_data.get(position).getDriver_face();

                ((MyReputationListHolder) holder).setViews(text , text1 , rating , face);
                break;

            case layout_two_reputation_list_advert_layout:
                NativeAdDetails ad = list_of_data.get(position).getAds();

                if (ad != null) {

                    ((MyReputationListAdvertHolder) holder).setViews(ad);

                }
                break;

            default:
                ((BaseAdapter) holder).setViews();
        }

    }

    @Override
    public int getItemCount() {

        int result = 0;


        for (int i = 0; i < list_of_data.size(); i++) {
            if (list_of_data.get(i).getViewType() == layout_one_reputation_list_layout) {
                result++;
            }

            if (list_of_data.get(i).getViewType() == layout_two_reputation_list_advert_layout) {
                result++;
            }
        }
        Log.i("value of getItemCount" , String.valueOf(result));

        return result;


    }

    public class MyReputationListHolder extends RecyclerView.ViewHolder {

        TextView driver_name_textView2_reputation_list;

        TextView driver_location_textView2_reputation_list;

        ImageView driver_face;

        RatingBar driverRatingReputationList;

        ConstraintLayout constraintLayout_reputation_list;


        public MyReputationListHolder(@NonNull View itemView) {
            super(itemView);


            driverRatingReputationList = itemView.findViewById(R.id.ratingBar_reputation_list);

            driver_name_textView2_reputation_list = itemView.findViewById(R.id.driver_name_reputation_list);

            driver_location_textView2_reputation_list = itemView.findViewById(R.id.location_reputation_list);

            driver_face = itemView.findViewById(R.id.imageView_reputation_list);

            constraintLayout_reputation_list = itemView.findViewById(R.id.constraintLayout_reputation_list);


            constraintLayout_reputation_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // not working currently
                    v.getContext().startActivity(new Intent(v.getContext() , driver_history_class.class));
                }
            });

        }

        private void setViews(String text , String text2 , Float rating , int face) {

            driverRatingReputationList.setRating(rating);
            driver_name_textView2_reputation_list.setText(text);
            driver_location_textView2_reputation_list.setText(text2);
            driver_face.setImageResource(face);
        }
    }


    public class MyReputationListAdvertHolder extends RecyclerView.ViewHolder {

        TextView advert_title;
        TextView advert_description;
        ImageView advert_URL_imageView;
        RatingBar advert_rating;
        Button advert_button_text;


        public MyReputationListAdvertHolder(@NonNull View itemView) {
            super(itemView);


            advert_title = itemView.findViewById(R.id.advert_title_reputation_list);

            advert_description = itemView.findViewById(R.id.advert_description_reputation_list);

            advert_URL_imageView = itemView.findViewById(R.id.advert_imageView_reputation_list);

            advert_rating = itemView.findViewById(R.id.advert_ratingBar_reputation_list2);

            advert_button_text = itemView.findViewById(R.id.advert_button_reputation_list);

            advert_button_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    itemView.performClick();

                    Log.i("campaign action value" , "item clicked!!");
                }
            });

        }

        public void setViews(NativeAdDetails ad) {

            advert_URL_imageView.setImageBitmap(ad.getSecondaryImageBitmap());
            advert_title.setText(ad.getTitle());
            advert_description.setText(ad.getDescription());
            advert_button_text.setText(ad.getCallToAction());
            advert_rating.setRating(ad.getRating());

            //option needed to activate the handling of ckicks bty the start.io
            //the view passed through will be performing the onclick function
            ad.registerViewForInteraction(itemView);

        }

    }

    public class BaseAdapter extends RecyclerView.ViewHolder {


        public BaseAdapter(@NonNull View itemView) {
            super(itemView);
        }

        private void setViews() {


        }

    }


}
