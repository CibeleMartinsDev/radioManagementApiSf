package br.com.radio.management.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "br.com.radio.management.api.*" })
public class RadioManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RadioManagementApplication.class, args);
	}

}
