package shop.mtcoding.firstproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.firstproject.dto.ArticleForm;
import shop.mtcoding.firstproject.entity.Article;
import shop.mtcoding.firstproject.repository.ArticleRepository;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    // articles를 뺀다면? 절대 안 됨!!!
    @GetMapping("/articles/new") // articles를 뺀다면?
    public String newArticleForm() {

        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
//        System.out.println("articleForm = " + form.toString());

        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        System.out.println("DTO를 엔티티로 변환: "+article.toString());

        // 2. 레파지토리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        System.out.println("레파지토리로 엔티티를 DB에 저장: "+saved.toString());

        return "";
    }
}
