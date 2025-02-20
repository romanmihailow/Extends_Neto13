package ru.netology.javaqa.javaqamvn.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    void testAdd() {
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