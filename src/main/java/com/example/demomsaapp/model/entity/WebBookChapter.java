package com.example.demomsaapp.model.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Created by Bloo
 * @Date: 2021/06/21
 */



@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class WebBookChapter {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long webBookChapterId;
    //제목
    private String title;
    //내용
    private String detail;

    private LocalDateTime createdAt;

    private Integer price;
}
