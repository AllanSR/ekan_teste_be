package br.com.ekan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ekan.demo.model.Customer;
import br.com.ekan.demo.service.CustomerService;

@RestController
@RequestMapping("v1/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;

	
	@PostMapping(value = "/insert")
    public Object insertCustomer(@RequestBody Customer customer) {
		return service.insertCustomer(customer);
    }
	
	@GetMapping(value = "/customers")
    public Object getAllCustomers() {
        return service.getAllCustomers(); 
    }
	
	@PutMapping(value = "/customer")
    public Object updateCustomer(@RequestBody Customer customer) {
        return service.updateCustomer(customer);
    }
	
}
