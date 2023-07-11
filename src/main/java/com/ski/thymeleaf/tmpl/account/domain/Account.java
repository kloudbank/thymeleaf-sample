package com.ski.thymeleaf.tmpl.account.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Account {
	private String userid;
	private String username;
	private String password;
}
