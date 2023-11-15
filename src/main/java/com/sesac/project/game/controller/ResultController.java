package com.sesac.project.game.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sesac.project.mvc.fx.AbstractController;
import com.sesac.project.mvc.fx.ModelAndView;

public class ResultController extends AbstractController {

    private final Map<Integer, String> status = new HashMap<>();

    {
        status.put(1, "가위");
        status.put(2, "바위");
        status.put(3, "보");
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("/WEB-INF/game/result.jsp");

        int answer = Integer.parseInt(request.getParameter("value"));
        int correct = (int)(Math.random() * 3) + 1;
        String result = message(answer, correct);

        mav.addObject("answer", status(answer));
        mav.addObject("correct", status(correct));
        mav.addObject("result", result);

        return mav;
    }

    private String status(int answer) {
        return status.get(answer);
    }

    private String message(int answer, int correct) {
        if (answer == correct) {
            return "무승부입니다.";
        } else if ((answer == 1 && correct == 3) || (answer > correct)) {
            return "당신의 승리입니다.";
        }
        return "패배입니다.";
    }
}
