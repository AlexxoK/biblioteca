package com.diegomonterroso.webapp.biblioteca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegomonterroso.webapp.biblioteca.model.Categoria;
import com.diegomonterroso.webapp.biblioteca.service.CategoriaService;

@Controller
@RestController
@RequestMapping("categoria-controller")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/")
    public List<Categoria> listarCategorias(){
        return categoriaService.listarCategorias();
    }

    @GetMapping("/id={id}")
    public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Long id){
        try{
            Categoria categoria = categoriaService.buscarCategoriaPorId(id);
            return ResponseEntity.ok(categoria);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Map<String, String>> agregarCategoria(@RequestBody Categoria categoria){
        Map<String, String> response = new HashMap<>();
        
        try { //Bien
            categoriaService.guardarCategoria(categoria);
            response.put("message", "Categoria creada con éxito!");
            return ResponseEntity.ok(response);
        } catch (Exception e) { //Mal
            response.put("message", "Error!");
            response.put("err", "Hubo un error al crear la categoria!");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/id={id}")
    public ResponseEntity<Map<String, String>> editarCategoria(@PathVariable Long id, @RequestBody Categoria categoriaNueva){
        Map<String, String> response = new HashMap<>();
        
        try {
            Categoria categoria = categoriaService.buscarCategoriaPorId(id);
            categoria.setNombreCategoria(categoriaNueva.getNombreCategoria());
            categoriaService.guardarCategoria(categoria);
            response.put("message", "La categoria de ha modificado con éxito!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Hubo un error al intentar modificar la categoria!");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/id={id}")
    public ResponseEntity<Map<String, String>> eliminarCategoria(@PathVariable Long id){
        Map<String, String> response = new HashMap<>();
        
        try {
            Categoria categoria = categoriaService.buscarCategoriaPorId(id);
            categoriaService.eliminarCategoria(categoria);
            response.put("message", "La categoria se ha eliminado con éxito!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "La categoria no se ha eliminado con éxito!");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
