package com.diegomonterroso.webapp.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diegomonterroso.webapp.biblioteca.system.Main;

import javafx.application.Application;

@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {
		// levanta FX
		Application.launch(Main.class, args);
		// levanta Springboot
		SpringApplication.run(BibliotecaApplication.class, args);
	}

}
