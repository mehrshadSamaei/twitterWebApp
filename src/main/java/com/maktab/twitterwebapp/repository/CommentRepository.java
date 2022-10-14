package com.maktab.twitterwebapp.repository;

import com.maktab.twitterwebapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Account, Long>,
        JpaSpecificationExecutor<Account> {
}
