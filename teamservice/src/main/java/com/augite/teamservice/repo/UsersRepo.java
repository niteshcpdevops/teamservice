package com.augite.teamservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.augite.teamservice.model.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{
    
}
