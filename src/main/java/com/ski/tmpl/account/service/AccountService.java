package com.ski.tmpl.account.service;

import org.springframework.stereotype.Service;

import com.ski.tmpl.account.domain.Account;

@Service
public class AccountService {

	public AccountService() {}

	public Account login(Account account) {
        account.setUsername("John Doe");
		return account;
	}
    
}
