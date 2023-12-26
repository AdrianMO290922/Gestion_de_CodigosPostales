package com.cpostalesApi.repository;

import com.cpostalesApi.entity.Municipio;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository

public interface MunicipioRepository extends JpaRepository<Municipio, String> {
}
