package br.com.ekan.demo.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Document {

	private String id;
	
	private String documentType;
	
	private String description;
	
	private LocalDate inclusionDate;
	
	private LocalDate modifyDate;
}