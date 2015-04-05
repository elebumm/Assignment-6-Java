/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author lewismenelaws
 */
@Path("/products")
public class ProductsREST {
    
    
    @GET
    @Produces("application/json")
    public JsonArray getAll() {
        Response.ok(productList.toJson()).build();
}
    
    @GET
    @Path("{id}")
    @Produces("application/json")
    public JsonArray getById(@PathParam("id") int id) {
        return null;
    }
    
    @POST
    @Consumes("application/json")
    public void add(JsonObject json) {
        
    }
    
    @PUT
    @Path("{id}")
    @Produces("application/json")
    public void edit (@PathParam("id") int id) {
        
    }
    
    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public void delete(@PathParam("id") int id) {
        
    }
}
