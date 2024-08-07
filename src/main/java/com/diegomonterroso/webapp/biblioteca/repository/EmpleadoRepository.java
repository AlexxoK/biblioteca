package com.diegomonterroso.webapp.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegomonterroso.webapp.biblioteca.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
