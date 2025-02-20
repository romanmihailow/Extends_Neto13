package ru.netology.javaqa.javaqamvn.services;

public class Repository {
    Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    ///  ADD
    public void add(Product product) {
        Product[] temp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            temp[i] = products[i];
        }
        temp[temp.length - 1] = product;
        products = temp;
    }

    /// REMOVE
    public void removeById(int removeId) {
        Product[] temp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != removeId) {
                temp[index] = product;
                index++;
            }
        }
        products = temp;
    }










}


//    ///  FIND_ALL
//    public Product[] findAll() {
//        return products;
//    }
//
//    ///  SAVE+
//    public void save(Product product) {
//        Product[] newProducts = new Product[products.length + 1];
//        for (int i = 0; i < products.length; i++) {
//            newProducts[i] = products[i];
//        }
//        newProducts[products.length] = product;
//        products = newProducts;
//    }
//
//    ///  REMOVE_BY_ID+
//    public void removeById(int id) {
//        Product[] temp = new Product[products.length - 1];
//        int copyToIndex = 0;
//        for (Product product : products) {
//            if (product.getId() != id) {
//                temp[copyToIndex] = product;
//                copyToIndex++;
//            }
//        }
//        products = temp;
//    }
//
//    ///   FIND_BY_ID+
//    public Product[] findById(int id) {
//        Product[] temp = new Product[1];
//        int copyToIndex = 0;
//        for (Product product : products) {
//            if (product.getId() == id) {
//                temp[copyToIndex] = product;
//                copyToIndex++;
//            }
//        }
//        return temp;
//    }
//
//    ///  REMOVE_ALL+
//    public void removeAll() {
//        products = new Product[0];
//    }
//



