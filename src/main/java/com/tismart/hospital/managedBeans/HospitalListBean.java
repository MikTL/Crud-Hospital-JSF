
package com.tismart.hospital.managedBeans;

import com.tismart.hospital.daoService.HospitalDao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.tismart.hospital.model.HospitalListaDTO;

@Named
@ViewScoped
public class HospitalListBean implements Serializable{
    @Inject
    private HospitalDao hospitalDao;
    
    private List<HospitalListaDTO> hospitales;
    
    @PostConstruct
    public void init() {
        hospitales=null;
        hospitales = hospitalDao.listaHospital();
    }

    public List<HospitalListaDTO> getHospitales() {
        return hospitales;
    }

    public void setHospitales(List<HospitalListaDTO> hospitales) {
        this.hospitales = hospitales;
    }
    
    public String paginaAgregarHospital(){
        return "agregarHospital?faces-redirect=true";
    }
    public String eliminarRegistro(int id){
        hospitalDao.eliminarHospital(id);
        return "index?faces-redirect=true";
    }
    public void actualizarHospitales() {
        hospitales=null;
        hospitales = hospitalDao.listaHospital();
    }
    
   
}
