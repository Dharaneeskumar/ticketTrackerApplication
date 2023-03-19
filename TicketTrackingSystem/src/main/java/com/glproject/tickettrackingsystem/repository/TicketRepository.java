package com.glproject.tickettrackingsystem.repository;

import com.glproject.tickettrackingsystem.entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface TicketRepository extends JpaRepository <Tickets,Integer>{


    public List<Tickets> findByTitleContainingOrDateContainingIgnoreCase(String search,String search1);
}
