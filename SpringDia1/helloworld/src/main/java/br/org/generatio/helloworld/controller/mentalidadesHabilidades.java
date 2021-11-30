package br.org.generatio.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mentEHab")
public class mentalidadesHabilidades {

	@GetMapping
	public String mentEHab() {
		return "\n A mentalidade de persitência foi a mais usada para não desistir quando um assunto é dificil, se encaixando na habilidade de adaptabilidade, juntando conceitos diferentes para mesma aplicação.";
}
}