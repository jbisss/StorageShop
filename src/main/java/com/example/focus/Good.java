package com.example.focus;

public class Good {
    private final String division;
    private final String name;
    private final String extraInfo;
    private int oldCost;
    private int newCost;
    public Good(String division, String name, String extraInfo, int cost) {
        this.division = division;
        this.name = name;
        this.extraInfo = extraInfo;
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
