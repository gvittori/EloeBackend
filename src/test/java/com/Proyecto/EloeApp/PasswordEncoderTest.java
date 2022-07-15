package com.Proyecto.EloeApp;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest {
	
	@Test
	public void encode_password() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("usuario3"));
	}
}
