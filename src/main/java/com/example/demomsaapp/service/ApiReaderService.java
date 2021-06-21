package com.example.demomsaapp.service;

import com.example.demomsaapp.model.dto.request.RegisterReaderRequest;
import com.example.demomsaapp.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Created by Bloo
 * @Date: 2021/06/21
 */

@RequiredArgsConstructor
@Service
public class ApiReaderService {
    private final ReaderRepository readerRepository;

    public Long registerReader ( RegisterReaderRequest registerReaderRequest ) {
        return readerRepository.save(registerReaderRequest.toEntity()).getReaderId();
    }
}
