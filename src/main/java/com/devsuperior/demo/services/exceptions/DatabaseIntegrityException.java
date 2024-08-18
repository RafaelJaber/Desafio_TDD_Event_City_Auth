package com.devsuperior.demo.services.exceptions;

public class DatabaseIntegrityException extends RuntimeException {
    public DatabaseIntegrityException() {
        super("Database integrity error");
    }
}
