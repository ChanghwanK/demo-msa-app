package com.example.demomsaapp.model.dto.response;

import com.example.demomsaapp.model.entity.WebBookChapter;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * @Created by Bloo
 * @Date: 2021/06/21
 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebBookChapterPaidResponse {

    private Long webBookChapterId;
    //제목
    private String title;
    //내용
    private String detail;

    private Integer price;

    private Boolean isPaid;
    private LocalDateTime createdAt;

    public static WebBookChapterPaidResponse from ( WebBookChapter webBookChapter ) {
        return WebBookChapterPaidResponse.builder()
            .webBookChapterId(webBookChapter.getWebBookChapterId())
            .title(webBookChapter.getTitle())
            .detail(webBookChapter.getDetail())
            .price(webBookChapter.getPrice())
            .createdAt(webBookChapter.getCreatedAt())
            .build();
    }
}
