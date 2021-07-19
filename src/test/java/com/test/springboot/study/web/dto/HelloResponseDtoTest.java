package com.test.springboot.study.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/*
Step 10:
    web.dto.HelloResponseDto.java에 final field 선언한 것을 테스트하는 모듈

    assertThat()
        org.assertj에서 제공하는 테스트 검증 메소드
        검증하는 대상을 메소드 인자로 받아서 처리
 */
public class HelloResponseDtoTest {

    @Test
    public void lombokTest() {
        String name = "test";
        int amount = 1234;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}
