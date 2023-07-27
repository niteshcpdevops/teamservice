package com.augite.teamservice.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augite.teamservice.model.TeamGroups;
import com.augite.teamservice.service.TeamGroupsService;

@RestController
@RequestMapping("/teamgroups")
public class TeamGroupsResource {
    
    private TeamGroupsService teamGroupsService;

    public TeamGroupsResource(TeamGroupsService teamGroupsService) {
        this.teamGroupsService = teamGroupsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TeamGroups>> getAllTeamGroups() {
        List <TeamGroups> teamGroupsList = teamGroupsService.getAllTeamGroups();
        return new ResponseEntity<>(teamGroupsList, HttpStatus.OK);
    }
}
