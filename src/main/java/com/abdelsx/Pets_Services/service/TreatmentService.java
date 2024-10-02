package com.abdelsx.Pets_Services.service;

import com.abdelsx.Pets_Services.model.Treatment;
import com.abdelsx.Pets_Services.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreatmentService {
   private final TreatmentRepository treatmentRepository;

   @Autowired
    public TreatmentService (TreatmentRepository treatmentRepository){
       this.treatmentRepository = treatmentRepository;
   }

   public List <Treatment> getAllTreatments(){
       return treatmentRepository.findAll();
   }

   public Treatment createTreatment (Treatment treatment){
       return treatmentRepository.save(treatment);
   }
   public Treatment updateTreatment (Long id, Treatment updatedTreatment){
       Optional<Treatment> existingTreatment = treatmentRepository.findById(id);
       if (existingTreatment.isPresent()){
           Treatment treatment = existingTreatment.get();
           treatment.setNameTreatment(updatedTreatment.getNameTreatment());
           treatment.setPriceTreatment(updatedTreatment.getPriceTreatment());
           return treatmentRepository.save(treatment);
       } else {
           throw new IllegalArgumentException("El tratamiento con el ID " + id + " no existe.");
       }
   }
   public void deleteTreatment (Long id){
       treatmentRepository.deleteById(id);
   }

}
