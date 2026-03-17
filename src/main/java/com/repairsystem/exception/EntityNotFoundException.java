package com.repairsystem.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public static EntityNotFoundException ofEntity(String entityName, Long id) {
        return new EntityNotFoundException(entityName + " com ID " + id + " não encontrado");
    }

    public static EntityNotFoundException ofEntity(String entityName, String field, String value) {
        return new EntityNotFoundException(entityName + " com " + field + " '" + value + "' não encontrado");
    }
}
