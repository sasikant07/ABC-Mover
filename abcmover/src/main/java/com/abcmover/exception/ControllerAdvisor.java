package com.abcmover.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ContainerNotFoundException.class)
    public ResponseEntity<Object> handleContainerNotFoundException(
    		ContainerNotFoundException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Container not found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(VesselNotFoundException.class)
    public ResponseEntity<Object> handleVesselNotFoundException(
    		VesselNotFoundException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Vessel not found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(ShippingLineNotFoundException.class)
    public ResponseEntity<Object> handleShippingLineNotFoundException(
    		ShippingLineNotFoundException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "ShippingLine not found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(NoRecordFoundException.class)
    public ResponseEntity<Object> handleNoRecordFoundException(
    		NoRecordFoundException ex, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "No data found");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex, HttpHeaders headers, 
        HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("status", status.value());

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
	
}
