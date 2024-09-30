package com.abdelsx.Pets_Services.controller;

import com.abdelsx.Pets_Services.model.Mascota;
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

}
