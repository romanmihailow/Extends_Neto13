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


}