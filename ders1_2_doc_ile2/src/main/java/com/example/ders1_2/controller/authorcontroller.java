//package com.example.ders1_2.controller;
//
//import com.example.ders1_2.dto.authordto;
//import com.example.ders1_2.service.authorservice;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/author")
//@RequiredArgsConstructor
//public class authorcontroller {
//    public final authorservice service;
//
//
//    @GetMapping("/{id}")
//    public authordto getbookbyid(@PathVariable Long id) {
//        System.out.println(service.getauthorbyid(id).getName());
//        return service.getauthorbyid(id);
//    }
//
//}
