package com.abdelsx.Pets_Services.repository;

import com.abdelsx.Pets_Services.model.Stores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StoresRepository extends JpaRepository<Stores, Long> {
    List<Stores> findBydirectionOfTheStore(String directionOfTheStore);
}
