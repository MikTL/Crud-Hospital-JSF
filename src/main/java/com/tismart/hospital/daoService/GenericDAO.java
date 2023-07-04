package com.tismart.hospital.daoService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAO {
    
    protected static EntityManager entityManager;
    private static EntityManagerFactory emf;
    private static final String PU = "hospital-JPA";
    
    public GenericDAO(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory(PU);
        }
    }
    
    protected EntityManager getEntityManager(){
        if(entityManager == null){
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }
}