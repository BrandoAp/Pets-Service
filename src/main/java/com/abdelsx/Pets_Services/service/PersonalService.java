package com.abdelsx.Pets_Services.service;

import com.abdelsx.Pets_Services.model.Personal;
import com.abdelsx.Pets_Services.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonalService {
    private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());
    @Autowired
    private final PersonalRepository personalRepository;

    public PersonalService(PersonalRepository personalRepository){
        this.personalRepository = personalRepository;
    }
    public Personal addPersonal(Personal personal){
        return personalRepository.save(personal);
    }
    public List<Personal> findAllPersonal(){
        return personalRepository.findAll();
    }
    public List<Personal> findByCIP(String CIP){
        return personalRepository.findByCIP(CIP);
    }
    public void deleteByCIP(String CIP){
        personalRepository.deleteByCIP(CIP);
    }

}
