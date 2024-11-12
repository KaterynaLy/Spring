/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion.presupuesto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresupuestoService {

    private final PresupuestoRepository presupuestoRepository;

    public PresupuestoService(PresupuestoRepository presupuestoRepository) {
        this.presupuestoRepository = presupuestoRepository;
    }

    public Presupuesto crearPresupuesto(Presupuesto presupuesto) {
        return presupuestoRepository.save(presupuesto);
    }

    public Presupuesto obtenerPresupuesto(Long id) {
        return presupuestoRepository.findById(id).orElseThrow(() -> new RuntimeException("Presupuesto no encontrado"));
    }

    public List<Presupuesto> listarPresupuestos() {
        return presupuestoRepository.findAll();
    }

    public Presupuesto actualizarPresupuesto(Long id, Presupuesto presupuesto) {
        if (presupuestoRepository.existsById(id)) {
            presupuesto.setIdPresupuesto(id);  // Aseguramos que se mantenga el mismo ID
            return presupuestoRepository.save(presupuesto);
        }
        throw new RuntimeException("Presupuesto no encontrado");
    }

    public void eliminarPresupuesto(Long id) {
        if (presupuestoRepository.existsById(id)) {
            presupuestoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Presupuesto no encontrado");
        }
    }

}
