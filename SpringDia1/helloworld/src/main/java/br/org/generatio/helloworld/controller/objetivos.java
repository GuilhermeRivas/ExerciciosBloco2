package br.org.generatio.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/objetivos")
public class objetivos {
	
	@GetMapping
	public String objetivo() {
		return "Conseguir absorver o máximo possivel de string pois sei que é uma materia essencial e que facilitará muito nosso trabalho e nos auxiliara no projeto integrador.";
	}
}
