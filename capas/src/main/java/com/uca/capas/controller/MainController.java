package com.uca.capas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@GetMapping ("/ejemplo1")
	@ResponseBody
	public String ejemplo1() {
		return "Bienvenidos\n" + "Programación N-Capas";
	}
}
