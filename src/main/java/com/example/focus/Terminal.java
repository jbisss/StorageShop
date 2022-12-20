package com.example.focus;

public class Terminal {
    private int money;
    public final Storage storage;
    public Terminal(int money){
        this.money = money;
        this.storage = new Storage(false);
    }
    public int getMoney(){
        return this.money;
    }
    public void decreaseMoney(int money){
        this.money -= money;
    }
    public void decreaseMoney(boolean bool, int money){
        this.money += money;
    }
}
