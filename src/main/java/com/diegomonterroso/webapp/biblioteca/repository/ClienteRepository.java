package com.diegomonterroso.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegomonterroso.webapp.biblioteca.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
