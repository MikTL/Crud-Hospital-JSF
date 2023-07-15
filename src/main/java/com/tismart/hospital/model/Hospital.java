package com.tismart.hospital.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToOne;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "HOSPITAL")
@NamedStoredProcedureQueries(
    {
        @NamedStoredProcedureQuery(
                name="obtenerHospitales",
                procedureName="obtener_hospitales",
                resultClasses={Hospital.class},
                parameters = {
                    @StoredProcedureParameter(
                            mode=ParameterMode.REF_CURSOR,
                            type = Class.class, 
                            name = "p_hospitales")
                }
        ),
        @NamedStoredProcedureQuery(
                name="insertarHospital",
                procedureName="insertar_hospital",
                parameters = {
                    @StoredProcedureParameter(mode=ParameterMode.IN, type = String.class, name = "p_nombre"),
                    @StoredProcedureParameter(mode=ParameterMode.IN, type = Integer.class, name = "p_antiguedad"),
                    @StoredProcedureParameter(mode=ParameterMode.IN, type = String.class, name = "p_area_text"),
                    @StoredProcedureParameter(mode=ParameterMode.IN, type = Integer.class, name = "p_idsede"),
                    @StoredProcedureParameter(mode=ParameterMode.IN, type = Integer.class, name = "p_idgerente"),
                    @StoredProcedureParameter(mode=ParameterMode.IN, type = Integer.class, name = "p_idcondicion"),
                    @StoredProcedureParameter(mode=ParameterMode.IN, type = Integer.class, name = "p_iddistrito"),
                    @StoredProcedureParameter(mode=ParameterMode.IN, type = String.class, name = "p_fecharegistro")
                }
        ),
        @NamedStoredProcedureQuery(
                name="actualizarHospital",
                procedureName="actualizar_hospital",
                parameters = {
                    @StoredProcedureParameter(mode=ParameterMode.IN, type = Integer.class, name = "p_idhospital"),
                    @StoredProcedureParameter(mode=ParameterMode.IN, type = String.class, name = "p_nombre"),
                    @StoredProcedureParameter(mode=ParameterMode.IN, type = Integer.class, name = "p_antiguedad"),
                    @StoredProcedureParameter(mode=ParameterMode.IN, type = String.class, name = "p_area_text"),
                    @StoredProcedureParameter(mode=ParameterMode.IN, type = Integer.class, name = "p_idsede"),
                    @StoredProcedureParameter(mode=ParameterMode.IN, type = Integer.class, name = "p_idgerente"),
                    @StoredProcedureParameter(mode=ParameterMode.IN, type = Integer.class, name = "p_idcondicion"),
                    @StoredProcedureParameter(mode=ParameterMode.IN, type = Integer.class, name = "p_iddistrito"),
                    @StoredProcedureParameter(mode=ParameterMode.IN, type = String.class, name = "p_fecharegistro")
                }
        ),
        @NamedStoredProcedureQuery(
                name="eliminarHospital",
                procedureName="eliminar_hospital",
                parameters={
                        @StoredProcedureParameter(mode= ParameterMode.IN,type=Integer.class,name="p_idhospital")
                }
        ),
        @NamedStoredProcedureQuery(
            name = "buscarHospital",
            procedureName = "buscar_hospital",
            resultClasses={Hospital.class},
            parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "p_nombre"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "p_idgerente"),
                @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = Class.class, name = "p_hospitales")
            }
        )
    }
)
public class Hospital implements Serializable{
    @Id
    @Column(name = "IDHOSPITAL")
    private int idHospital;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "ANTIGUEDAD")
    private int antiguedad;
    
    @Column(name = "AREA")
    private double area;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDSEDE")
    private Sede sede;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDGERENTE")
    private Gerente gerente;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDCONDICION")
    private Condicion condicion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDDISTRITO")
    private Distrito distrito;
    
    @Column(name = "FECHAREGISTRO")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    public Hospital() {
    }

    public Hospital(int idHospital, String nombre, int antiguedad, double area, Sede sede, Gerente gerente,
                    Condicion condicion, Distrito distrito, Date fechaRegistro) {
        this.idHospital = idHospital;
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.area = area;
        this.sede = sede;
        this.gerente = gerente;
        this.condicion = condicion;
        this.distrito = distrito;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
}