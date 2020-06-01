/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ramenrecipes;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        String url = "jdbc:mysql://localhost/ramenrecipes";
        Class.forName("com.mysql.jdbc.Driver");
        return (Connection)DriverManager.getConnection(url);
    }
}



