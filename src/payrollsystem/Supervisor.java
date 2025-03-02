/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    
    
    Supervisor(){
        super();
    }
    
    void setEmployeeRequest(String filePath){
        employee.setFilePath(filePath);
        employee.retrivedDetails();
    }
    
    void employeeLeaveRequest(){
        for(int i=1; i<employee.getDataList().size(); i++){
            if(employee.getDataList().get(i).get(8).equals("Pending")){
                employee.getDataList().get(i).remove(6);
                this.data.add(employee.getDataList().get(i));
            }
        }       
    }
    
    void employeeOvertimeRequest(){
        for(int i=1; i<employee.getDataList().size(); i++){
            if(employee.getDataList().get(i).get(7).equals("Pending"))
                this.data.add(employee.getDataList().get(i));       
        }
    }
    DefaultTableModel TableData(JTable jTableEmployeeRequest, String selectedItem){
      DefaultTableModel model = (DefaultTableModel) jTableEmployeeRequest.getModel();
     
        switch (selectedItem) {
            case "Leave Request" -> {
                setEmployeeRequest("CSVFiles//LeaveRequests.csv");
                employeeLeaveRequest();
                employee.getDataList().clear();
            }
            case "Overtime Request" -> {
                setEmployeeRequest("CSVFiles//OvertimeRequest.csv");
                employeeOvertimeRequest();
                employee.getDataList().clear();
            }
            default -> {
                System.out.print("I am here!");
                setEmployeeRequest("CSVFiles//LeaveRequests.csv");
                employeeLeaveRequest();
                employee.getDataList().clear();
                setEmployeeRequest("CSVFiles//OvertimeRequest.csv");
                employeeOvertimeRequest();
                employee.getDataList().clear();
            }
        }
           model.setRowCount(0);
//           if(!getData().isEmpty()){
           Object rowData[] = new Object [8];
           for(int row=0; row<getData().size(); row++){
                  rowData[0] = getData().get(row).get(0);
                  rowData[1] = getData().get(row).get(1);
                  rowData[2] = getData().get(row).get(2);
                  rowData[3] = getData().get(row).get(3);
                  rowData[4] = getData().get(row).get(4);
                  rowData[5] = getData().get(row).get(5);
                  rowData[6] = getData().get(row).get(6);
                  rowData[7] = getData().get(row).get(7);
                  model.addRow(rowData);
                  }
                return model;
   }    
    
      DefaultTableModel TableDTR(JTable jTableDTR, String selectedName){
      DefaultTableModel model = (DefaultTableModel) jTableDTR.getModel();
     
      if(selectedName.equals("")){
          model.setRowCount(0);
         return model;
       }else{
          String id = "";
           for(int i=0; i<getIdAndNames().size(); i++){
               if(getIdAndNames().get(i).get(1).equals(selectedName)){
                   id = getIdAndNames().get(i).get(0);
                   break;
               }
           }
           System.out.print("The id is : "+id);
           setEmployeeRequest("CSVFiles//AttendanceDatabase.csv");
           for(int i=0; i<employee.getDataList().size(); i++){
               if(employee.getDataList().get(i).get(0).equals(id) && employee.getDataList().get(i).get(5).equals("Yes") && employee.getDataList().get(i).get(6).equals("No")){
                   getData().add(employee.getDataList().get(i));
               }
           }
           employee.getDataList().clear();
           model.setRowCount(0);
           Object rowData[] = new Object [6];
           for(int row=0; row<getData().size(); row++){
                  rowData[0] = getData().get(row).get(0);
                  rowData[1] = selectedName;
                  rowData[2] = getData().get(row).get(2);
                  rowData[3] = getData().get(row).get(3);
                  rowData[4] = getData().get(row).get(4);
                  rowData[5] = "";
                  model.addRow(rowData);
                  }         
                return model;
      }
   }    
 
    void approvedEmployeeRequest(String id, String name, String dateFiled, String requestType, String periodFrom, String periodTo, String status, String command){
        switch (requestType){
            case "Overtime":
                setEmployeeRequest("CSVFiles//OvertimeRequest.csv");
                employee.getDataList();
                for(int i=1; i<employee.getDataList().size(); i++){
                    if(employee.getDataList().get(i).get(0).equals(id) && employee.getDataList().get(i).get(1).equals(name) &&
                           employee.getDataList().get(i).get(2).equals(dateFiled) && employee.getDataList().get(i).get(3).equals(requestType) &&
                            employee.getDataList().get(i).get(4).equals(periodFrom) && employee.getDataList().get(i).get(5).equals(periodTo) &&
                            employee.getDataList().get(i).get(7).equals(status)){
                        if(command.equals("APPROVED"))
                            employee.getDataList().get(i).set(7, "Approved");
                        else
                            employee.getDataList().get(i).set(7, "Disapproved");
                        break;
                    }
                }
                employee.addDetailsCSV();
                employee.getDataList().clear();
                break;       
            default:
                setEmployeeRequest("CSVFiles//LeaveRequests.csv");
                employee.getDataList();
                for(int i=1; i<employee.getDataList().size(); i++){
                    if(employee.getDataList().get(i).get(0).equals(id) && employee.getDataList().get(i).get(1).equals(name) &&
                           employee.getDataList().get(i).get(2).equals(dateFiled) && employee.getDataList().get(i).get(3).equals(requestType) &&
                            employee.getDataList().get(i).get(4).equals(periodFrom) && employee.getDataList().get(i).get(5).equals(periodTo) &&
                            employee.getDataList().get(i).get(8).equals(status)){
                        if(command.equals("APPROVED"))
                            employee.getDataList().get(i).set(8, "Approved");
                        else
                            employee.getDataList().get(i).set(8, "Disapproved");
                        break;
                    }
                }
                employee.addDetailsCSV();
                employee.getDataList().clear();
                break;
        }
    }
    
    void getEmployeeNames(){   
        setEmployeeRequest("CSVFiles//EmployeeDatabase.csv");
        ArrayList <String> fullName = new ArrayList<>();
        for(int i=1; i<employee.getDataList().size(); i++){
            ArrayList <String> names = new ArrayList<>();
            names.add(employee.getDataList().get(i).get(0));
            names.add(employee.getDataList().get(i).get(1) + ", "+employee.getDataList().get(i).get(2));
            getIdAndNames().add(names);
            fullName.add(employee.getDataList().get(i).get(1) + ", "+employee.getDataList().get(i).get(2));
        }
           
        Collections.sort(fullName);
        getData().add(fullName); 
    }

   ArrayList<ArrayList<String>> getIdAndNames(){
       return this.idAndNames;
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
}
