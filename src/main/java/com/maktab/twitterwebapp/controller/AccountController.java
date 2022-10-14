package com.maktab.twitterwebapp.controller;

import com.maktab.twitterwebapp.dto.account.RegisterAccountRequestClient;
import com.maktab.twitterwebapp.dto.account.RegisterAccountResponseClient;
import com.maktab.twitterwebapp.entity.Account;
import com.maktab.twitterwebapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<RegisterAccountResponseClient> registerNewAccount(@RequestBody RegisterAccountRequestClient requestClient) {
        RegisterAccountResponseClient responseClient = accountService.registerAccount(requestClient);
        return new ResponseEntity<>(responseClient, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable("id") Long id){
        Account account = accountService.findById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);

    }

}
