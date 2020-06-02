/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ramenrecipes.bean;

import com.mycompany.ramenrecipes.ConnectionFactory;
import com.mycompany.ramenrecipes.entities.Ingredients;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Glissted
 * hämtar alla ingredienser från en databas
 */
@Stateless
 public class ingredientsBean {

    public List<Ingredients> getIngredients(int id) {
        List<Ingredients> ingredients = new ArrayList<>();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT amount, ingredients.name FROM recipe_has_ingredients, ingredients WHERE ingredients_id = ingredients.id AND recipe_id = " + id;
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                String name = data.getString("name");
                String amount = data.getString("amount");
                Ingredients ingredient = new Ingredients(name,amount);
                ingredients.add(ingredient);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return ingredients;
    }
}
