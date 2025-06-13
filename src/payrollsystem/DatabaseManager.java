package payrollsystem;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

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
    
    public int writeToDatabase(String query, String condition){
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
    
    public int writeLeaveApplicationToDatabase(ArrayList<String> data){
        int rowsAffectedByQuery = 0;
        String query;
            
        try{
            Connection queryConnection = connection.getDBConnection();
            PreparedStatement statement = queryConnection.prepareStatement(
              "INSERT INTO payroll_system_db.leave_ledger (employee_id, date_filed, leave_type_id, leave_from, leave_to, number_of_days, reason, request_status_id) VALUES(?,?,?,?,?,?,?,?);"      
            );
            
            statement.setInt(1, Integer.parseInt(data.get(0))); //employee_id
            statement.setDate(2, parseDateFromString(data.get(2))); //date_filed
            statement.setDate(4, parseDateFromString(data.get(4))); //leave_from
            statement.setDate(5, parseDateFromString(data.get(5))); //leave_end
            statement.setFloat(6, Float.parseFloat(data.get(6))); //number_of_days
            statement.setNString(7, data.get(7)); //reason
            statement.setInt(8, 1); //request_status_id
            
            switch(data.get(3)){ //leave_type_id
                case "Vacation Leave":
                    statement.setInt(3, 1);
                    break;
                case "Sick Leave":
                    statement.setInt(3, 2);
                    break;
                default:
                    statement.setInt(3, 0);
            }
            
            System.out.println(statement);
            
            rowsAffectedByQuery = statement.executeUpdate();
            System.out.println("Rows Affected: " + rowsAffectedByQuery);
            
            statement.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        return rowsAffectedByQuery;
    }
    
    public ResultSet readFromDatabase(String table){ //method to read everything from a table
        ResultSet result;
        String query = "SELECT * FROM payroll_system_db." + table + ";";
        try{
            Connection queryConnection = connection.getDBConnection();
            PreparedStatement statement = queryConnection.prepareStatement(query);
            System.out.println(statement);
            result = statement.executeQuery();
            
            //statement.close();
            
            System.out.println(result);
            return result;
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        return null;
    }
    
    public ResultSet readFromDatabase(String table, String condition, String value){ //method to read from a table with specified WHERE condition
        ResultSet result;
        String query = "SELECT * FROM payroll_system_db." + table + " WHERE ? = ?;";
        
        try{
            Connection queryConnection = connection.getDBConnection();
            PreparedStatement statement = queryConnection.prepareStatement(query);
            statement.setNString(1, condition);
            statement.setNString(2, value);
            result = statement.executeQuery();
            
            statement.close();
            
            return result;
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        return null;
    }
    
    public ResultSet readFromDatabase(String columnName, String table, String condition, String value){ //method to read specific column from a table with specified WHERE condition
        ResultSet result;
        String query = "SELECT " + columnName + " FROM payroll_system_db." + table + " WHERE ? = ?;";
        
        try{
            Connection queryConnection = connection.getDBConnection();
            PreparedStatement statement = queryConnection.prepareStatement(query);
            statement.setNString(1, condition);
            statement.setNString(2, value);
            result = statement.executeQuery();
            
            statement.close();
            
            return result;
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        return null;
    }
    
    public ResultSet queryFromDatabase(String query){
        ResultSet result;
        
        try{
            Connection queryConnection = connection.getDBConnection();
            Statement statement = queryConnection.createStatement();
            result = statement.executeQuery(query);
            
            statement.close();
            
            return result;
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        return null;
    }
    
    public String readEmployeePosition(String employeeID){
        ResultSet result;
        String positionResult = null;
        
        try{
            Connection queryConnection = connection.getDBConnection();
            PreparedStatement statement = queryConnection.prepareStatement(
                "SELECT credentials.role FROM credentials WHERE employee_id = ?;"
            );
            statement.setInt(1, Integer.parseInt(employeeID));
            result = statement.executeQuery();
            while (result.next()) positionResult = result.getString(1);
            
            statement.close();
            
            return positionResult;
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        return null;
    }
    
    public String readEmployeeStatus(String employeeID){
        ResultSet result;
        String statusResult = null;
        
        try{
            Connection queryConnection = connection.getDBConnection();
            PreparedStatement statement = queryConnection.prepareStatement(
                "SELECT employee_statuses.status_name FROM employees RIGHT JOIN employee_statuses ON employees.status_id = employee_statuses.status_id WHERE employee_id = ?;"
            );
            statement.setInt(1, Integer.parseInt(employeeID));
            result = statement.executeQuery();
            while (result.next()) statusResult = result.getString(1);
            
            statement.close();
            
            return statusResult;
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        return null;
    }
    
    public String[] readEmployeeAddress(String employeeID){
        ResultSet result;
        String[] addressResult = new String[6];
        int columnCount;
        String[] columnNames;
        
        try{
            Connection queryConnection = connection.getDBConnection();
            PreparedStatement statement = queryConnection.prepareStatement(
                "SELECT employee_address.street, employee_address.barangay, employee_address.municipality, employee_address.city, employee_address.province, employee_address.zipcode FROM employees RIGHT JOIN employee_address ON employees.employee_address_id = employee_address.employee_address_id WHERE employee_id = ?;"
            );
            statement.setInt(1, Integer.parseInt(employeeID));
            result = statement.executeQuery();
            columnCount = result.getMetaData().getColumnCount();
            columnNames = new String[columnCount];
            
            for (int i = 0; i < columnCount; i++){
                columnNames[i] = result.getMetaData().getColumnName(i + 1);
            }
            
            while(result.next()){
                for(int i = 1; i <= columnCount; i++){ //for loop to concatenate address columns into one array
                    String temp = result.getObject(columnNames[i-1]).toString();
                    if (temp != null && !temp.isBlank()){ //check if column is empty
                        if (i == 6) //if statement for adding a comma and a space to the end of the string; the last column does not need either
                            addressResult[i - 1] = result.getString(columnNames[i - 1]); 
                        else 
                            addressResult[i - 1] = result.getString(columnNames[i - 1]) + ", ";
                    }
                    else addressResult[i - 1] = "";
                }
            }
            
            statement.close();
            result.close();
            
            return addressResult;
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        return null;
    }
    
    public Double[] readCompensationDetails(String employeeID){
        ResultSet result;
        Double[] compensationResult = new Double[5];
        String[] columnNames;
        int columnCount;
        
        try{
            Connection queryConnection = connection.getDBConnection();
            PreparedStatement statement = queryConnection.prepareStatement(
                "SELECT compensation_details.basic_salary, compensation_details.rice_subsidy, compensation_details.phone_allowance, compensation_details.clothing_allowance, compensation_details.hourly_rate FROM employees RIGHT JOIN compensation_details ON employees.employee_id = compensation_details.employee_id WHERE compensation_details.employee_id = ?"
            );
            statement.setInt(1, Integer.parseInt(employeeID));
            result = statement.executeQuery();
            columnCount = result.getMetaData().getColumnCount();
            columnNames = new String[columnCount];
            
            for (int i = 0; i < columnCount; i++){
                columnNames[i] = result.getMetaData().getColumnName(i + 1);
            }
            
            while (result.next()){
                compensationResult[0] = result.getDouble(columnNames[0]);
                compensationResult[1] = result.getDouble(columnNames[1]);
                compensationResult[2] = result.getDouble(columnNames[2]);
                compensationResult[3] = result.getDouble(columnNames[3]);
                compensationResult[4] = result.getDouble(columnNames[4]);
            }
            result.close();
            statement.close();
            
            return compensationResult;
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        return null;
    }
    
    public String[] readGovernmentDetails(String employeeID){
        ResultSet result;
        String[] governmentResult = new String[4];
        String[] columnNames;
        int columnCount;
        
        try{
            Connection queryConnection = connection.getDBConnection();
            PreparedStatement statement = queryConnection.prepareStatement(
                "SELECT government_ids.sss_number, government_ids.philhealth_number, government_ids.tin_number, government_ids.pagibig_number FROM employees RIGHT JOIN government_ids ON employees.employee_id = government_ids.employee_id WHERE government_ids.employee_id = ?"
            );
            statement.setInt(1, Integer.parseInt(employeeID));
            result = statement.executeQuery();
            columnCount = result.getMetaData().getColumnCount();
            columnNames = new String[columnCount];
            
            for (int i = 0; i < columnCount; i++){
                columnNames[i] = result.getMetaData().getColumnName(i + 1);
            }
            
            while (result.next()){
                governmentResult[0] = result.getString(columnNames[0]);
                governmentResult[1] = result.getString(columnNames[1]);
                governmentResult[2] = result.getString(columnNames[2]);
                governmentResult[3] = result.getString(columnNames[3]);
            }
            result.close();
            statement.close();
            
            return governmentResult;
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        return null;
    }
    
    public java.sql.Date parseDateFromString(String date){ //method to convert String to sql.Date
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        
        try{
            java.util.Date utilDate = format.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            return sqlDate;
        }
        catch(ParseException e){
            System.out.println(e);
        }
        
        return null;
    }
    
    public java.sql.Date parseDateFromString(String date, String dateFormat){
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        
        try{
            java.util.Date utilDate = format.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            return sqlDate;
        }
        catch(ParseException e){
            System.out.println(e);
        }
        
        return null;
    }
}
