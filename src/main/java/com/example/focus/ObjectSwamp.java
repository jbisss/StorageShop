package com.example.focus;

import java.util.*;

public class ObjectSwamp {
    public static final ArrayList<String> divisionsName = new ArrayList<> (Arrays.asList("Bread department",
            "Confectionery department", "Dairy department", "Meat section", "Fish department", "Vegetable department",
            "Fruit department", "Beverage department"));
    public static final ArrayList<String> deliverName = new ArrayList<> (Arrays.asList("Jemmie Lannister",
            "Christofer Nolan", "Mark Twen", "Chris Evans", "Bobby Dylan", "John Snow", "Ilya Muromets",
            "Vasya Perevalov", "Shrek Swampov", "Tony Start", "Gandalf White", "Bilbo Begins"));
    public static HashMap<String, Deliver> delivers = new HashMap<>();
    public static Deliver currentDeliver;
    public static String currentDepartment;
    public static Good currentGood;

    public static Terminal myTerminal;
    public static Storage myStorage;
    public static double rating = 0;
    public static int amountRatings = 1;
    public static double sumRatings = 0.5;
    static {
        Random rand_deliver = new Random();
        for (int i = 0; i < 9; i++) {
            int rand = rand_deliver.nextInt(deliverName.size());
            delivers.put(deliverName.get(rand), new Deliver(deliverName.get(rand)));
        }
        myTerminal = new Terminal(1000000);
        myStorage = new Storage(false);
    }
    public static void refreshRating(double result){
        amountRatings++;
        sumRatings+=result;
        rating = sumRatings/amountRatings;
    }
    public static void loadClass(){}
}
