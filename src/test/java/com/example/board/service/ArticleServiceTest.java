package com.example.board.service;

import com.example.board.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*; //
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;
    @Test
    void index() {
        //1. 예상 데이터
        Article a = new Article(1L, "가가가가", "1111");   //예사아 데이터 객체로 저장
        Article b = new Article(2L, "나나나나", "2222");
        Article c = new Article(3L, "다다다다", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c)); //a,b,c 합치기
        //2. 실제 데이터
        List<Article> articles = articleService.index();
        //3. 비교 및 검증
        assertEquals(expected.toString(), articles.toString());
    }
}