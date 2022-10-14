package com.maktab.twitterwebapp.service.impl;

import com.maktab.twitterwebapp.dto.AccountDto;
import com.maktab.twitterwebapp.entity.Account;
import com.maktab.twitterwebapp.exception.AccountNotFoundException;
import com.maktab.twitterwebapp.repository.AccountRepository;
import com.maktab.twitterwebapp.service.AccountService;
import lombok.RequiredArgsConstructor;
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
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Long id, AccountDto accountDto) {

        if (checkNullableInAccountDto(accountDto)) return null;

        Account foundAccount = findById(id);

        if (accountDto.getFirstName() != null) {
            foundAccount.setFirstName(accountDto.getFirstName());
        }
        if (accountDto.getLastName() != null) {
            foundAccount.setLastName(accountDto.getLastName());
        }
        if (accountDto.getUsername() != null) {
            foundAccount.setUsername(accountDto.getUsername());
        }
        if (accountDto.getPassword() != null) {
            foundAccount.setPassword(accountDto.getPassword());
        }
        return save(foundAccount);
    }

    private boolean checkNullableInAccountDto(AccountDto accountDto) {
        if (accountDto.getFirstName() == null &&
                accountDto.getLastName() == null &&
                accountDto.getUsername() == null &&
                accountDto.getPassword() == null) {

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
        save(account);
    }
}
