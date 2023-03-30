package com.example.ders1_2.service;

import com.example.ders1_2.dto.bookdto;
import com.example.ders1_2.model.book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface bookservice {
    bookdto getbookbyid(Long id);
    bookdto createbook(bookdto dto);
    void deletebook(Long id);
    bookdto updatebook(bookdto dto);
    List<bookdto> allbooks();
    List<List<String>> allbooks2();
    bookdto detailsbook(Long id);
//    bookdto createbooksecure(bookdto dto);
    List<bookdto> findByPub_Name(String name);
    Page<book> findByname(String name, Pageable pageable);
}
