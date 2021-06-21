package com.example.demomsaapp.model.dto.response;

import com.example.demomsaapp.model.entity.WebBook;
import java.time.LocalDateTime;
import lombok.AccessLevel;
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
@AllArgsConstructor
@NoArgsConstructor (access = AccessLevel.PRIVATE)
public class WebBookResponse {

    private Long webBookId;
    //제목
    private String title;
    //설명
    private String description;

    private LocalDateTime createdAt;

    // 내가 봤는지?

    public static WebBookResponse from ( WebBook webBook ) {
        return WebBookResponse.builder()
            .webBookId(webBook.getWebBookId())
            .title(webBook.getTitle())
            .description(webBook.getDescription())
            .createdAt(webBook.getCreatedAt())
            .build();
    }
}
