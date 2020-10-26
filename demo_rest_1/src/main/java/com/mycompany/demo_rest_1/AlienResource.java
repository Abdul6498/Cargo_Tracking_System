/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demo_rest_1;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;


/**
 *
 * @author Abdul
 */
@Path("database")
public class AlienResource {
    
 
    AlienRepository repo = new AlienRepository();
    Alien db_in = new Alien();
       public int id;
       public String name;
       public String date;
       public String pred_date;
       public String message;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Alien> addMessage() 
    { 
        return repo.getAliens();     
    }
    
    @GET
    @Path("admin/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Alien getAlien(@PathParam("id")int id)
    {
        return repo.getAlien(id);
    }
    
    @GET
    @Path("customer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCustomer(@PathParam("id")int id)
    {
        //date = repo.getCustomer(id);
        message = "Your Shipment will be delivered on :" + repo.getCustomer(id);
        return message;
    //return repo.getAlien(id);
    }
    
    @POST
    @Path("alien_post")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Alien makeAlien(Alien a1)
    {
        repo.make(a1);
        return a1;
    }
    
    @PUT
    @Path("alien_update")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Alien updateAlien(Alien a1)
    {
        if(repo.getAlien(a1.getId()).getId() == 0)
        {
            //message = "{\"message\":\"" + "Data not found" + "\"}";
            repo.make(a1);
        }
        else
        {
        repo.update(a1);
        }
        return a1;
    }
    
    @DELETE
    @Path("alien_delete/{id}")
    public Alien killAlien(@PathParam("id")int id)
    {
    	Alien a = repo.getAlien(id);
        if(a.getId()!=0)
        {
        repo.delete(id);
        }
        else
        {
        //Add Error message
        }
        return a;
    }
    
}
