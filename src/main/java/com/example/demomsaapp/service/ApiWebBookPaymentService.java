package com.example.demomsaapp.service;

import com.example.demomsaapp.model.dto.request.WebBookChapterPaymentRequest;
import com.example.demomsaapp.model.dto.response.WebBookChapterPaidResponse;
import com.example.demomsaapp.model.entity.ReaderWebBookPayment;
import com.example.demomsaapp.model.entity.WebBookChapter;
import com.example.demomsaapp.repository.ReaderWebBookPaymentRepository;
import com.example.demomsaapp.repository.WebBookChapterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Created by Bloo
 * @Date: 2021/06/21
 */
@RequiredArgsConstructor
@Service
public class ApiWebBookPaymentService {

    private final WebBookChapterRepository webBookChapterRepository;
    private final ReaderWebBookPaymentRepository readerWebBookPaymentRepository;

    public WebBookChapterPaidResponse payment ( Long readerId, WebBookChapterPaymentRequest webBookChapterPaymentRequest ) {

        ReaderWebBookPayment readerWebBookPayment = readerWebBookPaymentRepository.findByReaderIdAndWebBookChapterId(readerId, webBookChapterPaymentRequest.getWebBookChapterId());
        if ( readerWebBookPayment != null ) {
            throw new IllegalArgumentException("이미 결제가 되었습니다.");
        }

        WebBookChapter webBookChapter = webBookChapterRepository
            .findById(webBookChapterPaymentRequest.getWebBookChapterId()).get();

        if ( ! webBookChapter.getPrice().equals(webBookChapterPaymentRequest.getPrice()) ) {
            return null;    //금액이 다름
        }

        readerWebBookPaymentRepository.save(webBookChapterPaymentRequest.toEntity(readerId));
        return WebBookChapterPaidResponse.from(webBookChapter);
    }
}
