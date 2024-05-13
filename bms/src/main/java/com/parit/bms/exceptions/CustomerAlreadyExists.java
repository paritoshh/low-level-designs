package com.parit.bms.exceptions;

public class CustomerAlreadyExists extends RuntimeException {
    public CustomerAlreadyExists(String s) {
        super(s);
    }
}
