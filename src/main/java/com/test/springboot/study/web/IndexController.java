package com.test.springboot.study.web;


import com.test.springboot.study.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
객체로 넘어온 데이터를 템플릿 엔진(mustache)에 넘겨준다.
 */
@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    /*
    Step 31:

        http://localhost:8080/
     */

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts",postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}


// resources/static/js/app/index.js
