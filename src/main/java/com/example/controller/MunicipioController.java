package com.example.controller;

import com.example.DTOs.MunicipioDto;
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
    public MunicipioController(MunicipioService municipioService, EstadoService estadoService){
        this.municipioService = municipioService;
        this.municipioService = municipioService;
    }

    @Get("/municipios")
    @Status(HttpStatus.OK)
    public List<Municipio> showAll(){
        return municipioService.showAll();
    }

    @Get("/municipio/{id_estado}")
    @Status(HttpStatus.OK)
    public Set<Municipio> showById(@PathVariable Integer id_estado){
        return municipioService.showMunPorEdo(id_estado);
    }
    ///Prueba de un endpoint con dos parametros
    @Get("/colonias/estado/{id_edo}/municipio/{id_mun}")
    public String mostrarColonias(@PathVariable Integer id_edo, @PathVariable Integer id_mun){
        return "Las colonias del estado "+id_edo+" del municipio "+id_mun+" son:";
    }
    @Get("/municipios/estado/{id}")
    public HttpResponse<?> mostrarMunicipios(@PathVariable Integer id){
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
