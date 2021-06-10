package com.agenda.exceptions;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RegistroNaoLocalizadoException.class})
    public ResponseEntity<?> handleRegistroNaoLocalizadoException(RegistroNaoLocalizadoException ex) {

       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<String> erros = ex.getBindingResult().getAllErrors().stream().map(e-> e.getDefaultMessage()).collect(Collectors.toList());

        return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
    }
}
