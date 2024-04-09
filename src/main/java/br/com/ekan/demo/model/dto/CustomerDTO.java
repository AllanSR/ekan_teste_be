package br.com.ekan.demo.model.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class CustomerDTO {

	private String name;
	private String phone;
	private LocalDate birthDate;
	private List<DocumentDTO> documentDTOList;
}
