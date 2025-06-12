package payrollsystem;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseManager {
    DatabaseConnection connection;
    
    DatabaseManager(){
        connection = new DatabaseConnection();
    }
    
    public int writeToDatabase(String query){
        int rowsAffectedByQuery = 0;
            
        try{
            Connection queryConnection = connection.getDBConnection();
            Statement statement = queryConnection.createStatement();
            rowsAffectedByQuery = statement.executeUpdate(query);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        return rowsAffectedByQuery;
    }
}
