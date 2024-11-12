/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion.paciente;

import com.mycompany.iniciosesion.presupuesto.Presupuesto;
import com.mycompany.iniciosesion.documento.Documento;
import com.mycompany.iniciosesion.tratamiento.Tratamiento;
import java.util.List;

public class PacientePerfilCompleto {

    private Paciente perfil;
    private List<Documento> documentos;
    private List<Presupuesto> presupuestos;
    private List<Tratamiento> tratamientos;
    
        // Constructor
    public PacientePerfilCompleto(Paciente perfil, List<Documento> documentos, List<Presupuesto> presupuestos, List<Tratamiento> tratamientos) {
        this.perfil = perfil;
        this.documentos = documentos;
        this.presupuestos = presupuestos;
        this.tratamientos = tratamientos;
    }

     public Paciente getPerfil() {
        return perfil;
    }

    public void setPerfil(Paciente perfil) {
        this.perfil = perfil;
    }

    // Getter y Setter para documentos
    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    // Getter y Setter para presupuestos
    public List<Presupuesto> getPresupuestos() {
        return presupuestos;
    }

    public void setPresupuestos(List<Presupuesto> presupuestos) {
        this.presupuestos = presupuestos;
    }

    // Getter y Setter para tratamientos
    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }
}
