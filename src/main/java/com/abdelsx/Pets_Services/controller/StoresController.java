package com.abdelsx.Pets_Services.controller;

import com.abdelsx.Pets_Services.model.Stores;
import com.abdelsx.Pets_Services.service.StoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoresController {

    private final StoresService storesServices;

    @Autowired
    public StoresController (StoresService storesServices){
        this.storesServices = storesServices;
    }

    @GetMapping("/listAllStores")
    public List<Stores> getAllStores (){
        return storesServices.getAllStores();
    }
    @GetMapping("/findStore")
    public List<Stores> findStoreByDirection (@RequestParam String directionOfTheStore){
        return storesServices.getStoreByDirection(directionOfTheStore);
    }
    @PostMapping("addNewStore")
    public @ResponseBody String addStore (
            @RequestParam String directionOfTheStore, @RequestParam String nameOfTheStore) {
        Stores newStore = new Stores();
        newStore.setDirectionOfTheStore(directionOfTheStore);
        newStore.setNameOfTheStore(nameOfTheStore);
        storesServices.addStore(newStore);
        return "New store added successfully";
    }
}
