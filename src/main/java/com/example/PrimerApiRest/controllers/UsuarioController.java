package com.example.PrimerApiRest.controllers;

import com.example.PrimerApiRest.models.UsuarioModel;
import com.example.PrimerApiRest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/usuario")
public class UsuarioController
{
    @Autowired
    UsuarioService usuarioService;

    @GetMapping() //recibe la petición, obteniendo el usuario
    public ArrayList<UsuarioModel>obtenerUsuarios()
    {
        return  usuarioService.obtenerUsuarios();
    }

    @PostMapping()//una vez recibida la petición, lo devuelve
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario)
    {
        return  this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping (path = "/{id}") //localhost:8080/usuario/1, el 1 sería el primer id
    public Optional <UsuarioModel>obtenerUsuarioPorId(@PathVariable("id")Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping (path = "/query") //localhost:8080/usuario/query?prioridad=5   la estructura es : servidor/nombre puesto en el mappin/nombre puesto en el path seguido del signo de interrogación
    //seguido del nombre del atributo y su valor
    public ArrayList <UsuarioModel>obtenerUsuarioPorPrioridad(@RequestParam("prioridad")Integer prioridad)
    {
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id")Long id)
    {
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok)
        {
            return "Se eliminó el usuario con id : " + id;
        }
        else{return "No se pudo eliminar el usuario con id " + id;}
    }



}
