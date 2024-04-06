package br.com.ekan.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/document")
public class DocumentController {
	
	@GetMapping(value = "/customer/documents/{id}")
    public String getDocumentsById(@PathVariable String document) {
        return "custom"; //outra controller?
    }

}
