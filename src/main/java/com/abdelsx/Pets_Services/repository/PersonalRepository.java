package com.abdelsx.Pets_Services.repository;

import com.abdelsx.Pets_Services.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRepository extends JpaRepository<Personal, Long> {
}
