package com.example.ders1_2.service;


import com.example.ders1_2.dto.bookdto;
import com.example.ders1_2.model.author;
import com.example.ders1_2.model.book;
import com.example.ders1_2.model.publisher;
import com.example.ders1_2.repository.authorrepository;
import com.example.ders1_2.repository.bookrepository;
import com.example.ders1_2.repository.publisherrepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service//bunun vasitesi ile dependency injection bas verir
public class bookserviceimpl implements bookservice{
    private final bookrepository repository;  //???? BU NECE IMPLEMENTASIYASIZ ISLEYIR YENIki @RequiredArgsConstructor normal isleyir imp olmadan
    private final ModelMapper mapper;
private final authorrepository authorrepository;
private final publisherrepository publisherrepository;
    @Override
    public List<bookdto> allbooks() {
        List<book> byid=repository.findAll();
        List<bookdto> dto=new ArrayList<>();
        for (int i = 0; i < byid.size(); i++) {
            dto.add(mapper.map(byid.get(i), bookdto.class));
        }

        return dto;
    }

    @Override
    public List<List<String>> allbooks2() {
        List<book> byid=repository.findAll();
        List<bookdto> dto=new ArrayList<>();
        for (int i = 0; i < byid.size(); i++) {
            dto.add(mapper.map(byid.get(i), bookdto.class));
        }
        List<List<String>> netice=new ArrayList<>();
        for (int i = 0; i < byid.size(); i++) {

            dto.add(mapper.map(byid.get(i), bookdto.class));
            List<String> netice2=new ArrayList<>();
            netice2.add(dto.get(i).getName());
            netice2.add(dto.get(i).getYear().toString());
            netice2.add(dto.get(i).getAuthor().toString());
            netice2.add(dto.get(i).getPublisher().toString());
            netice.add(netice2);
        }
        return netice;
    }

    @Override
    public bookdto detailsbook(Long id) {
        book byid=repository.getById(id);
        bookdto dto=new bookdto();
        dto=mapper.map(byid, bookdto.class);
        return dto;
    }


    //private final ModelMapper mapper=new ModelMapper(); connfig->bean yaratmasaq bele de etmek olar ki implemanntasiyasi yaransin ki requiredarg islesin
    @Override
    public bookdto getbookbyid(Long id) {
        book byid=repository.findById(id).get();
//        book byid=repository.findByid(id);
        bookdto dto = mapper.map(byid, bookdto.class);
        return dto;
        ///////////mapper olmasa asagidaki kodlar ile  bir bir yazmalisan hamisini
//        studentdto a=new studentdto();
//        a.setAge(byid.getAge());
//        a.setName(byid.getName());
//        a.setId(byid.getId());
//        return a;
    }

//    @Override
//    public bookdto createbook(bookdto dto) {
//        book book=mapper.map(dto,book.class);
//        book save=repository.save(book);
//        return mapper.map(save,bookdto.class);
//
//    }

    @Override
    public bookdto createbook(bookdto dto) {
        book book = mapper.map(dto, book.class);
        author author = book.getAuthor();
        author = authorrepository.findById(author.getId()).orElse(null);
        book.setAuthor(author);

        publisher publisher=book.getPublisher();
        publisher=publisherrepository.findById(publisher.getId()).orElse(null);
        book.setPublisher(publisher);

        book savedBook = repository.save(book);
        return mapper.map(savedBook, bookdto.class);


    }



    @Override
    public void deletebook(Long id) {
        repository.deleteById(id);
    }

    @Override
    public bookdto updatebook(bookdto dto) {
        book book = repository.findById(dto.getId()).orElseThrow(() -> new RuntimeException("data tapilmadi"));
        book.setYear(dto.getYear());
        book.setName(dto.getName());/// BUNLARI MAPPER ILE YOXLA
        book save=repository.save(book);
        return mapper.map(save,bookdto.class);
    }

    @Override
    public List<bookdto> findByPub_Name(String name) {
        return repository.findBypublisher(name);
    }

    @Override
    public Page<book> findByname(String name, Pageable pageable) {

        return repository.findByname(name, pageable );
    }


}
