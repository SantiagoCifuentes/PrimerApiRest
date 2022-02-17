package com.example.PrimerApiRest.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Table(name = "usuario") // este tag sirve para ponerle el nombre a la tabla
// y que la tabla no quede por defecto con el nombre de la clase


// con @Entity se puede cambiar el nombre de  una tabla existente
@Entity
public class UsuarioModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrementable
    @Column(unique = true, nullable=false)
    private Long id;
    private String nombre;
    private String email;
    private Integer prioridad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
}
