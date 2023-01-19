package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 스프링이 com.cos.blog 패키지 이하를 스캔해서 모든 파일을 메모리에 new 하는 것이 아니리
// 특정 어노테이션이 붙어있는 클래스 파일들을 new 해서 스프링 컨테이너에 관리 해줍니다.
@RestController
public class BlogControllerTest {

    @GetMapping("/test/hello")
    public String hello() {
        return "<h1>Hello spring boot</h1>";
    }

}
