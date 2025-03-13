package dev_java._5.punch_clock.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException e) {
        List<FieldError> errors = e.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream()
                .map(ValidationError::new).toList());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity errorSQL(SQLIntegrityConstraintViolationException e){
        return ResponseEntity.badRequest()
                .body(e.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity entityNotFound(){
        return ResponseEntity.badRequest()
                .body(new CustomExceptionHandler("User not found."));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity noSuchElement(){
        return ResponseEntity.badRequest()
                .body(new CustomExceptionHandler("User not found."));
    }


    private record ValidationError(String campo, String mensagem) {
        public ValidationError(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
