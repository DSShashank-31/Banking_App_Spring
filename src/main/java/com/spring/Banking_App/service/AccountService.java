package com.spring.Banking_App.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.Banking_App.dto.AccountDto;


@Service
public interface AccountService {
	
	AccountDto createAccount(AccountDto accountDto);
	
	AccountDto getAccountById(Long id);
	
	AccountDto deposit(Long id, double amount);
	
	AccountDto withdrow(Long id,double amount);
	
	void deleteById(Long id);
	
	List<AccountDto> getAll();

}
