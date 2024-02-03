package shop.mtcoding.firstproject.repository;

import org.springframework.data.repository.CrudRepository;
import shop.mtcoding.firstproject.entity.Article;


public interface ArticleRepository extends CrudRepository<Article, Long> {

}
