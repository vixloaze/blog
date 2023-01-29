package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title; // 제목

    @Lob // 대용량 데이터
    private String content; // 내용 섬머노트 라이브러리를 사용할 예정 <html>태그가 섞여서 디자인이 됨

    @ColumnDefault("0")
    private int count; // 조회수

    @ManyToOne(fetch = FetchType.EAGER) // Board = Many , user = One 여러개의 게시글은 한 명에 의해서 작성이 될 수 있다. (연관 관계)
    @JoinColumn(name="userId")
    private User user; // DB는 오브젝트를 저장할 수 없으나 FK,자바는 오브젝트를 저장할 수 있다.

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // Board = One , reply = Many 하나의 게시글은 여러 개의 댓글을 받을 수 있다. (연관 관계)
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}
