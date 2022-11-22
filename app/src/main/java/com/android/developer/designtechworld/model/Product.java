package com.android.developer.designtechworld.model;

public class Product {

    // #PRODUCTs     ID - NAME - CONFIG - PRICE

    private int id;
    private String name;
    private String config;
    private int price;


    //Constructor

    public Product(String name, String config, int price) {
        this.name = name;
        this.config = config;
        this.price = price;
    }


    //Getter - Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
