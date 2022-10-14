package com.maktab.twitterwebapp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseBody
    public ExceptionResponseClient handleAccountNotFoundException(AccountNotFoundException exception) {

        ExceptionResponseClient exceptionResponseClient = new ExceptionResponseClient();

        exceptionResponseClient.setErrorMassage(exception.getMessage());

        return exceptionResponseClient;

    }

}
