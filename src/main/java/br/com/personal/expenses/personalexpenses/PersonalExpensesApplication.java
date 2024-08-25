package br.com.personal.expenses.personalexpenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "br.com.personal.expenses.personalexpenses.*" })
public class PersonalExpensesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalExpensesApplication.class, args);
	}

}
