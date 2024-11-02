package com.abdelsx.Pets_Services.service;

import com.abdelsx.Pets_Services.model.Treatment;
import com.abdelsx.Pets_Services.repository.TreatmentRepository;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TreatmentService {

    private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());
    private final TreatmentRepository treatmentRepository;

   @Autowired
    public TreatmentService (TreatmentRepository treatmentRepository){
       this.treatmentRepository = treatmentRepository;
   }

   public List <Treatment> getAllTreatments(){
       return treatmentRepository.findAll();
   }

   public void createTreatment (Treatment treatment){
       try {
           if (treatment.getNameTreatment().trim().isEmpty() || treatment.getNameTreatment() == null){
               throw new IllegalArgumentException("Treatment name cannot by empty");
           } else if (treatment.getPriceTreatment() < 0) {
               throw new IllegalArgumentException("The price of the treatment cannot be zero or negative.");
           }
       } catch (Exception e){
           LOGGER.log(Level.WARNING, e.getMessage());
       }
       treatmentRepository.save(treatment);
   }
   public void updateTreatment (Long id, Treatment updatedTreatment){
       Optional<Treatment> existingTreatment = treatmentRepository.findById(id);
       try {
           if (existingTreatment.isPresent()){
               Treatment treatment = existingTreatment.get();
               treatment.setPriceTreatment(updatedTreatment.getPriceTreatment());
               treatmentRepository.save(treatment);
           } else {
               throw new IllegalArgumentException("The treatment with the ID " + id + " does not exist.");
           }
       }catch (Exception e){
           LOGGER.log(Level.WARNING, e.getMessage());
       }
   }

   public Optional<Treatment> getTreatmentById (Long id){
       if (id < 0)
           throw new IllegalArgumentException("The treatment id cannot be negative");
       else if (!treatmentRepository.existsById(id))
           throw new IllegalArgumentException("Treatment with id " + id + " does not exist");
       return treatmentRepository.findById(id);
   }
   public void deleteTreatment (Long id){
       if (id < 0)
           throw new IllegalArgumentException("The treatment id cannot be negative");
       else if (!treatmentRepository.existsById(id))
           throw new IllegalArgumentException("Treatment with id " + id + " does not exist");
       else
           treatmentRepository.deleteById(id);

   }
}
