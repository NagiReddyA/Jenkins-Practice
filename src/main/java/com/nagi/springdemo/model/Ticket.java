package com.nagi.springdemo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ticket {
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((catagory == null) ? 0 : catagory.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Ticket other = (Ticket) obj;
//		if (catagory == null) {
//			if (other.catagory != null)
//				return false;
//		} else if (!catagory.equals(other.catagory))
//			return false;
//		return true;
//	}
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="catagory")
	private String catagory;
	
	@Column(name="age")
	private int age;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	
	

}
