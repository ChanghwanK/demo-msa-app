package com.example.demomsaapp.repository;

import com.example.demomsaapp.model.entity.WebBook;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Created by Bloo
 * @Date: 2021/06/21
 */


public interface WebBookRepository extends JpaRepository<WebBook, Long> {

}
