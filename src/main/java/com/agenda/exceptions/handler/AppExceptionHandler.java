package com.agenda.exceptions.handler;


import com.agenda.exceptions.RegistroNaoLocalizadoException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.MessageFormat;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RegistroNaoLocalizadoException.class})
    public ResponseEntity<?> handleRegistroNaoLocalizadoException(RegistroNaoLocalizadoException ex) {

       ProblemDetail  problemDetail = prepararProblemDetail(ProblemDetailEnum.REGISTRO_NAO_LOCALIZADO);
       problemDetail.getDetail().add(ex.getMessage());
       return prepararResponseEntity(problemDetail);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ProblemDetail problemDetail = prepararProblemDetail(ProblemDetailEnum.INFORMACAO_INVALIDA);
        ex.getBindingResult().getFieldErrors().forEach(e -> {
            String detail = MessageFormat.format(e.getDefaultMessage().concat(": {0}"), e.getRejectedValue().toString());
            problemDetail.getDetail().add(detail);
        });
        return prepararResponseEntity(problemDetail);
    }

    private ProblemDetail prepararProblemDetail(ProblemDetailEnum problemDetailEnum){
        ProblemDetail problemDetail = new ProblemDetail();
        problemDetail.setTitle(problemDetailEnum.title);
        problemDetail.setType(problemDetailEnum.type);
        problemDetail.setStatus(problemDetailEnum.status.value());
        return problemDetail;
    }

    private ResponseEntity<Object> prepararResponseEntity(ProblemDetail detail){
        return ResponseEntity.status(detail.getStatus()).contentType(MediaType.APPLICATION_PROBLEM_JSON).body(detail);
    }

}
