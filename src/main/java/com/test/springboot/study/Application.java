package com.test.springboot.study;


/*
Step 5. 프로그램의 시작포인트를 만든다: main()
@SpringBootApplication
    스프링부트의 시작설정, 자동 설정
    프로젝트의 최상단에 위치

    http://localhost:8080/hello/dto/?name=홍길동&amount=123
    http://localhost:8080/hello/dto?name=홍길동&amount=123

    http://localhost:8080/h2-console
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}