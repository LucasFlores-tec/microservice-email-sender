package com.ms.email.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.email.dtos.EmailDto;
import com.ms.email.models.Email;
import com.ms.email.services.EmailService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmailController {
	
	@Autowired
	EmailService service;
	
	@PostMapping("/sending-email")
	public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.sendEmail(emailDto));
	}

}
