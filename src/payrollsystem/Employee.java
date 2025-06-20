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
import java.lang.reflect.Array;
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
    private int numberOfDaysLeave = 0;
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
        String sql = "SELECT e.employee_id, e.first_name, e.last_name, e.birthdate, e.phone_number,ad.street, ad.barangay, ad.city, ad.province, ad.zipcode,\n" +
"    sal.basic_salary, sal.rice_subsidy, sal.phone_allowance, sal.clothing_allowance,id.philhealth_number, id.sss_number, id.tin_number, id.pagibig_number,\n" +
"    p.position_name, s.status_name FROM employees e JOIN employee_address ad ON e.employee_address_id = ad.employee_address_id JOIN compensation_details sal ON e.employee_id = sal.employee_id\n" +
"    JOIN government_ids id ON e.employee_id = id.employee_id JOIN positions p ON e.position_id = p.position_id JOIN employee_statuses s ON e.status_id = s.status_id WHERE e.employee_id = ?";
  
        accountDetails.userDetails(this.employeeID, sql);
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
                    "WHERE l.employee_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);
            statement.setInt(2, this.employeeID);
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
                    "WHERE l.employee_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, this.employeeID);
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
    
//    void forwardDTRToSupervisor(ArrayList<String> rowData){
        
//        for(int i=0; i<rowData.size(); i++){
//            System.out.print(rowData.get(i));
//            String sql = "UPDATE "
//        }
//        accountDetails.getDataList().clear();
//        accountDetails.setFilePath("CSVFiles//AttendanceDatabase.csv");
//        accountDetails.retrivedDetails();
//        for(int i=0; i<tempData.size(); i++){
//            for(int j=0; j<accountDetails.getDataList().size(); j++){
//                if(accountDetails.getDataList().get(j).get(0).equals(accountDetails.getEmployeeID()) && tempData.get(i).get(0).equals(accountDetails.getDataList().get(j).get(2)) &&
//                       tempData.get(i).get(1).equals(accountDetails.getDataList().get(j).get(5)) ){
//                    accountDetails.getDataList().get(j).set(5, "Yes");
//                    break;
//                }
//            }
//        }
//        accountDetails.addDetailsCSV();
//    }
    
    //To view
