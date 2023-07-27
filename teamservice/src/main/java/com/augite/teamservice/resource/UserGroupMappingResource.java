package com.augite.teamservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augite.teamservice.model.UserGroupMapping;
import com.augite.teamservice.service.UserGroupMappingService;

@RestController
@RequestMapping("/usergroupmapping")
public class UserGroupMappingResource {

    private UserGroupMappingService userGroupMappingService;

    @Autowired
    public UserGroupMappingResource(UserGroupMappingService userGroupMappingService) {
        this.userGroupMappingService = userGroupMappingService;
    }

    @GetMapping("/groupusers/{groupname}")
    public ResponseEntity<List<UserGroupMapping>> getUsersByGroupName(@PathVariable("groupname") String groupName) {
        List<UserGroupMapping> userGroupMappingList = this.userGroupMappingService.getUsersByGroupName(groupName);
        return new ResponseEntity<>(userGroupMappingList, HttpStatus.OK);
    }
    
}
