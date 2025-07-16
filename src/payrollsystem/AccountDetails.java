/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class AccountDetails extends DatabaseConnection{
    private ArrayList<ArrayList<String>> tableData = new ArrayList<>();         //Variable that hold all data to be display in the Table
    private int employeeID;                                                     //Variable that will hold employee id
    private String vlBalance, slBalance;                                        //Variable that hold VL and SL balance
    int tableSize;                                                              //Variable that holds table size for displaying data in table
    
    DatabaseConnection dbConnection = new DatabaseConnection();                 //Call the Database Connection Class 
    java.sql.Connection conn = dbConnection.getDBConnection();                  //Call specific method to create connection

    public AccountDetails(){}                                                   
  
    //Method to get data from Database
    public ArrayList<ArrayList<String>> getData(PreparedStatement statement) throws SQLException{
        ArrayList<ArrayList<String>> tableData = new ArrayList<>();
        ResultSet result = statement.executeQuery();
              ResultSetMetaData metaData = result.getMetaData();
              int columnCount = metaData.getColumnCount();
                
              // Add rows
              while (result.next()) {
                ArrayList<String> row = new ArrayList<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(result.getString(i));
                }
                tableData.add(row);
              }
            closeDBRequest(result, statement);  
            return tableData;
    }
   
    //Method that handle of retrieving data from Database
    public ArrayList<ArrayList<String>> retrivedDetails(PreparedStatement statement) throws SQLException{
         ArrayList<ArrayList<String>> data = new ArrayList<>();
          data = getData(statement);
          closeDBRequest(statement);
          return data;
    }
    
    //Method that handle for inserting data to Database
    public Boolean addDetailsToDatabase(PreparedStatement statement) throws SQLException{
        Boolean isSuccessfulyAdded = false;
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            isSuccessfulyAdded = true;
        }      
        closeDBRequest(statement);
        return isSuccessfulyAdded; 
    }
        
    //Method to display Data in the Table
    DefaultTableModel displayDataTable(JTable jTable){
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object [this.tableSize];
        for(int row=0; row<getTableData().size(); row++){
            for(int i=0; i<rowData.length; i++){
               rowData[i] = getTableData().get(row).get(i); 
            }
            model.addRow(rowData);
        }
        return model;
    }
    
    //Method to get Leave Balances
    public void getLeaveBalance(PreparedStatement statement) throws SQLException{
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        data = getData(statement);
        this.vlBalance = data.get(0).get(0); //To get VL Balance
        this.slBalance = data.get(1).get(0); //To get SL Balance
        closeDBRequest(statement);
    }
    
    //Method to close database request
    public void closeDBRequest(ResultSet resultSet, PreparedStatement statement) throws SQLException{
        resultSet.close();
        statement.close();
    }
    
    //Method to close database request
    public void closeDBRequest(PreparedStatement statement) throws SQLException{
        statement.close();
    }

    //Method to get employee id
    public int getEmployeeID() {
        return this.employeeID;
    }

    //Method to get table data
    ArrayList<ArrayList<String>> getTableData(){
        return this.tableData;
    }

    //Method to get Vacation Leave Balance
    String getVLBalance(){
        return this.vlBalance;
    }
    
    //Method to get Sick Leave Balance
    String getSLBalance(){
        return this.slBalance;
    }

    //Method to set the table to empty
   void setTableData(){
       getTableData().clear();
   }
   
   //Method to set the data into the table
   void setTableData(ArrayList<ArrayList<String>> newData){
       this.tableData = newData;
   }
   
   //Method that set size of the table
   void setTableSize(int tableSize){
       this.tableSize = tableSize;
   }
}
