/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion.paciente;

import com.mycompany.iniciosesion.presupuesto.Presupuesto;
import com.mycompany.iniciosesion.presupuesto.PresupuestoService;
import com.mycompany.iniciosesion.documento.Documento;
import com.mycompany.iniciosesion.tratamiento.Tratamiento;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Crear
    @PostMapping("/add")
    public ResponseEntity<Paciente> addPatient(@RequestBody Paciente paciente) {
        Paciente savedPaciente = pacienteService.addPaciente(paciente);
        return ResponseEntity.ok(savedPaciente);
    }

    // ver
    @GetMapping("/{id}/perfil")
    public Paciente obtenerPerfil(@PathVariable Long id) {
        return pacienteService.obtenerPacientePorId(id);
    }

    // Actualizar un paciente existente
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        Paciente pacienteActualizado = pacienteService.actualizarPaciente(id, paciente);
        return ResponseEntity.ok(pacienteActualizado);
    }

    // Eliminar un paciente por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}/documentos")
    public List<Documento> obtenerDocumentos(@PathVariable Long id) {
        return pacienteService.obtenerDocumentosPorPaciente(id);
    }

    @GetMapping("/{id}/presupuestos")
    public List<Presupuesto> obtenerPresupuestos(@PathVariable Long id) {
        return pacienteService.obtenerPresupuestosPorPaciente(id);
    }

    @GetMapping("/{id}/tratamientos")
    public List<Tratamiento> obtenerTratamientos(@PathVariable Long id) {
        return pacienteService.obtenerTratamientosPorPaciente(id);
    }

    @GetMapping("/{id}/perfil-completo")
    public ResponseEntity<?> obtenerPerfilCompleto(@PathVariable Long id) {
        try {
            Paciente perfil = pacienteService.obtenerPacientePorId(id);
            List<Documento> documentos = pacienteService.obtenerDocumentosPorPaciente(id);
            List<Presupuesto> presupuestos = pacienteService.obtenerPresupuestosPorPaciente(id);
            List<Tratamiento> tratamientos = pacienteService.obtenerTratamientosPorPaciente(id);

            // Crear un objeto para el perfil completo
            PacientePerfilCompleto perfilCompleto = new PacientePerfilCompleto(perfil, documentos, presupuestos, tratamientos);

            return ResponseEntity.ok(perfilCompleto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al cargar el perfil completo del paciente.");
        }
    }

    @GetMapping("/documento/{documentoIdentidad}/perfil-completo")
    public ResponseEntity<?> obtenerPerfilCompletoPorDocumento(@PathVariable String documentoIdentidad) {
        try {
            Paciente perfil = pacienteService.obtenerPacientePorDocumentoIdentidad(documentoIdentidad);
            Long id = perfil.getId(); // Obtener el ID del paciente encontrado
            List<Documento> documentos = pacienteService.obtenerDocumentosPorPaciente(id);
            List<Presupuesto> presupuestos = pacienteService.obtenerPresupuestosPorPaciente(id);
            List<Tratamiento> tratamientos = pacienteService.obtenerTratamientosPorPaciente(id);

            PacientePerfilCompleto perfilCompleto = new PacientePerfilCompleto(perfil, documentos, presupuestos, tratamientos);

            return ResponseEntity.ok(perfilCompleto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al cargar el perfil completo del paciente.");
        }
    }

    @GetMapping("/buscarPorNombre")
    public ResponseEntity<List<Paciente>> buscarPacientesPorNombre(@RequestParam String nombre) {
        List<Paciente> pacientes = pacienteService.buscarPacientesPorNombre(nombre);
        return ResponseEntity.ok(pacientes);
    }

    // Endpoint para buscar pacientes por rango de fechas de alta
    @GetMapping("/buscarPorFechaAlta")
    public ResponseEntity<List<Paciente>> buscarPacientesPorFechaAlta(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<Paciente> pacientes = pacienteService.buscarPacientesPorFechaAlta(startDate, endDate);
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/documentosPorNombre")
    public ResponseEntity<List<Documento>> obtenerDocumentosPorNombrePaciente(@RequestParam String nombre) {
        List<Documento> documentos = pacienteService.obtenerDocumentosPorNombrePaciente(nombre);
        return ResponseEntity.ok(documentos);
    }

    // Endpoint para obtener tratamientos por nombre del paciente
    @GetMapping("/tratamientosPorNombre")
    public ResponseEntity<List<Tratamiento>> obtenerTratamientosPorNombrePaciente(@RequestParam String nombre) {
        List<Tratamiento> tratamientos = pacienteService.obtenerTratamientosPorNombrePaciente(nombre);
        return ResponseEntity.ok(tratamientos);
    }

    /*@RestController
    @RequestMapping("/presupuestos")
    public class PresupuestoController {

        private final PresupuestoService presupuestoService;

        public PresupuestoController(PresupuestoService presupuestoService) {
            this.presupuestoService = presupuestoService;
        }

        @GetMapping("/{id}")
        public ResponseEntity<Presupuesto> obtenerPresupuesto(@PathVariable Long id) {
            Presupuesto presupuesto = presupuestoService.obtenerPresupuesto(id);
            return ResponseEntity.ok(presupuesto);
        }
    }*/
}
