package com.mbcjava2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("msg","반갑습니다");
		model.addAttribute("myname","홍길동");
		return "hello"; // 뷰(결과를 화면으로 생성) 이름 반환
	}
	
}
