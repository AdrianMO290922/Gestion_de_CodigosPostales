package com.example.controller;

import com.example.DTOs.CPDto;
import com.example.DTOs.ColoniaDto;
import com.example.entity.CP;
import com.example.entity.Colonia;
import com.example.payload.MensajeResponse;
import com.example.service.CPService;
import com.example.service.ColoniaService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller("/api/v1")
public class CPController {
    CPService cpService;
    ColoniaService coloniaService;
    MensajeResponse mensajeResponse;
    public CPController(CPService cpService, ColoniaService coloniaService){
        this.cpService = cpService;
        this.coloniaService = coloniaService;

    }

@Get("/CP")
    public List<CP> mostrarcP(){
    return cpService.findAll();
    }
    @Get("/CP/municipio/{id}")
    public HttpResponse<?> mostrarCp(Integer id){
        Set<CP> colCP= cpService.findMun(id);
        List<CPDto> listCpDto = colCP.stream()
                .map(cp -> CPDto.builder()


                        .build())
                .collect(Collectors.toList());
        if (colCP == null){
            mensajeResponse = MensajeResponse.builder().error(true).mensaje("No se encontraron coincidencias").codigo_postal(listCpDto).build();
            return io.micronaut.http.HttpResponse.ok(mensajeResponse);
        }
        else {
            mensajeResponse = MensajeResponse.builder().error(false).mensaje("Se encontraron "+listCpDto.size()+" que pertenecen").codigo_postal(listCpDto).build();
            return io.micronaut.http.HttpResponse.ok(mensajeResponse);
        }

    }

}


