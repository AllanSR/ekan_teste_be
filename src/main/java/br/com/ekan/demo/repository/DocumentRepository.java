package br.com.ekan.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ekan.demo.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>{

	@Query("select d from Document d where d.customer.id = :customerId")
	List<Document> getAllDocumentsByCustomerId(Long customerId);
}
