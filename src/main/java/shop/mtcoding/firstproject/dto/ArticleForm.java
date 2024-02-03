package shop.mtcoding.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;
import shop.mtcoding.firstproject.entity.Article;

@AllArgsConstructor
@ToString
public class ArticleForm {
    private String title; // 제목을 받을 필드
    private String content; // 내용을 받을 필드

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
