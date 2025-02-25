package ru.netology.javaqa.javaqamvn.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    void testAddProduct() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);

        // Используем полный конструктор
        Book book = new Book(1, "Book name_one", 100, "author_1");
        manager.add(book);

        Product[] allProducts = repository.findAll();
        assertEquals(1, allProducts.length); // Проверяем, что продукт добавлен
        assertEquals("Book name_one", allProducts[0].getName()); // Проверяем название продукта
        assertEquals(100, allProducts[0].getPrice()); // Проверяем цену продукта
    }



    @Test
    void searchByTextOne() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Book book1 = new Book(1, "Book name_one", 100, "author_1");
        Book book2 = new Book(2, "Book name_two", 200, "author_2");
        Book book3 = new Book(3, "Book name_three", 300, "author_3");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("one");
        Product[] expected = {book1};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void searchByTextNameBook() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Book book1 = new Book(1, "Book name_one", 100, "author_1");
        Book book2 = new Book(2, "Book name_two", 200, "author_2");
        Book book3 = new Book(3, "Book name_three", 300, "author_3");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("name");
        Product[] expected = {book1, book2, book3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchByTextNameSmartphoneToLowerCase() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Smartphone smartphone1 = new Smartphone(1, "Smartphone name_one", 100, "author_1");
        Smartphone smartphone2 = new Smartphone(2, "Smartphone name_two", 200, "author_2");
        Smartphone smartphone3 = new Smartphone(3, "Smartphone name_three", 300, "author_3");
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] actual = manager.searchBy("smart");
        Product[] expected = {smartphone1, smartphone2, smartphone3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchByTextNameSmartphoneToUpperCase() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Smartphone smartphone1 = new Smartphone(1, "Smartphone name_one", 100, "author_1");
        Smartphone smartphone2 = new Smartphone(2, "Smartphone name_two", 200, "author_2");
        Smartphone smartphone3 = new Smartphone(3, "Smartphone name_three", 300, "author_3");
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] actual = manager.searchBy("AUTH");
        Product[] expected = {smartphone1, smartphone2, smartphone3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchByTextNon() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Book book1 = new Book(1, "Book name_one", 100, "author_1");
        Book book2 = new Book(2, "Book name_two", 200, "author_2");
        Book book3 = new Book(3, "Book name_three", 300, "author_3");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("Non");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void add() {
        Repository repository = new Repository();
        Manager manager = new Manager(repository);
        Book book1 = new Book(1, "Book name_one", 100, "author_1");
        Book book2 = new Book(2, "Book name_two", 200, "author_2");
        Book book3 = new Book(3, "Book name_three", 300, "author_3");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2, book3};
        Assertions.assertArrayEquals(expected, actual);

    }

}