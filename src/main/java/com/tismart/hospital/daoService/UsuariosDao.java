package com.tismart.hospital.daoService;

import java.io.Serializable;
import static com.tismart.hospital.daoService.GenericDAO.entityManager;
import javax.persistence.Query;

public class UsuariosDao extends GenericDAO implements Serializable{
    
    public boolean validarLogin(String username, String password){
        try {
            entityManager=getEntityManager();
            String hql= "SELECT COUNT(*) FROM Usuario WHERE contrasenia=:password AND nombreUsuario=:username";
            Query query= entityManager.createQuery(hql);
            query.setParameter("password", password);
            query.setParameter("username", username);
            Long count =  (Long) query.getSingleResult();
            return count>0;
        } catch (Exception e) {
            throw new RuntimeException("No se puedo verificar las credenciales. "+e.getMessage());
        }
    }
    
}
