package com.example.demomsaapp.service;

import com.example.demomsaapp.model.dto.request.RegisterWriterRequest;
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
public class ApiWriterService {

    private final WriterRepository writerRepository;

    public Long registerWriter ( RegisterWriterRequest registerWriterRequest ) {
        return writerRepository.save(registerWriterRequest.toEntity()).getWriterId();
    }
}
