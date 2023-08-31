package com.example.board.dto;

import com.example.board.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private String title; //제목
    private String content; //내용


    public Article toEntity() {
        return new Article(null, title, content);
    }
}
