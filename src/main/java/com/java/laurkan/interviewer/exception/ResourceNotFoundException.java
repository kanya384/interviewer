package com.java.laurkan.interviewer.exception;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String resourceName, Long id) {
        super(String.format("%s с id = %d не найден", resourceName, id));
    }
}
