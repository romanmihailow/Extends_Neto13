package ru.netology.javaqa.javaqamvn.services;

public class AlreadyExistsException extends RuntimeException{

    public AlreadyExistsException(int id) {

        super("The id " + id + " already exists");

    }
}
