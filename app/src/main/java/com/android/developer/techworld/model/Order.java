package com.android.developer.techworld.model;

public class Order {

    // #ORDERs       ID - QUANTITY - DATE_ORDER - DATE_RECEIPT - STATUS - TOTAL - ACCOUNT_ID (ACCOUNTs) - PRODUCT_ID (PRODUCTs)
    // #ACCOUNTs     ID - PASSWORD - ROLE - NAME - PHONE - ADDRESS
    // #PRODUCTs     ID - BANNER - NAME - CONFIG - DESCRIPTION - PRICE - CATEGORY_ID (CATEGORies)

    private int id;
    private int quantity;
    private String date_order;
    private String date_receipt;
    private int status;
    private int total;

    private String account_id;
    private String account_password;
    private String account_role;
    private String account_name;
    private String account_phone;
    private String account_address;

    private int product_id;
    private int product_banner;
    private String product_name;
    private String product_config;
    private String product_description;
    private int product_price;
    private int product_category_id;

    //Constructor

    public Order(int id, int quantity, String date_order, String date_receipt, int status, int total, String account_id, String account_password, String account_role, String account_name, String account_phone, String account_address, int product_id, int product_banner, String product_name, String product_config, String product_description, int product_price, int product_category_id) {
        this.id = id;
        this.quantity = quantity;
        this.date_order = date_order;
        this.date_receipt = date_receipt;
        this.status = status;
        this.total = total;
        this.account_id = account_id;
        this.account_password = account_password;
        this.account_role = account_role;
        this.account_name = account_name;
        this.account_phone = account_phone;
        this.account_address = account_address;
        this.product_id = product_id;
        this.product_banner = product_banner;
        this.product_name = product_name;
        this.product_config = product_config;
        this.product_description = product_description;
        this.product_price = product_price;
        this.product_category_id = product_category_id;
    }




    //Getter - Setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate_order() {
        return date_order;
    }

    public void setDate_order(String date_order) {
        this.date_order = date_order;
    }

    public String getDate_receipt() {
        return date_receipt;
    }

    public void setDate_receipt(String date_receipt) {
        this.date_receipt = date_receipt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getAccount_password() {
        return account_password;
    }

    public void setAccount_password(String account_password) {
        this.account_password = account_password;
    }

    public String getAccount_role() {
        return account_role;
    }

    public void setAccount_role(String account_role) {
        this.account_role = account_role;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getAccount_phone() {
        return account_phone;
    }

    public void setAccount_phone(String account_phone) {
        this.account_phone = account_phone;
    }

    public String getAccount_address() {
        return account_address;
    }

    public void setAccount_address(String account_address) {
        this.account_address = account_address;
    }

    public int getProduct_banner() {
        return product_banner;
    }

    public void setProduct_banner(int product_banner) {
        this.product_banner = product_banner;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_config() {
        return product_config;
    }

    public void setProduct_config(String product_config) {
        this.product_config = product_config;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public int getProduct_category_id() {
        return product_category_id;
    }

    public void setProduct_category_id(int product_category_id) {
        this.product_category_id = product_category_id;
    }
}
