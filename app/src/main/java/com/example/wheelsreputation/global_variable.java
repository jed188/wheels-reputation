package com.example.wheelsreputation;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class global_variable extends Application {

    private static List<driver_history_class> driver_history_classList = new ArrayList<>();
    private static List<stolen_bike_class> stolen_bike_classList = new ArrayList<>();
    private static List<spare_parts_class> spare_parts_classList = new ArrayList<>();
    private static List<Model_class> model_class_items = new ArrayList<>();


    private static int countValue = 5;


    public global_variable() {

        fillStolenBikeList();

        fillSpareParts();

        fillDriverHistoryList();

        fillModelClassItems();



    }

    private void fillModelClassItems() {
//look at the descriptionof the viewtype  to kow which object it feeds
        Model_class item1 = new Model_class(Model_class.layout_three_spare_part_layout , "tyre" , "300-18" , "Big Boy" , "velocity" , R.drawable.mobile_mecanic);
        Model_class item2 = new Model_class(Model_class.layout_three_spare_part_layout , "battery" , "12N6.5-3B" , "Big Boy" , "velocity" , R.drawable.workshops);
        Model_class item3 = new Model_class(Model_class.layout_three_spare_part_layout , "chain" , "428H*128" , "Big Boy, HONDA" , "velocity, ACE" , R.drawable.mecanic);
        Model_class item4 = new Model_class(Model_class.layout_three_spare_part_layout , "tube" , "300-18" , "Big Boy" , "velocity" , R.drawable.stolen_bike);

        Model_class item5 = new Model_class(Model_class.layout_seven_driver_history_layout , 4.5f , "0834373761" , "Jedidia" , "he was a good driver but he left when my bike broke down yet he was fair since he spoke to me before leaving" , "12/08/2022" , "22/03/2023");
        Model_class item6 = new Model_class(Model_class.layout_seven_driver_history_layout , 1.5f , "0834373761" , "rey" , "he was a good driver, he was fair " , "10/04/2021" , "12/07/2023");
        Model_class item7 = new Model_class(Model_class.layout_seven_driver_history_layout , 3.5f , "0834373761" , "divine" , "he stole my bike and i hate him" , "18/01/2019" , "12/12/2022");
        Model_class item8 = new Model_class(Model_class.layout_seven_driver_history_layout , 2.5f , "0834373761" , "fiston" , "he was a good driver but he left and broke my bike " , "02/04/2020" , "13/08/2021");

        Model_class item9 = new Model_class(Model_class.layout_one_reputation_list_layout , "Mohamed Brahi" , "Tygervalley" , R.drawable.reputation_clipart , 4.0f);
        Model_class item10 = new Model_class(Model_class.layout_one_reputation_list_layout , "Jean Jacques" , "Pinelands" , R.drawable.bikers_image , 5.0f);
        Model_class item11 = new Model_class(Model_class.layout_one_reputation_list_layout , "Alain Mpela" , "Constantia" , R.drawable.reputation_sticker , 3.0f);
        Model_class item12 = new Model_class(Model_class.layout_one_reputation_list_layout , "Victor Hendries" , "Cape Town" , R.drawable.workshops , 3.5f);

        model_class_items.addAll(Arrays.asList(item1 , item2 , item3 , item4, item5 , item6 , item7 , item8,item9 , item10 , item11 , item12));

    }

    private void fillSpareParts() {

        spare_parts_class part1 = new spare_parts_class("tyre" , "300-18" , "Big Boy" , "velocity" , R.drawable.mobile_mecanic);
        spare_parts_class part2 = new spare_parts_class("battery" , "12N6.5-3B" , "Big Boy" , "velocity" , R.drawable.workshops);
        spare_parts_class part3 = new spare_parts_class("chain" , "428H*128" , "Big Boy, HONDA" , "velocity, ACE" , R.drawable.mecanic);
        spare_parts_class part4 = new spare_parts_class("tube" , "300-18" , "Big Boy" , "velocity" , R.drawable.stolen_bike);

        spare_parts_classList.addAll(Arrays.asList(part1 , part2 , part3 , part4));
    }

    private void fillDriverHistoryList() {

        driver_history_class history1 = new driver_history_class("he was a good driver" , "available" , 8 , "Alex" , "12/11/2022" , "12/10/2021" , "John" , "0834373761" , "honda" , "Ace 125cc");
        driver_history_class history2 = new driver_history_class("he stole my bike and didnt pay" , "available" , 1 , "matthew" , "8/02/2022" , "15/04/2022" , "Chance" , "0876547878" , "Big Boy" , "velocity");
        driver_history_class history4 = new driver_history_class("he was a good driver and my bike broke then he found another bike to drive" , "available" , 8 , "Alex" , "13/01/2021" , "23/12/2022" , "Patrick" , "0985674332" , "Honda" , "Ace 125cc");

        driver_history_classList.addAll(Arrays.asList(history1 , history2 , history4));


    }


    private void fillStolenBikeList() {

        stolen_bike_class bike1 = new stolen_bike_class("reputation_clipart.png" , "honda" , "Ace 125cc" , "Alex" , "0834373761" , "CV345867" , "Amos" , "if found, i will reward R1000");
        stolen_bike_class bike2 = new stolen_bike_class("reputation_sticker.png" , "honda" , "Ace 125cc" , "john" , "0834373761" , "CAA349867" , "Amos" , "if found, i will reward R1000");
        stolen_bike_class bike3 = new stolen_bike_class("reputation_clipart.png" , "honda" , "Ace 125cc" , "pappy" , "0834373761" , "CY348867" , "Amos" , "if found, i will reward R1000");

        stolen_bike_classList.addAll(Arrays.asList(bike1 , bike2 , bike3));

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

    public static List<spare_parts_class> getSpare_parts_classList() {
        return spare_parts_classList;
    }

    public static void setSpare_parts_classList(List<spare_parts_class> spare_parts_classList) {
        global_variable.spare_parts_classList = spare_parts_classList;
    }

    public static List<Model_class> getModel_class_items() {
        return model_class_items;
    }

    public static void setModel_class_items(List<Model_class> model_class_items) {
        global_variable.model_class_items = model_class_items;
    }

    public static int getCountValue() {
        return countValue;
    }

    public static void setCountValue(int countValue) {
        global_variable.countValue = countValue;
    }
}
