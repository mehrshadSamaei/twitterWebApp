package com.maktab.twitterwebapp.dto.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterAccountRequestClient {

    private String firstName;
    private String lastName;
    private String username;
    private String password;

}
