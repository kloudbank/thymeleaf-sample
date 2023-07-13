package com.ski.thymeleaf.tmpl.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ski.thymeleaf.tmpl.account.domain.Account;
import com.ski.thymeleaf.tmpl.account.service.AccountService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class AccountController {

    @Autowired
    private AccountService accountService;

	@PostMapping("/account/login")
	public Account login(HttpServletRequest request
					, @RequestBody Account account) throws Exception {
		
		HttpSession session = request.getSession();

		if (session.getAttribute("username") != null) {
			session.removeAttribute("username");
		}

		Account resultAccount = this.accountService.login(account);
		
		if(resultAccount.getUsername() != null) {
			session.setAttribute("username", resultAccount.getUsername());
		} else {
			throw new Exception();
		}
		
		return resultAccount;
	}
    
}
