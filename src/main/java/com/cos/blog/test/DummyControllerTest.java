package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {

    // DummyControllerTest 메서드가 메모리에 등록될 때, 이 어노테이션이 있는 것도 자동으로 메모리 등록 (의존성 주입)
    @Autowired
    private UserRepository userRepository;

    // http://localhost:8080/blog/dummy/join (요청)
    // http의 body에 username,password,email의 데이터를 가지고 요청
    // 그러면 세 변수는 join 함수의 파라미터에 쏙 들어가게 된다.
    @PostMapping("/dummy/join")
    public String join(User user) {
        System.out.println("id :" + user.getId());
        System.out.println("username :" + user.getUsername());
        System.out.println("password :" + user.getPassword());
        System.out.println("email :" + user.getEmail());
        System.out.println("role :" + user.getRole());
        System.out.println("createDate :" + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원 가입이 완료되었습니다.";
    }
}
