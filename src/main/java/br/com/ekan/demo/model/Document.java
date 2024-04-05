package br.com.ekan.demo.model;

import java.io.Serializable;
import java.time.LocalDate;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data

public class Document implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ManyToOne
	private String id;
	
	private String documentType;
	
	private String description;
	
	private LocalDate inclusionDate;
	
	private LocalDate modifyDate;
}