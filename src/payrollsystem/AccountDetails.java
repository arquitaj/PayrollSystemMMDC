/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.sun.jdi.connect.spi.Connection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Paul
 */
public class AccountDetails extends DatabaseConnection{
    private ArrayList<ArrayList<String>> tableData = new ArrayList<>();
    private ArrayList<ArrayList<String>> dataList = new ArrayList<>();
    private ArrayList<ArrayList<String>> newData = new ArrayList<>();
    private ArrayList<ArrayList<String>> idAndNames = new ArrayList<>();
    
    
    private String filePath;
    private String employeeID;
    private String employeeCompleteName;
    private String firstName, lastName, birthday, address, phoneNumber, sssNumber, philHealthNumber, tinNumber, pagibigNumber, status, position, supervisor;
    private double basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, semiBasicSalary, hourlyRate;

    int tableSize;
    
    DatabaseConnection dbConnection = new DatabaseConnection();
    java.sql.Connection conn = dbConnection.getDBConnection();
    
    AccountDetails(){
        
    }
   
    void databaseConnection () throws SQLException{
        System.out.println(dbConnection.getDBConnection());
    }
    
    
  
    void retrivedDetails(){
        String line; 
        try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath()))) {
            while ((line = reader.readLine()) != null){
                String[] datas = line.split(",");
                ArrayList<String> row = new ArrayList<>();
                row.addAll(Arrays.asList(datas));
                this.dataList.add(row);
            } 
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    void userDetails(String id){
        this.employeeID = id;
        for(ArrayList<String> data : dataList){
            if(data.get(0).equals(String.valueOf(getEmployeeID()))){
                this.lastName = data.get(1);
                this.firstName = data.get(2); 
                this.birthday = data.get(3);
                this.address = data.get(4);
                this.phoneNumber = data.get(5);
                this.sssNumber = data.get(6);
                this.philHealthNumber = data.get(7);
                this.tinNumber = data.get(8);
                this.pagibigNumber = data.get(9);
                this.status = data.get(10);
                this.position = data.get(11);
                this.supervisor = data.get(12);
                this.basicSalary = Double.parseDouble(data.get(13));
                this.riceSubsidy = Double.parseDouble(data.get(14));
                this.phoneAllowance = Double.parseDouble(data.get(15));
                this.clothingAllowance = Double.parseDouble(data.get(16));
                this.semiBasicSalary = Double.parseDouble(data.get(17));
                this.hourlyRate = Double.parseDouble(data.get(18));
            }
        }
    }
    
    void addDetailsCSV(){
        try(BufferedWriter writer = new BufferedWriter (new FileWriter (getFilePath()))){
                for(int i=0; i<getDataList().size(); i++){
                    for(int j=0; j<getDataList().get(i).size(); j++){
                        writer.write(getDataList().get(i).get(j)+",");
                    }
                    if(i<getDataList().size()-1)
                        writer.newLine();
                }
                writer.close();
                getDataList().clear();
            }catch(IOException e){
                e.printStackTrace();
            }
    }
    
    //Implementation of CSV to DATABASE FOR OVERTIME REQUEST
    Boolean addOvertimeToDatabase(int employee_id, Date overtime_from, Date overtime_to, int number_of_days, String reason) throws SQLException, ParseException{
        Boolean isSuccessfulyAdded = false;
        Date date = new Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        if(conn != null){
            int requestID = 0;
            String getSQL = "SELECT request_status_id FROM request_status WHERE status = ? ";
            PreparedStatement getStatement = conn.prepareStatement(getSQL);
            getStatement.setString(1, "Pending");
            ResultSet resultSet = getStatement.executeQuery();
            while (resultSet.next()) {
                requestID = resultSet.getInt("request_status_id");
            }
            
            if(requestID != 0){
                String insertSQL = "INSERT INTO overtime_requests (employee_id, date_filed, overtime_from, overtime_to, number_of_days, reason, request_status_id) VALUES (?,?,?,?,?,?,?)";
                PreparedStatement statement = conn.prepareStatement(insertSQL);
                statement.setInt(1, employee_id);
                statement.setDate(2, sqldate);
                statement.setDate(3, new java.sql.Date(overtime_from.getTime()));
                statement.setDate(4, new java.sql.Date(overtime_to.getTime()));
                statement.setInt(5, number_of_days);
                statement.setString(6, reason);
                statement.setInt(7, requestID);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    isSuccessfulyAdded = true;
                }       
            }
        }
        return isSuccessfulyAdded;
    }
    
    
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
           getNewData().clear();
        return model;
    }
    
    public ArrayList<ArrayList<String>> getDataList() {
        return dataList;
    }
   
    
    ArrayList<ArrayList<String>> getIdAndNames(){
       return this.idAndNames;
   }
   
    ArrayList<ArrayList<String>> getNewData(){
       return this.newData;
   }   
    String getEmployeeCompleteName(){
        return getLastName()+" "+getFirstName();
    }
    public String getFilePath() {
        return filePath;
    }

    public String getEmployeeID() {
        return this.employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
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
    int getTableSize(){
        return this.tableSize;
    }
    ArrayList<ArrayList<String>> getTableData(){
        return this.tableData;
    }
    public void setFilePath(String path){
        this.filePath = path;
    }
   void setEmployeeID(String employeeID){
       this.employeeID = employeeID;
   }
   void setEmptyDataList(){
       getDataList().clear();
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
