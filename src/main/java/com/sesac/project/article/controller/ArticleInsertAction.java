package com.sesac.project.article.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sesac.project.article.dto.ArticleDto;
import com.sesac.project.article.service.ArticleService;
import com.sesac.project.mvc.fx.AbstractController;
import com.sesac.project.mvc.fx.ModelAndView;

import lombok.extern.java.Log;

@Log
public class ArticleInsertAction extends AbstractController {

    private final ArticleService service = ArticleService.getInstance();

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String title = request.getParameter("title");
        String password = request.getParameter("password");
        String content = request.getParameter("content");

        ArticleDto articleDto = new ArticleDto();
        articleDto.setTitle(title);
        articleDto.setName(name);
        articleDto.setPassword(password);
        articleDto.setContent(content);

        log.info(articleDto.toString());

        try {
            service.insertArticle(articleDto);
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return null;
    }
}
