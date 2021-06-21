package com.example.demomsaapp.service;

import com.example.demomsaapp.model.dto.request.RegisterWebBookChapterRequest;
import com.example.demomsaapp.model.dto.request.RegisterWebBookRequest;
import com.example.demomsaapp.repository.WebBookChapterRepository;
import com.example.demomsaapp.repository.WebBookRepository;
import com.example.demomsaapp.repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Created by Bloo
 * @Date: 2021/06/21
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ApiWriterWebBookService {

    private final WebBookRepository webBookRepository;
    private final WriterRepository writerRepository;
    private final WebBookChapterRepository webBookChapterRepository;

    public Long registerWebBook ( Long writerId, RegisterWebBookRequest registerWebBookRequest ) {
        if ( webBookRepository.existsById(writerId) ) {
            return webBookRepository.save(registerWebBookRequest.toEntity()).getWebBookId();
        } else {
            throw new IllegalArgumentException("작가 ID가 존재하지 않습니다.");
        }
    }

    public Long registerWebBookChapter ( Long writerId, Long webBookId, RegisterWebBookChapterRequest registerWebBookChapterRequest ) {
        if ( writerRepository.existsById(writerId) && webBookRepository.existsById(webBookId) ) {
            return webBookChapterRepository.save(registerWebBookChapterRequest.toEntity()).getWebBookChapterId();
        } else {
            throw new IllegalArgumentException("작가 ID 혹은 웹 소설 ID 가 일치하지 않습니다.");
        }
    }
}
