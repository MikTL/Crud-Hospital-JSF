
package com.tismart.hospital.managedBeans;

import com.tismart.hospital.daoService.CondicionDao;
import com.tismart.hospital.daoService.DistritoDao;
import com.tismart.hospital.daoService.GerenteDao;
import com.tismart.hospital.daoService.HospitalDao;
import com.tismart.hospital.daoService.SedeDao;
import com.tismart.hospital.model.Condicion;
import com.tismart.hospital.model.Distrito;
import com.tismart.hospital.model.Gerente;
import com.tismart.hospital.model.Hospital;
import com.tismart.hospital.model.Sede;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class FormsBean implements Serializable{
    private final SedeDao sedeDao;
    private final DistritoDao distritoDao;
    private final GerenteDao gerenteDao;
    private final CondicionDao condicionDao;
    private final HospitalDao hospitalDao;

    private List<Sede> sedes;
    private List<Distrito> distritos;
    private List<Gerente> gerentes;
    private List<Condicion> condiciones;

    private int idHospital;
    private String nombreIngresado;
    private int antiguedadIngresada;
    private double areaIngresada;
    private Date fechaIngresada;
    private int sedeSeleccionada;
    private int distritoSeleccionado;
    private int gerenteSeleccionado;
    private int condicionSeleccionado;

    @Inject
    public FormsBean(
            SedeDao sedeDao, 
            DistritoDao distritoDao, 
            GerenteDao gerenteDao, 
            CondicionDao condicionDao, 
            HospitalDao hospitalDao
    ) {
        this.sedeDao = sedeDao;
        this.distritoDao = distritoDao;
        this.gerenteDao = gerenteDao;
        this.condicionDao = condicionDao;
        this.hospitalDao = hospitalDao;
    }

    @PostConstruct
    public void init() {
        sedes = sedeDao.listaSede();
        distritos = distritoDao.listaDistrito();
        gerentes = gerenteDao.listaGerentes();
        condiciones = condicionDao.listaCondiciones();
    }

    public String guardarHospital(){
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String fechaFormateada = formato.format(getFechaIngresada());
        
        hospitalDao.guardarHospital(
                nombreIngresado, 
                antiguedadIngresada,
                String.valueOf(areaIngresada), 
                sedeSeleccionada, 
                gerenteSeleccionado, 
                condicionSeleccionado, 
                distritoSeleccionado,
                fechaFormateada);
        return "index?faces-redirect=true";
    }
    
    public String cargarDatosParaEditar(int id){
        Hospital hospDatos=hospitalDao.obtenerHospital(id);
        asignarValoresHospital(hospDatos);
        return "editarHospital?faces-redirect=true";
    }
    
    public String editarHospital(int id){
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String fechaFormateada = formato.format(getFechaIngresada());
        
        hospitalDao.editarHospital(
                idHospital, 
                nombreIngresado, 
                antiguedadIngresada,
                String.valueOf(areaIngresada), 
                sedeSeleccionada, 
                gerenteSeleccionado, 
                condicionSeleccionado, 
                distritoSeleccionado,
                fechaFormateada);
        resetearValores();
        return "index?faces-redirect=true";
    }
    public void resetearValores(){
        this.idHospital=0;
        this.nombreIngresado="";
        this.antiguedadIngresada=0;
        this.areaIngresada=0;
        this.condicionSeleccionado=0;
        this.sedeSeleccionada=0;
        this.gerenteSeleccionado=0;
        this.distritoSeleccionado=0;
        this.fechaIngresada=null;
    }
    
    public String volverAlIndex(){
        return "index?faces-redirect=true";
    }
    
    private void asignarValoresHospital(Hospital hospital) {
        setIdHospital(hospital.getIdHospital());
        setNombreIngresado(hospital.getNombre());
        setAntiguedadIngresada(hospital.getAntiguedad());
        setAreaIngresada(hospital.getArea());
        setSedeSeleccionada(hospital.getSede().getIdSede());
        setCondicionSeleccionado(hospital.getCondicion().getIdCondicion());
        setDistritoSeleccionado(hospital.getDistrito().getIdDistrito());
        setGerenteSeleccionado(hospital.getGerente().getIdGerente());
        setFechaIngresada(hospital.getFechaRegistro());
    }
    
    public List<Sede> getSedes() {
        return sedes;
    }

    public void setSedes(List<Sede> sedes) {
        this.sedes = sedes;
    }

    public List<Distrito> getDistritos() {
        return distritos;
    }

    public void setDistritos(List<Distrito> distritos) {
        this.distritos = distritos;
    }

    public List<Gerente> getGerentes() {
        return gerentes;
    }

    public void setGerentes(List<Gerente> gerentes) {
        this.gerentes = gerentes;
    }

    public List<Condicion> getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(List<Condicion> condiciones) {
        this.condiciones = condiciones;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public String getNombreIngresado() {
        return nombreIngresado;
    }

    public void setNombreIngresado(String nombreIngresado) {
        this.nombreIngresado = nombreIngresado;
    }

    public int getAntiguedadIngresada() {
        return antiguedadIngresada;
    }

    public void setAntiguedadIngresada(int antiguedadIngresada) {
        this.antiguedadIngresada = antiguedadIngresada;
    }

    public double getAreaIngresada() {
        return areaIngresada;
    }

    public void setAreaIngresada(double areaIngresada) {
        this.areaIngresada = areaIngresada;
    }

    public Date getFechaIngresada() {
        return fechaIngresada;
    }

    public void setFechaIngresada(Date fechaIngresada) {
        this.fechaIngresada = fechaIngresada;
    }

    public int getSedeSeleccionada() {
        return sedeSeleccionada;
    }

    public void setSedeSeleccionada(int sedeSeleccionada) {
        this.sedeSeleccionada = sedeSeleccionada;
    }

    public int getDistritoSeleccionado() {
        return distritoSeleccionado;
    }

    public void setDistritoSeleccionado(int distritoSeleccionado) {
        this.distritoSeleccionado = distritoSeleccionado;
    }

    public int getGerenteSeleccionado() {
        return gerenteSeleccionado;
    }

    public void setGerenteSeleccionado(int gerenteSeleccionado) {
        this.gerenteSeleccionado = gerenteSeleccionado;
    }

    public int getCondicionSeleccionado() {
        return condicionSeleccionado;
    }

    public void setCondicionSeleccionado(int condicionSeleccionado) {
        this.condicionSeleccionado = condicionSeleccionado;
    }
    
    
    
}
