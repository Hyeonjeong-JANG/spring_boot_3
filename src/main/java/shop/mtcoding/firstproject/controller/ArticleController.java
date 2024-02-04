package shop.mtcoding.firstproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.firstproject.dto.ArticleForm;
import shop.mtcoding.firstproject.entity.Article;
import shop.mtcoding.firstproject.repository.ArticleRepository;

import java.util.ArrayList;

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
        log.info(form.toString());
//        System.out.println("articleForm = " + form.toString());

        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info(article.toString());
//        System.out.println("DTO를 엔티티로 변환: "+article.toString());

        // 2. 레파지토리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
//        System.out.println("레파지토리로 엔티티를 DB에 저장: "+saved.toString());

        return "";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);
        // 1. id를 조회해 데이터 가져오기
//        Optional<Article> articleEntity = articleRepository.findById(id);
        Article articleEntity = articleRepository.findById(id).orElse(null); // id로 조회한 결과, 값이 있으면 articleEntity 변수에 값을 넣고, 해당 id값이 없으면 null을 반환해라.
     log.info("id를 조회해 데이터 가져오기");

        // 2. 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);
        log.info("모델에 데이터 등록하기: "+articleEntity);

        // 3. 뷰 페이지 설정하기

        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        log.info(model.toString());

        // 1. 모든 데이터 가져오기
//        업캐스팅
//        Iterable<Article> articleEntityList=  articleRepository.findAll();
//        다운캐스팅
        ArrayList<Article> articleEntityList= articleRepository.findAll();
        log.info(articleEntityList.toString());

        // 2. 모델에 데이터 등록하기
        model.addAttribute("articleList", articleEntityList);
        log.info(model.toString());

        // 3. 뷰 페이지 설정하기


        return "articles/index";
    }

}
