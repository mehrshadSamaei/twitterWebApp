package com.maktab.twitterwebapp.service.impl;

import com.maktab.twitterwebapp.dto.account.RegisterAccountRequestClient;
import com.maktab.twitterwebapp.dto.account.RegisterAccountResponseClient;
import com.maktab.twitterwebapp.entity.Account;
import com.maktab.twitterwebapp.exception.AccountNotFoundException;
import com.maktab.twitterwebapp.repository.AccountRepository;
import com.maktab.twitterwebapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public RegisterAccountResponseClient registerAccount(RegisterAccountRequestClient requestClient) {
        Account savedAccount = saveAccountInDataBase(createAccount(requestClient));

        return createRegisterResponseClient(savedAccount);
    }

    @Override
    public Account update(Long id, RegisterAccountRequestClient registerAccountRequestClient) {

        if (checkNullableInAccountDto(registerAccountRequestClient)) return null;

        Account foundAccount = findById(id);

        if (registerAccountRequestClient.getFirstName() != null) {
            foundAccount.setFirstName(registerAccountRequestClient.getFirstName());
        }
        if (registerAccountRequestClient.getLastName() != null) {
            foundAccount.setLastName(registerAccountRequestClient.getLastName());
        }
        if (registerAccountRequestClient.getUsername() != null) {
            foundAccount.setUsername(registerAccountRequestClient.getUsername());
        }
        if (registerAccountRequestClient.getPassword() != null) {
            foundAccount.setPassword(registerAccountRequestClient.getPassword());
        }
        return saveAccountInDataBase(foundAccount);
    }

    private boolean checkNullableInAccountDto(RegisterAccountRequestClient registerAccountRequestClient) {
        if (registerAccountRequestClient.getFirstName() == null &&
                registerAccountRequestClient.getLastName() == null &&
                registerAccountRequestClient.getUsername() == null &&
                registerAccountRequestClient.getPassword() == null) {

            return true;

        }
        return false;
    }

    @Override
    public Account findById(Long id) {
        Optional<Account> foundAccount = accountRepository.findByIdAndIsActive(id, true);

        if (foundAccount.isPresent()) {
            return foundAccount.get();
        } else {
            throw new AccountNotFoundException("Account not found");
        }
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAllByIsActive(true);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Account account = findById(id);
        account.setIsActive(false);
        saveAccountInDataBase(account);
    }

    private Account createAccount(RegisterAccountRequestClient accountRequestClient) {
        Account account = new Account();
        BeanUtils.copyProperties(accountRequestClient, account);
        return account;
    }

    private RegisterAccountResponseClient createRegisterResponseClient(Account account) {
        RegisterAccountResponseClient responseClient = new RegisterAccountResponseClient();
        BeanUtils.copyProperties(account, responseClient);
        return responseClient;
    }

    private Account saveAccountInDataBase(Account account) {
        return accountRepository.save(account);
    }
}
