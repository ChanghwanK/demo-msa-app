package com.example.demomsaapp.model.dto.request;

import com.example.demomsaapp.model.entity.Writer;
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
public class RegisterWriterRequest {

    private String name;

    public Writer toEntity() {
        return Writer.builder()
            .name(name)
            .createdAt(LocalDateTime.now())
            .build();
    }
}
