package com.tismart.hospital.managedBeans;

import com.tismart.hospital.daoService.UsuariosDao;
import com.tismart.hospital.model.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class LoginBean implements Serializable{
    @Inject
    private UsuariosDao userDao;

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        boolean valido= userDao.validarLogin(this.username, this.password);
        Usuario user= new Usuario();
        if(valido){
            FacesContext.getCurrentInstance()
                    .getExternalContext().getSessionMap().put("username", user);
            return "protected/index.xhtml?faces-redirect=true";
        }else {
            // Si la validación no es exitosa, muestra un mensaje de error al usuario
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.addMessage("growl", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Nombre de usuario o contraseña incorrectos"));
        }
        return "";
    }
    
}
