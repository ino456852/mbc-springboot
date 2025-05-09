package com.mbcjava2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@ResponseBody
	@GetMapping("/gugudan")
	public String gugudan(@RequestParam("dan") int dan) {
		List<String> result = new ArrayList<String>();
		for (int i = 1; i < 9; i++) {
			result.add(dan+" * " + i + " = " + (dan*i)+"\n");
		}
		return result.toString();
	}
}
