/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends Credentials {
    private final int employeeID;
    private final String password;
    
    AccountDetails accountDetails = new AccountDetails();
    
    DatabaseConnection connection = new DatabaseConnection();
    Connection conn = connection.getDBConnection();
    
    
    Login(int id, String password){
        this.employeeID = id;
        this.password = password;
    }
    
    @Override
    ArrayList<ArrayList<String>> checkCredentials() {
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT e.employee_id, CONCAT(e.last_name, ', ', e.first_name) AS full_name, c.role AS role " +
                    "FROM employees e " +
                    "JOIN credentials c ON e.employee_id = c.employee_id " +
                    "WHERE c.employee_id = ? AND c.employee_password = ?";
            PreparedStatement statement = statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);
            statement.setString(2, this.password);
            data = accountDetails.retrivedDetails(statement);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
}
