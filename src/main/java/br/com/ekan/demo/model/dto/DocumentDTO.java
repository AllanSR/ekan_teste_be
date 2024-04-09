package br.com.ekan.demo.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentDTO {

	private String documentType;
	private String description;
}
