package com.distribuida.rh.service;

import com.distribuida.rh.db.Persona;

import java.util.List;

public interface PersonaService {
    public Persona getPersona(Integer id);
    public Persona getPersonaByName(String name);
    //Tarea 2 - CRUD de Persona
    public List<Persona> getPersonas();
    public void addPersona(Persona persona);
    public void updatePersona(Persona persona);
    public void deletePersona(Integer id);

}
