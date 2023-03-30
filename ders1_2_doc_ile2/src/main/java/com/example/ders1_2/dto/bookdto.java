package com.example.ders1_2.dto;

import com.example.ders1_2.model.author;
import com.example.ders1_2.model.book_type;
import com.example.ders1_2.model.publisher;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
@Data
public class bookdto {
    private Long id;
    private String name;
    private Integer year;
    private book_type type;
    private  author author;
    private   publisher publisher;
}
