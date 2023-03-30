package com.example.ders1_2.repository;

import com.example.ders1_2.model.author;
import com.example.ders1_2.model.book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface authorrepository extends JpaRepository<author,Long> {
}
