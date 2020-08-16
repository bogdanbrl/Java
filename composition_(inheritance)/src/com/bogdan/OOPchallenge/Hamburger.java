package com.bogdan.OOPchallenge;

public class Hamburger {
    private String name;
    private String meat;
    private double price;
    private String breadRollType;

    private String additional1Name;
    private double additional1Price;

    private String additional2Name;
    private double additional2Price;

    private String additional3Name;
    private double additional3Price;

    private String additional4Name;
    private double additional4Price;

    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
    }

    public void addHamburgerAddition1(String name, double price){
        this.additional1Name=name;
        this.additional1Price=price;
    }
    public void addHamburgerAddition2(String name, double price){
        this.additional2Name=name;
        this.additional2Price=price;
    }
    public void addHamburgerAddition3(String name, double price){
        this.additional3Name=name;
        this.additional3Price=price;
    }
    public void addHamburgerAddition4(String name, double price){
        this.additional4Name=name;
        this.additional4Price=price;
    }
}
