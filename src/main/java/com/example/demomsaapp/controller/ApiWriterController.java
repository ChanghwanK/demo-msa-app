package com.example.demomsaapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by Bloo
 * @Date: 2021/06/20
 */
@RestController
public class ApiWriterController {

    @PostMapping("/")
    public ResponseEntity<Long> registerWriter(@RequestBody  RegisterWriterForm registerWriterForm) {
        return ResponseEntity.ok()
    }

    @PostMapping("/{writerId}/webBook")
    public ResponseEntity<Long> registerWebBook(
        @PathVariable (value = "writerId") Long writerId,
        @RequestBody RegisterWebBookForm registerWebBookForm) {
        return ResponseEntity.ok(writerWebBookService.registerWebBook(writerId, registerWebBookForm));
    }

    @PostMapping("/{writerId}/webBook/{webBookId}")
    public ResponseEntity<Long> registerWebBook(
        @PathVariable(value = "writerId") Long writerId,
        @PathVariable(value = "webBookId") Long webBookId,
        @RequestBody RegisterWebBookChapterForm registerWebBookChapterForm) {
        return ResponseEntity.ok(writerWebBookService.registerWebBookChapter(writerId, webBookId, registerWebBookChapterForm));
    }
}
