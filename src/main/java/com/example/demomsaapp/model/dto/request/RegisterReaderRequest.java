package com.example.demomsaapp.model.dto.request;

import com.example.demomsaapp.model.entity.Reader;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Created by Bloo
 * @Date: 2021/06/21
 */

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterReaderRequest {
    private String name;

    public Reader toEntity() {
        return Reader.builder()
            .name(name)
            .createdAt(LocalDateTime.now())
            .build();
    }
}
