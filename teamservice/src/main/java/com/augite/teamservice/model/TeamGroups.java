package com.augite.teamservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;

import com.augite.teamservice.audit.TeamGroupsAuditTrailListener;

@EntityListeners(TeamGroupsAuditTrailListener.class)
@Entity
public class TeamGroups {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, columnDefinition = "INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)")
    private Integer id;
    private String groupName;

    public TeamGroups() {

    }

    public TeamGroups(String groupName) {
        this.groupName = groupName;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @PostPersist
	public void logNewTeamGroupsAdded() {
		System.out.println("Added group name '" + groupName + "' with ID: " + id);
	}
    
}
