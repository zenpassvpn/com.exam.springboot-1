package com.test.springboot.study.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

/*
Step 23 PostsRepositoryTest 추가


Step 24
    @AfterEach   : JUint4 @After
        단위테스틀 수행후 끝날때 마다 수행할 일

    실행 후, 단위테스트는 성공하지만 확인방법이 없다.
    로그확인 위한 세팅
    src/main/resources/application.properties


    mysql posts(id, title) 가정
    insert into posts values('', 'test');
    insert into posts (id, test) values('23', 'abcd'); //23
    insert into posts(test) values('xyz') ; // 24

    insert into posts(id, author, content, title) values(null, ? , ?, ?)

 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void saveAndLoad() {
        String title = "테스트 제목";
        String content = "테스트 본문";

        postsRepository.save( Posts.builder().title(title).content(content).author("user@test.com").build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntityRegister() {
        LocalDateTime now = LocalDateTime.of(2021,7,20,0,0, 0);
        postsRepository.save(Posts.builder()
                .title("title").content("content").author("author").build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println("\t\t\t ++++ createDate= "+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}