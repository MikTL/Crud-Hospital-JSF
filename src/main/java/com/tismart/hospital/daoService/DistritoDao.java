package com.tismart.hospital.daoService;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import static com.tismart.hospital.daoService.GenericDAO.entityManager;
import com.tismart.hospital.model.Distrito;

public class DistritoDao extends GenericDAO implements Serializable{
    
    public List<Distrito> listaDistrito(){
        try {
            String consulta="SELECT d FROM Distrito d";
            entityManager=getEntityManager();
            Query query = entityManager.createQuery(consulta);
        
        List<Distrito> listaD = query.getResultList();
        return listaD;
        } catch (Exception e) {
            throw new RuntimeException("Error al listar los distritos: " + e.getMessage());
        }
        
    }
}
