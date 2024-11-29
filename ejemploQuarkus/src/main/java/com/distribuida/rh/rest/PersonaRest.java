package com.distribuida.rh.rest;

import com.distribuida.rh.db.Persona;
import com.distribuida.rh.repository.PersonaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/personas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PersonaRest {

    @Inject
    PersonaRepository repository;


    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id) {

        //var obj = repository.getPersona(id);
        var obj = repository.findByIdOptional(id);
        return obj.isEmpty() ? Response.status(Response.Status.NOT_FOUND).build() : Response.ok(obj.get()).build();
    }

    @GET
    public List<Persona> findAll() {
    return repository.findAll().list();
    }

    @POST
    public Response create(Persona persona) {
      repository.persist(persona);
        return Response.ok(persona).build();

    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, Persona persona) {
        if(repository.findByIdOptional(id).isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }else{
            persona.setId(id);
            repository.updatePersona(id, persona);
            return Response.ok(persona).build();
        }

    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        repository.deleteById(id);

    }



}
