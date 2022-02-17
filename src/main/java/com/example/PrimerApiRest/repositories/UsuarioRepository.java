package com.example.PrimerApiRest.repositories;

import com.example.PrimerApiRest.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long> //el tipo de dato long es porque así se definió en el model

{
    //al ser abstractos podemos realizar la consultas sin programarlas
    public abstract ArrayList<UsuarioModel>findByPrioridad(Integer prioridad);
    public abstract ArrayList<UsuarioModel>findByEmail(String email);
    public abstract ArrayList<UsuarioModel>findByNombre(String nombre);
    //public List<UsuarioModel>findByNameCount(String name);
//    long countByName(String name);
}
