package com.nagi.springdemo.service;

import java.util.List;

import com.nagi.springdemo.model.Ticket;

public interface TicketService {
	
	public Ticket addTicket(Ticket ticket);
	
	public List<Ticket> getAllTicket();

}
