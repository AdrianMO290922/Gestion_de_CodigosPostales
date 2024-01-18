package com.example.controller;

import com.example.DTOs.MunicipioDto;
import com.example.entity.Estado;
import com.example.entity.Municipio;
import com.example.payload.MensajeResponse;
import com.example.service.EstadoService;
import com.example.service.MunicipioService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Status;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller("/api/v1")
public class MunicipioController {
    EstadoService estadoService;
    MensajeResponse mensajeResponse;
    HttpResponse<MensajeResponse> HttpResponse;
    MunicipioService municipioService;
    public MunicipioController(MunicipioService municipioService){
        this.municipioService = municipioService;
    }

    @Get("/municipios")
    @Status(HttpStatus.OK)
    public HttpResponse<?> mostrarMunicipios(){
        try {
            List<Municipio> list = municipioService.showAll();
            List<MunicipioDto> listMunDto = list.stream()
                    .map(municipio -> MunicipioDto.builder()
                            .id_estados(municipio.getEstado().getId_estado())
                            .id_municipios(String.valueOf(municipio.getId_municipios()))
                            .municipio(municipio.getMunicipios())
                            .build()
                    )
                    .collect(Collectors.toList());
            int tamaño = list.size();
            if (list == null) {
                mensajeResponse = MensajeResponse.builder().error(true).mensaje("No se encontraron municipios").build();
                return io.micronaut.http.HttpResponse.ok(mensajeResponse);
            } else {
                mensajeResponse = MensajeResponse.builder().error(false).municipios(listMunDto).mensaje("Municipios cargados " + tamaño).build();
                return io.micronaut.http.HttpResponse.ok(mensajeResponse);
            }
        }catch (Exception e){
            mensajeResponse = MensajeResponse.builder().error(true).mensaje(e.getMessage()).municipios(null).build();
            return io.micronaut.http.HttpResponse.ok(mensajeResponse);
        }
    }


    @Get("/municipios/estado/{id}")
    public HttpResponse<?> mostrarMunicipiosEdo(@PathVariable Integer id){
        try {
            Set<Municipio> colMunicipios =municipioService.showMunPorEdo(id);//Coleccion
            List<MunicipioDto> listMunDto =colMunicipios.stream()///Mapeo en la coleccion
                    .map(municipio -> MunicipioDto.builder()
                            .id_estados(municipio.getEstado().getId_estado())
                            .id_municipios(String.valueOf(municipio.getId_municipios()))
                            .municipio(municipio.getMunicipios())
                            .build())
                    .collect(Collectors.toList());//Ayuada a transsfomar la coleccion en una lista
            if(colMunicipios == null){
                mensajeResponse = MensajeResponse.builder().error(true).mensaje("No se encontraron municipios").municipios(null).build();
                return io.micronaut.http.HttpResponse.ok(mensajeResponse);
            }
            else {
                int tamaño = listMunDto.size();
                mensajeResponse = MensajeResponse.builder().error(false).mensaje("Municipios cargados "+tamaño).municipios(listMunDto).build();
                return io.micronaut.http.HttpResponse.ok(mensajeResponse);

            }
        }
        catch (Exception e){
            mensajeResponse = MensajeResponse.builder().error(true).mensaje(e.getMessage()).municipios(null).build();
            return io.micronaut.http.HttpResponse.ok(mensajeResponse);

        }
    }

}
