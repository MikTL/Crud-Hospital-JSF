package com.tismart.hospital.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "GERENTE")
public class Gerente {
    @Id
    @Column(name = "IDGERENTE")
    private int idGerente;
    
    @Column(name = "DESGERENTE")
    private String desGerente;
    
    @Column(name = "FECHAREGISTRO")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    public Gerente() {
    }

    public Gerente(int idGerente, String desGerente, Date fechaRegistro) {
        this.idGerente = idGerente;
        this.desGerente = desGerente;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(int idGerente) {
        this.idGerente = idGerente;
    }

    public String getDesGerente() {
        return desGerente;
    }

    public void setDesGerente(String desGerente) {
        this.desGerente = desGerente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
}
