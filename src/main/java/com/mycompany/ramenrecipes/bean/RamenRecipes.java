/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ramenrecipes.bean;

import com.mycompany.ramenrecipes.ConnectionFactory;
import com.mycompany.ramenrecipes.entities.Recipe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Glissted hämtar data från databasen hämtar alla recept
 */
@Stateless
public class RamenRecipes {

    public List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM recipe";
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                int id = data.getInt("id");
                String recipe_name = data.getString("Name");
                String recipe_instruction = data.getString("Instruction");
                Recipe recipe = new Recipe(id, recipe_name, recipe_instruction);
                recipes.add(recipe);

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return recipes;
    }

    /**
     * lägger till nya recept
     */
    public static int postRecipe(Recipe recipe) {
        try (com.mysql.jdbc.Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = String.format("INSERT INTO recipe VALUES(NULL,'%s','%s')",
                    recipe.getName(), recipe.getInstruction());
            return stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return 0;
    }

    /**
     * hämtar specifika recept recept
     */
    public Recipe getRecipe(int id) {
        try (com.mysql.jdbc.Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM recipe WHERE id=" + id;
            ResultSet data = stmt.executeQuery(sql);
            if (data.next()) {
                String recipe_name = data.getString("Name");
                String recipe_instruction = data.getString("Instruction");

                return new Recipe(id, recipe_name, recipe_instruction);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
