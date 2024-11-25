package com.distribuida.rh.service;

import com.distribuida.rh.db.Persona;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import lombok.Builder;

import java.util.List;

@ApplicationScoped
public class PersonaServiceImpl implements PersonaService {
    @Inject
    EntityManager em;


    @Override
    public Persona getPersona(Integer id) {
        return em.find(Persona.class, id);
    }
}
