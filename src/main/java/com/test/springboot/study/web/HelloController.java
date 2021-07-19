package com.test.springboot.study.web;

import org.springframework.web.bind.annotation.*;


/*
Step 6. HelloController

    Method : 405 Method Not Allowed
    GET:  test.com/a.jsp?id=user&pass=1234 ( 256Byte ) HTTP Header , 보안문제
    POST: 입력창, HTTP Body, 보안 유리
    PUT,
    DELETE

    http://tistory.com/user/a.jsp?idx=123
    http://tistory.com/user/123
    http://tistory.com/user/hello

    @RestController
        JSON으로 반환하는 컨트롤러 making
        JavaScript Object Notation
        "/hello":"hello"

        스프링 @ResponseBody 대체

    @GetMapping
        주소창에 오는 정보(get method)를 매핑해 줘
 */

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // @GetMapping 를 다음처럼 수정 (Step 7)
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
