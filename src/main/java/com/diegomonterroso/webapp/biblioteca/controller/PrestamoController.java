package com.diegomonterroso.webapp.biblioteca.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diegomonterroso.webapp.biblioteca.model.Prestamo;
import com.diegomonterroso.webapp.biblioteca.service.PrestamoService;

@Controller
@RestController
@RequestMapping("")
@CrossOrigin(value = "http://127.0.0.1:5500")
public class PrestamoController {

    @Autowired
    PrestamoService prestamoService;

    @GetMapping("/prestamos")
    public ResponseEntity<?> listarPrestamos(){
        Map<String, String> response = new HashMap<>();
        try {
            return ResponseEntity.ok(prestamoService.listarPrestamos());
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "No se encontró una lista de libros!");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/prestamo")
    public ResponseEntity<Prestamo> buscarPrestamoPorId(@RequestParam Long id){
        try{
            Prestamo prestamo = prestamoService.buscarPrestamoPorId(id);
            return ResponseEntity.ok(prestamo);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/prestamo")
    public ResponseEntity<Map<String, String>> agregarPrestamos(@RequestBody Prestamo prestamo){
        Map<String, String> response = new HashMap<>();

        try {
            prestamoService.guardarPrestamo(prestamo);
            response.put("message", "Prestamo creado con éxito!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "No se ha creado el prestamo!");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/prestamo")
    public ResponseEntity<Map<String, String>> editarPrestamo(@RequestParam Long id, @RequestBody Prestamo prestamoNuevo){
        Map<String, String> response = new HashMap<>();
        
        try {
            Prestamo prestamo = prestamoService.buscarPrestamoPorId(id);
            prestamo.setFechaDePrestamo(prestamoNuevo.getFechaDePrestamo());
            prestamo.setFechaDeDevolucion(prestamoNuevo.getFechaDeDevolucion());
            prestamo.setVigencia(prestamoNuevo.getVigencia());
            prestamo.setEmpleado(prestamoNuevo.getEmpleado());
            prestamo.setCliente(prestamoNuevo.getCliente());
            prestamoService.guardarPrestamo(prestamo);
            response.put("message", "El prestamo se ha modificado con éxito!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Hubo un error al intentar modificar el prestamo!");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/prestamo")
    public ResponseEntity<Map<String, String>> eliminarPrestamo(@RequestParam Long id){
        Map<String, String> response = new HashMap<>();
        
        try {
            Prestamo prestamo = prestamoService.buscarPrestamoPorId(id);
            prestamoService.eliminarPrestamo(prestamo);
            response.put("message", "El prestamo se ha eliminado con éxito!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "No se ha podido eliminar el prestamo!");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
