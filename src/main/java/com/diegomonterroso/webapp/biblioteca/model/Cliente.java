package com.diegomonterroso.webapp.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Clientes")
public class Cliente {
    @Id
    private Long dpi;
    private String nombreCliente;
    private String apellidoCliente;
    private String telefonoCliente;
}
