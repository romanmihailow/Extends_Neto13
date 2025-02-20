package ru.netology.javaqa.javaqamvn.services;

public class Manager {
    Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    ///  ADD_PRODUCT
    public void add(Product product) {
        repository.add(product);
    }

    ///  SEARCH_BY_TEXT_IN_PRODUCT
    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}
