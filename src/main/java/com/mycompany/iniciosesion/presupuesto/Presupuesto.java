/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion.presupuesto;

import com.mycompany.iniciosesion.paciente.Paciente;
import com.mycompany.iniciosesion.tratamiento.Tratamiento;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="presupuesto")
public class Presupuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idPresupuesto;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "monto")
    private BigDecimal montoTotal; // Monto total del presupuesto
    
    @Column(name = "fechaCreacion")
    private LocalDate fechaCreacion; // Fecha en que se generó el presupuesto
     
    @Column(name = "fechaAceptacion")
    private LocalDate fechaAceptacion; // Fecha en que se generó el presupuesto

    @OneToMany(mappedBy = "presupuesto", cascade = CascadeType.ALL)
    private List<Tratamiento> tratamientos; // Tratamientos incluidos en el presupuesto
    
       @Column(name = "estado")
    private String estado; // Pendiente, Aceptado, Rechazado
    
    @ManyToOne
    @JoinColumn(name = "idPaciente", referencedColumnName = "id")
    private Paciente paciente;
    
    //id, descripcion, monto, fechaCreacion, fechaAceptacion, idPaciente, estado
    public Presupuesto() {
    }

    public Long getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Long idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaAceptacion() {
        return fechaAceptacion;
    }

    public void setFechaAceptacion(LocalDate fechaAceptacion) {
        this.fechaAceptacion = fechaAceptacion;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
} 