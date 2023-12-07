package com.example.EmploymentManagementSystem.exceptions;

public class EntityDoesNotExistException extends RuntimeException{
    private String message;

    public EntityDoesNotExistException(String message)
    {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
