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
    public Product[] searchBy(String search) {
        Product[] allProducts = repository.findAll(); // Получаем все продукты из репозитория
        int matchCount = 0; // Счетчик количества совпавших продуктов

        // Сначала проходим по всем продуктам и проверяем, сколько из них подходят по поисковому запросу
        for (Product product : allProducts) {
            if (product.matches(search)) {
                matchCount++;
            }
        }

        // Создаем новый массив, в который будем добавлять найденные продукты
        Product[] result = new Product[matchCount];
        int index = 0;

        // Проходим снова по продуктам и добавляем подходящие в новый массив
        for (Product product : allProducts) {
            if (product.matches(search)) {
                result[index++] = product;
            }
        }

        return result;
    }




}
