/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion.financiacion;

import com.mycompany.iniciosesion.paciente.Paciente;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="financiacion")
public class Financiacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idFinanciacion;
    
  @Column(name = "metodoFinanciacion")
    private String entidad; // Banco o "Clínica"
  @Column(name = "montoTotal")
    private Double importeTotal;
  @Column(name = "montoCuota")
    private Double importeMensual;
  @Column(name = "cuotas")
    private Integer duracionMeses;
  @Column(name = "fechaInicio")
    private Date fechaInicio;
  @Column(name = "fechaFin")
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;
    
    //id, montoTotal, cuotas, montoCuota, fechaInicio, fechaFin, metodoFinanciacion, interes, idPaciente - SQL

    public Financiacion() {
    }

    public Financiacion(Long idFinanciacion, String entidad, Double importeTotal, Double importeMensual, Integer duracionMeses, Date fechaInicio, Date fechaFin, Paciente paciente) {
        this.idFinanciacion = idFinanciacion;
        this.entidad = entidad;
        this.importeTotal = importeTotal;
        this.importeMensual = importeMensual;
        this.duracionMeses = duracionMeses;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.paciente = paciente;
    }

    public Long getIdFinanciacion() {
        return idFinanciacion;
    }

    public void setIdFinanciacion(Long idFinanciacion) {
        this.idFinanciacion = idFinanciacion;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public Double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Double getImporteMensual() {
        return importeMensual;
    }

    public void setImporteMensual(Double importeMensual) {
        this.importeMensual = importeMensual;
    }

    public Integer getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(Integer duracionMeses) {
        this.duracionMeses = duracionMeses;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Financiacion{" + "idFinanciacion=" + idFinanciacion + ", entidad=" + entidad + ", importeTotal=" + importeTotal + ", importeMensual=" + importeMensual + ", duracionMeses=" + duracionMeses + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", paciente=" + paciente + '}';
    }
  
}
