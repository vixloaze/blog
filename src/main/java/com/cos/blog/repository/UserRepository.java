package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// 자동으로 bean 으로 등록이 되기 때문에 @Repository 어노테이션이 생략 가능하다.
public interface UserRepository extends JpaRepository<User,Integer> {

}
