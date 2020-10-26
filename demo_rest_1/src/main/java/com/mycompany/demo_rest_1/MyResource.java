package com.mycompany.demo_rest_1;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Application;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print("Hello World\n");
        
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        
        String resource1 = "Hello for resource";
        return resource1;
    }
   // @GET
   // @Produces(MediaType.TEXT_XML)
   // public String helloxml() {
   //     String resource2 = "<? xml version='1.0' ?>" + "<hello> Hello XML </hello>";
   //     return resource2;
   // }
   // @GET
   // @Produces(MediaType.APPLICATION_JSON)
   // public String hellojson() {
   //     String resource3 = "Hello_JSON";
   //     return resource3;
   // }
   // @GET
   // @Produces(MediaType.TEXT_HTML)
   // public String hellohtml() {
   //     String resource = "<h1>Hello World!</h1>";
   //     return resource;
   // }
}
