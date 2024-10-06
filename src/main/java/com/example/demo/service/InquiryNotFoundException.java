package com.example.demo.service;

public class InquiryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	// 独自例外（ビジネスロジック上でthrowする）
	public InquiryNotFoundException(String message) {
		super(message);
	}

}
