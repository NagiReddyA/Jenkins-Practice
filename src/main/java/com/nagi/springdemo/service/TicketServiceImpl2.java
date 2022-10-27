package com.nagi.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.nagi.springdemo.dao.TicketDao;
import com.nagi.springdemo.model.Ticket;
@Service("ticketServiceImpl2")
@Primary
public class TicketServiceImpl2 implements TicketService{
	
	@Autowired
	private TicketDao dao;

	@Override
	public Ticket addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		System.out.println("=============>TicketServiceImpl2");
		return null;
	}

	@Override
	public List<Ticket> getAllTicket() {
		// TODO Auto-generated method stub
		System.out.println("=============>TicketServiceImpl2");
		return dao.findAll();
	}

}
