package br.com.ueder.cipa_online.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiUtilException {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErroApi> genericException(ObjectNotFoundException ex) {
        ErroApi erroApi = new ErroApi(ex.getMessage());
        return new ResponseEntity<>(erroApi, HttpStatus.NOT_FOUND);
    }

}
