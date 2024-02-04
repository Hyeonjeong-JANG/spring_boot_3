package shop.mtcoding.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


// TODO: @AllArgsConstructor 이거 안 됨.
//@ToString

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
public class Article { // @AllArgsConstructor 어노테이션을 사용하면 기본 생성자를 추가로 정의해주어야 한다.

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String content;
}


