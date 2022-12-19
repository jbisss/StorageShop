package com.example.focus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Client {
    private ArrayList<String> names = new ArrayList<>(Arrays.asList("Mark", "Joe", "Jeffry", "Ten", "Sixty", "Robbie",
            "Bobbie", "Barrie", "Bilbo", "Roy", "Jack"));
    private String name;
    private ArrayList<String> cart = new ArrayList<>();
    private int happinessRate = 0;
    public Client(String favoriteGood){
        Random rand = new Random();
        int index = rand.nextInt(names.size());
        this.name = names.get(index);

    }
    public int buyGood(){
        int happinessRate = 0;
        return happinessRate;
    }
}
