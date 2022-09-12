package com.ms.email.builders;

import com.ms.email.dtos.EmailDto;

public class EmailDtoBuilder {
	
	private EmailDto emailDto;
	
	private EmailDtoBuilder() {}
	
	public static EmailDtoBuilder oneEmailDto() {
		EmailDtoBuilder builder = new EmailDtoBuilder();
		builder.emailDto = new EmailDto();
		builder.emailDto.setOwnerRef("Pedro");
		builder.emailDto.setEmailFrom("test@test.com.br");
		builder.emailDto.setEmailTo("test2@test2.com.br");
		builder.emailDto.setSubject("Subject test");
		builder.emailDto.setText("Text test");
		return builder;
	}
	
	public EmailDto now() {
		return emailDto;
	}

}
