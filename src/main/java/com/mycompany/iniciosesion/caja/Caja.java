/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iniciosesion.caja;

import com.mycompany.iniciosesion.financiacion.Financiacion;
import com.mycompany.iniciosesion.paciente.Paciente;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "caja")
public class Caja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Mapea el campo "id" de la base de datos
    private Long idPago;
    
    @Column(name = "fechaPago")
    private Date fechaPago;
    
    @Column(name = "monto")
    private Double importe;
    
     @Column(name = "metodoPago")
    private String metodoPago; // Efectivo, Tarjeta, Financiado
     
    @Column(name = "financiador") 
    private String financiador;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "idFinanciacion", nullable = true)
    private Financiacion financiacion;
//id, fechaPago, monto, metodoPago, financiador, idPaciente, idFinanciacion
    public Caja() {
    }

    
    public Caja(Long idPago, Date fechaPago, Double importe, String metodoPago, String financiador, Paciente paciente, Financiacion financiacion) {
        this.idPago = idPago;
        this.fechaPago = fechaPago;
        this.importe = importe;
        this.metodoPago = metodoPago;
        this.financiador = financiador;
        this.paciente = paciente;
        this.financiacion = financiacion;
    }

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getFinanciador() {
        return financiador;
    }

    public void setFinanciador(String financiador) {
        this.financiador = financiador;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Financiacion getFinanciacion() {
        return financiacion;
    }

    public void setFinanciacion(Financiacion financiacion) {
        this.financiacion = financiacion;
    }

    @Override
    public String toString() {
        return "Caja{" + "idPago=" + idPago + ", fechaPago=" + fechaPago + ", importe=" + importe + ", metodoPago=" + metodoPago + ", financiador=" + financiador + ", paciente=" + paciente + ", financiacion=" + financiacion + '}';
    }
      
}
