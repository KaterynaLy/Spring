/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion.caja;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/caja")
public class CajaController {

    private final CajaService cajaService;

    public CajaController(CajaService cajaService) {
        this.cajaService = cajaService;
    }

    @PostMapping
    public ResponseEntity<Caja> agregarTransaccion(@RequestBody Caja transaccion) {
        Caja nuevaTransaccion = cajaService.agregarTransaccion(transaccion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaTransaccion);

    }

    @PostMapping("/crear")
    public ResponseEntity<Caja> crearPago(@RequestBody Caja caja) {
        Caja nuevoPago = cajaService.crearPago(caja);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPago);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caja> obtenerTransaccion(@PathVariable Long id) {
        Caja transaccion = cajaService.obtenerTransaccion(id);
        return ResponseEntity.ok(transaccion);
    }

    @GetMapping("/listar")
    public List<Caja> listarPagos() {
        return cajaService.listarPagos();
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable Long id) {
        cajaService.eliminarPago(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
