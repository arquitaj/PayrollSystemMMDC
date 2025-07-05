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
    private String firstName, lastName, birthday, phoneNumber, street, barangay, city, province, zipcode, sssNumber, philHealthNumber, tinNumber, 
            pagibigNumber, status, position, supervisor, dateToday, timeNow;
    private double basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, semiBasicSalary, hourlyRate;
    private String vlBalance, slBalance;
    
    int tableSize;
    
    DatabaseConnection dbConnection = new DatabaseConnection();
    java.sql.Connection conn = dbConnection.getDBConnection();
    DatabaseManager databaseManager = new DatabaseManager();

    AccountDetails(){}
  
    //To get data from Database
    ArrayList<ArrayList<String>> getData(PreparedStatement statement) throws SQLException{
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
    ArrayList<ArrayList<String>> retrivedDetails(PreparedStatement statement) throws SQLException{
         ArrayList<ArrayList<String>> data = new ArrayList<>();
          data = getData(statement);
          return data;
    }
    
    //Methods that handle for inserting data to Database
    Boolean addDetailsToDatabase(PreparedStatement statement) throws SQLException{
        Boolean isSuccessfulyAdded = false;
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            isSuccessfulyAdded = true;
        }      
        return isSuccessfulyAdded; 
    }
        
    void userDetails (PreparedStatement statement){
           ArrayList<ArrayList<String>> data = new ArrayList<>();
          try{   
               data = getData(statement);
                this.employeeID = Integer.parseInt(data.get(0).get(0));
                this.firstName = data.get(0).get(1);
                this.lastName = data.get(0).get(2);
                this.birthday = data.get(0).get(3);
                this.phoneNumber = data.get(0).get(4); 
                this.street = data.get(0).get(5);
                this.barangay = data.get(0).get(6);
                this.city = data.get(0).get(7);
                this.province = data.get(0).get(8);
                this.zipcode = data.get(0).get(9);
                this.basicSalary = Double.parseDouble(data.get(0).get(10));
                this.semiBasicSalary = this.basicSalary / 2;
                this.hourlyRate = (semiBasicSalary/21)/8;
                this.riceSubsidy = Double.parseDouble(data.get(0).get(11));
                this.phoneAllowance = Double.parseDouble(data.get(0).get(12));
                this.clothingAllowance = Double.parseDouble(data.get(0).get(13));
                this.philHealthNumber = data.get(0).get(14);
                this.sssNumber = data.get(0).get(15);
                this.tinNumber = data.get(0).get(16);
                this.pagibigNumber = data.get(0).get(17);
                this.position = data.get(0).get(18);
                this.status = data.get(0).get(19);
                this.supervisor = data.get(0).get(20);
            } catch(SQLException ex){
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    
    public int getEmployeeCount(){
        int count = 0;
        try{
            String query = "SELECT COUNT(employee_id) FROM employees;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                count = result.getInt(1);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return count;
    }
    
    String getEmployeeCompleteName(){
        return getLastName()+", "+getFirstName();
    }
    public String getFilePath() {
        return filePath;
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getStreet() {
        return street;
    }
    public String getBarangay() {
        return barangay;
    }
    public String getCity() {
        return city;
    }
    public String getProvince() {
        return province;
    }
    public String getZipCode() {
        return zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSssNumber() {
        return sssNumber;
    }

    public String getPhilHealthNumber() {
        return philHealthNumber;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public String getPagibigNumber() {
        return pagibigNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getPosition() {
        return position;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getRiceSubsidy() {
        return riceSubsidy;
    }

    public double getPhoneAllowance() {
        return phoneAllowance;
    }

    public double getClothingAllowance() {
        return clothingAllowance;
    }

    public double getSemiBasicSalary() {
        return semiBasicSalary;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public String getBirthday() {
        return birthday;
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
