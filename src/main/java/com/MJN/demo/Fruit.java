package com.MJN.demo;

public class Fruit {
    int price;
    String code;

    @Override
    public String toString() {
        return "Fruit{" +
                "price=" + price +
                ", code='" + code + '\'' +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Fruit(int price, String code) {
        this.price = price;
        this.code = code;
    }

    public Fruit() {
    }
}
