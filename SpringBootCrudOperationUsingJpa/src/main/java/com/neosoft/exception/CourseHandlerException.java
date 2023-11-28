package com.neosoft.exception;

import com.neosoft.model.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CourseHandlerException {
    @ExceptionHandler(value={CourseNotFoundException.class})
    public ResponseEntity<Object> handleCustomer(CourseNotFoundException courseNotFoundException) {
        System.out.println("inside the handleCustomer() method");
        // create the object of CustomerException class
        CourseException courseexpection = new CourseException(courseNotFoundException.getMessage(),
                courseNotFoundException.getCause(), HttpStatus.NOT_FOUND); // constructor calling
        System.out.println("after calling constructor of CustomerException");
        return new ResponseEntity<>(courseexpection, HttpStatus.NOT_FOUND);
    }
}
