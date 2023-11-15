package com.sesac.project.game.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sesac.project.mvc.fx.AbstractController;
import com.sesac.project.mvc.fx.ModelAndView;

public class ReadyController extends AbstractController {

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/WEB-INF/game/ready.jsp");
    }
}
