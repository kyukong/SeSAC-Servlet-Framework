package com.sesac.project.article.service;

import java.sql.SQLException;
import java.util.List;

import com.sesac.project.article.dao.ArticleDao;
import com.sesac.project.article.dto.ArticleDto;

import lombok.extern.java.Log;

@Log
public class ArticleService {

    private static final ArticleService service = new ArticleService();
    private final ArticleDao dao = ArticleDao.getInstance();

    private ArticleService() {
    }

    public static ArticleService getInstance() {
        return service;
    }

    public void insertArticle(ArticleDto articleDto) throws SQLException {
        try {
            dao.insertArticle(articleDto);
        } catch (SQLException e) {
            log.info(e.getMessage());
            throw e;
        }
    }

    public List<ArticleDto> getArticleList() throws SQLException {
        try {
            return dao.getArticleList();
        } catch (SQLException e) {
            log.info(e.getMessage());
            throw e;
        }
    }
}
