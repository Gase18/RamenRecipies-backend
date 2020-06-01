/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ramenrecipes.resources;

import com.mycompany.ramenrecipes.bean.RamenRecipes;
import com.mycompany.ramenrecipes.bean.ingredientsBean;
import com.mycompany.ramenrecipes.entities.Ingredients;
import com.mycompany.ramenrecipes.entities.Recipe;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Glissted
 */
@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class RecipeResource {

    @EJB
    RamenRecipes ramenRecipes;
    
    @EJB
    ingredientsBean ingredientsBean;

    @GET
    @Path("recipes/{id}")
    public Response getRecipes() {
        List<Recipe> recipes = ramenRecipes.getRecipes();
        return Response.ok(recipes).build();
    }

    @GET
    @Path("recipe/{id}")
    public Response getRecipe(@PathParam("id") int id) {
        Recipe recipe = ramenRecipes.getRecipe(id);
        if (recipe != null) {
            return Response.ok(recipe).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    
    
    @GET
    @Path("recipe_has_ingredients/{id}")
    public Response getIngredient(@PathParam("id") int id) {
        List<Ingredients> ingredients = ingredientsBean.getIngredients(id);
        if (ingredients != null) {
            return Response.ok(ingredients).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
