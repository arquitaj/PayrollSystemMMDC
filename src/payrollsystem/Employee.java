/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.io.BufferedWriter;
import java.sql.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Employee extends AccountDetails {
    
    AccountDetails accountDetails = new AccountDetails();
    AccountDetails attendance = new AccountDetails();
    AccountDetails overtime = new AccountDetails();
    AccountDetails balance = new AccountDetails();
    AccountDetails payroll = new AccountDetails();
    AccountDetails dbConnection = new AccountDetails();
    
    
    private int employeeID;
    protected int indexAttendance;
    private String filePath;
    private String leaveDays;
    private int numberOfDaysLeave, daysWorked, overtimeDays = 0;
    private String balanceVL, balanceSL;
    
  
    java.sql.Connection conn = dbConnection.getDBConnection();
    
    Employee(){
        
    }
    
    Employee(String employeeID){
        this.employeeID = Integer.parseInt(employeeID);
        super();
    }
    
    //Method to get the date now
    java.sql.Date getDateNow(){
        Date date = new Date();
        java.sql.Date dateNow = new java.sql.Date(date.getTime());
        return dateNow;
    }
    
    //Method to get the time now with the format of "00:00:00"
    Time getTime(){
         // Get current time with seconds = 0, milliseconds = 0
            Timestamp time = new Timestamp(System.currentTimeMillis());
            LocalTime localTime = time.toLocalDateTime().toLocalTime().withSecond(0).withNano(0);
            // Convert to java.sql.Time
            Time timeNow = Time.valueOf(localTime);
            
            return timeNow;
    }
    void viewPersonalDetails(){
        try {
            String sql = "SELECT e.employee_id, e.first_name, e.last_name, e.birthdate, e.phone_number,ad.street, ad.barangay, ad.city, ad.province, "
                    + "ad.zipcode,sal.basic_salary, sal.rice_subsidy, sal.phone_allowance, sal.clothing_allowance,id.philhealth_number, id.sss_number, "
                    + "id.tin_number, id.pagibig_number, p.position_name, s.status_name, (SELECT CONCAT(es.last_name, ', ', es.first_name) "
                    + "FROM employees es WHERE es.employee_id = e.immediate_supervisor) AS supervisor_name "
                    + "FROM employees e JOIN employee_address ad "
                    + "ON e.employee_address_id = ad.employee_address_id JOIN compensation_details sal ON e.employee_id = sal.employee_id "
                    + "JOIN government_ids id ON e.employee_id = id.employee_id JOIN positions p ON e.position_id = p.position_id "
                    + "JOIN employee_statuses s ON e.status_id = s.status_id WHERE e.employee_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);
            accountDetails.userDetails(statement);
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    ArrayList<ArrayList<String>> getDataAllRequests(){
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT o.date_filed, 'Overtime' AS request_type, " +
                    "o.overtime_from AS leave_from, o.overtime_to AS leave_to, " +
                    "o.number_of_days, o.reason, r.status " +
                    "FROM overtime_requests o " +
                    "JOIN request_status r ON o.request_status_id = r.request_status_id " +
                    "WHERE o.employee_id = ? " +
                    "UNION ALL " +
                    "SELECT l.date_filed, t.leave_type AS request_type, " +
                    "l.leave_from, l.leave_to, l.number_of_days, l.reason, s.status " +
                    "FROM leave_ledger l " +
                    "JOIN leave_type t ON l.leave_type_id = t.leave_type_id " +
                    "JOIN request_status s ON l.request_status_id = s.request_status_id " +
                    "WHERE l.employee_id = ? AND status = ? ORDER BY date_filed ASC";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);
            statement.setInt(2, this.employeeID);
            statement.setString(3, "Pending");
            data = accountDetails.retrivedDetails(statement);  
         
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
           return data;
    }
    
    ArrayList<ArrayList<String>> getDTR(Date dateFrom, Date dateTo){
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql =  "SELECT ar.attendance_date, ar.login, ar.logout, rs.status AS request_status " +
                    "FROM attendance_records ar " +
                    "JOIN request_status rs ON ar.request_status_id = rs.request_status_id " +
                    "WHERE ar.employee_id = ? AND ar.attendance_date BETWEEN ? AND ?" +
                    "ORDER BY ar.attendance_date ASC";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);
            statement.setDate(2, new java.sql.Date(dateFrom.getTime()));
            statement.setDate(3, new java.sql.Date(dateTo.getTime()));
            data = accountDetails.retrivedDetails(statement); 
        } catch (SQLException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    ArrayList<ArrayList<String>> viewPersonalLeaveLedger() {
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT l.date_filed, t.leave_type, l.leave_from, l.leave_to, " +
                    "l.number_of_days, l.reason, s.status " +
                    "FROM leave_ledger l " +
                    "JOIN leave_type t ON t.leave_type_id = l.leave_type_id " +
                    "JOIN request_status s ON s.request_status_id = l.request_status_id " +
                    "WHERE l.employee_id = ? AND status  = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);
            statement.setString(2, "Approved");
            data = accountDetails.retrivedDetails(statement);
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    Boolean fileOvertimeRequest(int employee_id, Date overtime_from, Date overtime_to, int number_of_days, String reason){
        try {
            String sql =  "INSERT INTO overtime_requests (" +
                    "employee_id, date_filed, overtime_from, overtime_to, " +
                    "number_of_days, reason, request_status_id" +
                    ") VALUES (?, ?, ?, ?, ?, ?, " +
                    "(SELECT request_status_id FROM request_status WHERE status = 'Pending' LIMIT 1))";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, employee_id);
            statement.setDate(2, getDateNow());
            statement.setDate(3, new java.sql.Date(overtime_from.getTime()));
            statement.setDate(4, new java.sql.Date(overtime_to.getTime()));
            statement.setInt(5, number_of_days);
            statement.setString(6, reason);
            if(accountDetails.addDetailsToDatabase(statement)){
                JOptionPane.showMessageDialog(null, "Successfully File Overtime!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Request Failed!", "Error", JOptionPane.ERROR_MESSAGE);
                return false;   
            }
        } catch (SQLException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //Method for filing a request
    Boolean fileLeaveRequest(Date leaveFrom, Date leaveTo, String leaveType, String numDays, String reason){
        try {
            String sql = "INSERT INTO payroll_system_db.leave_ledger " +
                    "(employee_id, date_filed, leave_type_id, leave_from, leave_to, number_of_days, reason, request_status_id) " +
                    "VALUES(?,?,(SELECT leave_type_id FROM leave_type WHERE leave_type = ? ),?,?,?,?," +
                    "(SELECT request_status_id FROM request_status WHERE status = 'Pending' LIMIT 1))";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID); //employee_id
            statement.setDate(2, getDateNow()); //date_filed
            statement.setString(3, leaveType); //leave type
            statement.setDate(4, new java.sql.Date(leaveFrom.getTime())); //leave_from
            statement.setDate(5, new java.sql.Date(leaveTo.getTime())); //leave_end
            statement.setFloat(6, Float.parseFloat(numDays)); //number_of_days
            statement.setString(7, reason); //reason
            if(accountDetails.addDetailsToDatabase(statement)){
                JOptionPane.showMessageDialog(null, "Successfuly File A Leave Request!", "Success", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Request Failed!", "Error", JOptionPane.ERROR_MESSAGE);
                return false; 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //Method for Timein button
    void userLogin(){
        try {
            String sql = "INSERT INTO attendance_records (employee_id, attendance_date, login, request_status_id) " +
                    "SELECT ?, ?, ?, (SELECT request_status_id FROM request_status WHERE status = 'Pending' LIMIT 1) FROM DUAL " +
                    "WHERE NOT EXISTS (SELECT 1 FROM attendance_records WHERE employee_id = ? AND attendance_date = ?)";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID); // employee_id to insert
            statement.setDate(2, getDateNow()); // attendance_date to insert
            statement.setTime(3, getTime()); // login time
            
            statement.setInt(4, this.employeeID); // employee_id for existence check
            statement.setDate(5, getDateNow()); // attendance_date for existence check
            if(accountDetails.addDetailsToDatabase(statement)){
                JOptionPane.showMessageDialog(null, "Time in : "+getTime(), "Success", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Time in Failed! You already made your time-in.", "Error", JOptionPane.ERROR_MESSAGE);   
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Method for Time-out button
    void userLogout(){
        try {
            String sql = "INSERT INTO attendance_records (employee_id, attendance_date, logout, request_status_id) " +
                    "VALUES (?, ?, ?, (SELECT request_status_id FROM request_status WHERE status = 'Pending' LIMIT 1)) " +
                    "ON DUPLICATE KEY UPDATE logout = VALUES(logout)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID); // employee_id
            statement.setDate(2, getDateNow()); // attendance_date
            statement.setTime(3, getTime()); // logout
            if(accountDetails.addDetailsToDatabase(statement)){
                JOptionPane.showMessageDialog(null, "Time out : "+getTime(), "Success", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Time out Failed!", "Error", JOptionPane.ERROR_MESSAGE);  
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


     void leaveBalancesInformation(){
        try {
            String sql = "SELECT balance FROM leave_balances WHERE employee_id = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);
            accountDetails.getLeaveBalance(statement);
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
    boolean countNumberOfDays(Date dateFrom, Date dateTo){ // New method to count the days for leave
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.setTime(dateFrom);
        endDate.setTime(dateTo);
        while(!startDate.after(endDate)){
            if (startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                this.numberOfDaysLeave++; //To count the days of leave
            }
            // Move to the next day
            startDate.add(Calendar.DATE, 1);
        }
        if(getNumberOfDaysLeave() == 0){
            JOptionPane.showMessageDialog(null, "Invalid date applied!");
            return false;
        }
        return true;
    }
    
    int getDaysWorked(){
        try{
            String query = "SELECT * FROM payroll_system_db.attendance_records WHERE employee_id = ?;";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, this.employeeID);
            
            daysWorked = accountDetails.retrivedDetails(statement).size();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        return daysWorked;
    }
    
    int getOvertime(){
        try{
            String query = "SELECT * FROM payroll_system_db.overtime_requests WHERE employee_id = ? AND request_status_id = 2;";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, this.employeeID);
            
            overtimeDays = accountDetails.retrivedDetails(statement).size();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        return overtimeDays;
    }
    
    
    boolean downloadPayslip(Date date_from, Date date_to) {
        boolean isSuccess = false;
        if (date_from == null || date_to == null) {
            JOptionPane.showMessageDialog(null, "Error: date_from or date_to is null.", "Error", JOptionPane.ERROR_MESSAGE);
            return isSuccess;
        }
        try{
            String sql = "SELECT payslip_file FROM payslip p " +
                    "JOIN payroll_period per ON p.period_id = per.period_id " +
                    "WHERE employee_id = ? AND period_from = ? AND period_to = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);
            statement.setDate(2, new java.sql.Date(date_from.getTime()));
            statement.setDate(3, new java.sql.Date(date_to.getTime()));
            ResultSet result = statement.executeQuery();
            try{
                boolean fileFound = false;
                while (result.next()) {
                    Blob blob = result.getBlob("payslip_file");
                if (blob != null) {
                    InputStream inputStream = blob.getBinaryStream();
                    String folderPath = "DownloadFiles";
                    Files.createDirectories(Paths.get(folderPath)); // Create the folder if it doesn't exist

                    String filename = folderPath + "/" + this.employeeID + "_payslip.pdf";

                    try {
                        Files.copy(inputStream, Paths.get(filename), StandardCopyOption.REPLACE_EXISTING);
                        JOptionPane.showMessageDialog(null, "Payslip downloaded: " + filename, "Success", JOptionPane.INFORMATION_MESSAGE);
                        isSuccess = true;
                        fileFound = true;
                    } catch (IOException ex) {
                        Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, "IO error during file copy", ex);
                }
            }
            }
                if (!fileFound) {
                    JOptionPane.showMessageDialog(null, "No payslip record found for the given period.", "Error", JOptionPane.ERROR_MESSAGE);
                    return isSuccess;
                }
            }catch (Exception e){
                System.out.println(e); 
            }
        }catch (SQLException ex){
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null,ex); 
        }
        return isSuccess; 
    }
      
    public void updateLeaveRequest() {
    
    }
    
    public void updateOvertimeRequest() {
    
    }
    int getNumberOfDaysLeave(){
        return numberOfDaysLeave;
    }

    String getBalanceVL() {
        return balanceVL;
    }

    String getBalanceSL() {
        return balanceSL;
    }
    
    void setNumberOfDaysLeave(){
        this.numberOfDaysLeave = 0;
    }
    
}