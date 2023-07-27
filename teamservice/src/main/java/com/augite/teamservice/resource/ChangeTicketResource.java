package com.augite.teamservice.resource;

import com.augite.teamservice.model.ChangeTicket;
import com.augite.teamservice.service.ChangeTicketService;

//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/changeticket")
public class ChangeTicketResource {

    private final ChangeTicketService changeTicketService;

    @Autowired
    public ChangeTicketResource(ChangeTicketService changeTicketService) {
        this.changeTicketService = changeTicketService;
    }

    /*@PostMapping(
    		value="/add", 
    		consumes = { MediaType.APPLICATION_JSON_VALUE },
    		produces = { MediaType.APPLICATION_JSON_VALUE }
    		)*/
    @PostMapping("/add")
    public ResponseEntity<ChangeTicket> addChangeTicket(@RequestBody ChangeTicket changeTicket) {
        ChangeTicket newChangeTicket = changeTicketService.addChangeTicket(changeTicket);
        return new ResponseEntity<>(newChangeTicket, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ChangeTicket>> getAllChangeTickets() {
        List<ChangeTicket> changeTickets = changeTicketService.findAllChangeTickets();
        return new ResponseEntity<>(changeTickets, HttpStatus.OK);
    }

    @GetMapping("/getrandomchangeno")
    public ResponseEntity<String> getRandomChangeNo() {
        String randomChangeNo = changeTicketService.getRandomChangeNoJSONFormat();
        return new ResponseEntity<>(randomChangeNo, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Optional<ChangeTicket>> updateChangeTicket(@RequestBody ChangeTicket changeTicket) {
        Optional<ChangeTicket> updateChangeTicket = changeTicketService.updateChangeTicket(changeTicket);
        return new ResponseEntity<>(updateChangeTicket, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<ChangeTicket>> findChangeTicketById(@PathVariable ("id") Integer id) {
        Optional<ChangeTicket> changeTicket = changeTicketService.findChangeTicketById(id);
        return new ResponseEntity<>(changeTicket, HttpStatus.OK);
    }

    @GetMapping("/find/changeno/{changeNo}")
    public ResponseEntity<Optional<ChangeTicket>> findChangeTicketByChangeNo(@PathVariable ("changeNo") String changeNo) {
        Optional<ChangeTicket> changeTicket = changeTicketService.findChangeTicketByChangeNo(changeNo);
        return new ResponseEntity<>(changeTicket, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteChangeTicketById(@PathVariable ("id") Integer id) {
        this.changeTicketService.deleteChangeTicket(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/changeno/{changeno}")
    public ResponseEntity<?> deleteChangeTicketByChangeNo(@PathVariable ("changeno") String changeNo) {
        this.changeTicketService.deleteChangeTicket(changeNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }






}
