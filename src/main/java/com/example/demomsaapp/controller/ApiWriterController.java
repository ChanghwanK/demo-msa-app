package com.example.demomsaapp.controller;

import com.example.demomsaapp.model.dto.request.RegisterWebBookChapterRequest;
import com.example.demomsaapp.service.ApiWriterService;
import com.example.demomsaapp.model.dto.request.RegisterWebBookRequest;
import com.example.demomsaapp.model.dto.request.RegisterWriterRequest;
import com.example.demomsaapp.service.ApiWriterWebBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by Bloo
 * @Date: 2021/06/20
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/writer")
@RestController
public class ApiWriterController {

    private final ApiWriterService writerService;
    private final ApiWriterWebBookService writerWebBookService;

    @PostMapping("/")
    public ResponseEntity<Long> registerWriter(@RequestBody RegisterWriterRequest registerWriterRequest) {
        return ResponseEntity.ok(writerService.registerWriter(registerWriterRequest));
    }

    @PostMapping("/{writerId}/webBook")
    public ResponseEntity<Long> registerWebBook(
        @PathVariable (value = "writerId") Long writerId,
        @RequestBody RegisterWebBookRequest registerWebBookRequest) {
        return ResponseEntity.ok(writerWebBookService.registerWebBook(writerId, registerWebBookRequest));
    }

    @PostMapping("/{writerId}/webBook/{webBookId}")
    public ResponseEntity<Long> registerWebBook(
        @PathVariable(value = "writerId") Long writerId,
        @PathVariable(value = "webBookId") Long webBookId,
        @RequestBody RegisterWebBookChapterRequest registerWebBookChapterReqeust) {
        return ResponseEntity.ok(writerWebBookService.registerWebBookChapter(writerId, webBookId, registerWebBookChapterReqeust));
    }
}
