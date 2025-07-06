package payrollsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paul
 */
public class DatabaseConnection {
    
    // Database URL, username, and password
    private static final String DB_URL = "jdbc:mysql://localhost:3306/payroll_system_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Johnpaul090950";
    Connection connection = null;
    
    public DatabaseConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); 
        }
    }
 
    public Connection getDBConnection(){
        return this.connection; 
    }
}
