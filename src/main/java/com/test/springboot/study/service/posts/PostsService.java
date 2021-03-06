package com.test.springboot.study.service.posts;

import com.test.springboot.study.domain.posts.Posts;
import com.test.springboot.study.domain.posts.PostsRepository;
import com.test.springboot.study.web.dto.PostsListResponseDto;
import com.test.springboot.study.web.dto.PostsResponseDto;
import com.test.springboot.study.web.dto.PostsSaveRequestDto;
import com.test.springboot.study.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

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
    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("찾는 원본 게시글 없음. id = " + id));

        postsRepository.delete(posts);
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("찾는 원본 게시글 없음. id = " + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {

        return postsRepository
                .findAllDesc()
                .stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}

/*
    study/web/dto/PostsSaveRequestDto
    study/service/posts/PostsService
    study/web/PostsApiController
 */
