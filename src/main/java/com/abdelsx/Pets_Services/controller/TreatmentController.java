package com.abdelsx.Pets_Services.controller;

import com.abdelsx.Pets_Services.model.Treatment;
import com.abdelsx.Pets_Services.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/treatment")
public class TreatmentController {

    private final TreatmentService treatmentService;

    @Autowired
    public TreatmentController (TreatmentService treatmentServices){
        this.treatmentService = treatmentServices;
    }
    @GetMapping("/getAllTreatments")
    public List<Treatment> getAllTreatments (){
        return treatmentService.getAllTreatments();
    }

    @GetMapping("/addTreatment")
    public Treatment addTreatment (Treatment treatment){
        return treatmentService.createTreatment(treatment);
    }
}
