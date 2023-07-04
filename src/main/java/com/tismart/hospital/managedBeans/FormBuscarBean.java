package com.tismart.hospital.managedBeans;

import com.tismart.hospital.daoService.HospitalDao;
import com.tismart.hospital.model.HospitalListaDTO;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class FormBuscarBean implements Serializable {
    @Inject
    private HospitalDao hospitalDao;
    private String nombre;
    private int gerente;
    private boolean inputDisabled;
    private boolean selectDisabled;
    private List<HospitalListaDTO> hospitales;

    public void checkInput(AjaxBehaviorEvent event) {
        selectDisabled = (nombre != null && !nombre.isEmpty());
    }

    public void checkSelect(AjaxBehaviorEvent event) {
        inputDisabled = (gerente != 0);
    }

    public String buscarHospital() {
        hospitales = hospitalDao.buscarHospitales(nombre, gerente);
        resetearValores();
        return "busqueda?faces-redirect=true";
    }

    public void resetearValores() {
        nombre = "";
        gerente = 0;
        inputDisabled = false;
        selectDisabled = false;
    }

    // Getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGerente() {
        return gerente;
    }

    public void setGerente(int gerente) {
        this.gerente = gerente;
    }

    public boolean isInputDisabled() {
        return inputDisabled;
    }

    public void setInputDisabled(boolean inputDisabled) {
        this.inputDisabled = inputDisabled;
    }

    public boolean isSelectDisabled() {
        return selectDisabled;
    }

    public void setSelectDisabled(boolean selectDisabled) {
        this.selectDisabled = selectDisabled;
    }

    public List<HospitalListaDTO> getHospitales() {
        return hospitales;
    }

    public void setHospitales(List<HospitalListaDTO> hospitales) {
        this.hospitales = hospitales;
    }
}
