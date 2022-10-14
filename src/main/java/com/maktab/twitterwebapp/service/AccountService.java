package com.maktab.twitterwebapp.service;


import com.maktab.twitterwebapp.dto.account.RegisterAccountRequestClient;
import com.maktab.twitterwebapp.dto.account.RegisterAccountResponseClient;
import com.maktab.twitterwebapp.entity.Account;

import java.util.List;

public interface AccountService {

    RegisterAccountResponseClient registerAccount(RegisterAccountRequestClient requestClient);

    Account update (Long id, RegisterAccountRequestClient registerAccountRequestClient);

    Account findById(Long id);

    List<Account> findAll();

    void deleteById(Long id);

}
