package com.example.ders1_2.controller;

import com.example.ders1_2.dto.logindto;
import com.example.ders1_2.dto.loginjwt;
import com.example.ders1_2.service.securityservice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class logincontroller {

    private final securityservice securityservice;
    @PostMapping("/login")
    public loginjwt login( @RequestBody logindto request )
    {
        loginjwt loginjwt=securityservice.login(request);
        if (loginjwt!=null)
        {
            return loginjwt;
        }
           // throw  new RuntimeException("user tapilmadi");
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,"user tapilmadi");
    }
//    @PostMapping("/loginn")
//    public loginjwt loginn( @RequestBody loginjwt request )
//    {
//        return request;
//    }
//    @PostMapping("/loginw")
//    public loginjwt loginw( @RequestBody loginjwt request )
//    {
//        return request;
//    }
//    @GetMapping("/login")
//    public String loging(   )
//    {
//        return "request";
//    }
//    @PostMapping("/login2")
//    public String login2(  )
//    {
//        log.info("wwwwwwww");
//       return "heyyy";
//
//
//    }
//    @PostMapping("/login3")
//    public String login3(@RequestBody logindto request  )
//    {
//        log.info("wwwwwwww");
//        return "heyyy";
//
//
//    }

}
