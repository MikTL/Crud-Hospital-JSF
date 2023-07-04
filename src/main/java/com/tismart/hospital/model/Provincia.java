package com.tismart.hospital.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "PROVINCIA")
public class Provincia {
    @Id
    @Column(name = "IDPROVINCIA")
    private int idProvincia;
    @Column(name = "DESCPROVINCIA")
    private String descProvincia;
    @Column(name = "FECHAREGISTRO")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    
    public Provincia() {
    }

    public Provincia(int idProvincia, String descProvincia, Date fechaRegistro) {
        this.idProvincia = idProvincia;
        this.descProvincia = descProvincia;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getDescProvincia() {
        return descProvincia;
    }

    public void setDescProvincia(String descProvincia) {
        this.descProvincia = descProvincia;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
        
}