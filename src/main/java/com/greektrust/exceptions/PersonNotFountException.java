package com.greektrust.exceptions;

public class PersonNotFountException extends Exception {
    public PersonNotFountException(){
        super("PERSON_NOT_FOUND");
    }
}
