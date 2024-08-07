package com.diegomonterroso.webapp.biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String nombre;
    @Column(columnDefinition = "TEXT")
    private String sinopsis;
    private String autor;
    private String editorial;
    private Boolean disponibilidad;
    private String numeroEstanteria;
    private String cluster;
    @ManyToOne
    private Categoria categoria;
}
