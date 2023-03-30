package com.example.ders1_2.controller;

import com.example.ders1_2.dto.authordto;
import com.example.ders1_2.dto.bookdto;
import com.example.ders1_2.methods.checkingRole;
import com.example.ders1_2.model.Role;
import com.example.ders1_2.model.User;
import com.example.ders1_2.model.book;
import com.example.ders1_2.repository.UserRepository;
import com.example.ders1_2.service.authorservice;
import com.example.ders1_2.service.bookservice;
import com.example.ders1_2.service.roleservices;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/books")
@AllArgsConstructor
@Slf4j
public class bookcontroller {
    public final bookservice service;
    public final authorservice authorservice;
    UserRepository userRepository;
    private final roleservices roleservices;
    private checkingRole checkingRole;


    @GetMapping("/{id}")
    public bookdto getbookbyid(@PathVariable Long id) {
        System.out.println(service.getbookbyid(id).getName());
        return service.getbookbyid(id);
    }


    //butun kitablar get edilir
    @GetMapping("/all")
    public List<bookdto> getall() {
        return service.allbooks();
    }


    //ASAGIDAKI SADECE ADLARINI GETIRIR BUTUN KITABLARIN:
    @GetMapping("/all2")
    public List<List<String>> getall2() {
        return service.allbooks2();
    }


    //authorlari id ile get edilir:
    @GetMapping("author/{id}")
    public authordto getauthorbyid(@PathVariable Long id) {
        System.out.println(authorservice.getauthorbyid(id).getName());
        return authorservice.getauthorbyid(id);
    }

    @PostMapping("/createbook")
    public bookdto createbook(@RequestBody bookdto dto,Principal principal) {
        if (checkingRole.checkRole(principal,"Role_ADMIN" )||checkingRole.checkRole(principal,"ROLE_Publisher" ))
        {

            return service.createbook(dto);
        }
        else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

    }



    @PutMapping("/update")
    public bookdto updatebook(@RequestBody bookdto dto) {
        return service.updatebook(dto);
    }


    @DeleteMapping("/{id}")
    public void deletebook(@PathVariable Long id) {
        service.deletebook(id);
    }

// ASAGIDAKI PUBLISHERLERIN KITABLARININ SIYAHISINI CIXARIR:
    @GetMapping("/pub_name/{name}")
    public List<bookdto> findByPub_Name_withalgo(@PathVariable String name) {
        List<bookdto> all=service.allbooks();
        List<bookdto>findedbooks=new ArrayList<>();
        for (bookdto x:all)
        {
            if (x.getPublisher().getName().equals(name))
            {
                findedbooks.add(x);
            }
        }
        return findedbooks;
    }


//ASAGIDAKI KITABLARI ADI ILE PAGE VASITESI ILE GETIRIR
    @GetMapping("/all/{name}")
    public Page<book> findall(@PathVariable String name) {
        Pageable paging = PageRequest.of(0, 2);
        return service.findByname(name,paging);
    }


    //ANCAQ PUBLISHERIN OZUNE AID KITABLARI UPDATE EDE BILIR
    @PutMapping("/updatemy")
    public bookdto updatebookbypublishers(@RequestBody bookdto dto,Principal principal) {
        String username= principal.getName();

        User user = userRepository.findByName(username);
        if (user==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        String user_pub_name=user.getPublisher().getName();
        String wantedchange_pub_name= dto.getPublisher().getName();
        log.info("user pub name {}",user_pub_name);
        log.info("wanted change pub name {}",wantedchange_pub_name);
       if (user_pub_name.equals(wantedchange_pub_name))
       {
           return service.updatebook(dto);
       }
        else throw new ResponseStatusException(HttpStatus.FORBIDDEN);


    }

}
