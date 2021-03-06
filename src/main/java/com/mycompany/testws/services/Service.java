
package com.mycompany.testws.services;

import com.mycompany.testws.dao.PersonDao;
import com.mycompany.testws.model.Person;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("service")
public class Service {
   
    private PersonDao personDao= new PersonDao();
    
    //Method which return a single person object in XML
    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id") int id){
            return personDao.getPersonById(id);
    }

    @GET
    @Path("/getPersonByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJSON(@PathParam("id") int id){
            return personDao.getPersonById(id);
    }
    
    @GET
    @Path("/getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML(){
            return personDao.getAllPersons();
    }
    @GET
    @Path("/getAllPersonsInJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonsInJSON(){
            return personDao.getAllPersons();
    }
}
