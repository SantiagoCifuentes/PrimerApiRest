package com.example.PrimerApiRest.services;

import com.example.PrimerApiRest.models.UsuarioModel;
import com.example.PrimerApiRest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService
{
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel>obtenerUsuarios()
    {
        return(ArrayList<UsuarioModel>) usuarioRepository.findAll();//obtiene todos los registros
    }

    public  UsuarioModel guardarUsuario(UsuarioModel usuario)
    {
        return usuarioRepository.save(usuario);//registro de usuarios
    }

    public Optional<UsuarioModel>obtenerPorId(Long id)// se pone optional por si al momento de hacer la consulta no existe el id
            //consultas,
    {
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel>obtenerPorPrioridad(Integer prioridad)// se implementa el método abstracto creado en repository "findById"
    //método para realizar querys
    {
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public ArrayList<UsuarioModel>obtenerPorEmail(String email)//consulta por email
    {
        return usuarioRepository.findByEmail(email);
    }

    public ArrayList<UsuarioModel>obtenerPorNombre(String nombre)
    {
        return usuarioRepository.findByNombre(nombre);
    }

    public boolean eliminarUsuario(Long id)
    {
        try {
            usuarioRepository.deleteById(id);
            return true;
        }catch (Exception exception)
        {
            return false;
        }
    }
}
