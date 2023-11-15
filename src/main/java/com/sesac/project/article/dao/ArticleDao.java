package com.sesac.project.article.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.sesac.project.article.dto.ArticleDto;
import com.sesac.project.mvc.fx.ResourcesReader;
import com.sesac.project.util.DBConnector;

import lombok.extern.java.Log;

@Log
public class ArticleDao {

    private static final ArticleDao dao = new ArticleDao();

    private ArticleDao() {
        DBConnector.drive();
    }

    public static ArticleDao getInstance() {
        return dao;
    }

    public void insertArticle(ArticleDto articleDto) throws SQLException {
        String sql =
            """
                insert into article(no, title, name, content, password)
                values(seq_article.nextVal, ?, ?, ?, ?)
                """;
        try (
            Connection conn = DBConnector.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, articleDto.getTitle());
            pstmt.setString(2, articleDto.getName());
            pstmt.setString(3, articleDto.getContent());
            pstmt.setString(4, articleDto.getPassword());
            pstmt.executeQuery();
        }
    }

    public List<ArticleDto> getArticleList() throws SQLException {
        String sql =
            """
                select no, title, name, regdate, readcount
                from article
                order by no desc
                """;
        List<ArticleDto> list = new ArrayList<>();
        try (
            Connection conn = DBConnector.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
        ) {
            while (rs.next()) {
                ArticleDto dto = new ArticleDto();
                dto.setNo(rs.getLong("no"));
                dto.setTitle(rs.getString("title"));
                dto.setName(rs.getString("name"));
                dto.setRegdate(rs.getDate("regdate"));
                dto.setReadcount(rs.getInt("readcount"));
                list.add(dto);
            }
            return list;
        }
    }
}
