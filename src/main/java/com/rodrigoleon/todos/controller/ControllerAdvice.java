package com.rodrigoleon.todos.controller;

import com.rodrigoleon.todos.dto.ErrorDto;
import com.rodrigoleon.todos.exception.task.TaskDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TaskDoesNotExistException.class)
    public ErrorDto handleTaskDoesNotExistException(TaskDoesNotExistException e) {
        return new ErrorDto(1, "Task id do not exists");
    }

}