package com.tismart.hospital.daoService;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import static com.tismart.hospital.daoService.GenericDAO.entityManager;
import com.tismart.hospital.model.Sede;

public class SedeDao extends GenericDAO implements Serializable{
    
    public List<Sede> listaSede(){
        try {
            String consulta="SELECT s FROM Sede s";
            entityManager=getEntityManager();
            Query query = entityManager.createQuery(consulta);
        
        List<Sede> listaS = query.getResultList();
        return listaS;
        } catch (Exception e) {
            throw new RuntimeException("Error al listar las sedes: " + e.getMessage());
        }
        
    }
}
