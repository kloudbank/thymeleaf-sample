package com.ski.tmpl.thymeleaf.account.service;

import org.springframework.stereotype.Service;

import com.ski.tmpl.thymeleaf.account.domain.Account;

@Service
public class AccountService {

	public AccountService() {}

	public Account login(Account account) {
        account.setUsername("John Doe");
		return account;
	}
    
}
