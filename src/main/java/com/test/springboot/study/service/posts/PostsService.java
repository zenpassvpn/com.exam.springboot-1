package com.test.springboot.study.service.posts;

import com.test.springboot.study.domain.posts.Posts;
import com.test.springboot.study.domain.posts.PostsRepository;
import com.test.springboot.study.web.dto.PostsResponseDto;
import com.test.springboot.study.web.dto.PostsSaveRequestDto;
import com.test.springboot.study.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        System.out.println("PostsService.save() .....");
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    /* Step 26 , update

     */
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        System.out.println("----------------------- Service.update()");
        Posts posts = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("찾는 원본 게시글 없음. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("찾는 원본 게시글 없음. id = " + id));
        return new PostsResponseDto(entity);
    }
}

/*
    study/web/dto/PostsSaveRequestDto
    study/service/posts/PostsService
    study/web/PostsApiController
 */
