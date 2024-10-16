package com.abdelsx.Pets_Services.controller;

import com.abdelsx.Pets_Services.model.Mascota;
import com.abdelsx.Pets_Services.repository.MascotaRepository;
import com.abdelsx.Pets_Services.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {
    private final MascotaService mascotaService;

    @Autowired
    public MascotaController(MascotaService mascotaService){
        this.mascotaService = mascotaService;
    }
    @GetMapping("/listAllPets")
    public List<Mascota> getAllPets(){
        return mascotaService.getAllPets();
    }
    @PostMapping("/addPets")
    public @ResponseBody Mascota addPets(@RequestParam int age
            , @RequestParam String name, @RequestParam String raza){
        Mascota mascota = new Mascota();
        mascota.setEdad(age);
        mascota.setNombre(name);
        mascota.setRaza(raza);
        return mascotaService.addPets(mascota);
    }
    @GetMapping("findPet")
    public List<Mascota> findPet(@RequestParam String namePet){
        return mascotaService.findByName(namePet);
    }

    @PostMapping("/deletePet")
    public void deletePet(@RequestParam String namePet){
        mascotaService.deleteByName(namePet);
    }

}
