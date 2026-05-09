package com.trips.controllers;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import com.trips.TripsAnApplication;
import com.trips.services.IRolService;
import com.trips.services.ITripServices;
import com.trips.services.rolServiceImpl;
import com.trips.services.tripServicesImpl;
import com.trips.models.Rol;
import com.trips.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

	/*
	//Cambios 
	///private List<Trip> getTrips() {
	/// }
	*/

@Controller
public class HomeController {

	private final TripsAnApplication TripsAnApplication;

	@Autowired
	private ITripServices tripServices;

	@Autowired
	private IRolService rolService;

	HomeController(TripsAnApplication TripsAnApplication) {
		this.TripsAnApplication = TripsAnApplication;
	}

	@GetMapping("/")
	public String mostrarhome(Model model) {
		List<Trip> lista = tripServices.buscarTodo();
		model.addAttribute("trips", lista);
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
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Trip> lista = tripServices.buscarTodo();
		model.addAttribute("trips", lista);
		return "tabla";
	}

	@GetMapping("/tablaRoles")
	public String mostrarTablaRol(Model model) {
		List<Rol> lista = rolService.buscarTodo();
		model.addAttribute("roles", lista);
		return "tablaRoles";
	}
}