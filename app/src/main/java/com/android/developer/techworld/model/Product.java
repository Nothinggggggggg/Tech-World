package com.android.developer.techworld.model;

import java.io.Serializable;

public class Product implements Serializable {

    // #PRODUCTs     ID - BANNER - NAME - CONFIG - DESCRIPTION - PRICE - CATEGORY_ID (CATEGORies)

    private int id;
    private int IMG_banner;
    private String name;
    private String config;
    private String description;
    private int price;
    private int category_id;


    //Constructor

    public Product(String name, String config, int price) {
        this.name = name;
        this.config = config;
        this.price = price;
    }

    public Product(int id, int IMG_banner, String name, String config, String description, int price, int category_id) {
        this.id = id;
        this.IMG_banner = IMG_banner;
        this.name = name;
        this.config = config;
        this.description = description;
        this.price = price;
        this.category_id = category_id;
    }

    public Product(int IMG_banner, String name, String config, String description, int price, int category_id) {
        this.IMG_banner = IMG_banner;
        this.name = name;
        this.config = config;
        this.description = description;
        this.price = price;
        this.category_id = category_id;
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

    public int getIMG_banner() {
        return IMG_banner;
    }

    public void setIMG_banner(int IMG_banner) {
        this.IMG_banner = IMG_banner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
