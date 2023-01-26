package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reply {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id;

    @Column(nullable = false, length = 200)
    private String content;

    @ManyToOne // board 테이블과의 연관 관계 설정 (board: 게시글) // 한 게시글에는 여러 개의 답변이 작성될 수 있다.
    @JoinColumn(name="boardId")
    private Board board;

    @ManyToOne // 여러 개의 답변을 한 명이 작성할 수 있다.
    @JoinColumn(name="userId")
    private User user;

    @CreationTimestamp
    private Timestamp createDate;
}
