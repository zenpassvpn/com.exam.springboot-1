package com.test.springboot.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Step 5. 프로그램의 시작포인트를 만든다: main()
@SpringBootApplication
    스프링부트의 시작설정, 자동 설정
    프로젝트의 최상단에 위치
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
