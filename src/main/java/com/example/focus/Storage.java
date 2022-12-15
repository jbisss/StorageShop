package com.example.focus;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Good> goods = new ArrayList<>();
    public void addGood(Good good) {
        this.goods.add(good);
    }
}
