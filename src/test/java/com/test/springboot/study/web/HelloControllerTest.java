package com.test.springboot.study.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/*
Step 7
    HelloControllerTest 처럼 맨 뒤에 Test 붙이것이 관례

    @ExtendWith  : JUnit4에서 @RunWith
        스프링 부트 테스트와 JUnit 연결을 수행

    @WebMvcTest
        @Controller, @ControllerAdvice등을 사용가능하다.
        Service , Repository 등에서는 사용할 수 없다.

    STATUS
        cf. 구글 : HTTP RFC

        1xx: Trying
            100 Trying ------------------->
            180 Ringing <-------------------
        2xx: OK
            200 OK
        3xx: Temporary Error, Rediction Error
            100 -------------------------->
            3xx <--------------------(010-1111-2222)
            100 --------------------> 010-1111-2222
            180 <--------------------
        4xx: Permanent Error, Client Error
            404 Not Found
            405 Method Not Allowed
            403 Forbidden
        5xx: Server Error
            501 : Gateway Error
        6xx: Global Error
Step 11 계속
    주소창에
    http://localhost:8080/hello/dto/name=홍길동&amount=1234 와 같은 처리를 위해
    코드가 변경
 */

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void helloReturned() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDtoReturnTest() throws Exception {
        String name = "hello Spring Boot User";
        int amount = 1234;

        /*
        JPA 사용하지 않았을 때, MockMvc
         */
        // localhost:8080/hello/dto/?name=홍길동&amount=1234
        mvc.perform(get("/hello/dto")
                    .param("name", name)
                    .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));



    }
}
