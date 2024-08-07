package com.diegomonterroso.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegomonterroso.webapp.biblioteca.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

}
