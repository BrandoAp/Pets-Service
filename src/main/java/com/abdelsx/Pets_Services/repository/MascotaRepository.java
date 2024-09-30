package com.abdelsx.Pets_Services.repository;

import com.abdelsx.Pets_Services.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    List<Mascota> findByNombre(String namePet);
    void deleteByNombre(String namePet);
}
