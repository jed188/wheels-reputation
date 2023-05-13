package com.example.wheelsreputation;

import com.startapp.sdk.ads.nativead.NativeAdDetails;
import com.startapp.sdk.ads.nativead.StartAppNativeAd;

public class Model_class {

    public static final int layout_one_reputation_list_layout = 1;
    public static final int layout_two_reputation_list_advert_layout = 2;
    public static final int layout_three_spare_part_layout = 3;
    public static final int layout_four_spare_part_advert_layout = 4;
    public static final int layout_five_stolen_bike_layout = 5;
    public static final int layout_six_stolen_bike_advert_layout = 6;
    public static final int layout_seven_driver_history_layout = 7;
    public static final int layout_seven_driver_history_advert_layout = 8;
    public static final int layout_nine_no_value_layout = 9;



    private final int viewType;

    //for layout one and two
    private String driver_name, driver_location,ad_2_text,ad_2_description, ad_2_button_text;
    private int driver_face,ad_2_image;
    private float driver_rating,ad_2_rating;

    //for layout three and four
    private String description, size, make, model;
    private int part_image;

    //for layout five and six
    private String owner_number, owner_name, plate_number,owner_note;
    private int bike_image;

    //for layout seven and eight
    private String  start_date, end_date;

    //for layout eight
    private NativeAdDetails ads;


    //for layout_one
    public Model_class(int viewType , String driver_name , String driver_location , int driver_face , float driver_rating) {
        this.viewType = viewType;
        this.driver_name = driver_name;
        this.driver_location = driver_location;
        this.driver_face = driver_face;
        this.driver_rating = driver_rating;
    }

    //for layout_two

    public Model_class(int viewType , NativeAdDetails ads) {
        this.viewType = viewType;
        this.ads = ads;
    }

    //for layout three
    public Model_class(int viewType , String description , String size , String make , String model , int part_image) {
        this.viewType = viewType;
        this.description = description;
        this.size = size;
        this.make = make;
        this.model = model;
        this.part_image = part_image;
    }

    //for layout five
    public Model_class(int viewType , String driver_name , String make , String model , String owner_number , String owner_name , String plate_number , String owner_note , int bike_image) {
        this.viewType = viewType;
        this.driver_name = driver_name;
        this.make = make;
        this.model = model;
        this.owner_number = owner_number;
        this.owner_name = owner_name;
        this.plate_number = plate_number;
        this.owner_note = owner_note;
        this.bike_image = bike_image;
    }

    //for layout seven
    public Model_class(int viewType , float driver_rating , String owner_number , String owner_name , String owner_note , String start_date , String end_date) {
        this.viewType = viewType;
        this.driver_rating = driver_rating;
        this.owner_number = owner_number;
        this.owner_name = owner_name;
        this.owner_note = owner_note;
        this.start_date = start_date;
        this.end_date = end_date;
    }



    public int getViewType() {
        return viewType;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public String getDriver_location() {
        return driver_location;
    }

    public String getAd_2_text() {
        return ad_2_text;
    }

    public String getAd_2_description() {
        return ad_2_description;
    }

    public String getAd_2_button_text() {
        return ad_2_button_text;
    }

    public int getDriver_face() {
        return driver_face;
    }

    public int getAd_2_image() {
        return ad_2_image;
    }

    public float getDriver_rating() {
        return driver_rating;
    }

    public float getAd_2_rating() {
        return ad_2_rating;
    }

    public String getDescription() {
        return description;
    }

    public String getSize() {
        return size;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getPart_image() {
        return part_image;
    }

    public String getOwner_number() {
        return owner_number;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public String getPlate_number() {
        return plate_number;
    }

    public String getOwner_note() {
        return owner_note;
    }

    public int getBike_image() {
        return bike_image;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public NativeAdDetails getAds() {
        return ads;
    }

    public void setAds(NativeAdDetails ads) {
        this.ads = ads;
    }
}
