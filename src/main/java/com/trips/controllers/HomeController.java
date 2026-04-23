package com.trips.controllers;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class HomeController {

	@GetMapping("/")
	public String mostrarHome(Model model) {

		String trip = "Rapel en el Volcan";
		Date fechaPublicacion = new Date();
		double costo = 5.0;
		boolean vigente = true;

		model.addAttribute("trip", trip);
		model.addAttribute("fechaPublicacion", fechaPublicacion);
		model.addAttribute("costo", costo);
		model.addAttribute("vigente", vigente);

		return "home";
	}

	@GetMapping("/listado")
	public String MostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("En la montaña");
		lista.add("En la Ciudad");
		lista.add("En los pueblos");
		lista.add("En las playas");

		model.addAttribute("listadoTrips", lista);

		return "listado";
	}

}
