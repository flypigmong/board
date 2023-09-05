package com.example.board.service;

import com.example.board.dto.ArticleForm;
import com.example.board.entity.Article;
import com.example.board.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service // 서비스 객체 생성
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository; // 게시글 리파지터리 객체 주입

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntity(); // dto -> 엔티티로 변환한 후 article에 저장
        return articleRepository.save(article);  // article을 DB에 저장
    }

    public Article update(Long id, ArticleForm dto) {
        // 1. DTO -> 엔티티 변환하기
        Article article = dto.toEntity(); // dto를 엔티티로 변환
        log.info("id: {}, article: {}", id, article.toString());
        // 2. 타깃 조회하기
        Article target = articleRepository.findById(id).orElse(null);
        // 3. 잘못된 요청 처리하기(ex. id는 1인데 수정하려는 id는 7인경우)
        if (target == null || id != article.getId()) {
            // 400, 잘못된 요청 응답
            log.info("잘못된 요청! id: {},article: {}" , id,article.toString());
            return null;       // 응답은 컨트롤러가 함
        }
        // 4. 업데이트 및 정상 응답(200)하기
        target.path(article); // 기존 데이터에 새 데이터 붙이기
        Article updated = articleRepository.save(target);
        return updated;
    }

    public Article delete(Long id) {
        // 1. 대상 찾기
        Article target = articleRepository.findById(id).orElse(null);
        // 2. 잘못된 요청 처리하기
        if (target == null) {
            return null;      // 응답은 컨트롤러가 함
        }
        // 3. 대상 삭제하기
        articleRepository.delete(target);
        return target;          // DB에서 삭제한 대상을 컨트롤러에 반환
    }

    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos) {
        // 1. dto 묶음을 엔티티 묶음으로 변환하기
        List<Article> articleList = new ArrayList<>();
        for (int i=0; i <dtos.size(); i++) {
            ArticleForm dto = dtos.get(i);
            Article entity = dto.toEntity();
            articleList.add(entity);
        }
        // 2. 엔티티 묶음을 DB에 저장하기
        for (int i=0; i < articleList.size(); i++) {
            Article article = articleList.get(i);
            articleRepository.save(article);
        }
        // 3. 강제 예외 발생시키기
        articleRepository.findById(-1L)
                .orElseThrow(() -> new IllegalArgumentException("결제 실패!"));
        // 4. 결과 값 반환하기
        return articleList;
    }
}
