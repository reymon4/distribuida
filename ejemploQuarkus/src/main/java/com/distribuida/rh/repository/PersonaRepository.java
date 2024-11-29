package com.distribuida.rh.repository;

import com.distribuida.rh.db.Persona;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
@Transactional
public class PersonaRepository implements PanacheRepositoryBase<Persona, Integer> {

public Optional<Persona> updatePersona(Integer id, Persona persona) {
    var obj = this.findByIdOptional(id);
    if (obj.isEmpty()) {
        return Optional.empty();
    }
    obj.get().setDireccion(persona.getDireccion());
    obj.get().setNombre(persona.getNombre());
    return Optional.of(obj.get());
    }
}
