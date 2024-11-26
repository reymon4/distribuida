package com.distribuida.rh.service;

import com.distribuida.rh.db.Persona;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    @Override
    public Persona getPersonaByName(String name) {
        TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p WHERE p.nombre=:name", Persona.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public List<Persona> getPersonas() {
        TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p order by p.nombre asc", Persona.class);
        return query.getResultList();
    }

    @Override
    public void addPersona(Persona persona) {
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
    }

    @Override
    public void updatePersona(Persona persona) {
        em.getTransaction().begin();
        em.merge(persona);
        em.getTransaction().commit();
    }

    @Override
    public void deletePersona(Integer id) {
            em.remove(em.find(Persona.class, id));
    }
}
