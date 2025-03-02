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
    AccountDetails overtime = new AccountDetails();
    AccountDetails balance = new AccountDetails();
    
    protected int indexAttendance;
    private String filePath;
    private String dateToday, timeNow;
    private String leaveDays;
    private int numberOfDaysLeave = 0;
    private String balanceVL, balanceSL;
    
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
    
    //To view all Personal Leave Ledger
    void viewPersonalLeaveLedger(){
        leave.setFilePath("CSVFiles//LeaveRequests.csv");
        leave.retrivedDetails();
    }
    
    //To view
     void viewPersonalOvertime(){
        overtime.setFilePath("CSVFiles//OvertimeRequest.csv");
        overtime.retrivedDetails();
    }
     
     void leaveBalances(){
        balance.setFilePath("CSVFiles//LeaveBalances.csv");
        balance.retrivedDetails();
     }
     
     void leaveBalancesInformation(){
         leaveBalances();
         for(int i=1; i<balance.getDataList().size(); i++){
             if(balance.getDataList().get(i).get(0).equals(accountDetails.getEmployeeID())){
                 this.balanceVL = balance.getDataList().get(i).get(1);
                 this.balanceSL = balance.getDataList().get(i).get(2);
             }
         }
     }
     
    // To format the Local Time and Date Now
    void localDateTimeNow(){
        LocalDate dateNow = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        this.dateToday = dateFormat.format(dateNow); 
        
        LocalTime time = LocalTime.now();
        this.timeNow = time.getHour()+":"+time.getMinute();
    }
  
    
    //To Validate Attendance first before adding it in CSV
    boolean validateAttendance(String date){
        for (int i=1; i<attendance.getDataList().size(); i++){
            if(Integer.parseInt(attendance.getDataList().get(i).get(0)) == accountDetails.getEmployeeID() && 
                    attendance.getDataList().get(i).get(1).equals(accountDetails.getLastName()+" "+accountDetails.getFirstName()) &&
                    attendance.getDataList().get(i).get(2).equals(date)) {
                
                this.indexAttendance = i;
                return true;
            }
        }
        return false;
    }
    
    //To record the login or time in of the employeee
    void userLogin(){
        viewEmployeeAttendance(); //calling the method
        localDateTimeNow(); // To format the date

        if(validateAttendance(getDateToday())){
            JOptionPane.showMessageDialog(null, "You already made your time-in!!");
        }else{
            String [] newAttendance = {String.valueOf(accountDetails.getEmployeeID()), accountDetails.getEmployeeCompleteName(), getDateToday() , getTimeNow(),"","No", "No"};
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
            if(attendance.getDataList().get(indexAttendance).size() == 6){
                attendance.getDataList().get(indexAttendance).add(5, getTimeNow());
                attendance.addDetailsCSV();
            }else if (attendance.getDataList().get(indexAttendance).size() > 5 || attendance.getDataList().get(indexAttendance).get(4).equals("")){
                attendance.getDataList().get(indexAttendance).set(4, getTimeNow());
                attendance.addDetailsCSV();
            }
        }else{
            String [] newAttendance = {String.valueOf(accountDetails.getEmployeeID()), accountDetails.getEmployeeCompleteName(), getDateToday(), "",getTimeNow(),"No", "No"};
            ArrayList<String> data = new ArrayList<>();
            data.addAll(Arrays.asList(newAttendance));
            attendance.getDataList().add(data);
            attendance.addDetailsCSV(); 
        }
        attendance.getDataList().clear();
        attendance.printDetails();
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
    //To file new leave request
    boolean fileLeaveRequest(ArrayList<String> data){
        localDateTimeNow();
        viewPersonalLeaveLedger();
        
        data.add(2, getDateToday()); //To insert date filed in index 1 of the arraylist data 
        data.add("Pending");
        leave.getDataList().add(data);
        leave.addDetailsCSV(); //To add all data in the LeaveRequest CSV  
        
        data.clear(); //To empty or clear data in array list
        leave.getDataList().clear(); //To empty or clear all data list
        return true;
    }

    
    boolean fileOvertimeRequest(ArrayList<String> data) {
        localDateTimeNow();
        viewPersonalOvertime();
        
        data.add(2, getDateToday());
        data.add(3, "Overtime");
        data.add("Pending");
        overtime.getDataList().add(data);
        overtime.addDetailsCSV();
       
        data.clear();
        overtime.getDataList().clear();
        return true;
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