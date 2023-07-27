package com.augite.teamservice.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ChangeTicket {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, columnDefinition = "INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)")
    private Integer id;

    @Column(nullable = false, updatable = false)
    private String changeNo;
    private String changeShortDesc;
    private String changeLongDesc;

    //private String chgAssignedGroup;
    private String groupName;
    private String chgAssignedTo;
    private String changeState;

    private String changeType;

    //@JsonFormat(pattern="yyyy-dd-mmTHH:mm:ss")
    private Date chgPlannedStartDateTime;
    //@JsonFormat(pattern="yyyy-dd-mmTHH:mm:ss")
    private Date chgPlannedEndDateTime;

    @JsonFormat(pattern="yyyy-dd-mm HH:mm:ss")
    @Column(name="DATE_TIME_CREATED", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private Date dateTimeCreated;

    @JsonFormat(pattern="yyyy-dd-mm HH:mm:ss")
    @Column(name="DATE_TIME_MODIFIED", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private Date dateTimeModified;

    public ChangeTicket() {}

    public ChangeTicket(String changeShortDesc, String changeLongDesc, String groupName, String chgAssignedTo, String changeType, String changeState, Date chgPlannedStartDateTime, Date chgPlannedEndDateTime) {
        this.changeShortDesc = changeShortDesc;
        this.changeLongDesc = changeLongDesc;
        this.groupName = groupName;
        this.chgAssignedTo = chgAssignedTo;
        this.changeType = changeType;
        this.changeState = changeState;
        this.chgPlannedStartDateTime = chgPlannedStartDateTime;
        this.chgPlannedEndDateTime = chgPlannedEndDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChangeNo() {
        return changeNo;
    }

    public void setChangeNo(String changeNo) {
        this.changeNo = changeNo;
    }

    public String getChangeShortDesc() {
        return changeShortDesc;
    }

    public void setChangeShortDesc(String changeShortDesc) {
        this.changeShortDesc = changeShortDesc;
    }

    public String getChangeLongDesc() {
        return changeLongDesc;
    }

    public void setChangeLongDesc(String changeLongDesc) {
        this.changeLongDesc = changeLongDesc;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /*public String getChgAssignedGroup() {
        return chgAssignedGroup;
    }

    public void setChgAssignedGroup(String chgAssignedGroup) {
        this.chgAssignedGroup = chgAssignedGroup;
    }*/

    public String getChgAssignedTo() {
        return chgAssignedTo;
    }

    public void setChgAssignedTo(String chgAssignedTo) {
        this.chgAssignedTo = chgAssignedTo;
    }

    public String getChangeState() {
        return changeState;
    }

    public void setChangeState(String changeState) {
        this.changeState = changeState;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
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

    public Date getChgPlannedStartDateTime() {
        return chgPlannedStartDateTime;
    }

    public void setChgPlannedStartDateTime(Date chgPlannedStartDateTime) {
        this.chgPlannedStartDateTime = chgPlannedStartDateTime;
    }

    public Date getChgPlannedEndDateTime() {
        return chgPlannedEndDateTime;
    }

    public void setChgPlannedEndDateTime(Date chgPlannedEndDateTime) {
        this.chgPlannedEndDateTime = chgPlannedEndDateTime;
    }



}
