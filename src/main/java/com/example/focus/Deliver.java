package com.example.focus;

import java.util.ArrayList;
import java.util.Random;

public class Deliver {
    private final String name;
    private final ArrayList<Good> goods = new ArrayList<>();
    public Deliver(String name){
        this.name = name;
        Random rand_good = new Random();
        Random rand_cost = new Random();
        for (int i = 0; i < 9; i++){
            goods.add(new Good(ObjectSwamp.goodsName.get(rand_good.nextInt(ObjectSwamp.goodsName.size())),
                    rand_cost.nextInt(300) + 10));
        }
    }

    public String getName() {
        return name;
    }
    public ArrayList<Good> getGoods(){
        return this.goods;
    }
}
