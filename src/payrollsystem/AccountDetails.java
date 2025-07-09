/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;
import com.sun.jdi.connect.spi.Connection;
import java.text.*;
import java.time.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import java.time.format.DateTimeFormatter;
import java.sql.*;

/**
 *
 * @author Paul
 */
public class AccountDetails extends DatabaseConnection{
    private ArrayList<ArrayList<String>> tableData = new ArrayList<>();
    private ArrayList<ArrayList<String>> dataList = new ArrayList<>();
    
    private String filePath;
    private int employeeID;
  
    private String vlBalance, slBalance;
    
    int tableSize;
    
    DatabaseConnection dbConnection = new DatabaseConnection();
    java.sql.Connection conn = dbConnection.getDBConnection();
    DatabaseManager databaseManager = new DatabaseManager();

    public AccountDetails(){}
  
    //To get data from Database
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
              
            return tableData;
    }
    

    
    //Method that handle of retrieving data from Database
    public ArrayList<ArrayList<String>> retrivedDetails(PreparedStatement statement) throws SQLException{
         ArrayList<ArrayList<String>> data = new ArrayList<>();
          data = getData(statement);
          return data;
    }
    
    //Methods that handle for inserting data to Database
    public Boolean addDetailsToDatabase(PreparedStatement statement) throws SQLException{
        Boolean isSuccessfulyAdded = false;
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            isSuccessfulyAdded = true;
        }      
        return isSuccessfulyAdded; 
    }
        
     
    //To display Data in the Table
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
    
    void getLeaveBalance(PreparedStatement statement){
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            data = getData(statement);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.vlBalance = data.get(0).get(0); //To get VL Balance
        this.slBalance = data.get(1).get(0); //To get SL Balance
    }
    
    public ArrayList<ArrayList<String>> getDataList() {
        return dataList;
    }
    

    public String getFilePath() {
        return filePath;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

   
    ArrayList<ArrayList<String>> getTableData(){
        return this.tableData;
    }

    String getVLBalance(){
        return this.vlBalance;
    }
    String getSLBalance(){
        return this.slBalance;
    }

   void setTableData(){
       getTableData().clear();
   }
   void setTableData(ArrayList<ArrayList<String>> newData){
       this.tableData = newData;
   }
   void setTableSize(int tableSize){
       this.tableSize = tableSize;
   }
}
