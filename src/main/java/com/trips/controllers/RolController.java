package com.trips.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/roles")
public class RolController {
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idRol, Model model) {
	    System.out.println("idRol es " + idRol);
	    model.addAttribute("id", idRol);
	    return "mensaje";
	}

    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") int idRol, Model model) {
        System.out.println("idRol es: " + idRol);
        model.addAttribute("idRol" , idRol);

        return "rol/detalle";
    }
}
