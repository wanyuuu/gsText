package com.wanyu.A;

/**
 * Created by wanyu3 on 2018/7/25.
 */
public class Card {
    private String id;
    private int money;
    public Card(String id,int money){
        this.id = id;
        this.money = money;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
