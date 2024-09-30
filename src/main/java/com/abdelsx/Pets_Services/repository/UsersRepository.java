package com.abdelsx.Pets_Services.repository;

import com.abdelsx.Pets_Services.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findByUserName(String userName);
    void deleteByUserName(String userName);
}
