package com.prueba.crudprueba.controler;


import com.prueba.crudprueba.dto.Mensaje;
import com.prueba.crudprueba.dto.personaDto;
import com.prueba.crudprueba.entity.persona;
import com.prueba.crudprueba.service.personaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "http://localhost:4200")
public class personaControler {
    @Autowired
    personaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<persona>> list(){
        List<persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody personaDto personaDto){
        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(personaDto.getEdad()==0 || personaDto.getEdad()<0 )
            return new ResponseEntity(new Mensaje("La edad debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        persona persona = new persona(personaDto.getNombre(), personaDto.getEdad());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona Agregada"), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody personaDto personaDto){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(personaDto.getEdad()==0 || personaDto.getEdad()<0 )
            return new ResponseEntity(new Mensaje("La edad debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

        persona persona = personaService.getOne(id).get();
        persona.setNombre(personaDto.getNombre());
        persona.setEdad(personaDto.getEdad());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Datos actualizados"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }
}
