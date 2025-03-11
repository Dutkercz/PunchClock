package dev_java._5.punch_clock.infra;

import jakarta.validation.Validation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException e) {
        List<FieldError> errors = e.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream()
                .map(ValidationError::new).toList());
    }


    private record ValidationError(String campo, String mensagem) {
        public ValidationError(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
