package com.trips.services;

import java.util.List;
import com.trips.models.Rol;

public interface IRolService {
    List<Rol> buscarTodos();
    Rol buscarPorId(Integer idRol);
}