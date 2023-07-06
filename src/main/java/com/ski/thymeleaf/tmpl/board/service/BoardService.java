package com.ski.thymeleaf.tmpl.board.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.ski.thymeleaf.tmpl.board.domain.Board;
import com.ski.thymeleaf.tmpl.config.RestService;

@Service
public class BoardService {

	@Value("${api.board.url}")
	private String apiBoardUrl;
	
	@Autowired
	private RestService<Board[]> restBoardArrayService;
	
	public BoardService() {}
	
	public List<Board> getBoardAll(){
		return Arrays.asList(this.restBoardArrayService.get(String.format("%s%s", apiBoardUrl, "/v1/board/all"), HttpHeaders.EMPTY,Board[].class).getBody());
	}
}
