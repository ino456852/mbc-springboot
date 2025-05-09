package com.mbcjava2.controller;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GawibawiboGame {

    @ResponseBody
    @GetMapping("/gawibawibo")
    public String playGame(@RequestParam("choice") String user) {
        List<String> choices = List.of("가위", "바위", "보");

        if (!choices.contains(user)) {
            return "잘못된 입력입니다. 가위, 바위, 보 중에서 선택하세요.";
        }

        String com = choices.get(new Random().nextInt(3));
        String result = "당신: " + user + ", 컴퓨터: " + com + " → ";

        if (user.equals(com)) {
            result += "무승부!";
        } else if (
            (user.equals("가위") && com.equals("보")) ||
            (user.equals("바위") && com.equals("가위")) ||
            (user.equals("보") && com.equals("바위"))
        ) {
            result += "당신 승!";
        } else {
            result += "컴퓨터 승!";
        }

        return result;
    }
}
