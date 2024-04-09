package br.com.ekan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ekan.demo.service.DocumentService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("v1/document")
@Tag(name = "Document", description = "CRUD de Document")
public class DocumentController {
	
	@Autowired
	private DocumentService service;
	
	@GetMapping(value = "/documents/{customerId}")
    public Object getDocumentsById(@PathVariable Long customerId) {
        return service.getDocumentsById(customerId); 
    }

}
