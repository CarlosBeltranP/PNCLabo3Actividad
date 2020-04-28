package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Student;

@Controller
public class MainController {
	
	private List<Student> students = new ArrayList< Student>();	

	//************** Uso de @ResponseBody ************************
	
	@GetMapping (path = "/ejemplo1", produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String ejemplo1() {
		return "Bienvenidos\n" + "Programación N-Capas";
	}
	
	@GetMapping("/ejemplo2") //@ResponseBody puede devolver un Jason
	public @ResponseBody List<Student> ejemplo2(){
		return Arrays.asList( //lista de estudiantes 
				new Student("Nombre1", "Apellido", "10/10/1992", "Carrera X ", true),
				new Student("Nombre1", "Apellido", "10/10/1992", "Ingeniería en Limones", false)
				);			
	}
	
	//************** Uso de ModelAndView ************************
	
	@GetMapping("/inicio") //mi inicio
	public String inicio(Student student) {
		return "index";
	}
	
	@PostMapping("/formData") //devuelve un ModelAndView
	public ModelAndView procesar(Student student) {
		students.add(student);	
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("index");
		mav.addObject("student", new Student());
		return mav;	
	}
	
	@GetMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("listado");
		mav.addObject("studentList", this.students);
		return mav;
		
	}
}
