package br.com.ekan.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ekan.demo.repository.DocumentRepository;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository repository;
	
	public Object getDocumentsById(Long customerId){
		return repository.getAllDocumentsByCustomerId(customerId);
	}
}