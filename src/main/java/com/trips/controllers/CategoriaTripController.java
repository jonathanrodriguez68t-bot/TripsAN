package com.trips.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trips.models.Categoria;

@Controller
@RequestMapping(value="/categorias")
public class CategoriaTripController {

    
    @GetMapping("/index")
    public String mostrarIndex() {
        
        return "categoriasTrip/listCategoria";
    }

    @GetMapping("/create")
    public String crear(Categoria categoria) { 
        return "categoriasTrip/formCategoria"; 
    }

    @PostMapping("/save")
    public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion) {
        System.out.println("Nombre Categoria: " + nombre);
        System.out.println("Descripcion: " + descripcion);
        return "categoriasTrip/listCategoria";
    }
}