package com.diegomonterroso.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegomonterroso.webapp.biblioteca.model.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

}
