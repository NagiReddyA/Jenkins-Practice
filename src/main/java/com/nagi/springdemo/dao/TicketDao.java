package com.nagi.springdemo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagi.springdemo.model.Ticket;

public interface TicketDao extends JpaRepository<Ticket,Integer>{

	Ticket getById(Long idl);


}
