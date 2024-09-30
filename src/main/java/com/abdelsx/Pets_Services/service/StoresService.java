package com.abdelsx.Pets_Services.service;

import com.abdelsx.Pets_Services.model.Stores;
import com.abdelsx.Pets_Services.repository.StoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoresService {
    @Autowired
    private final StoresRepository storesRepository;

    public StoresService (StoresRepository storesRepository){
        this.storesRepository = storesRepository;
    }
    public List<Stores> getAllStores(){
        return storesRepository.findAll();
    }
    public List<Stores> getStoreByDirection(String direction){
        return storesRepository.findBydirectionOfTheStore(direction);
    }
    public Stores addStore(Stores stores){
        return storesRepository.save(stores);
    }
}
