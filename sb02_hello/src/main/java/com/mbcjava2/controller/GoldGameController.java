package com.mbcjava2.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GoldGameController {

    // 보물 좌표 (0~9 사이의 랜덤값)
    private int goldX = new Random().nextInt(10);
    private int goldY = new Random().nextInt(10);

    @ResponseBody
    @GetMapping("/treasure")
    public String findTreasure(
            @RequestParam("x") int x,
            @RequestParam("y") int y) {

        // 직선 거리 계산 (피타고라스 거리)
        double distance = Math.sqrt(Math.pow(goldX - x, 2) + Math.pow(goldY - y, 2));
        int distanceInt = (int) distance;

        if (distanceInt == 0) {
            // 정답 시 좌표 리셋
            int oldX = goldX;
            int oldY = goldY;
            goldX = new Random().nextInt(10);
            goldY = new Random().nextInt(10);
            return "🎉 정답입니다! 좌표: (" + oldX + ", " + oldY + ") → 보물이 다시 숨겨졌습니다!";
        } else {
            return "❌ 보물이 아닙니다. 거리: " + distanceInt;
        }
    }
}