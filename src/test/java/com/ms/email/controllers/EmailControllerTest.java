package com.ms.email.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ms.email.builders.EmailDtoBuilder;
import com.ms.email.dtos.EmailDto;
import com.ms.email.models.Email;
import com.ms.email.services.EmailService;

@WebMvcTest(EmailController.class)
public class EmailControllerTest {
		
	private EmailDto emailDto;
	
	@Autowired
	private EmailController controller;
	
	@MockBean
	private EmailService service;

	@BeforeEach
	public void setup() {
		emailDto = EmailDtoBuilder.oneEmailDto().now();
	}
	
	@Test
	public void shouldReturnHttpStatusCreated_whenSendingEmail() {
		// scenario
		ResponseEntity<Email> expectedResponse = new ResponseEntity<Email>(HttpStatus.CREATED);
		
		// action
		ResponseEntity<Email> response = controller.sendingEmail(emailDto);
		
		// validation
		assertEquals(expectedResponse, response);
	}
	
}
