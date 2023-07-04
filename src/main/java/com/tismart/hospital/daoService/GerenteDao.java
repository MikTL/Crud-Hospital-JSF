package com.tismart.hospital.daoService;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import com.tismart.hospital.model.Gerente;
import static com.tismart.hospital.daoService.GenericDAO.entityManager;

public class GerenteDao extends GenericDAO implements Serializable{
    
    public List<Gerente> listaGerentes(){
        try {
            String consulta="SELECT g FROM Gerente g";
            entityManager=getEntityManager();
            Query query = entityManager.createQuery(consulta);
        
        List<Gerente> listaG = query.getResultList();
        return listaG;
        } catch (Exception e) {
            throw new RuntimeException("Error al listar los gerentes: " + e.getMessage());
        }
        
    }
}
