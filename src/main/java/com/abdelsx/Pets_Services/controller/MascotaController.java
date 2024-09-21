package com.abdelsx.Pets_Services.controller;

import com.abdelsx.Pets_Services.model.Mascota;
import com.abdelsx.Pets_Services.repository.MascotaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    private final MascotaRepository mascotaRepository;

     public MascotaController (MascotaRepository mascotaRepository){
         this.mascotaRepository = mascotaRepository;
     }

     @GetMapping ("/listPets")
    public List<Mascota> listarMascotas(){
         return mascotaRepository.findAll();
     }

     @PostMapping ("/addPets")
    public Mascota agregarMascota (@RequestBody Mascota mascota){
         return mascotaRepository.save(mascota);
     }
}
