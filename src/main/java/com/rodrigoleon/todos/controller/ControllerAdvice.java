package com.rodrigoleon.todos.controller;

import com.rodrigoleon.todos.dto.ErrorDto;
import com.rodrigoleon.todos.exception.folder.FolderDoesNotExistException;
import com.rodrigoleon.todos.exception.task.TaskDoesNotExistException;
import com.rodrigoleon.todos.exception.user.UserDoesNotExistException;
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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(FolderDoesNotExistException.class)
    public ErrorDto handleFolderDoesNotExistException(FolderDoesNotExistException e) {
        return new ErrorDto(2, "Folder id do not exists");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserDoesNotExistException.class)
    public ErrorDto handleUserDoesNotExistException(UserDoesNotExistException e) {
        return new ErrorDto(3, "User id do not exists");
    }

}