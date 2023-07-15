package com.tismart.hospital.daoService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.StoredProcedureQuery;
import com.tismart.hospital.model.Hospital;
import com.tismart.hospital.model.HospitalListaDTO;
import static com.tismart.hospital.daoService.GenericDAO.entityManager;


public class HospitalDao extends GenericDAO implements Serializable{
    
    public List<HospitalListaDTO> listaHospital() {
        List<HospitalListaDTO> listaHospitalDTO = new ArrayList<>();
        try {
            entityManager=getEntityManager();
            StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("obtenerHospitales");
            
            List<Hospital> resultados = query.getResultList();
            listaHospitalDTO = resultados.stream()
                    .map(this::mapearHospitalDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error al Listar los hospitales: " + e.getMessage());
        } 
        return listaHospitalDTO;
    }
    
    public void guardarHospital(
        String nombre,
        int antiguedad,
        String area,
        int idSede,
        int idGerente,
        int idCondicion,
        int idDistrito,
        String fecha
        ){
        try {
            entityManager=getEntityManager();
            StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("insertarHospital");
            query.setParameter("p_nombre",nombre);
            query.setParameter("p_antiguedad", antiguedad);
            query.setParameter("p_area_text",area);
            query.setParameter("p_idsede",idSede);
            query.setParameter("p_idgerente",idGerente);
            query.setParameter("p_idcondicion",idCondicion);
            query.setParameter("p_iddistrito",idDistrito);
            query.setParameter("p_fecharegistro",fecha);
            
            query.execute();
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el hospital: " + e.getMessage());
        } 
    }
    
    public void editarHospital(
            int idHospital,
            String nombre,
            int antiguedad,
            String area,
            int idSede,
            int idGerente,
            int idCondicion,
            int idDistrito,
            String fecha
    ){
        try {
            entityManager=getEntityManager();
            StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("actualizarHospital");
            query.setParameter("p_idhospital", idHospital);
            query.setParameter("p_nombre",nombre);
            query.setParameter("p_antiguedad", antiguedad);
            query.setParameter("p_area_text",area);
            query.setParameter("p_idsede",idSede);
            query.setParameter("p_idgerente",idGerente);
            query.setParameter("p_idcondicion",idCondicion);
            query.setParameter("p_iddistrito",idDistrito);
            query.setParameter("p_fecharegistro",fecha);
            
            query.execute();
        } catch (Exception e) {
            throw new RuntimeException("Error al editar el hospital: " + e.getMessage());
        } 
    }
    
    public void eliminarHospital(int id){
        try {
            entityManager=getEntityManager();
            StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("eliminarHospital");
            query.setParameter("p_idhospital", id);
            query.execute();
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el hospital: " + e.getMessage());
        } 
    }
    
    public List<HospitalListaDTO> buscarHospitales(String nombreHospital, int idgerente){
        List<HospitalListaDTO> listaHospitalDTO = new ArrayList<>();
        nombreHospital = (nombreHospital == null || nombreHospital.isEmpty()) ? "CADENA_ESPECIFICA" : nombreHospital;
        try {
            entityManager=getEntityManager();
            
            StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("buscarHospital");
            query.setParameter("p_nombre", nombreHospital);
            query.setParameter("p_idgerente",idgerente);
            
            List<Hospital> resultados = query.getResultList();
            listaHospitalDTO = resultados.stream()
                    .map(this::mapearHospitalDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el hospital: " + e.getMessage());
        }
        return listaHospitalDTO;
    }
    
    public Hospital obtenerHospital(int id){
        entityManager=getEntityManager();
        Hospital hospital= entityManager.find(Hospital.class, id);
        System.out.println(hospital.getNombre());
        return hospital;
        
    }
    
    private HospitalListaDTO mapearHospitalDTO(Hospital hospital) {
        HospitalListaDTO hospitalDTO = new HospitalListaDTO();
        hospitalDTO.setId(hospital.getIdHospital());
        hospitalDTO.setNombre(hospital.getNombre());
        hospitalDTO.setCondicion(hospital.getCondicion().getDescCondicion());
        hospitalDTO.setSede(hospital.getSede().getDescSede());
        hospitalDTO.setGerente(hospital.getGerente().getDesGerente());
        return hospitalDTO;
    }
}
