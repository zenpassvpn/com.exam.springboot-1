package com.test.springboot.study.web;

import com.test.springboot.study.service.posts.PostsService;
import com.test.springboot.study.web.dto.PostsResponseDto;
import com.test.springboot.study.web.dto.PostsSaveRequestDto;
import com.test.springboot.study.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    // http://localhost:1234/api/vi/posts
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        System.out.println("PostsApiController.save() .....");
        return postsService.save(requestDto);
    }

    @PostMapping("/api/v1/posts/${id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}