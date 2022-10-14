package com.maktab.twitterwebapp.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountNotFoundException extends RuntimeException{


    public AccountNotFoundException(String message) {
        super(message);
    }


}
