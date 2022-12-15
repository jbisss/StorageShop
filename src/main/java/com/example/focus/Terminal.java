package com.example.focus;

public class Terminal {
    private int money;
    public Terminal(int money){
        this.money = money;
    }
    public int getMoney(){
        return this.money;
    }
    public void decreaseMoney(int money){
        this.money -= money;
    }
}
