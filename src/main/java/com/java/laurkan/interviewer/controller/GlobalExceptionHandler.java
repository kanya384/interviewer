package com.java.laurkan.interviewer.controller;

import com.java.laurkan.interviewer.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException(Exception e, Model model) {
        model.addAttribute("error", Map.of(
                "code", HttpStatus.NOT_FOUND,
                "text", e.getMessage()
        ));
        return "oops";
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception e, Model model) {
        model.addAttribute("error", Map.of(
                "code", HttpStatus.INTERNAL_SERVER_ERROR,
                "text", e.getMessage()
        ));
        return "oops";
    }
}
