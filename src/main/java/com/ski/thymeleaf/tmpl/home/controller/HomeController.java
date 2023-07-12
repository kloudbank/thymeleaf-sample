package com.ski.thymeleaf.tmpl.home.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ski.thymeleaf.tmpl.board.domain.Board;
import com.ski.thymeleaf.tmpl.board.service.BoardService;

@Controller
public class HomeController {
	
	@Autowired
	private BoardService boardService;

	String pagePrefix = "pages/";
	
	@GetMapping({"","/","/index","/main"})
	public String index(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("username") == null) {
			return pagePrefix + "sign";
		}
		
		List<Board> boardList = this.boardService.getBoardAll();
		model.addAttribute(boardList);
		
		return pagePrefix + "index";
	}

	@GetMapping("/sign")
	public String signin(Model model) {
		
		return pagePrefix + "sign";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("username") != null) {
			session.removeAttribute("username");
		}
		
		return "redirect:sign?";
		// return pagePrefix + "sign";
	}

	@GetMapping("/board")
	public String board(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("username") == null) {
			return pagePrefix + "sign";
		}
		
		List<Board> boardList = this.boardService.getBoardAll();
		model.addAttribute(boardList);

		model.addAttribute("count", 5);
		
		return pagePrefix + "board";
	}

	@GetMapping("/about")
	public String about(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("username") == null) {
			return pagePrefix + "sign";
		}
		
		model.addAttribute("count", 3);

		return pagePrefix + "about";
	}

	@GetMapping("/test")
	public String test(HttpServletRequest request, Model model) {
		
		return pagePrefix + "test";
	}
}
