package com.ski.thymeleaf.tmpl.account.service;

import org.springframework.stereotype.Service;

import com.ski.thymeleaf.tmpl.account.domain.Account;

@Service
public class AccountService {

	public AccountService() {}

	public Account login(Account account) {
        account.setUsername("John Doe");
		return account;
	}
    
}
