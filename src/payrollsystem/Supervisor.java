/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Paul
 */
public class Supervisor extends Employee{
    
    Employee employee = new Employee();
    private ArrayList<ArrayList<String>> data = new ArrayList<>();
    private ArrayList<ArrayList<String>> idAndNames = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    private String selectedName;
    private ArrayList <String> fullName = new ArrayList<>();
    
    Supervisor(){
        super();
    }
    
    void setEmployeeRequest(String filePath){
        employee.setFilePath(filePath);
        employee.retrivedDetails();
    }
    
     void employeeRequest(){
       employee.retrivedDetails();
       for(int i=1; i<employee.getDataList().size(); i++){
          if(employee.getDataList().get(i).get(8).equals("Pending")){
            getNewData().add(employee.getDataList().get(i));
          }
       }
       
   } 
   DefaultTableModel TableData(JTable jTableEmployeeRequest, String selectedItem){
      DefaultTableModel model = (DefaultTableModel) jTableEmployeeRequest.getModel();
        employee.getDataList().clear();
        int tableSize = 0;
        switch (selectedItem) {
            case "Leave Request" -> {
                employee.setFilePath("CSVFiles//LeaveRequests.csv");
                employeeRequest();
                employee.getDataList().clear();
                tableSize = 9;
            }
            case "Overtime Request" -> {
                employee.setFilePath("CSVFiles//OvertimeRequest.csv");
                employeeRequest();
                tableSize = 9;  
            }
            case "All Request" -> {
                employee.setFilePath("CSVFiles//LeaveRequests.csv");
                employeeRequest();
                getDataList().clear();
                employee.setFilePath("CSVFiles//OvertimeRequest.csv");
                employeeRequest();
                employee.getDataList().clear();
                tableSize = 9;
            }
            default -> {
                setFilePath("CSVFiles//AttendanceDatabase.csv");
                employeeRequest();
                tableSize = 6;
            }
        }
           model.setRowCount(0);
           Object rowData[] = new Object [tableSize];

           for(int row=0; row<getNewData().size(); row++){
               for(int i=0; i<rowData.length; i++){
                  rowData[i] = getNewData().get(row).get(i); 
               }
               model.addRow(rowData);
           }
           getNewData().clear();
            return model;
   } 
   
    void getEmployeeNames(){  
        getDataList().clear();
        getNewData().clear();
        fullName.clear();
        setFilePath("CSVFiles//EmployeeDatabase.csv");
        retrivedDetails();
        for(int i=1; i<getDataList().size(); i++){
            ArrayList <String> names = new ArrayList<>();
            names.add(getDataList().get(i).get(0));
            names.add(getDataList().get(i).get(1) + ", "+getDataList().get(i).get(2));
            getIdAndNames().add(names);
            fullName.add(getDataList().get(i).get(1) + ", "+getDataList().get(i).get(2));
        }
           
        Collections.sort(fullName);
        getNewData().add(fullName); 
    }
       

    ArrayList<ArrayList<String>> getDataForDTRTable(){
        employee.getDataList().clear();
        String id = "";
        for(ArrayList<String> idName : getIdAndNames()){
           if(idName.get(1).equals(getSelectedName())){
               id = idName.get(0);
           }
        }
        employee.setFilePath("CSVFiles//AttendanceDatabase.csv");
        employee.retrivedDetails();
        for(int i=1; i<employee.getDataList().size(); i++){
            if(employee.getDataList().get(i).get(0).equals(id) && employee.getDataList().get(i).get(5).equals("Yes") && employee.getDataList().get(i).get(6).equals("No")){
                employee.getDataList().get(i).remove(5);
                employee.getDataList().get(i).remove(5);
                data.add(employee.getDataList().get(i));
            }
        }
        return data;
    }
      
    void updateEmployeeRequestRecord(String command){
        employee.retrivedDetails();
        for(int i=1; i<employee.getDataList().size(); i++){
            if(employee.getDataList().get(i).get(0).equals(list.get(0)) && employee.getDataList().get(i).get(1).equals(list.get(1)) &&
               employee.getDataList().get(i).get(2).equals(list.get(2)) && employee.getDataList().get(i).get(3).equals(list.get(3)) &&
               employee.getDataList().get(i).get(4).equals(list.get(4)) && employee.getDataList().get(i).get(5).equals(list.get(5)) &&
               employee.getDataList().get(i).get(6).equals(list.get(6))){
                  if(command.equals("APPROVED"))
                        employee.getDataList().get(i).set(8, "Approved");
                   else
                        employee.getDataList().get(i).set(8, "Disapproved");
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
                         System.out.println("Not Found : " +employee.getDataList());
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
                System.out.println("Command is: "+command);
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

   void printData(){
       System.out.print("The data is: "+getData());
   }
   void setSelectedName(String selectedName){
       this.selectedName = selectedName;
   }
   String getSelectedName(){
       return this.selectedName;
   }
}
