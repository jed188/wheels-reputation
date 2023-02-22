package com.example.wheelsreputation;

public class spare_parts_class {

    private String description;
    private String size;
    private String Make;
    private String Model;
    private int picture;

    @Override
    public String toString() {
        return "spare_parts_class{" +
                "description='" + description + '\'' +
                ", size='" + size + '\'' +
                ", Make='" + Make + '\'' +
                ", Model='" + Model + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public spare_parts_class(String description , String size , String make , String model , int picture) {
        this.description = description;
        this.size = size;
        Make = make;
        Model = model;
        this.picture = picture;
    }
}
