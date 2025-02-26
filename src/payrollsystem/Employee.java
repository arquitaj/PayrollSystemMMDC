/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;

public class Employee extends AccountDetails {
    
    AccountDetails accountDetails = new AccountDetails();
    AccountDetails attendance = new AccountDetails();
    protected int indexAttendance;
    private String filePath;
    
    Employee(){
        super();
    }
    
    Employee(int employeeID, String filePath) {
        super();
        this.filePath = filePath;
    }
    
    void viewPersonalDetails(){
        accountDetails.setFilePath("CSVFiles//EmployeeDatabase.csv");
        accountDetails.retrivedDetails();
        accountDetails.userDetails();
    }
    
    void viewEmployeeAttendance(){
        viewPersonalDetails();
        attendance.setFilePath("CSVFiles//AttendanceDatabase.csv");
        attendance.retrivedDetails();
    }
    
    public void viewPersonalDTR() {
        
        viewEmployeeAttendance();
    }
    
    public void viewPersonalPayslip() {
        
    }
    
    public void viewPersonalLeaveLedger() {
       
        AccountDetails leaveLedger = new AccountDetails();
        leaveLedger.setFilePath("CSVFiles//LeaveRequests.csv");
        try {
            leaveLedger.retrivedDetails();
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No leave records found.");
        }
    }
    
    boolean validateAttendance(String date){
        for (int i=1; i<attendance.getDataList().size(); i++){
            if(Integer.parseInt(attendance.getDataList().get(i).get(0)) == accountDetails.getEmployeeID() && 
                    attendance.getDataList().get(i).get(1).equals(accountDetails.getLastName()) &&
                    attendance.getDataList().get(i).get(2).equals(accountDetails.getFirstName()) &&
                    attendance.getDataList().get(i).get(3).equals(date)) {
                
                this.indexAttendance = i;
                return true;
            }
        }
        return false;
    }
    
    void userLogin(){
        boolean isLogin = false;
        viewEmployeeAttendance();
   
        LocalDate dateNow = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = dateFormat.format(dateNow); 
        LocalTime time = LocalTime.now();
        String timeLogin = time.getHour()+":"+time.getMinute();
 
        if(validateAttendance(date)){
            JOptionPane.showMessageDialog(null, "Your already made your time-in!!");
        }else{
            String [] newAttendance = {String.valueOf(accountDetails.getEmployeeID()), accountDetails.getLastName(), accountDetails.getFirstName(), date, timeLogin};
            ArrayList<String> data = new ArrayList<>();
            data.addAll(Arrays.asList(newAttendance));
            attendance.getDataList().add(data);
            attendance.addDetailsCSV();
        }
       attendance.getDataList().clear();
       attendance.printDetails();
    }
    
    void userLogout(){
        viewEmployeeAttendance();
        
        LocalDate dateNow = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = dateFormat.format(dateNow); 
        LocalTime time = LocalTime.now();
        String timeLogout = time.getHour()+":"+time.getMinute();
       
        if(validateAttendance(date)){
            if(attendance.getDataList().get(indexAttendance).size() == 5){
                attendance.getDataList().get(indexAttendance).add(5, timeLogout);
                attendance.addDetailsCSV();
            }else if (attendance.getDataList().get(indexAttendance).size() > 5 || attendance.getDataList().get(indexAttendance).get(4).equals("")){
                attendance.getDataList().get(indexAttendance).set(5, timeLogout);
                attendance.addDetailsCSV();
            }
        }else{
            String [] newAttendance = {String.valueOf(accountDetails.getEmployeeID()), accountDetails.getLastName(), accountDetails.getFirstName(), date, "",timeLogout};
            ArrayList<String> data = new ArrayList<>();
            data.addAll(Arrays.asList(newAttendance));
            attendance.getDataList().add(data);
            attendance.addDetailsCSV(); 
        }
        attendance.getDataList().clear();
        attendance.printDetails();
    }
    
    public void populateRequestForm(javax.swing.JLabel idLabel, javax.swing.JLabel nameLabel) {
        viewPersonalDetails();
        
        idLabel.setText(String.valueOf(accountDetails.getEmployeeID()));
        nameLabel.setText(accountDetails.getFirstName() + " " + accountDetails.getLastName());
    }
    
    public void fileLeaveRequest(String leaveType, java.util.Date fromDate, java.util.Date toDate, int days, String reason) {
    
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("MM/dd/yyyy");
        String fromDateStr = dateFormat.format(fromDate);
        String toDateStr = dateFormat.format(toDate);
        
        AccountDetails leaveDetails = new AccountDetails();
        leaveDetails.setFilePath("CSVFiles//LeaveRequests.csv");
        
        try {
            leaveDetails.retrivedDetails();
        } catch (Exception e) {

            ArrayList<String> headers = new ArrayList<>();
            headers.add("Employee #");
            headers.add("Last Name");
            headers.add("First Name");
            headers.add("Leave Type");
            headers.add("From Date");
            headers.add("To Date");
            headers.add("Days");
            headers.add("Reason");
            headers.add("Status");
            leaveDetails.getDataList().add(headers);
        }
        
        ArrayList<String> leaveRequestRow = new ArrayList<>();
        leaveRequestRow.add(String.valueOf(accountDetails.getEmployeeID()));
        leaveRequestRow.add(accountDetails.getLastName());
        leaveRequestRow.add(accountDetails.getFirstName());
        leaveRequestRow.add(leaveType);
        leaveRequestRow.add(fromDateStr);
        leaveRequestRow.add(toDateStr);
        leaveRequestRow.add(String.valueOf(days));
        leaveRequestRow.add(reason);
        leaveRequestRow.add("Pending");
        
        leaveDetails.getDataList().add(leaveRequestRow);
        
        leaveDetails.addDetailsCSV();
        
        javax.swing.JOptionPane.showMessageDialog(null, "Leave request submitted successfully!");
    }
    
    public void fileOvertimeRequest() {
        
    }
    
    public void updateLeaveRequest() {
    
    }
    
    public void updateOvertimeRequest() {
    
    }
    
    public String getFilePath() {
        return filePath;
    }
    
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}