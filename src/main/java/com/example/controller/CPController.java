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

    @Get("/codigos_postales")
    public HttpResponse<?> mostrarCp() {
    List<CP> list = cpService.findAll();
    List<CPDto> cpDtoList = list.stream()
            .map(cp -> CPDto.builder()
                    .estado_id(cp.getMunicipio().getEstado().getId_estado())
                    .municipio_id(cp.getMunicipio().getId_municipios())
                    .estado(cp.getMunicipio().getEstado().getEstado())
                    .municipio(cp.getMunicipio().getMunicipios())
                    .codigo_postal(cp.getCp())
                    .build()
            )
            .collect(Collectors.toList());
        if (list == null){
            mensajeResponse = MensajeResponse.builder().error(true).mensaje("No se encontraron coincidencias").codigo_postal(cpDtoList).build();
            return io.micronaut.http.HttpResponse.ok(mensajeResponse);
        }
        else {
            mensajeResponse = MensajeResponse.builder().error(false).mensaje("Se encontraron "+list.size()+" que pertenecen").codigo_postal(cpDtoList).build();
            return io.micronaut.http.HttpResponse.ok(mensajeResponse);
        }
    }

    @Get("/codigos_postales/municipio/{id}")
    public HttpResponse<?> mostrarCp(Integer id){
        Set<CP> colCP= cpService.findMun(id);
        List<CPDto> listCpDto = colCP.stream()
                .map(cp -> CPDto.builder()
                        .municipio(cp.getMunicipio().getMunicipios())
                        .codigo_postal(cp.getCp())
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


