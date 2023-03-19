package com.glproject.tickettrackingsystem.controller;

import com.glproject.tickettrackingsystem.entity.Tickets;
import com.glproject.tickettrackingsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    TicketRepository ticketRepository;

    @RequestMapping("/showResult")
    public String showResult(@RequestParam("search") String search , Model model){
        System.out.println(search);
        List<Tickets> tickets=ticketRepository.findByTitleContainingOrDateContainingIgnoreCase(search,search);
        model.addAttribute("ticket",tickets);
        return  "searchPage";
    }
    @RequestMapping("/viewPage")
    public String showview( @RequestParam("id") int id,Model model){
        System.out.println("hojkhlhk"+id);
        Optional<Tickets> tickets=ticketRepository.findById(id);
        Tickets list=tickets.get();
        model.addAttribute("tickets",list);

        return  "view";
    }

}
