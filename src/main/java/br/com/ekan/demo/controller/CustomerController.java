package br.com.ekan.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

	
	@PostMapping(value = "/custom")
    public String custom() {
        return "custom";
    }
}
