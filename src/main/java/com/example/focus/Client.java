package com.example.focus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Client {
    private final String name;
    private double rating;
    public Client(){
        Random rand = new Random();
        // Массив возможных имён
        ArrayList<String> names = new ArrayList<>(Arrays.asList("Mark", "Joe", "Jeffry", "Ten", "Sixty", "Robbie",
                "Bobbie", "Barrie", "Bilbo", "Roy", "Jack"));
        int index = rand.nextInt(names.size());
        this.name = names.get(index);
        Random choiceDepartmentRand = new Random();
        int rateWant = 0;
        int rateGain = 0;
        for(int i = 0; i < ObjectSwamp.divisionsName.size(); i++){
            int choiceDepartment = choiceDepartmentRand.nextInt(2);
            if (choiceDepartment == 1) {
                String departmentName = ObjectSwamp.divisionsName.get(i);
                Random choiceGoodRand = new Random();
                for (int j = 0; j < 3; j++){
                    int choiceGood = choiceGoodRand.nextInt(2);
                    if (choiceGood == 1) {
                        rateWant++;
                        Random amountRand = new Random();
                        int amount = amountRand.nextInt(6) + 1;
                        int amountOnStorage = ObjectSwamp.myStorage.goodsByDivision.get(departmentName).get(j).getCount();
                        int costOnStorage = ObjectSwamp.myStorage.goodsByDivision.get(departmentName).get(j).getNewCost();
                        if (amountOnStorage >= amount){
                            rateGain++;
                            ObjectSwamp.myTerminal.decreaseMoney(false, amount * costOnStorage);
                            ObjectSwamp.myStorage.goodsByDivision.get(departmentName).get(j).setCount(amountOnStorage - amount);
                        }
                    }
                }
            }
            if (rateWant != 0) {
                this.rating = (double) rateGain / rateWant;
                ObjectSwamp.refreshRating(this.rating);
            }
        }
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }
}
