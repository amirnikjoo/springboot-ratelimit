package com.efarda.sample.exception;

public class DataNotFound extends Exception {
    String data;

    public DataNotFound(String message, String data) {
        super(message);
        this.data = data;
    }
}