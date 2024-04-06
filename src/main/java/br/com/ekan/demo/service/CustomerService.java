package br.com.ekan.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ekan.demo.model.Customer;
import br.com.ekan.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Object insertCustomer(Customer customer) {
		
		if(isInvalidCustomer(customer))
			throw new RuntimeException();
		
		try {
			customerRepository.save(customer);
		} catch(RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	public Object getAllCustomers(){
		return new ResponseEntity<>(customerRepository.getAllCustomers(), HttpStatus.OK);
	}
	
	public Object updateCustomer(Customer customer) {
		
		if(isInvalidCustomer(customer))
			throw new RuntimeException();
		
		try {
			customerRepository.save(customer);
		} catch(RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	public void deleteCustomer(Long id){
		Customer customer = customerRepository.getOne(id);
		
		if(customer != null)
			customerRepository.delete(null);
		
	}

	private boolean isInvalidCustomer(Customer customer) {
		//aqui seria interessante saber as regras de negocio para validar melhor
		//algumas regras eu vou abstrair como validacao de cpf por conta do tempo
		return Objects.isNull(customer) || customer.getDocument() == null;
	}
}
