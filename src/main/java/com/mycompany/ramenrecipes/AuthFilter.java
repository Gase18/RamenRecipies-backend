/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ramenrecipes;

import com.mycompany.ramenrecipes.bean.CredentialsBean;
import com.mycompany.ramenrecipes.entities.Credentials;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;


/**
 *
 * @author Gabriel
 */
@Provider
public class AuthFilter implements ContainerRequestFilter{

    @EJB
    CredentialsBean credentialsBean;
    
        
    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        //Om get pass
        if(request.getMethod().equals("GET")){
            return;
        }
        try {
        String basicAuth = request.getHeaderString("Authorization");
        System.out.println(basicAuth);
        Credentials credentials = credentialsBean.createCredentials(basicAuth);
            if(credentialsBean.checkCredentials(credentials)){
                return;
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
      
        Response unAuth = Response.status(Response.Status.UNAUTHORIZED)
        .entity("Tips Nisse Manpower").build();
        request.abortWith(unAuth);
    }
    
}
