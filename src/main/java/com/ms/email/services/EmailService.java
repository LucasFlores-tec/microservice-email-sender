package com.ms.email.services;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms.email.dtos.EmailDto;
import com.ms.email.enums.StatusEmail;
import com.ms.email.models.Email;
import com.ms.email.repositories.EmailRepository;

@Service
public class EmailService {
	
	@Autowired
	EmailRepository repository;
	
	@Autowired
	private JavaMailSender sender;

	public Email sendEmail(EmailDto emailDto) {
		Email emailModel = new Email();
		copyProperties(emailDto, emailModel);
		emailModel.setSendDateEmail(LocalDateTime.now());
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailModel.getEmailFrom());
			message.setTo(emailModel.getEmailTo());
			message.setSubject(emailModel.getSubject());
			message.setText(emailModel.getText());
			sender.send(message);
			emailModel.setStatusEmail(StatusEmail.SENT);
		} catch (MailException e) {
			emailModel.setStatusEmail(StatusEmail.ERROR);
		}
		return repository.save(emailModel);
	}
	
}
