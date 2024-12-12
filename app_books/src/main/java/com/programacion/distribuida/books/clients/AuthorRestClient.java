package com.programacion.distribuida.books.clients;

import com.programacion.distribuida.books.dto.AuthorDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
//ANOTACION PARA QUE SEA EL PROXY AUTOMÁTICO
@RegisterRestClient(configKey ="authors-api")
public interface AuthorRestClient {

    @GET
    @Path("/{id}")
    AuthorDTO findById(@PathParam("id") Integer id);

}
