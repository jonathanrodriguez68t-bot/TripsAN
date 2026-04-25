package com.trips.controllers;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import com.trips.TripsAnApplication;
import com.trips.services.ITripServices;
import com.trips.services.tripServicesImpl;


import com.trips.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	private final TripsAnApplication TripsAnApplication;

	@Autowired
	private ITripServices tripServices;

	HomeController(TripsAnApplication TripsAnApplication) {
		this.TripsAnApplication = TripsAnApplication;
	}

	@GetMapping("/")
	public String mostrarhome(Model model) {

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
	public String mostrarListado(Model model) {

		List<String> lista = new LinkedList<String>();
		lista.add("En la montana ");
		lista.add("En la ciudad");
		lista.add("En los pueblos");
		lista.add("En las playas");

		model.addAttribute("listadoTrips", lista);

		return "listado";
	}

	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Trip trip = new Trip();
		trip.setNombre("Rapel en Volcatenango");
		trip.setDescripcion("Aventa rapel en un listado pero pequeño circuito conectado en las...");
		trip.setFecha(new Date());
		trip.setCosto(10.0);

		model.addAttribute("trip", trip);

		return "detalle";

	}
	/*
	//Cambios 
	///private List<Trip> getTrips() {
	/// }
	*/

	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Trip> lista = tripServices.buscarTodo();
		model.addAttribute("trips", lista);
		return "tabla";
	}

}