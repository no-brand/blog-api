package com.nobrand.blogapi.controller;

import com.nobrand.blogapi.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
      log.warn(e.toString());

      ErrorResponse response = new ErrorResponse("400", "argument is not valid", new HashMap<>());
      if (e.hasErrors()) {
          for (FieldError fieldError: e.getFieldErrors()) {
              String fieldName = fieldError.getField();
              String errorMessage = fieldError.getDefaultMessage();
              response.putValidation(fieldName, errorMessage);
          }
      }
      return response;
    }

}
