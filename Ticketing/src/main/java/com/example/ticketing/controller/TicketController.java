package com.example.ticketing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ticketing.entity.Ticket;
import com.example.ticketing.service.TicketService;

//@RestController
@Controller
@RequestMapping("/ticketsystem")
public class TicketController {

	@Autowired
	TicketService ticketService;

	@GetMapping("/sayHello")
	public String sayHello() {
		return "Welcome to Ticketing System";
	}

	@GetMapping("/list")
	public String listTickets(Model theModel) {
		List<Ticket> listTickets = ticketService.getAllTickets();
		theModel.addAttribute("ticket", listTickets);
		return "tickets/list-tickets";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Ticket t1 = new Ticket();
		theModel.addAttribute("ticket", t1);
		return "tickets/ticket-form";
	}

	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("ticket") Ticket t1) {
		ticketService.addTicket(t1);
		return "redirect:/ticketsystem/list";
	}

	@PostMapping("/delete")
	public String deleteTicket(@RequestParam("ticketId") int id) {
		ticketService.deleteTicket(id);
		return "redirect:/ticketsystem/list";
	}

	@PostMapping("/edit")
	public String showFormForUpdate(@RequestParam("ticketId") int id, Model theModel) {
		
		Ticket ticketdb = ticketService.getTicket(id);
		theModel.addAttribute("ticket", ticketdb);
		return "tickets/ticket-form";
	}

	@GetMapping("/view")
	public String showFormForView(@RequestParam("ticketId") int id, Model theModel) {
		Ticket ticketdb = ticketService.getTicket(id);
		theModel.addAttribute("ticket", ticketdb);
		return "tickets/ticket-form";
	}
	
	@GetMapping("/search")
	public String showFormForSearch(@RequestParam("ticketId") int id, Model theModel) {
		Ticket ticketdb = ticketService.getTicket(id);
		theModel.addAttribute("ticket", ticketdb);
		return "tickets/ticket-form";
	}

}