//     void viewPersonalOvertime(){
//        overtime.setFilePath("CSVFiles//OvertimeRequest.csv");
//        overtime.retrivedDetails();
//    }

     
     void leaveBalancesInformation(){
         accountDetails.getDataList().clear();
         accountDetails.setFilePath("CSVFiles//LeaveBalances.csv");
         accountDetails.retrivedDetails();
         for(int i=1; i<accountDetails.getDataList().size(); i++){
             if(accountDetails.getDataList().get(i).get(0).equals(accountDetails.getEmployeeID())){
                 this.balanceVL = accountDetails.getDataList().get(i).get(1);
                 this.balanceSL = accountDetails.getDataList().get(i).get(2);
             }
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
    
//    boolean fileOvertimeRequest(ArrayList<String> data) {
//        localDateTimeNow();
//        viewPersonalOvertime();
//        
//        data.add(2, getDateToday());
//        data.add(3, "Overtime");
//        data.add("Pending");
//        overtime.getDataList().add(data);
//        overtime.addDetailsCSV();
//       
//        data.clear();
//        overtime.getDataList().clear();
//        return true;
//    }
    
//    ArrayList<ArrayList<String>> getDataAllRequests() {
//        accountDetails.getDataList().clear();
//        ArrayList<ArrayList<String>> tempData = new ArrayList<>();
//        accountDetails.setFilePath("CSVFiles//LeaveRequests.csv");
//        accountDetails.retrivedDetails("employees");
//        for(int i=0; i<accountDetails.getDataList().size(); i++){
//            if(accountDetails.getDataList().get(i).get(0).equals(accountDetails.getEmployeeID()) && accountDetails.getDataList().get(i).get(8).equals("Pending")){
//                ArrayList<String> data = new ArrayList<>();
//                data.add(accountDetails.getDataList().get(i).get(2)); // Date Filed
//                data.add(accountDetails.getDataList().get(i).get(3)); // Type of Request (Leave Type)
//                data.add(accountDetails.getDataList().get(i).get(4)); // Period From
//                data.add(accountDetails.getDataList().get(i).get(5)); // Period To
//                data.add(accountDetails.getDataList().get(i).get(6)); // Number of days
//                data.add(accountDetails.getDataList().get(i).get(7)); // Reason
//                data.add(accountDetails.getDataList().get(i).get(8)); // Status
//                tempData.add(data);
//            }
//        }
//
//        accountDetails.getDataList().clear();
//        accountDetails.setFilePath("CSVFiles//OvertimeRequest.csv");
//        accountDetails.retrivedDetails();
//        for(int i=0; i<accountDetails.getDataList().size(); i++){
//            if(accountDetails.getDataList().get(i).get(0).equals(accountDetails.getEmployeeID()) && accountDetails.getDataList().get(i).get(8).equals("Pending")){
//                ArrayList<String> data = new ArrayList<>();
//                data.add(accountDetails.getDataList().get(i).get(2)); // Date Filed
//                data.add(accountDetails.getDataList().get(i).get(3)); // Type of Request (Leave Type)
//                data.add(accountDetails.getDataList().get(i).get(4)); // Period From
//                data.add(accountDetails.getDataList().get(i).get(5)); // Period To
//                data.add(accountDetails.getDataList().get(i).get(6)); // Number of days
//                data.add(accountDetails.getDataList().get(i).get(7)); // Reason
//                data.add(accountDetails.getDataList().get(i).get(8)); // Status
//                tempData.add(data);
//            }
//        }
//        return tempData;
//    }
    
//    void viewPersonalDTR(Date dateFrom, Date dateTo){
//         SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
// 
//        Calendar startDate = Calendar.getInstance();
//        Calendar endDate = Calendar.getInstance();
//        startDate.setTime(dateFrom);
//        endDate.setTime(dateTo);
//        while(!startDate.after(endDate)){
//            Date currentDate = startDate.getTime();
//            if (startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
//                String formattedDate = formatter.format(currentDate);
//            }
//            // Move to the next day
//            startDate.add(Calendar.DATE, 1);
//        }
//    }
    
    ArrayList<ArrayList<String>> getDataAllDTR(Date fromDate, Date toDate) {
        accountDetails.getDataList().clear();
        accountDetails.setFilePath("CSVFiles//AttendanceDatabase.csv");
        accountDetails.retrivedDetails();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar start = Calendar.getInstance();
        start.setTime(fromDate);
        
        Calendar end = Calendar.getInstance();
        end.setTime(toDate);
        ArrayList<ArrayList<String>> tempData = new ArrayList<>();
        // Loop through each day from fromDate to toDate
        while (!start.after(end)) {
            // Print the current date in your desired format (e.g., "MMM d, yyyy")
            for(int i=1; i<accountDetails.getDataList().size(); i++){
                if(accountDetails.getDataList().get(i).get(0).equals(accountDetails.getEmployeeID()) 
                        && accountDetails.getDataList().get(i).get(2).equals(dateFormat.format(start.getTime()))){
                    ArrayList<String> data = new ArrayList<>();
                    data.add(accountDetails.getDataList().get(i).get(2));
                    data.add(accountDetails.getDataList().get(i).get(3));
                    data.add(accountDetails.getDataList().get(i).get(4));
                    data.add(accountDetails.getDataList().get(i).get(5));
                    data.add(accountDetails.getDataList().get(i).get(7));
                    tempData.add(data);
                    break;
                }
            }
            // Increment the day by one
            start.add(Calendar.DAY_OF_MONTH, 1);
        }
        
        
        
        return tempData;
}
    ArrayList<ArrayList<String>> allApprovedPersonalLeaveLedger() {
        //load personal details to ensure we have the employee ID
        accountDetails.getDataList().clear();
        accountDetails.setFilePath("CSVFiles//LeaveRequests.csv");
        accountDetails.retrivedDetails();
        ArrayList<ArrayList<String>> tempData = new ArrayList<>();
        for(int i=1; i<accountDetails.getDataList().size(); i++){

            if(accountDetails.getDataList().get(i).get(0).equals(accountDetails.getEmployeeID()) && accountDetails.getDataList().get(i).get(8).equals("Approved")){
                String [] list = {accountDetails.getDataList().get(i).get(2), accountDetails.getDataList().get(i).get(3),accountDetails.getDataList().get(i).get(4),
                        accountDetails.getDataList().get(i).get(5),accountDetails.getDataList().get(i).get(6), accountDetails.getDataList().get(i).get(7), 
                        accountDetails.getDataList().get(i).get(8)
                };
                ArrayList<String> row = new ArrayList<>();
                row.addAll(Arrays.asList(list));
                tempData.add(row);
            }
        }
    return tempData;
}

    public void updateLeaveBalanceLabels(javax.swing.JLabel lblVL, javax.swing.JLabel lblSL) {
        // Load personal details to ensure we have the employee ID
    
        // Load leave balances
        leaveBalancesInformation();

        // Update the labels with current balances
        lblVL.setText(getBalanceVL());
        lblSL.setText(getBalanceSL());
}
    ArrayList<ArrayList<String>> viewPersonalPayslip(Date dateFrom, Date dateTo, String id){
        accountDetails.getDataList().clear();
        ArrayList<ArrayList<String>> tempData = new ArrayList<>();
        if(dateFrom == null || dateTo == null){
            JOptionPane.showMessageDialog(null, "Please Provide Payroll Period!");
        }else{
            String fromFormatted = new SimpleDateFormat("MM/dd/yyyy").format(dateFrom);
            String toFormatted = new SimpleDateFormat("MM/dd/yyyy").format(dateTo);
            String datePeriod = fromFormatted + " to " + toFormatted;
            int date = dateFrom.compareTo(dateTo);
            if(date > 0){
                JOptionPane.showMessageDialog(null, "Invalid Payroll Period");
            }else{
                accountDetails.setFilePath("CSVFiles//Payroll.csv");
                accountDetails.retrivedDetails();
                for(int i=0; i<accountDetails.getDataList().size(); i++){
                    if(accountDetails.getDataList().get(i).get(0).equals(id) && accountDetails.getDataList().get(i).get(2).equals(datePeriod) && accountDetails.getDataList().get(i).get(13).equals("Approved")){
                        tempData.add(accountDetails.getDataList().get(i));
                        break;
                    }
                }
            }
        }
        return tempData;
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