/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ramenrecipes.bean;

import com.mycompany.ramenrecipes.entities.Credentials;
import java.util.Base64;
import javax.ejb.Stateless;


/**
 *
 * @author Glissted
 * Skapar användarnamn och lösenord
 */
@Stateless
public class CredentialsBean {
    public Credentials createCredentials(String basicAuth){
        //Basic Z2FicmllbDpnYWJyaWVs
        basicAuth = basicAuth.substring(6).trim();//Z2FicmllbDpnYWJyaWVs
        byte[] bytes = Base64.getDecoder().decode(basicAuth);//g a b r i e l : g a b r i e l
        basicAuth = new String(bytes);//gabriel:gabriel
        int colonPos = basicAuth.indexOf(":");//7
        String username = basicAuth.substring(0, colonPos);//gabriel
        String password = basicAuth.substring(colonPos + 1);//andra gabriel
        return new Credentials(username, password);
    }
        
    
    public boolean checkCredentials(Credentials credentials){
          if(credentials.getUsername().equals("Nisse")&&
             credentials.getPassword().equals("Manpower")){
            
            return true;
        }
         return false;
    }           
}
