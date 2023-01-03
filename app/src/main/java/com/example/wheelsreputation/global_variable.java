package com.example.wheelsreputation;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class global_variable extends Application {

    private static List<driver_history_class> driver_history_classList = new ArrayList<>();
    private static List<stolen_bike_class> stolen_bike_classList = new ArrayList<>();
    private static int countValue = 3;

    public global_variable() {

        fillDriverHistoryList();

        fillStolenBikeList();

    }

    private void fillDriverHistoryList() {

        driver_history_class history1 = new driver_history_class("he was a good driver","available",8,"Alex", "12/11/2022" , "12/10/2021","Patrick","0834373761","honda","Ace 125cc");
        driver_history_class history2 = new driver_history_class("he stole my bike and didnt pay","available",1, "matthew", "8/02/2022","15/04/2022", "Chance","0876547878","Big Boy", "velocity");
        driver_history_class history4 = new driver_history_class("he was a good driver and my bike broke then he found another bike to drive","available",8,"Alex","13/01/2021","23/12/2022","Patrick","0985674332","Honda","Ace 125cc");

        driver_history_classList.addAll(Arrays.asList(history1,history2,history4));

    }

    private void fillStolenBikeList() {

        stolen_bike_class bike1 = new stolen_bike_class("reputation_clipart.png","honda","Ace 125cc","Alex","0834373761","CV345867","Amos","if found, i will reward R1000");
        stolen_bike_class bike2 = new stolen_bike_class("reputation_sticker.png","honda","Ace 125cc","Alex","0834373761","CV345867","Amos","if found, i will reward R1000");
        stolen_bike_class bike3 = new stolen_bike_class("reputation_clipart.png","honda","Ace 125cc","Alex","0834373761","CV345867","Amos","if found, i will reward R1000");

        stolen_bike_classList.addAll(Arrays.asList(bike1,bike2,bike3));

    }

    public static List<stolen_bike_class> getStolen_bike_classList() {
        return stolen_bike_classList;
    }

    public static void setStolen_bike_classList(List<stolen_bike_class> stolen_bike_classList) {
        global_variable.stolen_bike_classList = stolen_bike_classList;
    }

    public static List<driver_history_class> getDriver_history_classList() {
        return driver_history_classList;
    }

    public static void setDriver_history_classList(List<driver_history_class> driver_history_classList) {
        global_variable.driver_history_classList = driver_history_classList;
    }

    public static int getCountValue() {
        return countValue;
    }

    public static void setCountValue(int countValue) {
        global_variable.countValue = countValue;
    }
}
