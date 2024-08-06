package com.diegomonterroso.webapp.biblioteca.service;

import java.util.List;

import com.diegomonterroso.webapp.biblioteca.model.Cliente;

public interface IClienteService {

    public List<Cliente> listarClientes();

    public Cliente guardarCliente(Cliente cliente);

    public Cliente buscarClientePorDpi(Long dpi);

    public void eliminarCliente(Cliente cliente);
}
