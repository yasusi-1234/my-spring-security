package com.example.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true) // スプリングセキュリティーのデバッグ用
public class MySecuritySampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySecuritySampleApplication.class, args);
	}

}
