package com.example.demomsaapp.model.dto.request;

import com.example.demomsaapp.model.entity.WebBookChapter;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Entity;
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
public class RegisterWebBookChapterRequest {

    private String title;

    private String detail;

    private Integer price;

    public WebBookChapter toEntity () {
        return WebBookChapter.builder()
            .title(title)
            .price(price)
            .detail(detail)
            .createdAt(LocalDateTime.now())
            .build();
    }
}
