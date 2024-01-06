package com.example.entity;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "colonias")
@Serdeable.Serializable
public class Colonia {

    @Id
    @ManyToOne
    @JoinColumn(name = "CP")
    private CP cp;

    @Column(name = "Colonia")
    private String colonia;


}
