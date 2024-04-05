package br.com.ekan.demo.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Customer {
	
	private String id;
	
	private String name;
	
	private String phone;
	
	private LocalDate birthDate;
	
	private LocalDate inclusionDate;
	
	private LocalDate modifyDate;
	
	private Document document;
}