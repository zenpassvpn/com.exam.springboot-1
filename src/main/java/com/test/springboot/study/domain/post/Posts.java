package com.test.springboot.study.domain.post;

import com.sun.javafx.beans.IDProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
Step 21 (2일차 첫번째)
JPA를 이용하기 위해 build.gradle 에 추가
    implementation('org.springframework.boot:spring-boot-starter-data-jpa')
    implementation('com.h2database:h2')

현재의 패키지 구조를 만든다.
    study.domain.post

    id, title, author, content
 */
@Getter
@NoArgsConstructor
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
