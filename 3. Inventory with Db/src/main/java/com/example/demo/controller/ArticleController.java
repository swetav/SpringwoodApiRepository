package com.example.demo.controller;

import com.example.demo.dto.ArticleRepository;
import com.example.demo.models.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @GetMapping("api/getArticles")
    public Object getArticle(){

        return this.articleRepository.findAll();
    }

    @PostMapping("api/postArticle")
    public Object insertArticle(@RequestBody Article article){

        return this.articleRepository.save(article);

    }
    @PutMapping("api/putArticle/{id}")
    public Object putArticle(@PathVariable Long id, @RequestBody Article article)
    {

        //Article oldArticle  = this.articleRepository.findById(id);

        article.setId(id);

        return this.articleRepository.save(article);

    }

    /*@PutMapping("api/updateName/{id}")
    public Object putArticle(@PathVariable Long id, @RequestBody String name)
    {

        Optional<Article> article  = this.articleRepository.findById(id);

        article.get().setName(name);

        return this.articleRepository.save((Article)article);

    }*/
    @DeleteMapping("api/deleteArticle/{id}")
    public Object deleteArticle(@PathVariable Long id){
       this.articleRepository.deleteById(id);
       return "Article " +id+ "deleted successfully";
    }

}