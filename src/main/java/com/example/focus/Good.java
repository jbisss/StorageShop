package com.example.focus;

public class Good {
    private final String name;
    private int oldCost;
    private int newCost;
    public Good(String name, int cost) {
        this.name = name;
        this.oldCost = cost;
    }

    public String getName(){
        return this.name;
    }
    public int getNewCost(){
        return this.newCost;
    }
    public int getOldCost(){
        return this.oldCost;
    }
    public void setNewCost(int newCost) {
        this.newCost = newCost;
    }
    public void setOldCost(int oldCost){
        this.oldCost = oldCost;
    }
}
