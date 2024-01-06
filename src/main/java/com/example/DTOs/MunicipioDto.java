package com.example.DTOs;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Serdeable.Serializable
public class MunicipioDto {
    private Integer id_estados;

    private String id_municipios;

    private String municipio;
}
