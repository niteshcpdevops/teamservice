package com.augite.teamservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augite.teamservice.model.TeamGroups;
import com.augite.teamservice.repo.TeamGroupsRepo;

@Service
@Transactional
public class TeamGroupsService {
    
    private TeamGroupsRepo teamGroupsRepo;

    @Autowired
    public TeamGroupsService(TeamGroupsRepo teamGroupsRepo) {
        this.teamGroupsRepo = teamGroupsRepo;
    }

    public List<TeamGroups> getAllTeamGroups() {
        return teamGroupsRepo.findAll();
    }
}
