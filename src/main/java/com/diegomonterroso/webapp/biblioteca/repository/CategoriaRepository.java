package com.diegomonterroso.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegomonterroso.webapp.biblioteca.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
