package com.augite.teamservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.augite.teamservice.model.ChangeTicket;

import java.util.Optional;

public interface ChangeTicketRepo extends JpaRepository<ChangeTicket, Integer> {
    Optional<ChangeTicket> findChangeTicketById(Integer id);

    Optional<ChangeTicket> findChangeTicketByChangeNo(String changeNo);

    void deleteChangeTicketById(Integer id);

    void deleteChangeTicketByChangeNo(String changeNo);

    //ChangeTicket updateChangeTicketByChangeNo(String changeNo);

}
