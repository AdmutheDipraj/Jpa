package com.neosoft.exception;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(String errorMessage) {
        super(errorMessage); // super class constructor calling
        System.out.println("errorMessage>>" + errorMessage);
    }
}
