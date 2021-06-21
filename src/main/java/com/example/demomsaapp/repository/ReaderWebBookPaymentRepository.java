package com.example.demomsaapp.repository;

import com.example.demomsaapp.model.entity.ReaderWebBookPayment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Created by Bloo
 * @Date: 2021/06/21
 */

public interface ReaderWebBookPaymentRepository extends JpaRepository<ReaderWebBookPayment, Long> {

    List<ReaderWebBookPayment> findAllByReaderId ( Long readerId );
    ReaderWebBookPayment findByReaderIdAndWebBookChapterId(Long readerId, Long webBookChapterId);

}
