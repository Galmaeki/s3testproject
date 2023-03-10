package com.example.s3testproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Diary {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long diary_id;  // 일기 pk

    @Column(length = 1000)
    private String content; // 일기 내용

    @Column
    private String imageUrl;

    public Diary(String content, String imageUrl){
        this.content = content;
//        this.imageUrl = imageUrl;
    }

}
