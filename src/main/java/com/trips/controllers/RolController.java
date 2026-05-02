package com.trips.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trips.services.IRolService;

@Controller
@RequestMapping("/tablaroles") 
public class RolController {

    @Autowired
    private IRolService serviceRoles; 

    @GetMapping("/index") 
    public String mostrarTabla(Model model) {
        
     
        model.addAttribute("listaRoles", serviceRoles.buscarTodos());
        
      
        return "tablaroles"; 
    }
}