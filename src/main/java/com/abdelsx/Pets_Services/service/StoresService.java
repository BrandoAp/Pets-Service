package com.abdelsx.Pets_Services.service;

import com.abdelsx.Pets_Services.model.Stores;
import com.abdelsx.Pets_Services.repository.StoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Service
public class StoresService {

    private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());
    private final StoresRepository storesRepository;

    @Autowired
    public StoresService (StoresRepository storesRepository){
        this.storesRepository = storesRepository;
    }
    public List<Stores> getAllStores(){
        return storesRepository.findAll();
    }
    public List<Stores> getStoreByDirection(String direction){
        String regexDirection = "^[A-Za-z\\s]+,\\s[A-Za-z\\s]+,\\s\\d+$";
        Pattern pattern = Pattern.compile(regexDirection);
        Matcher matcher = pattern.matcher(direction);
        try {
            if (!matcher.matches())
                LOGGER.info("The address format is invalid");
            else if (direction.trim().isEmpty())
                LOGGER.log(Level.WARNING, "The store address cannot be empty");
            else if (!storesRepository.existsByDirectionOfTheStore(direction)) {
                LOGGER.info("The store does not exist");
            } else
                LOGGER.info("The store with the address " + direction + "found");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        return storesRepository.findBydirectionOfTheStore(direction);
    }
    public void addStore(Stores stores){
        String regexDirection = "^[A-Za-z\\s]+,\\s[A-Za-z\\s]+,\\s\\d+$";
        Pattern pattern = Pattern.compile(regexDirection);
        Matcher matcher = pattern.matcher(stores.getDirectionOfTheStore());
        try {
            if (!matcher.matches() || stores.getDirectionOfTheStore().trim().isEmpty())
                LOGGER.log(Level.WARNING, "The address is invalid or empty");
            if (stores.getNameOfTheStore().trim().isEmpty())
                LOGGER.log(Level.WARNING, "The store name cannot by empty");
        } catch (Exception e){
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        storesRepository.save(stores);
    }
}
