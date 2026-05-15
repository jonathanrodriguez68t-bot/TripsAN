package com.trips.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trips.models.Trip;
import com.trips.services.ITripServices;
import com.trips.services.tripServicesImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//PS C:\Users\bryan\OneDrive\Escritorio\VisualStudio\TripsAN> ./mvnw spring-boot:run                                          
@Controller
@RequestMapping("/trips")
public class TripController {

	@Autowired
	private ITripServices tripServices;

	@GetMapping("/create")
	public String crear() {

		return "trips/formTrip";
	}

	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idTrip, Model model) {
		System.out.println("idTrip es " + idTrip);
		model.addAttribute("id", idTrip);
		return "mensaje";
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
	 * Metodo save sin DataBinding
	 * 
	 * @PostMapping("/save")
	 * public String guardar (@RequestParam("nombre") String nombre,
	 * 
	 * @RequestParam("descripcion") String descripcion,
	 * 
	 * @RequestParam("estatus") String status,
	 * 
	 * @RequestParam("fecha") String fecha,
	 * 
	 * @RequestParam("destacado") int destacado,
	 * 
	 * @RequestParam("costo") double costo,
	 * 
	 * @RequestParam("detalles") String detalles){
	 * 
	 * System.out.println("Nombre: " + nombre);
	 * System.out.println("Descripcion: " + descripcion);
	 * System.out.println("fecha: " + fecha);
	 * System.out.println("Costo: " + costo);
	 * System.out.println("Detalles: " + detalles);
	 * 
	 * 
	 * return "trips/listTrips";
	 * }
	 */
	
	@PostMapping("/save")
	public String guardar(Trip trip, BindingResult result) {

		if(result.hasErrors()){
			for(ObjectError error: result.getAllErrors()){
				System.out.println(error.getDefaultMessage());
			}
			return "trips/formTrip";
		}

		tripServices.guardar(trip);
		System.out.println("Trip: " + trip);
		return "trips/listTrips";
	}

	@InitBinder
	public void InitBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idTrip, Model model) {
		Trip trip = tripServices.buscarPorId(idTrip);
		System.out.println("IdTrip es: " + idTrip);
		model.addAttribute("trip", trip);

		return "trips/detalle";
	}
}