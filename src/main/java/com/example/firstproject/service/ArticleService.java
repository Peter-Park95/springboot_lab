package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {

        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto) {
        Article article = dto.toEntitiy();
        if (article.getId() != null){
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticleForm dto) {        //1 DTO -> 엔티티 변환하기
        Article article = dto.toEntitiy();
        log.info("id: {}, article: {}", id, article.toString());
        //2 타켓 조회하기
        Article target = articleRepository.findById(id).orElse(null);
        if (target == null || id != article.getId()){
            log.info("잘못된 요청! id: {}, article: {}", id, article.toString());
            return null;
        }
        target.patch(article);
        Article updated = articleRepository.save(target);
        return updated;
    }

    public Article delete(Long id) {
        // 1. 대상찾기
        Article target = articleRepository.findById(id).orElse(null);
        // 2. 잘못된 요청 처리하기
        if (target == null){
            return null;
        }
        articleRepository.delete(target);
        return target;
    }

    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos) {
        List<Article> articleList = dtos.stream()
                .map(dto->dto.toEntitiy())
                .collect(Collectors.toList());
        articleList.stream().forEach(article -> articleRepository.save(article));
        //강제예외 발생
        articleRepository.findById(-1L).orElseThrow(()-> new IllegalArgumentException("결제실패!"));
        return articleList;
    }
}
