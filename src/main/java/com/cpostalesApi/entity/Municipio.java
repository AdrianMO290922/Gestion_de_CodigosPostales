package com.cpostalesApi.entity;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "municipios")
@Serdeable.Serializable

public class Municipio {

    @Id
    @Column(name = "id_municipios")
    private String id_municipios;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "id_estados")
    private int id_estados;
}
