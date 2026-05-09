package com.trips.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trips.models.Trip;
import com.trips.services.ITripServices;
import com.trips.services.tripServicesImpl;

//PS C:\Users\bryan\OneDrive\Escritorio\VisualStudio\TripsAN> ./mvnw spring-boot:run                                          
@Controller
@RequestMapping("/trips")
public class TripController {

    	@Autowired
	private ITripServices tripServices;
	
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
    
    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idTrip, Model model) {
        Trip trip = tripServices.buscarPorId(idTrip);
        System.out.println("IdTrip es: " + idTrip);
        model.addAttribute("trip" , trip);

        return "trips/detalle";
    }
}