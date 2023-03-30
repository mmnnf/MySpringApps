package com.example.ders1_2.service;

import com.example.ders1_2.dto.authordto;
import com.example.ders1_2.dto.bookdto;
import com.example.ders1_2.model.author;
import com.example.ders1_2.repository.authorrepository;
import com.example.ders1_2.repository.bookrepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service//bunun vasitesi ile dependency injection bas verir
public class authorimpl implements authorservice {
    private final authorrepository repository;  //???? BU NECE IMPLEMENTASIYASIZ ISLEYIR YENIki @RequiredArgsConstructor normal isleyir imp olmadan
    private final ModelMapper mapper;
    @Override
    public authordto getauthorbyid(Long id) {
        author byid=repository.findById(id).get();
        authordto dto = mapper.map(byid, authordto.class);
        return dto;
    }
}
