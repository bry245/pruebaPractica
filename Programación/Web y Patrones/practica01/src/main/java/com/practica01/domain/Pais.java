package com.practica01.domain;

import java.io.Serializable;
import javax.persistence.*; // "*" trae todo lo que esta dentro de persistence

import lombok.Data;

@Data
@Entity
@Table (name="estado")
public class Pais implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPais;
    private String nombre, capital, idioma, continente, poblacion;

    public Pais() {
    }

    public Pais(Long idPais, String nombre, String capital, String idioma, String poblacion, String continente) {
        this.idPais = idPais;
        this.nombre = nombre;
        this.capital = capital;
        this.idioma = idioma;
        this.poblacion = poblacion;
        this.continente = continente;
    }
}
