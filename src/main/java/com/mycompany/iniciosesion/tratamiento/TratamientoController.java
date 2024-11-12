/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion.tratamiento;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tratamientos")
public class TratamientoController {

    private final TratamientoService tratamientoService;

    public TratamientoController(TratamientoService tratamientoService) {
        this.tratamientoService = tratamientoService;
    }

    @PostMapping
    public ResponseEntity<Tratamiento> crearTratamiento(@RequestBody Tratamiento tratamiento) {
        Tratamiento nuevoTratamiento = tratamientoService.crearTratamiento(tratamiento);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTratamiento);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tratamiento> obtenerTratamiento(@PathVariable Long id) {
        Tratamiento tratamiento = tratamientoService.obtenerTratamiento(id);
        return ResponseEntity.ok(tratamiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tratamiento> actualizarTratamiento(@PathVariable Long id, @RequestBody Tratamiento tratamiento) {
        Tratamiento tratamientoActualizado = tratamientoService.actualizarTratamiento(id, tratamiento);
        return ResponseEntity.ok(tratamientoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTratamiento(@PathVariable Long id) {
        tratamientoService.eliminarTratamiento(id);
        return ResponseEntity.noContent().build();
    }
}