package com.sesac.project.article.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sesac.project.article.dto.ArticleDto;
import com.sesac.project.article.service.ArticleService;
import com.sesac.project.mvc.fx.AbstractController;
import com.sesac.project.mvc.fx.ModelAndView;

import lombok.extern.java.Log;

@Log
public class ArticleList extends AbstractController {

    private final ArticleService service = ArticleService.getInstance();

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<ArticleDto> list = service.getArticleList();
            return new ModelAndView("/WEB-INF/article/list.jsp", "list", list);
        } catch (Exception e) {
            ModelAndView mav = new ModelAndView("/WEB-INF/article/result.jsp");
            mav.addObject("msg", "게시물 리스트 출력 실패");
            mav.addObject("url", "../");
            return mav;
        }
    }
}
