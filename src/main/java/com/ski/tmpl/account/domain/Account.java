package com.ski.tmpl.account.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Account {
	
	private long id;
	private String userid;
	private String username;
	private String password;	
}
