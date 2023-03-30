package com.example.ders1_2.repository;

import com.example.ders1_2.dto.bookdto;
import com.example.ders1_2.model.book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface bookrepository extends JpaRepository<book,Long>{
    List<bookdto> findBypublisher(String publisherName);

    //QEYD ASAGIDAKI SORGU ADI TAM DUZ YAZANDA GETIRIR
   // Page<book> findByname(String lastname, Pageable pagingInfo);

    //ASAGIDAKI SORGU ADI LIKE ILE GETIRIR
    @Query("SELECT m FROM book m WHERE m.name LIKE %:name%")
    Page<book> findByname(String name, Pageable pagingInfo);

    book findByid(Long id);
//    book findById(Long id);
}