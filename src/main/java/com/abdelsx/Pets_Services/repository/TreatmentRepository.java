package com.abdelsx.Pets_Services.repository;

import com.abdelsx.Pets_Services.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    List<Treatment> findByPrice(float priceTreatment);
    void deleteByNameTreatment(String nameTreatment);
}
