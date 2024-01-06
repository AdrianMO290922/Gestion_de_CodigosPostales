package com.example.service;

import com.example.repository.ColoniaRepository;

public class ColoniaService {
    ColoniaRepository coloniaRepository;
    public ColoniaService(ColoniaRepository coloniaRepository){
        this.coloniaRepository = coloniaRepository;
    }
}
