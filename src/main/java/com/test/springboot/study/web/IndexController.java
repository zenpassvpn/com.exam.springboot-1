package com.test.springboot.study.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    // http://localhost:8080

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
