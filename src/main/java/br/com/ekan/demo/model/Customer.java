package br.com.ekan.demo.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Document> documentList;
	

}