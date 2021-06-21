package com.example.demomsaapp.controller;

import com.example.demomsaapp.model.dto.request.RegisterReaderRequest;
import com.example.demomsaapp.model.dto.request.WebBookChapterPaymentRequest;
import com.example.demomsaapp.model.dto.response.WebBookChapterPaidResponse;
import com.example.demomsaapp.model.dto.response.WebBookChapterResponse;
import com.example.demomsaapp.model.dto.response.WebBookResponse;
import com.example.demomsaapp.service.ApiReaderService;
import com.example.demomsaapp.service.ApiWebBookPaymentService;
import com.example.demomsaapp.service.ApiWebBookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by Bloo
 * @Date: 2021/06/21
 */


@RequiredArgsConstructor
@RequestMapping("/api/reader")
@RestController
public class ApiReaderController {

    private final ApiReaderService ReaderService;
    private final ApiWebBookService webBookService;
    private final ApiWebBookPaymentService webBookPaymentService;


    @PostMapping ("/")
    public ResponseEntity<Long> registerReader(@RequestBody RegisterReaderRequest registerReaderRequest){
        return ResponseEntity.ok(ReaderService.registerReader(registerReaderRequest));
    }

    @GetMapping ("/webBook")
    public ResponseEntity<List<WebBookResponse>> getWebBookList(){
        return ResponseEntity.ok(webBookService.getWebBookList());
    }

    @GetMapping("/{readerId}/webBook/{webBookId}/chapter")
    public ResponseEntity<List<WebBookChapterResponse>> getWebBookChapterList(
        @PathVariable (value = "readerId") Long readerId,
        @PathVariable(value = "webBookId") Long webBookId){
        return ResponseEntity.ok(webBookService.getWebBookList(readerId,webBookId));
    }

    @PostMapping("/{readerId}/payment/")
    public ResponseEntity<WebBookChapterPaidResponse> paymentWebBookChapter(
        @PathVariable(value = "readerId") Long readerId,
        @RequestBody WebBookChapterPaymentRequest webBookChapterPaymentForm){
        return ResponseEntity.ok(webBookPaymentService.payment(readerId,webBookChapterPaymentForm));
    }

}
