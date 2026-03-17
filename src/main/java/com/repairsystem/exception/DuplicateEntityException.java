package com.repairsystem.exception;

public class DuplicateEntityException extends RuntimeException {

    public DuplicateEntityException(String message) {
        super(message);
    }

    public DuplicateEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public static DuplicateEntityException ofField(String entityName, String field, String value) {
        return new DuplicateEntityException(entityName + " com " + field + " '" + value + "' já existe");
    }
}
