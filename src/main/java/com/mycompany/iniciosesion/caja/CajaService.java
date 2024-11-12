/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion.caja;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CajaService {

    private final CajaRepository cajaRepository;

    public Caja crearPago(Caja caja) {
        return cajaRepository.save(caja);
    }

    public CajaService(CajaRepository cajaRepository) {
        this.cajaRepository = cajaRepository;
    }

    public Caja agregarTransaccion(Caja transaccion) {
        return cajaRepository.save(transaccion);
    }

    public Caja obtenerTransaccion(Long id) {
        return cajaRepository.findById(id).orElseThrow(() -> new RuntimeException("Transacción no encontrada"));
    }

    public List<Caja> listarPagos() {
        return cajaRepository.findAll();
    }

    public void eliminarPago(Long id) {
        if (cajaRepository.existsById(id)) {
            cajaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Pago no encontrado");
        }
    }

}
