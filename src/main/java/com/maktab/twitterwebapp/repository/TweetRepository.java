package com.maktab.twitterwebapp.repository;

import com.maktab.twitterwebapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface TweetRepository extends JpaRepository<Account, Long>,
        JpaSpecificationExecutor<Account> {
}
