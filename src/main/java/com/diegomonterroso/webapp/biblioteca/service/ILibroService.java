package com.diegomonterroso.webapp.biblioteca.service;

import java.util.List;

import com.diegomonterroso.webapp.biblioteca.model.Libro;

public interface ILibroService {

    public List<Libro> listarLibros();

    public Libro buscarLibroPorId(Long id);

    public Libro guardarLibro(Libro libro);

    public void eliminarLibro(Libro libro);
    
}
