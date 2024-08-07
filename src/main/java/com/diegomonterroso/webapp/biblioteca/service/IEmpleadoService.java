package com.diegomonterroso.webapp.biblioteca.service;

import java.util.List;

import com.diegomonterroso.webapp.biblioteca.model.Empleado;

public interface IEmpleadoService {

    public List<Empleado> listarEmpleados();

    public Empleado guardarEmpleado(Empleado empleado);

    public Empleado buscarEmpleadoPorId(Long id);

    public void eliminarEmpleado(Empleado empleado);
}
