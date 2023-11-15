package com.sesac.project.pilot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sesac.project.mvc.fx.AbstractController;
import com.sesac.project.mvc.fx.ModelAndView;

public class ProcessController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String iam = "그래, 난 " + name + ".";
        return new ModelAndView("/WEB-INF/pilot/process.jsp", "iam", iam);
    }
}
