package com.carlos.springvscode.controller.exceptions;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import com.carlos.springvscode.services.exceptions.DataIntegrityException;
import com.carlos.springvscode.services.exceptions.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objctNotFound(ObjectNotFoundException e, HttpServletRequest request){
        
        StandardError stErro = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(stErro);    

    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> deleteIntegrity(DataIntegrityException e, HttpServletRequest request){
        
        StandardError stErro = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(stErro);    

    }

    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validatioEntity(MethodArgumentNotValidException e, HttpServletRequest request){
        
        ValidationError stErro = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação!", System.currentTimeMillis());
        for (FieldError x : e.getBindingResult().getFieldErrors()){
            stErro.addError(x.getField(), x.getDefaultMessage());
            
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(stErro);    

    }
}
