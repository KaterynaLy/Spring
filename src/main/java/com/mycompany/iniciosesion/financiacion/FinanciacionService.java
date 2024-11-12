/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion.financiacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanciacionService {

    @Autowired
    private FinanciacionRepository financiacionRepository;

    public Financiacion crearFinanciacion(Financiacion financiacion) {
        return financiacionRepository.save(financiacion);
    }

    public List<Financiacion> listarFinanciaciones() {
        return financiacionRepository.findAll();
    }

    public Financiacion actualizarFinanciacion(Long id, Financiacion financiacion) {
        if (financiacionRepository.existsById(id)) {
            financiacion.setIdFinanciacion(id); // Aseguramos que se mantenga el mismo ID
            return financiacionRepository.save(financiacion);
        }
        throw new RuntimeException("Financiación no encontrada");
    }

    public void eliminarFinanciacion(Long id) {
        if (financiacionRepository.existsById(id)) {
            financiacionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Financiación no encontrada");
        }
    }

}
