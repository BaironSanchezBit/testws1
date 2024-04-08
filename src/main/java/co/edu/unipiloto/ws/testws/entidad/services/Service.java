/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.ws.testws.entidad.services;

import co.edu.unipiloto.ws.testws.entidad.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author bairon
 */
@Path("service")
public class Service {

    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

    static {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            int id = i + 1;
            person.setId(id);
            person.setFullName("My wonderful Person " + id);
            person.setAge(new Random().nextInt(40) + 1);
            persons.put(id, person);
        }
    }

    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id") int id) {
        return persons.get(id);
    }

    @GET
    @Path("/getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJson(@PathParam("id") int id) {
        return persons.get(id);
    }

    @GET
    @Path("/getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML() {
        return new ArrayList<Person>(persons.values());
    }

    @GET
    @Path("/getAllPersonsInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonsInJson() {
        return new ArrayList<Person>(persons.values());
    }

    @POST
    @Path("/addPersonInJson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPersonInJson(Person person) {
        System.out.println(person.getId());
        persons.put(new Integer(person.getId()), person);
        return person;
    }

    @GET
    @Path("/getAverageSalary")
    @Produces(MediaType.APPLICATION_XML)
    public String getAverageSalary() {
        double sum = 0;
        for (Person person : persons.values()) {
            sum += person.getSalary();
        }
        double average = persons.isEmpty() ? 0 : sum / persons.size();
        return "<averageSalary>" + average + "</averageSalary>";
    }

    @GET
    @Path("/getTotalSalary")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTotalSalary() {
        double sum = 0;
        for (Person person : persons.values()) {
            sum += person.getSalary();
        }
        return "{\"totalSalary\":" + sum + "}";
    }

    @POST
    @Path("/addPerson")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person addPerson(Person person) {
        int newId = persons.size() + 1;
        person.setId(newId);
        persons.put(newId, person);
        return person;
    }
}
