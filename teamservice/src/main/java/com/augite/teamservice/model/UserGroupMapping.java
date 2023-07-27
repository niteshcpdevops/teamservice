package com.augite.teamservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class UserGroupMapping {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    private String userUid;

    private String groupName;
    
    private String username;
    
    public UserGroupMapping() {
    	
    }
    
    public UserGroupMapping(String userUid, String groupName) {
    	this.userUid = userUid;
    	this.groupName = groupName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public String getUsername() {
    	return this.username;
    }
    
    public void setUsername(String username) {
    	this.username = username;
    }
    
    //private Users users;
    
    /*@Autowired
    public UserGroupMapping(Users users) {
    	this.users = users;
    }
    
    public Users getUsers() {
    	return this.users;
    }*/
    
    

    
}
