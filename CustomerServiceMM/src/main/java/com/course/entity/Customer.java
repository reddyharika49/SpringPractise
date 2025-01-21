package com.course.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String contact;
	private String email;
	private Date dop;
	private boolean isCustomer;
	private double amount;
	public void setId(int id2) {
		// TODO Auto-generated method stub
		
	}

	

}
