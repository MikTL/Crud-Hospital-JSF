package com.tismart.hospital.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SEDE")
public class Sede {
    @Id
    @Column(name = "IDSEDE")
    private int idSede;
    
    @Column(name = "DESCSEDE")
    private String descSede;
    
    @Column(name = "FECHAREGISTRO")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    public Sede() {
    }

    public Sede(int idSede, String descSede, Date fechaRegistro) {
        this.idSede = idSede;
        this.descSede = descSede;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

    public String getDescSede() {
        return descSede;
    }

    public void setDescSede(String descSede) {
        this.descSede = descSede;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    
}
