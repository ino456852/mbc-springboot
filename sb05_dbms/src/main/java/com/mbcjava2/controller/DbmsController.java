package com.mbcjava2.controller;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mbcjava2.ActorRepository;
import com.mbcjava2.BoardRepository;
import com.mbcjava2.entity.Board;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class DbmsController {
	
	private final JdbcTemplate jdbcTemplate;
	// BoardRepository : Board 테이블 과의 통신 기능
	private final BoardRepository boardRepository;
	private final ActorRepository actorRepository;
	
	@ResponseBody
	@GetMapping("/connect")
	public List<Map<String, Object>> connect() {
		return jdbcTemplate.queryForList("SELECT TABLE_NAME FROM USER_TABLES");
	}
	
	
	@GetMapping("/board/list")
	public String board_list(Model model) {
		 
		Sort sort = Sort.by("bno").descending();
		model.addAttribute("board_list",boardRepository.findAll(sort));
		return "/board/list";
	}
	
	@GetMapping("/actor/list")
	public String Actor_list(Model model) {
		 
		Sort sort = Sort.by("actorId");
		model.addAttribute("actor_list",actorRepository.findAll(sort));
		return "/actor/list";
	}
}
