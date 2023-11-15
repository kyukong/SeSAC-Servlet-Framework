package com.sesac.project.article.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sesac.project.mvc.fx.AbstractController;
import com.sesac.project.mvc.fx.ModelAndView;

public class ArticleInsert extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/WEB-INF/article/insert.jsp");
    }
}
