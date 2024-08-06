package com.diegomonterroso.webapp.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegomonterroso.webapp.biblioteca.model.Cliente;
import com.diegomonterroso.webapp.biblioteca.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente buscarClientePorDpi(Long dpi) {
        return clienteRepository.findById(dpi).orElse(null);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}
