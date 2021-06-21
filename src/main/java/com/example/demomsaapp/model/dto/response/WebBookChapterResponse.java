package com.example.demomsaapp.model.dto.response;

import com.example.demomsaapp.model.entity.WebBookChapter;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Created by Bloo
 * @Date: 2021/06/21
 */

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebBookChapterResponse {

    private Long webBookChapterId;
    private String title;
    private LocalDateTime createdAt;
    private Integer price;
    private Boolean isPaid;

    public static WebBookChapterResponse from ( WebBookChapter webBookChapter){
        return WebBookChapterResponse.builder()
            .webBookChapterId(webBookChapter.getWebBookChapterId())
            .title(webBookChapter.getTitle())
            .createdAt(webBookChapter.getCreatedAt())
            .price(webBookChapter.getPrice())
            .build();
    }
}
