package com.augite.teamservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.augite.apstracker.repo.UsersRepo;
import com.augite.teamservice.model.UserGroupMapping;
import com.augite.teamservice.repo.UserGroupMappingRepo;

@Service
@Transactional
public class UserGroupMappingService {

    private UserGroupMappingRepo userGroupMappingRepo;
    
    //private UsersRepo usersRepo;

    @Autowired
    public UserGroupMappingService(UserGroupMappingRepo userGroupMappingRepo){
        this.userGroupMappingRepo = userGroupMappingRepo;
    }
    
    /*@Autowired
    public UserGroupMappingService(UsersRepo usersRepo) {
    	this.usersRepo = usersRepo;
    }*/

    public List<UserGroupMapping> getUsersByGroupName(String groupName) {
        return this.userGroupMappingRepo.findUsersByGroupName(groupName);
    }
    
}
