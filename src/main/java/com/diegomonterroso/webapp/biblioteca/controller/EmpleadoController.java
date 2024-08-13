package com.diegomonterroso.webapp.biblioteca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diegomonterroso.webapp.biblioteca.model.Empleado;
import com.diegomonterroso.webapp.biblioteca.service.EmpleadoService;

@Controller
@RestController
@RequestMapping("")
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/empleados")
    public List<Empleado> listarEmpleados(){
        return empleadoService.listarEmpleados();
    }

    @GetMapping("/empleado")
    public ResponseEntity<Empleado> buscarEmpleadoPorId(@RequestParam Long id){
        try{
            Empleado empleado = empleadoService.buscarEmpleadoPorId(id);
            return ResponseEntity.ok(empleado);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/empleado")
    public ResponseEntity<Map<String, String>> agregarEmpleado(@RequestBody Empleado empleado){
        Map<String, String> response = new HashMap<>();
        
        try { //Bien
            if (!empleadoService.verificarDpiDuplicado(empleado)) {
                empleadoService.guardarEmpleado(empleado);
                response.put("message", "Empleado creado con éxito!");
                return ResponseEntity.ok(response);
            }else{
                response.put("message", "Error");
                response.put("err", "El dpi se encuentra duplicado!");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) { //Mal
            response.put("message", "Error!");
            response.put("err", "Hubo un error al crear el empleado!");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/empleado")
    public ResponseEntity<Map<String, String>> editarEmpleado(@RequestParam Long id, @RequestBody Empleado empleadoNuevo){
        Map<String, String> response = new HashMap<>();

        Empleado empleado = empleadoService.buscarEmpleadoPorId(id);
        empleado.setNombreEmpleado(empleadoNuevo.getNombreEmpleado());
        empleado.setApellidoEmpleado(empleadoNuevo.getApellidoEmpleado());
        empleado.setTelefonoEmpleado(empleadoNuevo.getTelefonoEmpleado());
        empleado.setDireccionEmpleado(empleadoNuevo.getDireccionEmpleado());
        empleado.setDpi(empleadoNuevo.getDpi());
        
        try {
            if (!empleadoService.verificarDpiDuplicado(empleado)) {
                empleadoService.guardarEmpleado(empleado);
                response.put("message", "El empleado se ha modificado con éxito!");
                return ResponseEntity.ok(response);
            }else{
                response.put("message", "Error");
                response.put("err", "El dpi se encuentra duplicado!");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "Hubo un error al intentar modificar el empleado!");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/empleado")
    public ResponseEntity<Map<String, String>> eliminarEmpleado(@RequestParam Long id){
        Map<String, String> response = new HashMap<>();
        
        try {
            Empleado empleado = empleadoService.buscarEmpleadoPorId(id);
            empleadoService.eliminarEmpleado(empleado);
            response.put("message", "El empleado se ha eliminado con éxito!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error");
            response.put("err", "No se ha podido eliminar el empleado!");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
