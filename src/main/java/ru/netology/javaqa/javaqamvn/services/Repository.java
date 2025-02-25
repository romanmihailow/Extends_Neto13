package ru.netology.javaqa.javaqamvn.services;

public class Repository {
    Product[] products = new Product[0];

    ///   FIND_ALL
    public Product[] findAll() {
        return products;
    }



//        ///   FIND_BY_ID+
//    public Product[] findById(int id) {
//        Product[] temp = new Product[1];
//        int copyToIndex = 0;
//        for (Product product : products) {
//            if (product.getId() == id) {
//                temp[copyToIndex] = product;
//                copyToIndex++;
//                return temp;
//
//            }
//        }
//        return null;
//    }



    ///  ADD +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void add(Product product) {
        // Проверка, существует ли уже товар с таким же id
        if (findById(product.getId()) != null) {
            // Если товар с таким id найден, выбрасываем исключение
            throw new AlreadyExistsException(product.getId());
        }

        // Создаем временный массив для нового списка товаров, на 1 больше
        Product[] temp = new Product[products.length + 1];

        // Копируем все существующие товары из старого массива в новый
        for (int i = 0; i < products.length; i++) {
            temp[i] = products[i];
        }

        // Добавляем новый товар в последний элемент нового массива
        temp[temp.length - 1] = product;

        // Присваиваем новый массив товаров в поле products
        products = temp;
    }


    /// REMOVE +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void removeById(int removeId) {
        Product foundProduct = findById(removeId);
        if (foundProduct == null) {
            throw new NotFoundException(removeId);
        }
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


    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
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

//
//    ///  REMOVE_ALL+
//    public void removeAll() {
//        products = new Product[0];
//    }
//



