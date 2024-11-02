package com.abdelsx.Pets_Services.service;

import com.abdelsx.Pets_Services.model  .Mascota;
import com.abdelsx.Pets_Services.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
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
        if (mascota.getEdad() < 0)
            throw new IllegalArgumentException("Pet age cannot be negative");
        if (mascota.getRaza() == null || mascota.getRaza().trim().isEmpty())
            throw new IllegalArgumentException("Pet raza cannot be empty");
        return mascotaRepository.save(mascota);
    }

    public List<Mascota>getAllPets(){
        return mascotaRepository.findAll();
    }

    public List <Mascota> findByName(String namePet){
        try{
            if (namePet.trim().isEmpty())
                throw new IllegalArgumentException("");
            else
                LOGGER.info("Pet found successfully");
        } catch (Exception e){
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return mascotaRepository.findByNombre(namePet);
    }

    public void updatePet (Long id, Mascota updateMascota){
        Optional<Mascota> existingPet = mascotaRepository.findById(id);
        if (existingPet.isPresent()){
            Mascota mascota = existingPet.get();
            mascota.setNombre(updateMascota.getNombre());
            mascotaRepository.save(mascota);
        } else
            throw new IllegalArgumentException("The pet with the ID " + id + " does not exist.");
    }

    public void deleteByName (String namePet){
        try{
            if (namePet.trim().isEmpty())
                throw new IllegalArgumentException("Pet name cannot be empty");
        }catch (Exception e){
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        mascotaRepository.deleteByNombre(namePet);
    }
}