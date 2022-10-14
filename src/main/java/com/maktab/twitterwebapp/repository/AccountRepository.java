package com.maktab.twitterwebapp.repository;

import com.maktab.twitterwebapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>,
        JpaSpecificationExecutor<Account> {

    Optional<Account> findByIdAndIsActive(Long id, Boolean isActive);


    List<Account> findAllByIsActive(Boolean isActive);
}
