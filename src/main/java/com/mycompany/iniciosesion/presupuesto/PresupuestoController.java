/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion.presupuesto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/presupuestos")
public class PresupuestoController {

    private final PresupuestoService presupuestoService;

    public PresupuestoController(PresupuestoService presupuestoService) {
        this.presupuestoService = presupuestoService;
    }

    @PostMapping
    public ResponseEntity<Presupuesto> crearPresupuesto(@RequestBody Presupuesto presupuesto) {
        Presupuesto nuevoPresupuesto = presupuestoService.crearPresupuesto(presupuesto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPresupuesto);
        // return new ResponseEntity<>(nuevoPresupuesto, HttpStatus.CREATED);
    }

    // Obtener un presupuesto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Presupuesto> obtenerPresupuesto(@PathVariable Long id) {
        Presupuesto presupuesto = presupuestoService.obtenerPresupuesto(id);
        return new ResponseEntity<>(presupuesto, HttpStatus.OK);
    }

    /*@GetMapping("/listar")
    public List<Presupuesto> listarPresupuestos() {
        return presupuestoService.listarPresupuestos();
    }
    
        @PutMapping("/actualizar/{id}")
    public ResponseEntity<Presupuesto> actualizarPresupuesto(@PathVariable Long id, @RequestBody Presupuesto presupuesto) {
        Presupuesto presupuestoActualizado = presupuestoService.actualizarPresupuesto(id, presupuesto);
        return ResponseEntity.ok(presupuestoActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPresupuesto(@PathVariable Long id) {
        presupuestoService.eliminarPresupuesto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }*/
    // Listar todos los presupuestos
    @GetMapping
    public ResponseEntity<List<Presupuesto>> listarPresupuestos() {
        List<Presupuesto> presupuestos = presupuestoService.listarPresupuestos();
        return new ResponseEntity<>(presupuestos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Presupuesto> actualizarPresupuesto(@PathVariable Long id, @RequestBody Presupuesto presupuesto) {
        Presupuesto presupuestoActualizado = presupuestoService.actualizarPresupuesto(id, presupuesto);
        return ResponseEntity.ok(presupuestoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPresupuesto(@PathVariable Long id) {
        presupuestoService.eliminarPresupuesto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
