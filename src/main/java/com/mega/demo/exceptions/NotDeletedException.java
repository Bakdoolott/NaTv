package com.mega.demo.exceptions;

public class NotDeletedException extends RuntimeException {
    public NotDeletedException(String message) {
        super(message);
    }
}
