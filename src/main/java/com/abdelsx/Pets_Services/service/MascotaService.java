package com.abdelsx.Pets_Services.service;

import com.abdelsx.Pets_Services.model  .Mascota;
import com.abdelsx.Pets_Services.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class MascotaService{
    private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

    private final MascotaRepository mascotaRepository;

    @Autowired
    public MascotaService (MascotaRepository mascotaRepository){
        this.mascotaRepository = mascotaRepository;
    }

    public Mascota addPets (Mascota mascota){
        if (mascota.getNombre() == null || mascota.getNombre().trim().isEmpty())
            throw new IllegalArgumentException("Pet name cannot be empty");
        if (mascota.getEdad()<0)
            throw new IllegalArgumentException("Pet age cannot be negative");
        if (mascota.getRaza() == null || mascota.getRaza().trim().isEmpty())
            throw new IllegalArgumentException("Pet raza cannot be empty");
        LOGGER.info("Pet adding successfully");
        return mascotaRepository.save(mascota);
    }

    public List<Mascota>getAllPets(){
        return mascotaRepository.findAll();
    }

    public List <Mascota> findByName(String namePet){
        try{
            if (namePet.isEmpty())
                LOGGER.info("The pet name cannot be empty");
        } catch (IllegalArgumentException e){
            LOGGER.warning(e.getMessage());
        }
        return mascotaRepository.findByNombre(namePet);
    }

    public void deleteByName (String namePet){
        if (namePet.isEmpty())
            throw new IllegalArgumentException("Pet name cannot be empty");
        mascotaRepository.deleteByNombre(namePet);
    }
}