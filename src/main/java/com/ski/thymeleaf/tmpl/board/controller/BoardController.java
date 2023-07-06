package com.ski.thymeleaf.tmpl.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ski.thymeleaf.tmpl.board.domain.Board;
import com.ski.thymeleaf.tmpl.board.service.BoardService;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/all")
	public List<Board> getBoardAll() {
		return this.boardService.getBoardAll();
	}
}
