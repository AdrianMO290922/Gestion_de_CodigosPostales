package com.cpostalesApi.repository;

import com.cpostalesApi.entity.Estado;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
