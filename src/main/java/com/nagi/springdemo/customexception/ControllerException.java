package com.nagi.springdemo.customexception;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
public class ControllerException  extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMessage;
	public ControllerException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public ControllerException() {
		
	}
	
	

}
