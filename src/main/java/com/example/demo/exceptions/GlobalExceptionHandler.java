package com.example.demo.exceptions;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
                System.out.print(request);
                ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.NOT_FOUND.value(),
                                ex.getMessage(),
                                request.getDescription(false));
                return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        }

        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        @ExceptionHandler(Exception.class)
        public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
                ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                ex.getMessage(),
                                request.getDescription(false));
                return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        @ResponseBody
        protected ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
                List<String> errorList = ex
                                .getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(fieldError -> fieldError.getDefaultMessage())
                                .collect(Collectors.toList());
                ErrorDetails errorDetails = new ErrorDetails(new Date(), HttpStatus.BAD_REQUEST.value(),
                                "Validation Failed",
                                errorList);
                return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }
}
