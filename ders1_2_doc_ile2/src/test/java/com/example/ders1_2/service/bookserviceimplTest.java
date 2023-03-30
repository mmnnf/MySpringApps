package com.example.ders1_2.service;

import com.example.ders1_2.dto.bookdto;
import com.example.ders1_2.model.author;
import com.example.ders1_2.model.book;
import com.example.ders1_2.repository.bookrepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class bookserviceimplTest {
    @Mock
//    @MockBean(name="repository")
    private bookrepository repository;
    @Mock
    private ModelMapper mapper;
    @InjectMocks
    bookserviceimpl servis;

    @Test
    public void givenIdWhenGetProductThenSuccess() {
        //Arange
        book book = new book();
        book.setYear(1998);
        book.setName("beyaz_zanbaklar_olkesi");
        author aut = author.builder()
                .name("jhon ")
                .surname("stevan")
                .birthdate(1977)
                .build();
        book.setAuthor(aut);

        bookdto bookdto = new bookdto();
        bookdto.setYear(1998);
        bookdto.setName("beyaz_zanbaklar_olkesi");
        author aut2 = author.builder()
                .id(1l)
                .name("jhon ")
                .surname("stevan")
                .birthdate(1977)
                .build();
        bookdto.setAuthor(aut2);
        when(repository.findById(anyLong())).thenReturn(Optional.of(book));
        when(mapper.map(book, bookdto.class)).thenReturn(bookdto);

        //Akt

        bookdto response = servis.getbookbyid(1l);

        //Assert

        Assertions.assertEquals(response.getName(), book.getName());
        Assertions.assertEquals(response.getYear(), book.getYear());
        Assertions.assertEquals(response.getAuthor().getName(), book.getAuthor().getName());
    }

    @Test
    public void WhenCreateThenSuccess2() {
        //Arange
        book book = new book();
        book.setYear(1998);
        book.setName("beyaz_zanbaklar_olkesi");
        author aut = author.builder()
                .name("jhon ")
                .surname("stevan")
                .birthdate(1977)
                .build();
        book.setAuthor(aut);

        bookdto bookdto = new bookdto();
        bookdto.setYear(1998);
        bookdto.setName("beyaz_zanbaklar_olkesi");
        author aut2 = author.builder()
                .name("jhon ")
                .surname("stevan")
                .birthdate(1977)
                .build();
        bookdto.setAuthor(aut2);
        when(mapper.map(bookdto, book.class)).thenReturn(book);
        when(mapper.map(book, bookdto.class)).thenReturn(bookdto);
        when(repository.save(any())).thenReturn(book);

        //Akt
        bookdto b1 = servis.createbook(bookdto);

        //Assert
        Assertions.assertEquals(b1, bookdto);

    }

    @Test
    public void WhenGetAllThenSuccess() {
        //Arange

        book book = new book();
        book.setYear(1998);
        book.setName("beyaz_zanbaklar_olkesi");
        author aut = author.builder()
                .name("jhon ")
                .surname("stevan")
                .birthdate(1977)
                .build();
        book.setAuthor(aut);

        book book2 = new book();
        book2.setYear(1998);
        book2.setName("beyaz_zanbaklar_olkesi2");
        author aut2 = author.builder()
                .name("jhon 2")
                .surname("stevan 2")
                .birthdate(1978)
                .build();
        book.setAuthor(aut);

        bookdto bookdto = new bookdto();
        bookdto.setYear(1998);
        bookdto.setName("beyaz_zanbaklar_olkesi");
        author aut3 = author.builder()
                .name("jhon ")
                .surname("stevan")
                .birthdate(1977)
                .build();
        bookdto.setAuthor(aut3);

        bookdto bookdto2 = new bookdto();
        bookdto2.setYear(1998);
        bookdto2.setName("beyaz_zanbaklar_olkesi2");
        author aut4 = author.builder()
                .name("jhon 2")
                .surname("stevan 2")
                .birthdate(1978)
                .build();
        bookdto2.setAuthor(aut4);

        when(mapper.map(bookdto, book.class)).thenReturn(book);
        when(mapper.map(book, bookdto.class)).thenReturn(bookdto);
        when(mapper.map(bookdto2, book.class)).thenReturn(book2);
        when(mapper.map(book2, bookdto.class)).thenReturn(bookdto2);
        when(repository.save(any())).thenReturn(book);
        when(repository.findAll()).thenReturn(List.of(book,book2));

        //Akt
        bookdto b1 = servis.createbook(bookdto);
        bookdto b2 = servis.createbook(bookdto2);
        List<bookdto> result=servis.allbooks();

        //Assert
        Assertions.assertEquals(result, List.of(bookdto,bookdto2));
    }
}


