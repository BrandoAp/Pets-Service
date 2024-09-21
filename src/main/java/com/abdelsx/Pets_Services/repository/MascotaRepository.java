package com.abdelsx.Pets_Services.repository;

import com.abdelsx.Pets_Services.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}
