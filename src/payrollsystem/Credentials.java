/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Paul
 */
abstract class Credentials extends DatabaseManager {
    private String userPassword;
    private int userID;
    

    DatabaseConnection connection = new DatabaseConnection();
    DatabaseManager databaseManager = new DatabaseManager();
    Credentials(int id, String password){
        this.userID = id;
        this.userPassword = password;
    }
    
    ArrayList<ArrayList<String>> getDataFromDatabase(String sql){
         ArrayList<ArrayList<String>> tableData = new ArrayList<>();
          try( Connection queryConnection = connection.getDBConnection();
               PreparedStatement statement = queryConnection.prepareStatement(sql)){     
              statement.setInt(1, userID);
              statement.setString(2, userPassword);
              return databaseManager.getData(statement);
            } catch(SQLException e){
                System.out.println(e);
            }
          return tableData;
    }
}
