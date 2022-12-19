package com.example.focus;

import java.util.*;

public class ObjectSwamp {
    public static final ArrayList<String> divisionsName = new ArrayList<> (Arrays.asList("Bread department",
            "Confectionery department", "Dairy department", "Meat section", "Fish department", "Vegetable department",
            "Fruit department", "Beverage department"));
    public static final ArrayList<String> goodsName = new ArrayList<> (Arrays.asList("Milk", "Cookie", "Bread",
            "Chocolate bar", "Yogurt", "Apple", "Cheese", "Sausage", "Fish", "Ice cream", "Pasta", "Water"));
    public static final ArrayList<String> deliverName = new ArrayList<> (Arrays.asList("Jemmie Lannister",
            "Christofer Nolan", "Mark Twen", "Chris Evans", "Bobby Dylan", "John Snow", "Ilya Muromets",
            "Vasya Perevalov", "Shrek Swampov", "Tony Start", "Gandalf White", "Bilbo Begins"));
    public static HashMap<String, Deliver> delivers = new HashMap<>();
    public static ArrayList<Client> clients = new ArrayList<>();
    public static Terminal myTerminal;
    public static Storage myStorage;
    static {
        Random rand_deliver = new Random();
        for (int i = 0; i < 9; i++) {
            int rand = rand_deliver.nextInt(deliverName.size());
            delivers.put(deliverName.get(rand), new Deliver(deliverName.get(rand)));
        }
        myTerminal = new Terminal(10000);
        myStorage = new Storage(false);
    }
    public static void loadClass(){}
}
