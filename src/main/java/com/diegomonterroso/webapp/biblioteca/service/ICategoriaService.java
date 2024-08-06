package com.diegomonterroso.webapp.biblioteca.service;

import java.util.List;

import com.diegomonterroso.webapp.biblioteca.model.Categoria;

public interface ICategoriaService {

    public List<Categoria> listarCategorias();

    public Categoria guardarCategoria(Categoria categoria);

    public Categoria buscarCategoriaPorId(Long id);

    public void eliminarCategoria(Categoria categoria);

}
