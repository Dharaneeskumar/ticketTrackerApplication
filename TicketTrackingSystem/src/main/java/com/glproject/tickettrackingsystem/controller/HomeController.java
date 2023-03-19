package com.glproject.tickettrackingsystem.controller;

import com.glproject.tickettrackingsystem.entity.Tickets;
import com.glproject.tickettrackingsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ticketPage")
public class HomeController {

    @Autowired
    TicketService ticketService;

    @RequestMapping("/home")
    public String home(){
        return "HomePage";
    }
    @GetMapping("/getAllTickets")
    public String getAllTicket(Model model) {
        List<Tickets> tickets = ticketService.getAllTicket();
        model.addAttribute("tickets", tickets);
        return "ticketPage";
    }

    @GetMapping("/showEditPage")
    public String showEditPage(@RequestParam("id") int id, Model model) {
        Tickets tickets = ticketService.getTicketToUpdate(id);
        model.addAttribute("ticket", tickets);
        System.out.println();
        return "updateForm";
    }

    @RequestMapping("/updateForm")
    public String updateForm(@ModelAttribute Tickets tickets) {
        ticketService.updateTicket(tickets);
        return "redirect:/ticketPage/getAllTickets";
    }

    @RequestMapping("/deleteTicket")
    public String deleteTicket(@RequestParam("id") int id) {
        ticketService.deleteRecord(id);
        return "redirect:/ticketPage/getAllTickets";

    }
    @RequestMapping ("/createTicket")
    public String createTicket(Model model){
Tickets tickets=new Tickets();
model.addAttribute("ticket",tickets);
      return "createTicket";

}
    @RequestMapping ("/updateTicket")
    public String updateTicket(@ModelAttribute Tickets tickets){
        ticketService.saveTicket(tickets);

        return  "redirect:/logout";

    }
}
