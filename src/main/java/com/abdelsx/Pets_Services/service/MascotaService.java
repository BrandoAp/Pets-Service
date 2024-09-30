package com.abdelsx.Pets_Services.service;

import com.abdelsx.Pets_Services.model.Mascota;
import com.abdelsx.Pets_Services.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class MascotaService{
    private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

    @Autowired
    private final MascotaRepository mascotaRepository;

    public MascotaService (MascotaRepository mascotaRepository){
        this.mascotaRepository = mascotaRepository;
    }

    public Mascota addPets (Mascota mascota){
        return mascotaRepository.save(mascota);
    }

    public List<Mascota>getAllPets(){
        return mascotaRepository.findAll();
    }

    public List <Mascota> findByName(String namePet){
        return mascotaRepository.findByNombre(namePet);
    }
    public void deleteByName (String namePet){
        mascotaRepository.deleteByNombre(namePet);
    }
}