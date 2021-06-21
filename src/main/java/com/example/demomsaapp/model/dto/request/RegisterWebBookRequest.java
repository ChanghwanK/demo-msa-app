package com.example.demomsaapp.model.dto.request;

import com.example.demomsaapp.model.entity.WebBook;
import java.time.LocalDateTime;
import lombok.AccessLevel;
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
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class RegisterWebBookRequest {

    private String title;
    private String description;

    public WebBook toEntity () {
        return WebBook.builder()
            .title(title)
            .description(description)
            .createdAt(LocalDateTime.now())
            .build();
    }
}
