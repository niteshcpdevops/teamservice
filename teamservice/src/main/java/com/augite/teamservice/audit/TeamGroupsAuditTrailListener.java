package com.augite.teamservice.audit;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.augite.teamservice.model.TeamGroups;

public class TeamGroupsAuditTrailListener {

    private static Logger log = LoggerFactory.getLogger(TeamGroupsAuditTrailListener.class);

    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(TeamGroups teamGroups) {
        if (teamGroups.getId() == 0) {
            log.info("[TEAM GROUPS AUDIT] About to add a team group");
        } else {
            log.info("[TEAM GROUPS] About to update/delete team group: " + teamGroups.getId());
        }
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(TeamGroups teamGroups) {
        log.info("[TEAM GROUPS AUDIT] add/update/delete complete for team group: " + teamGroups.getId());
        System.out.println("[TEAM GROUPS AUDIT] add/update/delete complete for team group: " + teamGroups.getId());
    }
    
    @PostLoad
    private void afterLoad(TeamGroups teamGroups) {
        log.info("[TEAM GROUPS AUDIT] user loaded from database: " + teamGroups.getId());
    } 
    
}
