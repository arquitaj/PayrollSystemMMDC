/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Paul
 */
public class Supervisor extends Employee{
    private String employeeID;
    Employee employee = new Employee(this.employeeID);
    private ArrayList<ArrayList<String>> data = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    private String selectedName;
    private ArrayList <String> fullName = new ArrayList<>();
  
    Supervisor(String employeeID){
        this.employeeID = employeeID;
        super();  
    }
    
   ArrayList<ArrayList<String>> employeeRequest(String selectedItem){
       ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sqlForLeave = "SELECT e.employee_id, CONCAT(e.first_name, ' ', e.last_name) AS full_name, ll.date_filed, " +
                                "lt.leave_type, ll.leave_from, ll.leave_to, ll.number_of_days, ll.reason, rs.status " +
                                "FROM employees e " +
                                "JOIN leave_ledger ll ON e.employee_id = ll.employee_id " +
                                "JOIN leave_type lt ON ll.leave_type_id = lt.leave_type_id " +
                                "JOIN request_status rs ON ll.request_status_id = rs.request_status_id " +
                                "WHERE rs.status = ? AND e.immediate_supervisor = ? ORDER BY employee_id";
            
            String sqlForOvertime = "SELECT e.employee_id, CONCAT(e.first_name, ' ', e.last_name) AS full_name, eo.date_filed, " +
                                    "'Overtime' AS overtime, eo.overtime_from, eo.overtime_to, eo.number_of_days, eo.reason, rs.status " +
                                    "FROM employees e " +
                                    "JOIN overtime_requests eo ON e.employee_id = eo.employee_id " +
                                    "JOIN request_status rs ON eo.request_status_id = rs.request_status_id " +
                                    "WHERE rs.status = ? AND e.immediate_supervisor = ? ORDER BY employee_id";

             String combinedSql = "SELECT e.employee_id, CONCAT(e.first_name, ' ', e.last_name) AS full_name, ll.date_filed, lt.leave_type AS request_type, " +
                                    "ll.leave_from AS from_time, ll.leave_to AS to_time, ll.number_of_days, ll.reason, rs.status " +
                                    "FROM employees e " +
                                    "JOIN leave_ledger ll ON e.employee_id = ll.employee_id " +
                                    "JOIN leave_type lt ON ll.leave_type_id = lt.leave_type_id " +
                                    "JOIN request_status rs ON ll.request_status_id = rs.request_status_id " +
                                    "WHERE rs.status = ? AND e.immediate_supervisor = ? " +
                                    "UNION ALL " +
                                    "SELECT e.employee_id, CONCAT(e.first_name, ' ', e.last_name) AS full_name, eo.date_filed, 'Overtime' AS request_type, " +
                                    "eo.overtime_from AS from_time, eo.overtime_to AS to_time, eo.number_of_days, eo.reason, rs.status " +
                                    "FROM employees e " +
                                    "JOIN overtime_requests eo ON e.employee_id = eo.employee_id " +
                                    "JOIN request_status rs ON eo.request_status_id = rs.request_status_id " +
                                    "WHERE rs.status = ? AND e.immediate_supervisor = ? ORDER BY employee_id";
             
            switch (selectedItem){
                case "Leave Request":
                    PreparedStatement leaveStatement = conn.prepareStatement(sqlForLeave);
                    leaveStatement.setString(1, "Pending");
                    leaveStatement.setInt(2, Integer.parseInt(this.employeeID));
                    data = accountDetails.retrivedDetails(leaveStatement);
                    break;
                case "Overtime Request":
                    PreparedStatement overtimeStatement = conn.prepareStatement(sqlForOvertime);
                    overtimeStatement.setString(1, "Pending");
                    overtimeStatement.setInt(2, Integer.parseInt(this.employeeID));
                    data = accountDetails.retrivedDetails(overtimeStatement);
                    break;
                default :
                    PreparedStatement combineStatement = conn.prepareStatement(combinedSql);
                    combineStatement.setString(1, "Pending");
                    combineStatement.setInt(2, Integer.parseInt(this.employeeID));
                    combineStatement.setString(3, "Pending");
                    combineStatement.setInt(4, Integer.parseInt(this.employeeID));
                    data = accountDetails.retrivedDetails(combineStatement);
                    break;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Supervisor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
   }  
    

    ArrayList<ArrayList<String>> employeeNames(){  
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT CONCAT(last_name, ', ',first_name) AS full_name FROM employees WHERE immediate_supervisor = ? ORDER BY full_name";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(this.employeeID));
            data = accountDetails.retrivedDetails(statement);
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Supervisor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
       
    
     ArrayList<ArrayList<String>> getDataForDTRTable(String employeeName){
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT e.employee_id, CONCAT(e.last_name, ' ', e.first_name) AS full_name, " +
                    "ar.attendance_date, ar.login, ar.logout, rs.status " +
                    "FROM attendance_records ar " +
                    "JOIN employees e ON ar.employee_id = e.employee_id " +
                    "JOIN request_status rs ON ar.request_status_id = rs.request_status_id " +
                    "WHERE e.immediate_supervisor = ? AND CONCAT(e.last_name, ', ', e.first_name) = ? AND rs.status = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(this.employeeID));
            statement.setString(2, employeeName);
            statement.setString(3, "Pending");
            data = accountDetails.retrivedDetails(statement);
        } catch (SQLException ex) {
            Logger.getLogger(Supervisor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
     

   //Hereunder Codes are not yet modified  
     
    void updateEmployeeRequestRecord(String command){
        employee.retrivedDetails();
        for(int i=1; i<employee.getDataList().size(); i++){
            if(employee.getDataList().get(i).get(0).equals(list.get(0)) && employee.getDataList().get(i).get(1).equals(list.get(1)) &&
               employee.getDataList().get(i).get(2).equals(list.get(2)) && employee.getDataList().get(i).get(3).equals(list.get(3)) &&
               employee.getDataList().get(i).get(4).equals(list.get(4)) && employee.getDataList().get(i).get(5).equals(list.get(5)) &&
               employee.getDataList().get(i).get(6).equals(list.get(6))){
                  if(command.equals("APPROVED")){
                        employee.getDataList().get(i).set(8, "Approved");
                        JOptionPane.showMessageDialog(null, "Successfuly Approved Request!");
                  } else{
                        employee.getDataList().get(i).set(8, "Disapproved");
                        JOptionPane.showMessageDialog(null, "Successfuly Disapproved Request!");
                  }
            return;
            }
        }
    }
    
    void updateAttendanceForRequest(String request){
        ArrayList<String> row = new ArrayList<>();
        employee.getDataList().clear();
        getData().clear();
        
        employee.setFilePath("CSVFiles//AttendanceDatabase.csv");
        
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dateFrom = LocalDate.parse(list.get(4), dateFormat);  // Parse the input date strings into LocalDate objects
        LocalDate dateTo = LocalDate.parse(list.get(5), dateFormat);    
        List<LocalDate> dates = new ArrayList<>();
        
        for (LocalDate date = dateFrom; !date.isAfter(dateTo); date = date.plusDays(1)) {
            dates.add(date);
        }
        if(request.equals("Leave")){
            for (LocalDate date : dates) {
                employee.retrivedDetails();
                DayOfWeek dayOfWeek = date.getDayOfWeek();
                if(!dayOfWeek.toString().equals("SUNDAY")){
                      String [] newAttendanceForLeave = {list.get(0),list.get(1),dateFormat.format(date)," "," ","No","No","With Approved Leave"};
                      row.addAll(Arrays.asList(newAttendanceForLeave));
                      employee.getDataList().add(row);
                      employee.addDetailsCSV();
                      row.clear();
                      employee.getDataList().clear();
                }
                employee.getDataList().clear();
            }
        }else if(request.equals("Overtime")){
            employee.retrivedDetails();
            for(LocalDate date : dates){
                boolean isFound = false;
                if(!date.getDayOfWeek().toString().equals("SUNDAY")){
                    for(int i=1; i<employee.getDataList().size(); i++){
                        if(list.get(0).equals(employee.getDataList().get(i).get(0)) && dateFormat.format(date).equals(employee.getDataList().get(i).get(2))){
                            employee.getDataList().get(i).set(7, "With Approved Overtime");
                            isFound = true;
                            break;
                        }
                    }
                    if(!isFound){
                         String [] newOvertime = {list.get(0),list.get(1),dateFormat.format(date)," "," ","No","No","With Approved Overtime"};
                         row.addAll(Arrays.asList(newOvertime));
                         employee.getDataList().add(row);
                         row.clear();
                    }      
                }
            }
             employee.addDetailsCSV();
        }
        employee.getDataList().clear();
    }
    
    void forwardDTR(ArrayList<ArrayList <String>> tempData){
        employee.getDataList().clear();
        employee.setFilePath("CSVFiles//AttendanceDatabase.csv");
        employee.retrivedDetails();
        for(int i=0; i<tempData.size(); i++){
            for(int j=0; j<employee.getDataList().size(); j++){
                if(tempData.get(i).get(0).equals(employee.getDataList().get(j).get(0)) && tempData.get(i).get(1).equals(employee.getDataList().get(j).get(1)) &&
                        tempData.get(i).get(2).equals(employee.getDataList().get(j).get(2)) && tempData.get(i).get(3).equals(employee.getDataList().get(j).get(3)) &&
                        tempData.get(i).get(4).equals(employee.getDataList().get(j).get(4))){
                    employee.getDataList().get(j).set(6, "Yes");
                    break;
                }
            }
        }
        employee.addDetailsCSV();
    }
    
    void approvedEmployeeRequest(String command){
        employee.getDataList().clear();
        switch (list.get(3)){
            case "Overtime":
                employee.setFilePath("CSVFiles//OvertimeRequest.csv");
                updateEmployeeRequestRecord(command);
                employee.addDetailsCSV();
                updateAttendanceForRequest("Overtime");
                employee.getDataList().clear();
                list.clear();
                break;
            default:
                int numberOfLeave = Integer.parseInt(String.valueOf(list.get(6)));
                int leaveBalance = 0;
                boolean canLeave = false;
                if(command.equals("APPROVED")){
                    employee.setFilePath("CSVFiles//LeaveBalances.csv");
                    employee.retrivedDetails();
                    for(int i=1; i<employee.getDataList().size(); i++){
                        if(list.get(0).equals(employee.getDataList().get(i).get(0))){
                            if(list.get(3).equals("Vacation Leave")){
                                leaveBalance = Integer.parseInt(employee.getDataList().get(i).get(1));
                                if(leaveBalance >= numberOfLeave){
                                    employee.getDataList().get(i).set(1, String.valueOf(leaveBalance-numberOfLeave));
                                    employee.addDetailsCSV();
                                    canLeave = true;
                                    updateAttendanceForRequest("Leave");
                                }else{
                                    JOptionPane.showMessageDialog(null, "Insufficient Leave Balance!" );
                                }
                                break; 
                            }else{
                                leaveBalance = Integer.parseInt(employee.getDataList().get(i).get(2));
                                if(leaveBalance >= numberOfLeave){
                                    employee.getDataList().get(i).set(2, String.valueOf(leaveBalance-numberOfLeave));
                                    employee.addDetailsCSV();
                                    canLeave = true;
                                    updateAttendanceForRequest("Leave");
                                 }else{
                                    JOptionPane.showMessageDialog(null, "Insufficient Leave Balance!" );
                                }
                                break;
                            }
                        }
                    } 
                }else{
                    canLeave = true;
                }
                
                if(canLeave){
                    employee.setFilePath("CSVFiles//LeaveRequests.csv");
                    updateEmployeeRequestRecord(command);
                    employee.addDetailsCSV();
                    employee.getDataList().clear();
                    list.clear();
                }
                break;
        }
    }
    

   ArrayList<ArrayList<String>> getData(){
       return this.data;
   }
   void setData(){
       this.data.clear();
   }

   void setSelectedName(String selectedName){
       this.selectedName = selectedName;
   }
   String getSelectedName(){
       return this.selectedName;
   }
}
