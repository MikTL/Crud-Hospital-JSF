package com.tismart.hospital.model;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "DISTRITO")
public class Distrito implements Serializable{
    @Id
    @Column(name = "IDDISTRITO")
    private int idDistrito;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPROVINCIA")
    private Provincia Provincia;
    
    @Column(name = "DESCDISTRITO")
    private String descDistrito;
    
    @Column(name = "FECHAREGISTRO")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    public Distrito() {
    }

    public Distrito(int idDistrito, Provincia Provincia, String descDistrito, Date fechaRegistro) {
        this.idDistrito = idDistrito;
        this.Provincia = Provincia;
        this.descDistrito = descDistrito;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public Provincia getProvincia() {
        return Provincia;
    }

    public void setProvincia(Provincia Provincia) {
        this.Provincia = Provincia;
    }

    public String getDescDistrito() {
        return descDistrito;
    }

    public void setDescDistrito(String descDistrito) {
        this.descDistrito = descDistrito;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
}