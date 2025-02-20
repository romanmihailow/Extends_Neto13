package ru.netology.javaqa.javaqamvn.services;

public class Smartphone extends Product {
    private String vendor;

    public Smartphone(int id, String name, int price, String vendor) {
        super(id, name, price);
        this.vendor = vendor;
    }

    public String getVendor() {
        return vendor;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return vendor.toLowerCase().contains(search.toLowerCase());


    }
}
