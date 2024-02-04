package shop.mtcoding.firstproject.repository;

import org.springframework.data.repository.CrudRepository;
import shop.mtcoding.firstproject.entity.Article;

import java.util.ArrayList;


public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Override
    ArrayList<Article> findAll();
}
