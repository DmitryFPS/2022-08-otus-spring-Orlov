package ru.spring.orlov.exception;

public class NoSuchMenuItem extends RuntimeException {
    public NoSuchMenuItem(String message) {
        super(message);
    }

    public NoSuchMenuItem(String message, Throwable cause) {
        super(message, cause);
    }
}