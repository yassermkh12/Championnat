package com.example.championnat.exceptions.handlers;

import com.example.championnat.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class ApiNotFoundHandler {
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NotFoundException.class)
    public Map<String,String> handleNotFoundException(NotFoundException e){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("errorMessage",e.getMessage());
        return errorMap;
    }
}
