package com.mbcjava2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalcController {

	@ResponseBody
	@GetMapping("/calc")
	public String calc(
			@RequestParam("n1") int n1, 
			@RequestParam("n2") int n2, 
			@RequestParam("opr") String opr
			) {
		String result = n1 + " " + opr + " " + n2 + " = ";
		switch(opr) {
		case"+":
			return result += (n1+n2+"");
		case"-":
			return result += (n1-n2+"");
		case"*":
			return result += (n1*n2+"");
		case"/":
			return result += (n1/n2+"");
		case"%":
			return result += (n1%n2+"");
		default:
			return "미지원 연산자입니다";
		}
	}
}
