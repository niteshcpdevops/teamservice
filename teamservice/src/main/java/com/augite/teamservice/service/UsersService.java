package com.augite.teamservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augite.teamservice.model.Users;
import com.augite.teamservice.repo.UsersRepo;


@Service
@Transactional
public class UsersService {


    private UsersRepo usersRepo;

    @Autowired
    public UsersService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public List<Users> getUsers() {
        return usersRepo.findAll();
    }
    
}
