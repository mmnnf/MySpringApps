package com.example.ders1_2.service;

import com.example.ders1_2.dto.logindto;
import com.example.ders1_2.dto.loginjwt;

public interface securityservice {
    public loginjwt login(logindto request);
}
