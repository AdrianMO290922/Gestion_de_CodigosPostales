package com.example.service;

import com.example.repository.CPRepository;

public class CPService {
    CPRepository cpRepository;
    public CPService(CPRepository cpRepository){
        this.cpRepository = cpRepository;
    }
}
