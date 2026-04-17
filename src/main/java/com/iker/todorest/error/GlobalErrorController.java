package com.iker.todorest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;
import java.net.URI;
import java.nio.file.AccessDeniedException;

@RestControllerAdvice
public class GlobalErrorController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProblemDetail handleTaskNotFound(TaskNotFoundException ex){
        ProblemDetail result = ProblemDetail.forStatusAndDetail( HttpStatus.NOT_FOUND, ex.getMessage());
        result.setTitle("Tarea no encontrada");
        result.setType(URI.create("https://www.iker.com.ar/errors/task-not-found"));
        return result;
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ProblemDetail handleAuthException(AuthenticationException ex){
        ProblemDetail result = ProblemDetail.forStatusAndDetail( HttpStatus.UNAUTHORIZED, ex.getMessage());
        result.setTitle("Error de autenticación");
        result.setType(URI.create("https://www.iker.com.ar/errors/authentication"));
        return result;
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ProblemDetail handleAccessDeniedException(AccessDeniedException ex){
        ProblemDetail result = ProblemDetail.forStatusAndDetail( HttpStatus.FORBIDDEN, ex.getMessage());
        result.setTitle("Error de autenticación");
        result.setType(URI.create("https://www.iker.com.ar/errors/authentication"));
        return result;
    }
}
