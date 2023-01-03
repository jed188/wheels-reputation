package com.example.wheelsreputation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class driver_history_class {



    private String description;
    private String availability;
    private int rating;
    private String driverName;
    private String beginningService = DateFormat.getDateInstance().format(new Date());
    private String endService  = DateFormat.getDateInstance().format(new Date());
    private String ownerName;
    private String contactNumber;
    private String bikeMake;
    private String bikeModel;

    public driver_history_class(String description , String availability , int rating , String driverName , String beginningService , String endService , String ownerName , String contactNumber , String bikeMake , String bikeModel) {
        this.description = description;
        this.availability = availability;
        this.rating = rating;
        this.driverName = driverName;
        this.beginningService = beginningService;
        this.endService = endService;
        this.ownerName = ownerName;
        this.contactNumber = contactNumber;
        this.bikeMake = bikeMake;
        this.bikeModel = bikeModel;
    }

    @Override
    public String toString() {
        return "driver_history_class{" +
                "description='" + description + '\'' +
                ", availability='" + availability + '\'' +
                ", rating=" + rating +
                ", driverName='" + driverName + '\'' +
                ", beginningService=" + beginningService +
                ", endService=" + endService +
                ", ownerName='" + ownerName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", bikeMake='" + bikeMake + '\'' +
                ", bikeModel='" + bikeModel + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBeginningService() {
        return beginningService;
    }

    public void setBeginningService(String beginningService) {
        this.beginningService = beginningService;
    }

    public String getEndService() {
        return endService;
    }

    public void setEndService(String endService) {
        this.endService = endService;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getBikeMake() {
        return bikeMake;
    }

    public void setBikeMake(String bikeMake) {
        this.bikeMake = bikeMake;
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }
}
