package com.nagi.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagi.springdemo.customexception.BusinessException;
import com.nagi.springdemo.dao.TicketDao;
import com.nagi.springdemo.model.Ticket;

@Service("ticketServiceImpl")
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDao dao;

	@Override
	public Ticket addTicket(Ticket ticket) {
		 System.out.println("In service Impl============>>>>>>");
		if (ticket.getCatagory().isEmpty() || ticket.getCatagory().length() == 0) {
			throw new BusinessException("601", "pls send proper name, It is blank");

		}
		try {

			Ticket savedTicket = dao.save(ticket);
			return savedTicket;
		} catch (IllegalArgumentException e) {

			throw new BusinessException("602", " Given employee is null" + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("603", "  Something went wrong in service layer while saving data" + e.getMessage());
		}

	}

	@Override
	public List<Ticket> getAllTicket() {

		try {
			 System.out.println("In service Impl============>>>>>>");
			List<Ticket> getTickets = dao.findAll();
			if (getTickets.isEmpty()) { 
				throw new BusinessException("604", " Hey list is completly empty, we have nothing to return");
			}
			return getTickets;
		} catch (Exception e) {
			throw new BusinessException("605", " somthing went wrong in service layer while fatcing data"+e.getMessage());

		}

	}

}
