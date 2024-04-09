package br.com.ekan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ekan.demo.model.Customer;
import br.com.ekan.demo.model.dto.CustomerDTO;
import br.com.ekan.demo.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("v1/customer")
@Tag(name = "Customer", description = "CRUD de Customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;

	
	@PostMapping(value = "/insert")
    public Object insertCustomer(@RequestBody CustomerDTO customerDTO) {
		return service.insertCustomer(customerDTO);
    }
	
	@GetMapping(value = "/customers")
    public Object getAllCustomers() {
        return service.getAllCustomers(); 
    }
	
	@PutMapping(value = "/customer")
    public Object updateCustomer(@RequestBody CustomerDTO customerDTO) {
        return service.updateCustomer(customerDTO);
    }
	
	@DeleteMapping(value = "/customer/{id}")
    public Object deleteCustomer(@RequestParam Long customerId) {
        return service.deleteCustomer(customerId);
    }
}
