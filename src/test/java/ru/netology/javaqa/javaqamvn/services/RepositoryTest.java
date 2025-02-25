package ru.netology.javaqa.javaqamvn.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    void testAddBook() {
        Repository repository = new Repository();
        Book book1 = new Book(1, "Book name_one", 100, "author_1");
        Book book2 = new Book(2, "Book name_two", 200, "author_2");
        Book book3 = new Book(3, "Book name_three", 300, "author_3");
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2, book3};
        assertArrayEquals(expected, actual);
    }
    @Test
    void testAddSmartphone() {
        Repository repository = new Repository();
        Smartphone smartphone1 = new Smartphone(1, "Book name_one", 100, "author_1");
        Smartphone smartphone2 = new Smartphone(2, "Book name_two", 200, "author_2");
        Smartphone smartphone3 = new Smartphone(3, "Book name_three", 300, "author_3");

        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.add(smartphone3);
        Product[] actual = repository.findAll();
        Product[] expected = {smartphone1, smartphone2, smartphone3};
        assertArrayEquals(expected, actual);
    }
    @Test
    void testGetVendor() {
        Smartphone smartphone1 = new Smartphone(1, "Smartphone name_one", 100, "vendor_1");
        String actual = smartphone1.getVendor();
        String expected = "vendor_1";
        assertEquals(expected, actual);

    }

    @Test
    void testZeroRepo() {
        Repository repository = new Repository();
        Product[] actual = repository.findAll();
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testRemoveId() {
        Repository repository = new Repository();
        Book book1 = new Book(1, "Book name_one", 100, "author_1");
        Book book2 = new Book(2, "Book name_two", 200, "author_2");
        Book book3 = new Book(3, "Book name_three", 300, "author_3");
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.removeById(3);
        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2};
        assertArrayEquals(expected, actual);
    }


    @Test
    void testRemoveIdExtends() {
        Repository repository = new Repository();
        Book book1 = new Book(1, "Book name_one", 100, "author_1");
        Book book2 = new Book(2, "Book name_two", 200, "author_2");
        Book book3 = new Book(3, "Book name_three", 300, "author_3");
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.removeById(3);
        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2};
        assertArrayEquals(expected, actual);
    }


    @Test
    void testRemoveIdExtendsOutOfRange() {
        Repository repository = new Repository();
        Book book1 = new Book(1, "Book name_one", 100, "author_1");
        Book book2 = new Book(2, "Book name_two", 200, "author_2");
        Book book3 = new Book(3, "Book name_three", 300, "author_3");
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repository.removeById(-1)
        );
        /// NETOLOGY -> 44:50 ] https://netology.ru/profile/program/javaqa-52/lessons/230578/lesson_items/1221922
    }


    @Test
    public void testAddProductWithDuplicateId() {
        // Создаем репозиторий и два продукта с одинаковым ID
        Repository repository = new Repository();
        Product product1 = new Product(1, "Book", 100);
        Product product2 = new Product(1, "Another Book", 150);

        // Добавляем первый продукт
        repository.add(product1);

        // Проверяем, что при добавлении второго товара с таким же ID выбрасывается исключение
        try {
            repository.add(product2);
            fail("Expected AlreadyExistsException to be thrown");
        } catch (AlreadyExistsException e) {
            // Проверяем, что исключение выброшено, и что сообщение в нем правильное
            assertEquals("The id 1 already exists", e.getMessage());
        }
    }


    @Test
    public void testAddProduct() {
        // Создаем репозиторий и продукт
        Repository repository = new Repository();
        Product product = new Product(1, "Book", 100);

        // Добавляем продукт в репозиторий
        repository.add(product);

        // Проверяем, что продукт был добавлен в репозиторий
        Product[] products = repository.findAll();
        assertEquals(1, products.length); // в репозитории должен быть один товар
        assertEquals("Book", products[0].getName()); // проверяем имя товара
        assertEquals(100, products[0].getPrice()); // проверяем цену товара
    }






}