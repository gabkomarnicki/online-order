package com.csci318.onlineorder.controllers;

@SuppressWarnings("serial")
public class OrderNotFoundException extends RuntimeException {
    //return error message when cannot find order id
    OrderNotFoundException(Long id) {
        super("Could not find order " + id);
    }
}