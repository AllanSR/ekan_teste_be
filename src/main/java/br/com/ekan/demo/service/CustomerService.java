package br.com.ekan.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ekan.demo.model.Customer;
import br.com.ekan.demo.model.Document;
import br.com.ekan.demo.model.dto.CustomerDTO;
import br.com.ekan.demo.model.dto.DocumentDTO;
import br.com.ekan.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Object insertCustomer(CustomerDTO customerDTO) {
		
		if(isInvalidCustomer(customerDTO))
			throw new RuntimeException();
		Customer customer;
		try {
			customer = customerRepository.save(getCustomerByDTO(customerDTO));
		} catch(RuntimeException e) {
			System.err.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
		
	}
	
	public Object getAllCustomers(){
		return new ResponseEntity<>(customerRepository.getAllCustomers(), HttpStatus.OK);
	}
	
	public Object updateCustomer(CustomerDTO customerDTO) {
		
		if(isInvalidCustomer(customerDTO))
			throw new RuntimeException();
		Customer customer;
		try {
			customer = customerRepository.save(getCustomerByDTO(customerDTO));
		} catch(RuntimeException e) {
			System.err.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}	
	
	@SuppressWarnings("deprecation")
	public Object deleteCustomer(Long id) {

		try {

			Customer customer = customerRepository.getOne(id);

			if (customer != null)
				customerRepository.delete(customer);

		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	private boolean isInvalidCustomer(CustomerDTO customerDTO) {
		//aqui seria interessante saber as regras de negocio para validar melhor
		//validacoes como se o cpf for valido ou existir eu vou abster para o exemplo
		return Objects.isNull(customerDTO) || customerDTO.getDocumentDTOList().isEmpty();
	}
	
	private Customer getCustomerByDTO(CustomerDTO dto) {
		return Customer.builder()
				.birthDate(dto.getBirthDate())
				.name(dto.getName())
				.inclusionDate(LocalDate.now())
				.modifyDate(LocalDate.now())
				.documentList(getDocumentListByDTO(dto))
				.phone(dto.getPhone())
				.build();
		
	}
	
	private List<Document> getDocumentListByDTO(CustomerDTO dto){
		
		List<Document> documentList = new ArrayList<Document>();
		
		for (DocumentDTO doc : dto.getDocumentDTOList()) {
			Document document = new Document();
			document.setDescription(doc.getDescription());
			document.setDocumentType(doc.getDocumentType());
			document.setInclusionDate(LocalDate.now());
			document.setModifyDate(LocalDate.now());
			documentList.add(document);
		}
		return documentList;
	}
}
