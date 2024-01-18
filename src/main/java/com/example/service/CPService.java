package com.example.service;

import com.example.DTOs.CPDto;
import com.example.entity.CP;
import com.example.entity.Colonia;
import com.example.entity.Municipio;
import com.example.repository.CPRepository;
import com.example.repository.ColoniaRepository;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Set;
@Singleton
public class CPService {
    CPRepository cpRepository;
    ColoniaRepository coloniaRepository;
    public CPService(CPRepository cpRepository ){
        this.cpRepository = cpRepository;
    }
    public List<CP> findAll(){
        return cpRepository.findAll();
    }
    public Set<CP> findMun(Integer id){return cpRepository.findMun(id);}






}
