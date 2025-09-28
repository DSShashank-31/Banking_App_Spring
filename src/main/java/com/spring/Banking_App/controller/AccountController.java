package com.spring.Banking_App.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Banking_App.dto.AccountDto;
import com.spring.Banking_App.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)
	{
		return new ResponseEntity<AccountDto>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id)
	{
		return new ResponseEntity<AccountDto>(accountService.getAccountById(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String,Double> request)
	{
		Double amount=request.get("amount");
		AccountDto accountDto= accountService.deposit(id,amount);
		return  ResponseEntity.ok(accountDto);
	}
	
	@PutMapping("/{id}/withdrow")
	public ResponseEntity<AccountDto> withdrow(@PathVariable Long id,@RequestBody Map<String,Double> request)
	{
		Double amount=request.get("amount");
		AccountDto accountDto =accountService.withdrow(id,amount);
		return ResponseEntity.ok(accountDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id)
	{
		accountService.deleteById(id);
		return ResponseEntity.ok("Account is deleted successfully");
	}
	
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAll()
	{
		List<AccountDto> account= accountService.getAll();
		return ResponseEntity.ok(account);
	}
}
