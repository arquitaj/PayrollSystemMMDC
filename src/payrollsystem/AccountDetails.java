/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;
import com.sun.jdi.connect.spi.Connection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.sql.*;

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
    private String address = "";
    private String employeeCompleteName;
    private String firstName, lastName, birthday, phoneNumber, sssNumber, philHealthNumber, tinNumber, pagibigNumber, status, position, supervisor, dateToday, timeNow;
    private double basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, semiBasicSalary, hourlyRate;

    int tableSize;
    
    DatabaseConnection dbConnection = new DatabaseConnection();
    java.sql.Connection conn = dbConnection.getDBConnection();
    DatabaseManager db = new DatabaseManager();
    
    AccountDetails(){}
  
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
    
    void retrivedDetails(String table){
        ArrayList<ArrayList<String>> dataListClone = new ArrayList<>();
        String[] columnNames;
        int columnCount;
        
        try{
            ResultSet result = db.readFromDatabase(table);
            columnCount = result.getMetaData().getColumnCount();
            columnNames = new String[columnCount];
            
            for (int i = 0; i < columnCount; i++){
                columnNames[i] = result.getMetaData().getColumnName(i + 1);
            }
            
            while (result.next()){
                ArrayList<String> resultItems = new ArrayList<>();
                for (String columnName : columnNames){
                    resultItems.add(result.getString(columnName));
                }
                dataListClone.add(resultItems); //dataListClone is used instead of direct assignment due to an object reference error
            }
            result.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        dataList = dataListClone;
    }
    
    void userDetails(String id){
        this.employeeID = id;
        for(ArrayList<String> data : dataList){
            if(data.get(0).equals(String.valueOf(getEmployeeID()))){
                this.lastName = data.get(6);
                this.firstName = data.get(5); 
                this.birthday = data.get(7);
                this.phoneNumber = data.get(8);
                this.status = db.readEmployeeStatus(employeeID);
                this.position = db.readEmployeePosition(employeeID);
                this.supervisor = data.get(3);
//                this.semiBasicSalary = Double.parseDouble(data.get(17)); //TODO
                
                
                for(String item : db.readEmployeeAddress(employeeID)){ //assigning this.address from address columns in database
                    this.address += item;
                }
                
                Double[] compensationDetails = db.readCompensationDetails(employeeID);
                this.basicSalary = compensationDetails[0];
                this.riceSubsidy = compensationDetails[1];
                this.phoneAllowance = compensationDetails[2];
                this.clothingAllowance = compensationDetails[3];
                this.hourlyRate = compensationDetails[4];
                
                String[] governmentDetails = db.readGovernmentDetails(employeeID);
                this.sssNumber = governmentDetails[0];
                this.philHealthNumber = governmentDetails[1];
                this.tinNumber = governmentDetails[2];
                this.pagibigNumber = governmentDetails[3];

                if (!this.lastName.isBlank() || !this.lastName.isEmpty()){
                    break;
                }
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
    
    //To get the id of the column table in the database
    int getConnectionKey (String query) throws SQLException{
        int requestID = 0;
     
        PreparedStatement getStatement =  conn.prepareStatement(query);
        ResultSet resultSet = getStatement.executeQuery();
        requestID = resultSet.getInt("request_status_id");
        
        return requestID;
    }
    
    //Implementation of CSV to DATABASE FOR OVERTIME REQUEST
    Boolean addOvertimeToDatabase(int employee_id, Date overtime_from, Date overtime_to, int number_of_days, String reason) throws SQLException, ParseException{
        Boolean isSuccessfulyAdded = false;
        Date date = new Date();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        if(conn != null){
            int requestID = 0;
            String getSQL = "SELECT request_status_id FROM request_status WHERE status = 'Pending' ";
            PreparedStatement getStatement = conn.prepareStatement(getSQL);
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
    
    Boolean userLogin(int employeeID) throws SQLException{
        Boolean isSuccessfulyAdded = false;
          java.sql.Date dateNow = new java.sql.Date(System.currentTimeMillis());
          Timestamp timeNow = new Timestamp(System.currentTimeMillis());
        if(conn != null){
            int requestID = 0;
            String getSQL = "SELECT * FROM attendance_records WHERE employee_id = ? AND attendance_date = ?";
            PreparedStatement getStatement = conn.prepareStatement(getSQL);
            getStatement.setInt(1, employeeID);
            getStatement.setDate(2, dateNow);
            ResultSet resultSet = getStatement.executeQuery();
            while (resultSet.next()) {
                requestID = resultSet.getInt("employee_id");
            }
            
            if(requestID == 0){
                String insertSQL = "INSERT INTO attendance_records (employee_id, attendance_date, login) VALUES (?,?,?)";
                PreparedStatement statement = conn.prepareStatement(insertSQL);
                statement.setInt(1, employeeID);
                statement.setDate(2, dateNow);
                statement.setTimestamp(3, timeNow);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    isSuccessfulyAdded = true;
                }       
            }else{
                JOptionPane.showMessageDialog(null, "You already time in!");
            }
        }    
        return isSuccessfulyAdded;
    }
    
    Boolean userLogout(int employeeID) throws SQLException{
        Boolean isSuccessfulyAdded = false;
          java.sql.Date dateNow = new java.sql.Date(System.currentTimeMillis());
          Timestamp timeNow = new Timestamp(System.currentTimeMillis());
        if(conn != null){
       
            int requestID = 0;
            String getSQL = "SELECT * FROM attendance_records WHERE employee_id = ? AND attendance_date = ?";
            PreparedStatement getStatement = conn.prepareStatement(getSQL);
            getStatement.setInt(1, employeeID);
            getStatement.setDate(2, dateNow);
            ResultSet resultSet = getStatement.executeQuery();
            while (resultSet.next()) {
                requestID = resultSet.getInt("employee_id");
            }
            
            if(requestID != 0){
                String insertSQL = "UPDATE attendance_records SET logout = ? WHERE employee_id = ? AND attendance_date = ?";
                PreparedStatement statement = conn.prepareStatement(insertSQL);
                statement.setTimestamp(1, timeNow);
                statement.setInt(2, employeeID);
                statement.setDate(3, dateNow);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    isSuccessfulyAdded = true;
                }       
            }else{
                String insertSQL = "INSERT INTO attendance_records (employee_id, attendance_date, logout) VALUES (?,?,?)";
                PreparedStatement statement = conn.prepareStatement(insertSQL);
                statement.setInt(1, employeeID);
                statement.setDate(2, dateNow);
                statement.setTimestamp(3, timeNow);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    isSuccessfulyAdded = true;
                }       
            }
        }    
        return isSuccessfulyAdded;
    }
    
    //To file new leave request
    boolean fileLeaveRequest(ArrayList<String> data){
        localDateTimeNow();
        
        data.add(2, getDateToday()); //To insert date filed in index 2 of the arraylist data 
        data.add("Pending");
        db.writeLeaveApplicationToDatabase(data);
        
        data.clear(); //To empty or clear data in array list
        return true;
    }
    
    // To format the Local Time and Date Now
    void localDateTimeNow(){
        LocalDate dateNow = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        this.dateToday = dateFormat.format(dateNow); 
        
        LocalTime time = LocalTime.now();
        this.timeNow = time.getHour()+":"+time.getMinute();
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
    String getDateToday(){
        return dateToday;
    }
    String getTimeNow(){
        return timeNow;
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
