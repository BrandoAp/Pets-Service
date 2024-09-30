package com.abdelsx.Pets_Services.service;

import com.abdelsx.Pets_Services.model.Treatment;
import com.abdelsx.Pets_Services.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {
    @Autowired
    private final TreatmentRepository treatmentRepository;

    public TreatmentService(TreatmentRepository treatmentRepository){
        this.treatmentRepository = treatmentRepository;
    }

    public Treatment addTreatment (Treatment treatment){
        return treatmentRepository.save(treatment);
    }

    public List<Treatment> getAllTreatments(){
        return treatmentRepository.findAll();
    }

    public List<Treatment> getTreatmentByPrice(float priceTreatment){
        return treatmentRepository.findByPrice(priceTreatment);
    }
    public void deleteTreatmentByName(String nameTreatment){
        treatmentRepository.deleteByNameTreatment(nameTreatment);
    }

}
