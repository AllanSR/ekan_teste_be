package br.com.ekan.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ekan.demo.model.Customer;

@Controller
@RequestMapping("v1")
public class CustomerController {

	
	@PostMapping(value = "/insert")
    public String insertCustomer(@RequestBody Customer customer) {
        return "custom"; //inserir
    }
	
	@GetMapping(value = "/customers")
    public String getAllCustomers() {
        return "custom"; //gettodos
    }
	
	@GetMapping(value = "/customer/documents/{id}")
    public String getDocumentsById(@PathVariable String document) {
        return "custom"; //outra controller?
    }
	
	@PutMapping(value = "/customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return null; //inserir
    }
	
}
