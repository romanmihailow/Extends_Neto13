package ru.netology.javaqa.javaqamvn.services;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {


    @Test
    public void testGetPrice() {
        Product product = new Product(1, "Book name_one", 100);
        int actual = product.getPrice();
        int expected = 100;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetName() {
        Product product = new Product(1, "Book name_one", 100);
        String actual = product.getName();
        String expected = "Book name_one";
        assertEquals(expected, actual);
    }

    @Test
    public void testSetName() {
        Product product = new Product(1, "Book name_one", 100);
        String actual = product.setName("Simpson");
        String expected = "Simpson";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAuthor() {
        Product book = new Book(1, "Book name_one", 100, "Author one");
        String expected = "Author one";
        String actual = ((Book) book).getAuthor();
    }






}
