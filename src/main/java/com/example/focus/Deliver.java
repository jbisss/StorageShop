package com.example.focus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Deliver {
    private final String name;
    public final Storage storage;
    public Deliver(String name){
        this.name = name;
        this.storage = new Storage(true);
        System.out.println("");
    }

    public String getName() {
        return name;
    }
}
