package com.abdelsx.Pets_Services.controller;

import com.abdelsx.Pets_Services.model.Treatment;
import com.abdelsx.Pets_Services.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/addTreatment")
    public @ResponseBody String addTreatment (
            @RequestParam String nameTreatment, @RequestParam float priceTreatment){
        Treatment newTreatment = new Treatment();
        newTreatment.setNameTreatment(nameTreatment);
        newTreatment.setPriceTreatment(priceTreatment);
        treatmentService.createTreatment(newTreatment);
        return "Treatment adding successfully";
    }

    @PostMapping("/updateTreatment")
    public @ResponseBody String updateTreatment (
            @RequestParam Long idTreatment, @RequestParam float newPriceTreatment){
        Treatment updateTreatment = new Treatment();
        updateTreatment.setPriceTreatment(newPriceTreatment);
        treatmentService.updateTreatment(idTreatment, updateTreatment);
        return "Treatment updated successfully";
    }

    @GetMapping("/findTreatment")
    public Optional<Treatment> getTreatmentById(Long id){
        return treatmentService.getTreatmentById(id);
    }

    @PostMapping("/deleteTreatment")
    public String deleteTreatmentById (Long id){
        treatmentService.deleteTreatment(id);
        return "Treatment successfully remove";
    }
}
