package com.example.demomsaapp.service;

import com.example.demomsaapp.model.dto.response.WebBookChapterResponse;
import com.example.demomsaapp.model.dto.response.WebBookResponse;
import com.example.demomsaapp.model.entity.ReaderWebBookPayment;
import com.example.demomsaapp.repository.ReaderWebBookPaymentRepository;
import com.example.demomsaapp.repository.WebBookChapterRepository;
import com.example.demomsaapp.repository.WebBookRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Created by Bloo
 * @Date: 2021/06/21
 */
@RequiredArgsConstructor
@Service
public class ApiWebBookService {

    private final WebBookRepository webBookRepository;
    private final WebBookChapterRepository webBookChapterRepository;
    private final ReaderWebBookPaymentRepository readerWebBookPaymentRepository;

    public List<WebBookResponse> getWebBookList () {
        return webBookRepository.findAll().stream().map(webBook -> WebBookResponse.from(webBook))
            .collect(Collectors.toList());
    }

    public List<WebBookChapterResponse> getWebBookList (Long readerId, Long webBookId) {
        List<ReaderWebBookPayment> readerWebBookPayments = readerWebBookPaymentRepository.findAllByReaderId(readerId);

        List<WebBookChapterResponse> webBookChapterResponses = webBookChapterRepository.findAllById(List.of(webBookId)).stream()
            .map(webBookChapter -> WebBookChapterResponse.from(webBookChapter))
            .collect(Collectors.toList());

        readerWebBookPayments.forEach(readerWebBookPayment -> {
            WebBookChapterResponse webBookChapterDto = webBookChapterResponses.stream().filter(webBookChapterDto1 ->
                webBookChapterDto1.getWebBookChapterId().equals(readerWebBookPayment.getWebBookChapterId())).findFirst().get();
            if (webBookChapterDto != null) {
                webBookChapterDto.setIsPaid(true);
            } else {
                webBookChapterDto.setIsPaid(false);
            }
        });
        return webBookChapterResponses;
    }
}
