/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion.tratamiento;

import org.springframework.stereotype.Service;

@Service
public class TratamientoService {

    private final TratamientoRepository tratamientoRepository;

    public TratamientoService(TratamientoRepository tratamientoRepository) {
        this.tratamientoRepository = tratamientoRepository;
    }

    public Tratamiento crearTratamiento(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    public Tratamiento obtenerTratamiento(Long id) {
        return tratamientoRepository.findById(id).orElseThrow(() -> new RuntimeException("Tratamiento no encontrado"));
    }

    public Tratamiento actualizarTratamiento(Long id, Tratamiento tratamiento) {
        Tratamiento existente = obtenerTratamiento(id);
        existente.setDescripcion(tratamiento.getDescripcion());
        existente.setFechaInicio(tratamiento.getFechaInicio());
        existente.setFechaFin(tratamiento.getFechaFin());
        return tratamientoRepository.save(existente);
    }

    public void eliminarTratamiento(Long id) {
        tratamientoRepository.deleteById(id);
    }
}
