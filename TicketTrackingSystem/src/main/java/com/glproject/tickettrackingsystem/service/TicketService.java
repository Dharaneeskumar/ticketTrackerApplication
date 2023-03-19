package com.glproject.tickettrackingsystem.service;

import com.glproject.tickettrackingsystem.entity.Tickets;
import com.glproject.tickettrackingsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
@Autowired
    TicketRepository ticketRepository;

    public List<Tickets> getAllTicket(){
        List<Tickets> ticket=ticketRepository.findAll();
        return ticket;
    }
    public Tickets getTicketToUpdate(int id){
        Optional<Tickets> tickets=ticketRepository.findById(id);
    return  tickets.get();
    }
    public void updateTicket(Tickets tickets){
       Optional<Tickets> optional=ticketRepository.findById(tickets.getId());
       Tickets t=optional.get();
       t.setTitle(tickets.getTitle());
       t.setDescription(tickets.getDescription());
       t.setDate(tickets.getDate());
        ticketRepository.save(t);

    }
    public  void deleteRecord(int id){
        ticketRepository.deleteById(id);
    }
    public void saveTicket(Tickets tickets){

        ticketRepository.save(tickets);
    }
}
