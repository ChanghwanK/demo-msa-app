package com.example.demomsaapp.model.dto.request;

import com.example.demomsaapp.model.entity.ReaderWebBookPayment;
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
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class WebBookChapterPaymentRequest {
    private Long webBookChapterId;
    private Integer price;

    public ReaderWebBookPayment toEntity (Long readerId) {
        return ReaderWebBookPayment.builder()
            .webBookChapterId(webBookChapterId)
            .readerId(readerId)
            .paymentAmount(price)
            .createdAt(LocalDateTime.now())
            .build();
    }
}
