package com.mbcjava2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalcController {

	@GetMapping("/calc") //n1=3&opr=%2B&n2=4
	public String calc( 
			Model model,
			@RequestParam("n1") int n1, 
			@RequestParam("n2") int n2,  
			@RequestParam("opr") String opr  
			) {
		String result = n1+" "+opr+" "+n2+" = ";
		switch(opr) {
		case "+":
			result += (n1+n2+"");
			break;
		case "-":
			result += (n1-n2+"");
			break;
		case "*":
			result += (n1*n2+"");
			break;
		case "/":
			result += (1.0*n1/n2+"");
			break;
		case "%":
			result += (n1%n2+"");
			break;
		default:
			result = "미지원 연산자입니다";
		}
		model.addAttribute("result", result);
		return "calc_result";
	}
	
}
