package com.example.board.controller;

import com.example.board.dto.ArticleForm;
import com.example.board.entity.Article;
import com.example.board.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.JavaServiceLoadable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());
        //1 .DTO를 엔티티로 변환
        Article article = form.toEntity();
        //2. 리파지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        return "";
    }
}
