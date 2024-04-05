package br.com.ekan.demo.model;

import java.time.LocalDate;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@NamedQuery(name="getallcustomer", query="select c from Customer c")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String phone;
	
	private LocalDate birthDate;
	
	private LocalDate inclusionDate;
	
	private LocalDate modifyDate;
	
	private Document document;
}