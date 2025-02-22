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
import javax.swing.JOptionPane;

public class Employee extends AccountDetails {
    
    AccountDetails accountDetails = new AccountDetails();
    AccountDetails attendance = new AccountDetails();
    protected int indexAttendance;
    
    Employee(){
        super();
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
   
}
