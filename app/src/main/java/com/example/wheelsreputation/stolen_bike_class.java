package com.example.wheelsreputation;

import android.widget.ImageView;

public class stolen_bike_class {

    private String picture;
    private String Make;
    private String Model;
    private String OwnerName;
    private String cellphone;
    private String plateNumber;
    private String driverName;
    private String note;

    public stolen_bike_class(String picture , String make , String model , String ownerName , String cellphone , String plateNumber , String driverName , String note) {
        this.picture = picture;
        Make = make;
        Model = model;
        OwnerName = ownerName;
        this.cellphone = cellphone;
        this.plateNumber = plateNumber;
        this.driverName = driverName;
        this.note = note;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "stolen_bike_class{" +
                "picture=" + picture +
                ", Make='" + Make + '\'' +
                ", Model='" + Model + '\'' +
                ", OwnerName='" + OwnerName + '\'' +
                ", cellphone=" + cellphone +
                ", plateNumber='" + plateNumber + '\'' +
                ", driverName='" + driverName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
