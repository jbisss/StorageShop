package com.example.focus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Storage {
    public final HashMap<String, ArrayList<Good>> goodsByDivision = new HashMap<>();
    private Good fillGoods(int min, int max, String goodName, String divisionName, String extraInfo){
        Random rand = new Random();
        int costByDivision = rand.nextInt(max - min + 1) + min;
        return new Good(divisionName, goodName, extraInfo, costByDivision);
    }
    public Storage(boolean loadFactor){
        for (String division : ObjectSwamp.divisionsName){
            if (division.equals("Bread department")) {
                ArrayList<Good> goodsBread = new ArrayList<>();
                goodsBread.add(fillGoods(30, 45,"Bread",  division, "(1 loaf)"));
                goodsBread.add(fillGoods(50,60, "Bun", division, "(1 loaf)"));
                goodsBread.add(fillGoods(15, 30,"Patty", division,"(1 thing)"));
                goodsByDivision.put(division, goodsBread);
            }
            if (division.equals("Confectionery department")) {
                ArrayList<Good> goodsConfectionery = new ArrayList<>();
                goodsConfectionery.add(fillGoods(200, 235, "Jam", division,  "(1 kg)"));
                goodsConfectionery.add(fillGoods(210, 260, "Cookies", division,  "(1 kg)"));
                goodsConfectionery.add(fillGoods(400, 490, "Pie", division,  "(1 kg)"));
                goodsByDivision.put(division, goodsConfectionery);
            }
            if (division.equals("Dairy department")) {
                ArrayList<Good> goodsDairy = new ArrayList<>();
                goodsDairy.add(fillGoods(60, 80, "Milk", division,  "(1 l)"));
                goodsDairy.add(fillGoods(500, 600, "Cheese", division,  "(1 kg)"));
                goodsDairy.add(fillGoods(350, 400, "Curd", division,  "(1 kg)"));
                goodsByDivision.put(division, goodsDairy);
            }
            if (division.equals("Meat section")) {
                ArrayList<Good> goodsMeat = new ArrayList<>();
                goodsMeat.add(fillGoods(380, 460, "Stuffing", division,  "(1 kg)"));
                goodsMeat.add(fillGoods(330, 380, "Сhicken breast", division,  "(1 kg)"));
                goodsMeat.add(fillGoods(320, 360, "Sausage", division,  "(1 kg)"));
                goodsByDivision.put(division, goodsMeat);
            }
            if (division.equals("Fish department")) {
                ArrayList<Good> goodsFish = new ArrayList<>();
                goodsFish.add(fillGoods(290, 330, "Fish", division,  "(1 kg)"));
                goodsFish.add(fillGoods(280, 330, "Sea kale", division,  "(1 kg)"));
                goodsFish.add(fillGoods(460, 530, "Shrimps", division,  "(1 kg)"));
                goodsByDivision.put(division, goodsFish);
            }
            if (division.equals("Vegetable department")) {
                ArrayList<Good> goodsVegetable = new ArrayList<>();
                goodsVegetable.add(fillGoods(180, 210, "Cucumbers", division,  "(1 kg)"));
                goodsVegetable.add(fillGoods(280, 220, "Tomatoes", division,  "(1 kg)"));
                goodsVegetable.add(fillGoods(15, 25, "Onions", division,  "(1 kg)"));
                goodsByDivision.put(division, goodsVegetable);
            }
            if (division.equals("Fruit department")) {
                ArrayList<Good> goodsFruit = new ArrayList<>();
                goodsFruit.add(fillGoods(80, 100, "Apples", division,  "(1 kg)"));
                goodsFruit.add(fillGoods(100, 120, "Bananas", division,  "(1 kg)"));
                goodsFruit.add(fillGoods(90, 110, "Peaches", division,  "(1 kg)"));
                goodsByDivision.put(division, goodsFruit);
            }
            if (division.equals("Beverage department")) {
                ArrayList<Good> goodsBeverage = new ArrayList<>();
                goodsBeverage.add(fillGoods(100, 130, "Soda", division,  "(1 l)"));
                goodsBeverage.add(fillGoods(55, 70, "Water", division,  "(1 l)"));
                goodsBeverage.add(fillGoods(100, 130, "Juice", division,  "(1 l)"));
                goodsByDivision.put(division, goodsBeverage);
            }
        }
    }
}
