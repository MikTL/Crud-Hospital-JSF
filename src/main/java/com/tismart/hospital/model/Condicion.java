package com.tismart.hospital.model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CONDICION")
public class Condicion implements Serializable{
    @Id
    @Column(name = "IDCONDICION")
    private int idCondicion;
    
    @Column(name = "DESCCONDICION")
    private String descCondicion;
    
    @Column(name = "FECHAREGISTRO")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    public Condicion() {
    }

    public Condicion(int idCondicion, String descCondicion, Date fechaRegistro) {
        this.idCondicion = idCondicion;
        this.descCondicion = descCondicion;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdCondicion() {
        return idCondicion;
    }

    public void setIdCondicion(int idCondicion) {
        this.idCondicion = idCondicion;
    }

    public String getDescCondicion() {
        return descCondicion;
    }

    public void setDescCondicion(String descCondicion) {
        this.descCondicion = descCondicion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
}
