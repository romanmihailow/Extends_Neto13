package ru.netology.javaqa.javaqamvn.services;


import org.junit.jupiter.api.Test; // Для JUnit 5
import static org.junit.jupiter.api.Assertions.assertEquals; // Для JUnit 5

public class ProductTest {


    @Test
    public void testGetAuthor() {
        Book book = new Book(1, "Book name_one", 100, "Author one");
        String expected = "Author one";
        String actual = book.getAuthor();
        assertEquals(expected, actual);
    }


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
        product.setName("Simpson");
        String actual = product.getName();
        String expected = "Simpson";
        assertEquals(expected, actual);
    }

    @Test
    public void testProductConstructorWithName() {
        // Создаем продукт с именем
        Product product = new Product("Product name");

        // Проверяем, что имя установлено правильно
        String expected = "Product name";
        String actual = product.getName();
        assertEquals(expected, actual);
    }




}
