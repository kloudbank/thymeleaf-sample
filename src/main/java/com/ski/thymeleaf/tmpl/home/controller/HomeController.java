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
	
	@GetMapping({"","/","/index","main"})
	public String index(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("username") == null) {
			return "sign";
		}
		
		List<Board> boardList = this.boardService.getBoardAll();
		model.addAttribute(boardList);
		
		return "board";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("username") != null) {
			session.removeAttribute("userid");
			session.removeAttribute("username");
		}
		
		return "sign";
	}

	@GetMapping("/board")
	public String product(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("username") == null) {
			return "sign";
		}
		
		List<Board> boardList = this.boardService.getBoardAll();
		model.addAttribute(boardList);
		
		return "board";
	}
	
	@GetMapping("/about")
	public String about(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("username") == null) {
			return "sign";
		}
		
		return "about";
	}
	
	@GetMapping("/blog")
	public String blog(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("username") == null) {
			return "sign";
		}
		
		return "blog";
	}

	@GetMapping("/blog-detail")
	public String blogDetail(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("username") == null) {
			return "sign";
		}
		
		return "blog-detail";
	}
	
	@GetMapping("/contact")
	public String contact(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		if(session.getAttribute("username") == null) {
			return "sign";
		}
		
		return "contact";
	}
}
