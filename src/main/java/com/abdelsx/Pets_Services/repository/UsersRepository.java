package com.abdelsx.Pets_Services.repository;

import com.abdelsx.Pets_Services.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository <Users, Long> {
}
