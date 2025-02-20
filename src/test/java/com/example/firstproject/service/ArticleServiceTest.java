package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService;
    @Test
    void index() {
        // 1. 예상 데이터
        Article a = new Article(1L, "가가가", "1111");
        Article b = new Article(2L, "나나나", "2222");
        Article c = new Article(3L, "다다다", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));

        // 2. 실제 데이터
        List<Article> articles = articleService.index();
        // 3. 비교 및 검증
        assertEquals (expected.toString(), articles.toString());
    }

    @Test
    void show_성공_존재하는_id_입력() {
        Long id = 1L;
        Article expected = new Article(id, "가가가", "1111");
        Article article = articleService.show(id);
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    void show_실패_존재하지_않는_id_입력() {
        Long id = -1L;
        Article expected = null;
        Article article = articleService.show(id);
        assertEquals(expected, article);
    }
    @Transactional
    @Test
    void create_성공() {
        String title = "라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);
        Article article = articleService.create(dto);
        assertEquals(expected.toString(), article.toString());
    }
    @Transactional
    @Test
    void create_실패() {
        Long id = -1L;
        String title = "라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;
        Article article = articleService.create(dto);
        assertEquals(expected, article);
    }
    @Transactional
    @Test
    void update_성공() {
        Long id = 1L;
        String title = "가가가";
        String content = "1111";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(id, title, content);
        Article article = articleService.update(id, dto);
        assertEquals(expected.toString(), article.toString());
    }
    @Transactional
    @Test
    void update_실패() {
        Long id = -1L;
        String title = "가가가";
        String content = "1111";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;
        Article article = articleService.update(id, dto);
        assertEquals(expected, article);
    }
    @Transactional
    @Test
    void delete_성공() {
        Long id = 2L;
        Article expected = new Article(2L, "나나나", "2222");
        Article article = articleService.delete(id);
        assertEquals(expected.toString(), article.toString());
    }
    @Transactional
    @Test
    void delete_실패() {
        Long id = -1L;
        Article expected = null;
        Article article = articleService.delete(id);
        assertEquals(expected, article);
    }
}