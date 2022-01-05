package com.prueba.crudprueba.repository;

import com.prueba.crudprueba.entity.persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface personaRepository extends JpaRepository<persona, Integer> {
    Optional<persona> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
