package com.trips.services;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.trips.models.Rol;

@Service
public class rolServiceImpl implements IRolService {

    List<Rol> lista = null;

    public rolServiceImpl(){

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Rol>();
		try {
            /*
            Trip trip1 = new Trip();
			trip1.setId(1);
			trip1.setNombre("Rapel en Volcatenango");
			trip1.setDescripcion("Hacer rapel en los circuitos de Volcatenango");
			trip1.setFecha(sdf.parse("10-05-2022"));
			trip1.setCosto(5.0);
			trip1.setDestacado(1);
            trip1.setImagen("trip01.png");

			lista.add(trip1);
            */

            //Rol contiene: id, nombre, descripcion, estado, fecha

            Rol rol1 = new Rol();
            rol1.setId(1);
            rol1.setNombre("Vendedor");
            rol1.setDescripcion("Rol de Vendedor, Prototipo 1");
            rol1.setEstado(1);
            rol1.setFecha(sdf.parse("02-05-2024"));

            Rol rol2 = new Rol();
            rol2.setId(1);
            rol2.setNombre("Visitante");
            rol2.setDescripcion("Rol de Visitante, Prototipo 1");
            rol2.setEstado(2);
            rol2.setFecha(sdf.parse("02-05-2024"));

            Rol rol3 = new Rol();
            rol3.setId(1);
            rol3.setNombre("Master");
            rol3.setDescripcion("Rol de Admin, Prototipo 1");
            rol3.setEstado(1);
            rol3.setFecha(sdf.parse("02-02-2024"));
            
            Rol rol4 = new Rol();
            rol4.setId(1);
            rol4.setNombre("Prueba");
            rol4.setDescripcion("Rol de Prueba, Prototipo 1");
            rol4.setEstado(2);
            rol4.setFecha(sdf.parse("02-05-2026"));

            lista.add(rol1);
            lista.add(rol2);
            lista.add(rol3);
            lista.add(rol4);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

    }

    @Override
    public List<Rol> buscarTodo() {
        return lista;
    }

    @Override
    public Rol buscarPorId(Integer idRol) {
        for (Rol rol : lista)
            if (rol.getId() == idRol) {
                return rol;
            }
        return null;
    }

}
