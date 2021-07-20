package com.test.springboot.study.web.dto;

import com.test.springboot.study.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


// PostsApiCotroller


@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {

        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("title = " + title);
        System.out.println("content = " + content);


        return Posts.builder().title(title).content(content).author(author).build();
    }
}