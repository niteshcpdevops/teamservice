package com.augite.teamservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.augite.teamservice.model.TeamGroups;

public interface TeamGroupsRepo extends JpaRepository<TeamGroups,Integer>{
    
}
