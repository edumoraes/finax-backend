package com.finax.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleError400(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(ErrorHandlerDTO::new).toList());
    }

    /*@ExceptionHandler(Exception.class)
    public ResponseEntity handleError500() {
        return ResponseEntity.internalServerError().build();
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity handleError409() {
        return ResponseEntity.status(409).build();
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity handleErrorNullPointer() {
        return ResponseEntity.internalServerError().build();
    }*/

    private record ErrorHandlerDTO(String field, String message) {
        public ErrorHandlerDTO(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
