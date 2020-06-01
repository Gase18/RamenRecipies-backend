/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ramenrecipes.entities;

/**
 *
 * @author Glissted
 */
public class Recipe {

    private int id;
    private String name;
    private String instruction;

    public Recipe(int id, String name, String instruction) {
        this.id = id;
        this.name = name;
        this.instruction = instruction;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
