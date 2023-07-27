package com.augite.teamservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ChangeTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, columnDefinition = "INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)")
    private Integer id;
    @Column(nullable = false, updatable = false)
    private String cTaskNo;
    private String cTaskShortDesc;
    private String cTaskLongDesc;
    //private String cTaskAssignedGroup;
    private String groupName;
    private String cTaskAssignedTo;
    private String cTaskState;
    private String changeNo;
    //@JsonFormat(pattern="yyyy-dd-mm HH:mm:ss")
    private Date cTaskPlannedStartDateTime;
    //@JsonFormat(pattern="yyyy-dd-mm HH:mm:ss")
    private Date cTaskPlannedEndDateTime;
    @JsonFormat(pattern="yyyy-dd-mm HH:mm:ss")
    @Column(nullable = false, name="DATE_TIME_CREATED", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private Date dateTimeCreated;

    @JsonFormat(pattern="yyyy-dd-mm HH:mm:ss")
    @Column(name="DATE_TIME_MODIFIED", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private Date dateTimeModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcTaskNo() {
        return cTaskNo;
    }

    public void setcTaskNo(String cTaskNo) {
        this.cTaskNo = cTaskNo;
    }

    public String getcTaskShortDesc() {
        return cTaskShortDesc;
    }

    public void setcTaskShortDesc(String cTaskShortDesc) {
        this.cTaskShortDesc = cTaskShortDesc;
    }

    public String getcTaskLongDesc() {
        return cTaskLongDesc;
    }

    public void setcTaskLongDesc(String cTaskLongDesc) {
        this.cTaskLongDesc = cTaskLongDesc;
    }

    /*public String getcTaskAssignedGroup() {
        return cTaskAssignedGroup;
    }

    public void setcTaskAssignedGroup(String cTaskAssignedGroup) {
        this.cTaskAssignedGroup = cTaskAssignedGroup;
    }*/

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getcTaskAssignedTo() {
        return cTaskAssignedTo;
    }

    public void setcTaskAssignedTo(String cTaskAssignedTo) {
        this.cTaskAssignedTo = cTaskAssignedTo;
    }

    public String getcTaskState() {
        return cTaskState;
    }

    public void setcTaskState(String cTaskState) {
        this.cTaskState = cTaskState;
    }

    public String getChangeNo() {
        return changeNo;
    }

    public void setChangeNo(String changeNo) {
        this.changeNo = changeNo;
    }

    public Date getcTaskPlannedStartDateTime() {
        return cTaskPlannedStartDateTime;
    }

    public void setcTaskPlannedStartDateTime(Date cTaskPlannedStartDateTime) {
        this.cTaskPlannedStartDateTime = cTaskPlannedStartDateTime;
    }

    public Date getcTaskPlannedEndDateTime() {
        return cTaskPlannedEndDateTime;
    }

    public void setcTaskPlannedEndDateTime(Date cTaskPlannedEndDateTime) {
        this.cTaskPlannedEndDateTime = cTaskPlannedEndDateTime;
    }

    public Date getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(Date dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    public Date getDateTimeModified() {
        return dateTimeModified;
    }

    public void setDateTimeModified(Date dateTimeModified) {
        this.dateTimeModified = dateTimeModified;
    }

    public ChangeTask(String changeShortDesc, String changeLongDesc, String groupName, String chgAssignedTo, String changeState, String changeNo, Date cTaskPlannedStartDateTime, Date cTaskPlannedEndDateTime) {
        this.cTaskShortDesc = changeShortDesc;
        this.cTaskLongDesc = changeLongDesc;
        this.groupName = groupName;
        this.cTaskAssignedTo = chgAssignedTo;
        this.cTaskState = changeState;
        this.changeNo = changeNo;
        this.cTaskPlannedStartDateTime = cTaskPlannedStartDateTime;
        this.cTaskPlannedEndDateTime = cTaskPlannedEndDateTime;
    }
}
