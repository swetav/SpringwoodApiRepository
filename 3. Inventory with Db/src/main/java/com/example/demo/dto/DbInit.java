package com.example.demo.dto;

import com.example.demo.models.Article;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private ArticleRepository articleRepository;

    public DbInit(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.articleRepository.deleteAll();

        Article a1 = new Article("shoe1a",50,"This is a black shoe");
        Article a2 = new Article("shoe2",60,"This is a red shoe");
        Article a3 = new Article("shoe3",70,"This is a white shoe");
        Article a4 = new Article("shoe4",100,"This is a blue shoe");

        List<Article> articles = Arrays.asList(a1, a2, a3 , a4);

        this.articleRepository.saveAll(articles);
    }
}
