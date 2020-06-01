/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ramenrecipes.bean;

import com.mycompany.ramenrecipes.ConnectionFactory;
import com.mycompany.ramenrecipes.entities.Mesurements;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Glissted
 */
public class MesurementsBean {

    public List<Mesurements> getName() {
        List<Mesurements> mesurements = new ArrayList<>();
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM mesurements";
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                String name = data.getString("name");
                Mesurements mesurement = new Mesurements(name);
                mesurements.add(mesurement);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return mesurements;
    }
}
