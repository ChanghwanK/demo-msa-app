package com.example.demomsaapp.model.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Created by Bloo
 * @Date: 2021/06/21
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class WebBook {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long webBookId;

    private String title;

    private String description;

    private LocalDateTime createdAt;
}
