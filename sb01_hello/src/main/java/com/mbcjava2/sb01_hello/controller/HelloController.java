package com.mbcjava2.sb01_hello.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		return "Hello Spring Boot";
	}
	
	@ResponseBody
	@GetMapping("/get_time")
	public String get_time() {
		LocalDateTime now = LocalDateTime.now();
		return now.toString();
	}
	
	@ResponseBody
	@GetMapping("/get_lotto")
	public int[] get_lotto() {
		int[] lottoNums = new int [6];
		for (int i = 0; i < lottoNums.length; i++) {
				lottoNums[i] = (int)(Math.random()*45) +1;
		}
		return lottoNums;
	}
	
	@ResponseBody
	@GetMapping("/gugudan")
	public List<String> gugudan(@RequestParam (value = "dan",  required = false, defaultValue = "2") int dan) {
		List<String> gugudan = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			gugudan.add(dan + " X " + i + " = " + (dan*i));
		}
		return gugudan;
	}
	
	int comNum = (int)(Math.random() * 100) + 1;
	@ResponseBody
	@GetMapping("/number_guess")
	public String number_guess(@RequestParam (value = "userNum",  required = false, defaultValue = "0") int userNum) {
			if(comNum == userNum) {
				return "정답";
			} else if(comNum < userNum) {
				return "DOWN"; 
			} else {
				return "UP";
			}
	}
}
