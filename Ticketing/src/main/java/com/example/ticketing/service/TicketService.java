package com.example.ticketing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ticketing.entity.Ticket;
import com.example.ticketing.repository.TicketRepository;

@Service
public class TicketService {
	@Autowired
	TicketRepository ticketRepository;
	
	public void addTicket(Ticket t1) {
		ticketRepository.save(t1);
	}
	
	public void deleteTicket(int id) {
		ticketRepository.deleteById(id);
	}
	
	public Ticket getTicket(int id) {
		return ticketRepository.findById(id).get();
	}
	
	public Ticket updateTicket(int id, Ticket newTicket) {
		Ticket dbTicket = getTicket(id);
		dbTicket.setTitle(newTicket.getTitle());
		dbTicket.setDescription(newTicket.getDescription());
//		dbTicket.setCreation(newTicket.getCreation());
		ticketRepository.save(dbTicket);
		return dbTicket;
	}
	
	public List<Ticket> getAllTickets(){
		return ticketRepository.findAll();
	}
}
