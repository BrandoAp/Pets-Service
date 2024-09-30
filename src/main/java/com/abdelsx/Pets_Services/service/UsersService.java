package com.abdelsx.Pets_Services.service;

import com.abdelsx.Pets_Services.model.Users;
import com.abdelsx.Pets_Services.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public Users addUsers(Users users){
        return usersRepository.save(users);
    }
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }
    public List<Users> getUserByUserName(String userName){
        return usersRepository.findByUserName(userName);
    }
    public void deleteByUserName(String userName){
        usersRepository.deleteByUserName(userName);
    }
}
