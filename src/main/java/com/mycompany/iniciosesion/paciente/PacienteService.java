/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion.paciente;

import com.mycompany.iniciosesion.presupuesto.Presupuesto;
import com.mycompany.iniciosesion.presupuesto.PresupuestoRepository;
import com.mycompany.iniciosesion.documento.DocumentoRepository;
import com.mycompany.iniciosesion.documento.Documento;
import com.mycompany.iniciosesion.tratamiento.Tratamiento;
import com.mycompany.iniciosesion.tratamiento.TratamientoRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private PresupuestoRepository presupuestoRepository;

    @Autowired
    private TratamientoRepository tratamientoRepository;
    
     public Paciente addPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Paciente obtenerPacientePorId(Long idPaciente) {
        return pacienteRepository.findById(idPaciente)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
    }
    
     // Listar todos los pacientes
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }
    
    // Actualizar un paciente existente
    public Paciente actualizarPaciente(Long idPaciente, Paciente paciente) {
        if (pacienteRepository.existsById(idPaciente)) {
            paciente.setId(idPaciente);// Aseguramos que se mantenga el mismo ID
            return pacienteRepository.save(paciente);
        }
        throw new RuntimeException("Paciente no encontrado");
    }
    // Eliminar
       public void eliminarPaciente(Long idPaciente) {
        if (pacienteRepository.existsById(idPaciente)) {
            pacienteRepository.deleteById(idPaciente);
        } else {
            throw new RuntimeException("Paciente no encontrado");
        }
    }
       // Buscar pacientes por nombre
    public List<Paciente> buscarPacientesPorNombre(String nombre) {
        return pacienteRepository.findByNombre(nombre);
    }

    // Buscar pacientes por rango de fechas de alta
    public List<Paciente> buscarPacientesPorFechaAlta(LocalDate startDate, LocalDate endDate) {
        return pacienteRepository.findByFechaCreacionBetween(startDate, endDate);
    }


    public List<Documento> obtenerDocumentosPorPaciente(Long idPaciente) {
        return documentoRepository.findByPaciente_Id(idPaciente);
    }

    public List<Presupuesto> obtenerPresupuestosPorPaciente(Long idPaciente) {
        return presupuestoRepository.findByPaciente_Id(idPaciente);
    }

    public List<Tratamiento> obtenerTratamientosPorPaciente(Long idPaciente) {
        return tratamientoRepository.findByPaciente_Id(idPaciente);
    }
     public List<Documento> obtenerDocumentosPorNombrePaciente(String nombrePaciente) {
        return documentoRepository.findByPaciente_Nombre(nombrePaciente);
    }
        // Buscar tratamientos por nombre del paciente
    public List<Tratamiento> obtenerTratamientosPorNombrePaciente(String nombrePaciente) {
        return tratamientoRepository.findByPaciente_Nombre(nombrePaciente);
    }
    public Paciente obtenerPacientePorDocumentoIdentidad(String documentoIdentidad) {
    return pacienteRepository.findByDocumentoIdentidad(documentoIdentidad)
            .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
}

     
}
