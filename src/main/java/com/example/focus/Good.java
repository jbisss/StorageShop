package com.example.focus;

public class Good {
    private final String division;
    private final String name;
    private final String extraInfo;
    private int count;
    private int oldCost;
    private int newCost;
    public Good(String division, String name, String extraInfo, int cost, int count) {
        this.division = division;
        this.name = name;
        this.extraInfo = extraInfo;
        this.oldCost = cost;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setNewCost(int newCost) {
        this.newCost = newCost;
    }
    public void setOldCost(int oldCost){
        this.oldCost = oldCost;
    }
}
