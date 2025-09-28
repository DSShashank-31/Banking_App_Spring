package com.spring.Banking_App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.Banking_App.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{

}
