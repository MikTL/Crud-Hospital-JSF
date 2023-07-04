package com.tismart.hospital.daoService;

import java.io.Serializable;
import java.util.List;
import static com.tismart.hospital.daoService.GenericDAO.entityManager;
import com.tismart.hospital.model.Condicion;
import javax.persistence.Query;


public class CondicionDao extends GenericDAO implements Serializable{
    
    public List<Condicion> listaCondiciones(){
        try {
            String consulta="SELECT c FROM Condicion c";
            entityManager=getEntityManager();
            Query query = entityManager.createQuery(consulta);
        
        List<Condicion> listaC = query.getResultList();
        return listaC;
        } catch (Exception e) {
            throw new RuntimeException("Error al listar las condiciones: " + e.getMessage());
        }
        
    }
}
