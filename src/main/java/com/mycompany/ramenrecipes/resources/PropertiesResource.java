/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ramenrecipes.resources;

import com.mycompany.ramenrecipes.bean.PropertiesBean;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author gliss
 */

@Path("properties")
public class PropertiesResource {
    @EJB
    PropertiesBean propertiesBean;
    
    @GET
    @Path("{key}")
    public Response getKey(@PathParam("key") String key){
        return Response
                .ok(propertiesBean.getProp(key))
                .build();
    }
}
