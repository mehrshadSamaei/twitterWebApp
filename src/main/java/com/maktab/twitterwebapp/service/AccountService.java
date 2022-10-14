package com.maktab.twitterwebapp.service;


import com.maktab.twitterwebapp.dto.AccountDto;
import com.maktab.twitterwebapp.entity.Account;

import java.util.List;

public interface AccountService {

    Account save(Account account);

    Account update (Long id, AccountDto accountDto);

    Account findById(Long id);

    List<Account> findAll();

    void deleteById(Long id);

}
