package com.tismart.hospital.managedBeans;

import com.tismart.hospital.model.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
@Named
@ViewScoped
public class SessionBean implements Serializable{
    public void verificarSession(){
        System.out.println("Ejecutando la verificacion de Session");
        try {
            Usuario usuario =(Usuario) FacesContext.getCurrentInstance()
                    .getExternalContext().getSessionMap().get("username");
            if(usuario==null){
                FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/login.xhtml");
            }
        } catch (IOException e) {
            throw new RuntimeException("No se pudo verificar la sesión "+e.getMessage());
        }
    }
}
