package com.prueba.crudprueba.service;


import com.prueba.crudprueba.entity.persona;
import com.prueba.crudprueba.repository.personaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class personaService {
    @Autowired
    personaRepository personaRepository;

    public List<persona> list(){
        return personaRepository.findAll();
    }

    public Optional<persona> getOne(int id){
        return personaRepository.findById(id);
    }

    public Optional<persona> getByNombre(String nombre){
        return personaRepository.findByNombre(nombre);
    }

    public void  save(persona persona){
        personaRepository.save(persona);
    }

    public void delete(int id){
        personaRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return personaRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return personaRepository.existsByNombre(nombre);
    }
}
