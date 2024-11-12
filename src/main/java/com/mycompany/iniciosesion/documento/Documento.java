/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion.documento;

import com.mycompany.iniciosesion.paciente.Paciente;
import com.mycompany.iniciosesion.tratamiento.Tratamiento;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "documento")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idDocumento;
    
    @Column(name = "nombreDocumento")
    private String tipo; // Ej.: Protección de datos, Cuestionario de salud
    
    private Boolean firmado;
    
    @Column(name = "fechaFirma")
    private Date fechaFirma;

    @ManyToOne
    @JoinColumn(name = "idPaciente", referencedColumnName = "id")
    private Paciente paciente;
     
    @ManyToOne
    @JoinColumn(name = "idTratamiento")
    private Tratamiento tratamiento;
    
    //id, nombreDocumento, fechaFirma, idPaciente SQL

    public Documento() {
    }

    public Documento(Long idDocumento, String tipo, Boolean firmado, Date fechaFirma, Paciente paciente) {
        this.idDocumento = idDocumento;
        this.tipo = tipo;
        this.firmado = firmado;
        this.fechaFirma = fechaFirma;
        this.paciente = paciente;
    }

    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getFirmado() {
        return firmado;
    }

    public void setFirmado(Boolean firmado) {
        this.firmado = firmado;
    }

    public Date getFechaFirma() {
        return fechaFirma;
    }

    public void setFechaFirma(Date fechaFirma) {
        this.fechaFirma = fechaFirma;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Documento{" + "idDocumento=" + idDocumento + ", tipo=" + tipo + ", firmado=" + firmado + ", fechaFirma=" + fechaFirma + ", paciente=" + paciente + '}';
    }
     
}