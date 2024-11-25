package com.distribuida.rh;

import com.distribuida.rh.db.Persona;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class MainJPA {

    public static void main(String[] args) {

        //CREAMOS EL ENTITY MANAGER FACTORY DE LA PERSISTENCIA CON SU UNIDAD (UNITY)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("distribuida");

        EntityManager em = emf.createEntityManager();


        TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p order by p.nombre asc", Persona.class);
        query.getResultList().forEach(System.out::println);

//INICIAMOS LA TRANSACCIÓN EN LA DB
        /*em.getTransaction().begin();
        //CREAMOS UNA PERSONA
        Persona p = new Persona();
        p.setNombre("Yo");
        p.setDireccion("Calle 3");
        em.persist(p);
        em.getTransaction().commit();

        query.getResultList().forEach(System.out::println);*/

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println("Personas en JSON");
        query.getResultStream().map(gson::toJson).forEach(System.out::println);
        //CERRAMOS LA CONEXIÓN
        em.close();
        emf.close();
    }
}
