package com.prueba.crudprueba.dto;

public class personaDto {

    private String Nombre;
    private int Edad;

    public personaDto() {
    }

    public personaDto(String nombre, int edad) {
        Nombre = nombre;
        Edad = edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }
}
