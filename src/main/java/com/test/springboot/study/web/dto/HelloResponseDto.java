package com.test.springboot.study.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
Step 9 lombok 설치
bundle.gradle 파일에 다음을 추가
implementation('org.projectlombok:lombok')

추가했으니까, 번들 새로고침
클래스 위에 있는 두 annotation 이 자동완성되는지 확인

File > Setting > Build, Execution...> Annotation Process.. >
    Compiler > Enable annotation processing CHECK

@Getter
    필드의 get method()자동 생성
@RequiredArgsConstructor
    선언된 final field가 포함된 생성자 생성자
 */

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
