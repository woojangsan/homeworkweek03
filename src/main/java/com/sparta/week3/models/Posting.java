package com.sparta.week3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Posting extends Timestamped{

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String title;


    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String content;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    public Posting(PostingRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.name = requestDto.getName();
        this.content = requestDto.getContent();
        this.password = requestDto.getPassword();

    }

    public void update(PostingRequestDto requestDto) {
        this.content = requestDto.getContent();
    }
}