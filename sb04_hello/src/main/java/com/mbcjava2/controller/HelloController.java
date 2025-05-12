package com.mbcjava2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@ResponseBody
	@GetMapping("/hello")
	public String getMethodName() {
		return "Hello";
	}

	@ResponseBody
	@GetMapping("/gugudan")
	public List getMethodName(@RequestParam("dan") int dan) {
		List<String> result = new ArrayList<String>();
		for (int i = 1; i <= 9; i++) {
			result.add(dan + " X " + i + " = " + (dan * i));
		}

		return result;
	}

	@ResponseBody
	@GetMapping("/gugudan2/{dan}")
	public String gugudan2(@PathVariable("dan") int dan) {
		List<String> result = new ArrayList<String>();
		for (int i = 1; i <= 9; i++) {
			result.add(dan + "X" + i + "=" + (dan * i));
		}

		return "<h1>" + result+ "</h1>";
	}
	
	@GetMapping("/gugudan3/{dan}")
	public String gugudan3(@PathVariable("dan") int dan
			,Model model) {
		model.addAttribute("dan",dan);
		List<String> result = new ArrayList<String>();
		for (int i = 1; i <= 9; i++) {
			result.add(dan + "X" + i + "=" + (dan * i));
		}
		model.addAttribute("result",result);
		
		return "gugudan";
	}

}
