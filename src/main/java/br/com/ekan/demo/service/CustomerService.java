package br.com.ekan.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ekan.demo.model.Customer;
import br.com.ekan.demo.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void insertCustomer(Customer customer) {
		
		if(isInvalidCustomer(customer))
			throw new RuntimeException();
		
		customerRepository.save(customer);
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepository.getAllCustomers();
	}
	
	public Customer updateCustomer(Customer customer) {
		
		if(isInvalidCustomer(customer))
			throw new RuntimeException();
		
		return customerRepository.save(customer);
	}
	
	public void deleteCustomer(Long id){
		Customer customer = customerRepository.getOne(id);
		
		if(customer != null)
			customerRepository.delete(null);
		
	}

	private boolean isInvalidCustomer(Customer customer) {
		return Objects.isNull(customer) || customer.getDocument() != null;
	}
}
