package br.com.ekan.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ekan.demo.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query("select c from Customer c")
	List<Customer> getAllCustomers();
}
