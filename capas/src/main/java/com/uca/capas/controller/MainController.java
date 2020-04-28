package com.uca.capas.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uca.capas.domain.Student;

@Controller
public class MainController {
	
	@GetMapping (path = "/ejemplo1", produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String ejemplo1() {
		return "Bienvenidos\n" + "Programación N-Capas";
	}
	
	@GetMapping("/ejemplo2") //@ResponseBody puede devolver Jason
	public @ResponseBody List<Student> ejemplo2(){
		return Arrays.asList( //lista de estudiantes 
				new Student("Nombre1", "Apellido", "10/10/1992", "Carrera X ", true),
				new Student("Nombre1", "Apellido", "10/10/1992", "Ingeniería en Limones", false)
				);
				
		
	}
}
