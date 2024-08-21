package com.swsa.exception;

public class StudentNotFoundException extends RuntimeException
{
    public StudentNotFoundException(Long id) {
        super("Address not found with id: " + id);
    }
}