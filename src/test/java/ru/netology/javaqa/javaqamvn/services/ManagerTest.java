package ru.netology.javaqa.javaqamvn.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

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
    void searchByTextName() {
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