package com.abdelsx.Pets_Services.repository;

import com.abdelsx.Pets_Services.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonalRepository extends JpaRepository<Personal, Long> {
    List<Personal> findByCIP(String CIP);
    void deleteByCIP(String CIP);
}
