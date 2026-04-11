package com.trip.controllers;



import java.util.List;
import java.util.Date;
import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	
	
	
	
	
	@GetMapping("/")
	public String mostrarhome(Model model) {
		
		String trip = "Rapel en el Volcan";
		Date fechaPublicacion = new Date();
		double costo = 5.0;
		boolean vigente= true;
		
		model.addAttribute("trip", trip);
		model.addAttribute("fechaPublicacion", fechaPublicacion);
		model.addAttribute("costo", costo);
		model.addAttribute("vigente",vigente);
		
		return "home";

	}
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		
		List<String> lista= new LinkedList<String>();
		lista.add("En la montana ");
		lista.add("En la ciudad");
		lista.add("En los pueblos");
		lista.add("En las playas");
		
		model.addAttribute("listadoTrips", lista);
		
		return "listado";
	}

}
