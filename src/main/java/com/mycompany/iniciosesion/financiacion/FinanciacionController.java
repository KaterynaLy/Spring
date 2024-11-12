/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion.financiacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/financiaciones")
public class FinanciacionController {

    @Autowired
    private FinanciacionService financiacionService;

    @PostMapping("/crear")
    public ResponseEntity<Financiacion> crearFinanciacion(@RequestBody Financiacion financiacion) {
        Financiacion nuevaFinanciacion = financiacionService.crearFinanciacion(financiacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaFinanciacion);
    }

    @GetMapping("/listar")
    public List<Financiacion> listarFinanciaciones() {
        return financiacionService.listarFinanciaciones();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Financiacion> actualizarFinanciacion(@PathVariable Long id, @RequestBody Financiacion financiacion) {
        Financiacion financiacionActualizada = financiacionService.actualizarFinanciacion(id, financiacion);
        return ResponseEntity.ok(financiacionActualizada);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarFinanciacion(@PathVariable Long id) {
        financiacionService.eliminarFinanciacion(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
