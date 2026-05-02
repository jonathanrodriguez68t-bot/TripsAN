package com.trips.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.trips.models.Rol;

@Service
public class RolServiceImpl implements IRolService {
	
  
	private List<Rol> lista = null;

	public RolServiceImpl() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
      
	    lista = new LinkedList<Rol>();
	    
	    try {
	        Rol r1 = new Rol();
	        r1.setId(1);
	        r1.setNombre("Admin");
	        r1.setDescripcion("Este rol tiene la capacidad de administrar la pagina web");
	        r1.setActivo(true);
	        r1.setFechaCreacion(sdf.parse("02-05-2026"));
	        
	        Rol r2 = new Rol();
	        r2.setId(2);
	        r2.setNombre("Vendedor");
	        r2.setDescripcion("Encargado de las ventas de la tienda y ordenar el inventario");
	        r2.setActivo(true);
	        r2.setFechaCreacion(sdf.parse("01-05-2026"));
	        
	        Rol r3 = new Rol();
	        r3.setId(3);
	        r3.setNombre("Visitante");
	        r3.setDescripcion("Cliente que debe registrarse para disfrutar de los beneficios");
	        r3.setActivo(false);
	        r3.setFechaCreacion(sdf.parse("03-05-2026"));

	        
	        lista.add(r1);
	        lista.add(r2);
	        lista.add(r3);

	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public List<Rol> buscarTodos() {
        
		return lista;
	}

	@Override
	public Rol buscarPorId(Integer idRol) {
        
		for(Rol r : lista) {
			if(r.getId().equals(idRol)) {
				return r;
			}
		}
		return null;
	}
}