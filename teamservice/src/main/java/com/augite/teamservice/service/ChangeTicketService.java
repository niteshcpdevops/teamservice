package com.augite.teamservice.service;

import com.augite.teamservice.model.ChangeTicket;
import com.augite.teamservice.repo.ChangeTicketRepo;

//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
//import java.util.UUID;

@Service
@Transactional
public class ChangeTicketService {

    private final ChangeTicketRepo changeTicketRepo;

    @Autowired
    public ChangeTicketService(ChangeTicketRepo changeTicketRepo) {
        this.changeTicketRepo = changeTicketRepo;
    }

    public ChangeTicket addChangeTicket(ChangeTicket changeTicket) {
        //changeTicket.setChangeNo(UUID.randomUUID().toString());
        if (changeTicket.getChangeNo() == null || changeTicket.getChangeNo().equals(""))
            changeTicket.setChangeNo(getRandomChangeNo());
        changeTicket.setDateTimeCreated(new Date());
        return this.changeTicketRepo.save(changeTicket);
    }

    public String getRandomChangeNo() {
        return ("CHG" + new Random().nextInt()).replaceAll("-","");
    }

    public String getRandomChangeNoJSONFormat() {
        return "{\"changeNo\": \""+getRandomChangeNo()+"\"}";
    }

    public List<ChangeTicket> findAllChangeTickets() {
        return this.changeTicketRepo.findAll();
    }

    public Optional<ChangeTicket> updateChangeTicket(ChangeTicket changeTicket) {

        this.changeTicketRepo.findChangeTicketByChangeNo(changeTicket.getChangeNo()).ifPresent(
                updatedChangeTicket -> {
                    updatedChangeTicket.setChangeShortDesc(changeTicket.getChangeShortDesc());
                    updatedChangeTicket.setChangeLongDesc(changeTicket.getChangeLongDesc());
                    updatedChangeTicket.setGroupName(changeTicket.getGroupName());
                    updatedChangeTicket.setChgAssignedTo(changeTicket.getChgAssignedTo());
                    updatedChangeTicket.setChangeType(changeTicket.getChangeType());
                    updatedChangeTicket.setChangeState(changeTicket.getChangeState());
                    updatedChangeTicket.setChgPlannedStartDateTime(changeTicket.getChgPlannedStartDateTime());
                    updatedChangeTicket.setChgPlannedEndDateTime(changeTicket.getChgPlannedEndDateTime());
                    updatedChangeTicket.setDateTimeModified(new Date());
                }
        );

        return this.changeTicketRepo.findChangeTicketByChangeNo(changeTicket.getChangeNo());
    }

    public Optional<ChangeTicket> findChangeTicketById(Integer id) {
        return this.changeTicketRepo.findChangeTicketById(id);
    }

    public Optional<ChangeTicket> findChangeTicketByChangeNo(String changeNo) {
        return this.changeTicketRepo.findChangeTicketByChangeNo(changeNo);
    }

    public void deleteChangeTicket(Integer id) {
        this.changeTicketRepo.deleteChangeTicketById(id);
    }

    public void deleteChangeTicket(String changeNo) {
        this.changeTicketRepo.deleteChangeTicketByChangeNo(changeNo);
    }
}
