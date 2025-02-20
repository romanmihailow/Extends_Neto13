package ru.netology.javaqa.javaqamvn.services;

public class Product {
    protected int id;
    protected String name;
    protected int price;


    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public boolean matches(String search) {
        return name.toLowerCase().contains(search.toLowerCase());
    }


    public int getPrice() {
        return price;
    }

    public Product(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }
}
