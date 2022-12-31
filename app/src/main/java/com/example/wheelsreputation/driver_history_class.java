package com.example.wheelsreputation;

public class driver_history_class {

    private String description;
    private String availability;
    private int rating;


    public driver_history_class(String description , String availability , int rating) {
        this.description = description;
        this.availability = availability;
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "driver_history_class{" +
                "description='" + description + '\'' +
                ", availability='" + availability + '\'' +
                ", rating=" + rating +
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
}
