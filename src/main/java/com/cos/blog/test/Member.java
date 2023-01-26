package com.cos.blog.test;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Member {
    private int id; // final로 하는 이유 : 불변성 유지 데이터베이스에서 데이터를 가져오는 것이기 때문에
    private String username;
    private String password;
    private String email;

    @Builder
    public Member(int id, String username,String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
