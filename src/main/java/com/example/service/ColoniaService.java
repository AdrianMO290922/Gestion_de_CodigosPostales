package com.example.service;


import com.example.entity.Colonia;
import com.example.repository.ColoniaRepository;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Set;
@Singleton
public class ColoniaService {
    ColoniaRepository coloniaRepository;
    public ColoniaService(ColoniaRepository coloniaRepository){
        this.coloniaRepository = coloniaRepository;
    }
    public Set<Colonia> showColCp(Integer codigo){return coloniaRepository.showColCp(codigo);}
    public List<Colonia> showColEdoMun(Integer id_edo, Integer id_mun){
        return coloniaRepository.showColEdoMu(id_edo,id_mun);
    }
}
