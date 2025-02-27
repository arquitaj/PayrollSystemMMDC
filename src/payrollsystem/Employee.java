/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class Employee extends AccountDetails {
    
    AccountDetails accountDetails = new AccountDetails();
    AccountDetails attendance = new AccountDetails();
    AccountDetails leave = new AccountDetails();
    protected int indexAttendance;
    private String filePath;
    private String dateToday, timeNow;
    private String leaveDays;
    
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
    //To view all personal attendance
    void viewEmployeeAttendance(){
        viewPersonalDetails();
        attendance.setFilePath("CSVFiles//AttendanceDatabase.csv");
        attendance.retrivedDetails();
    }
    
    void viewPersonalLeaveLedger(){
        leave.setFilePath("CSVFiles//LeaveRequests.csv");
        leave.retrivedDetails();
    }
    // To format the Local Time and Date Now
    void localDateTimeNow(){
        LocalDate dateNow = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        this.dateToday = dateFormat.format(dateNow); 
        
        LocalTime time = LocalTime.now();
        this.timeNow = time.getHour()+":"+time.getMinute();
    }
//    public void viewPersonalDTR() {  
//        viewEmployeeAttendance();
//    }
    
    public void viewPersonalPayslip() {
        
    }
    
//    public void viewPersonalLeaveLedger() {
//        AccountDetails leaveLedger = new AccountDetails();
//        leaveLedger.setFilePath("CSVFiles//LeaveRequests.csv");
//        try {
//            leaveLedger.retrivedDetails();
//        
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "No leave records found.");
//        }
//    }
    
    //To Validate Attendance first before adding it in CSV
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
    
    //To record the login or time in of the employeee
    void userLogin(){
        boolean isLogin = false;
        viewEmployeeAttendance(); //calling the method
        localDateTimeNow(); // To format the date

        if(validateAttendance(getDateToday())){
            JOptionPane.showMessageDialog(null, "You already made your time-in!!");
        }else{
            String [] newAttendance = {String.valueOf(accountDetails.getEmployeeID()), accountDetails.getLastName(), accountDetails.getFirstName(), getDateToday() , getTimeNow()};
            ArrayList<String> data = new ArrayList<>();
            data.addAll(Arrays.asList(newAttendance));
            attendance.getDataList().add(data);
            attendance.addDetailsCSV();
        }
       attendance.getDataList().clear();
       attendance.printDetails();
    }
    
    //To record the logout or time out of the employee
    void userLogout(){
        viewEmployeeAttendance(); //Calling the method    
        localDateTimeNow();
        if(validateAttendance(getDateToday())){
            if(attendance.getDataList().get(indexAttendance).size() == 5){
                attendance.getDataList().get(indexAttendance).add(5, getTimeNow());
                attendance.addDetailsCSV();
            }else if (attendance.getDataList().get(indexAttendance).size() > 5 || attendance.getDataList().get(indexAttendance).get(4).equals("")){
                attendance.getDataList().get(indexAttendance).set(5, getTimeNow());
                attendance.addDetailsCSV();
            }
        }else{
            String [] newAttendance = {String.valueOf(accountDetails.getEmployeeID()), accountDetails.getLastName(), accountDetails.getFirstName(), getDateToday(), "",getTimeNow()};
            ArrayList<String> data = new ArrayList<>();
            data.addAll(Arrays.asList(newAttendance));
            attendance.getDataList().add(data);
            attendance.addDetailsCSV(); 
        }
        attendance.getDataList().clear();
        attendance.printDetails();
    }
    
    //To file new leave request
    boolean fileLeaveRequest(ArrayList<String> data, Date dateFrom, Date dateTo){
        localDateTimeNow();
        viewPersonalLeaveLedger();
        
        int count = 0;
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.setTime(dateFrom);
        endDate.setTime(dateTo);
        while(!startDate.after(endDate)){
            if (startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                count++;
            }
            // Move to the next day
            startDate.add(Calendar.DATE, 1);
        }
        if(count == 0){
            JOptionPane.showMessageDialog(null, "Invalid date applied!");
            data.clear(); //To empty or clear data in array list
            leave.getDataList().clear(); //To clear all data list
            return false;
        }else{
            this.leaveDays = String.valueOf(count);
            data.add(1, getDateToday()); //To insert date filed in index 1 of the arraylist data 
            data.add(5, getLeaveDays()); //To add number of days on leave excluding Sunday
            data.add("Pending");
            leave.getDataList().add(data);
            leave.addDetailsCSV(); //To add all data in the LeaveRequest CSV  
        }
       data.clear(); //To empty or clear data in array list
       leave.getDataList().clear(); //To empty or clear all data list
       return true;
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
    
    String getDateToday(){
        return dateToday;
    }
    String getTimeNow(){
        return timeNow;
    }
    String getLeaveDays(){
        return leaveDays;
    }
}