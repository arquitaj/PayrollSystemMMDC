/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class HumanResource extends Employee{
    Employee employee = new Employee();
    private String employeeID;
    
    HumanResource(String employeeID){
        super();
        this.employeeID = employeeID;
    }
    
    
    void addDetails(){
        
    }
    void updateDetails(){
        
    }
    void deleteDetails(){
        
    }
    
    ArrayList<ArrayList<String>> displayAllDetails(){
        employee.getDataList().clear();
        employee.setFilePath("CSVFiles//EmployeeDatabase.csv");
        employee.retrivedDetails();
        employee.getDataList().remove(0);
        return employee.getDataList();
    }
    
    void displayLeaveLedger(){
        
    }
    void displayPayrollHistory(){
        
    }
    void displayEmployeeRequest(){
        
    }
    ArrayList<ArrayList<String>> displayAllCredentials(){
        employee.getDataList().clear();
        employee.setFilePath("CSVFiles//CredentialsDatabase.csv");
        employee.retrivedDetails();
        employee.getDataList().remove(0);
        System.out.println(employee.getDataList());
        return employee.getDataList();
    }
    
    String nextID(){
        int tempID = 0;
        employee.getDataList().clear();
        employee.setFilePath("CSVFiles//EmployeeDatabase.csv");
        employee.retrivedDetails();
        employee.getDataList();
        for(int i=1; i<employee.getDataList().size(); i++){
            if(tempID < Integer.parseInt(employee.getDataList().get(i).get(0))){
                tempID = Integer.parseInt(employee.getDataList().get(i).get(0));
            }
        }
        System.out.println("Temp ID : "+tempID);
        return String.valueOf(tempID+1);
    }
    
    void addNewEmployee(ArrayList<String> tempData){
        employee.getDataList().clear();
        employee.setFilePath("CSVFiles//EmployeeDatabase.csv");
        employee.retrivedDetails();
        employee.getDataList().add(tempData);
        employee.addDetailsCSV();
        JOptionPane.showMessageDialog(null, "Successfuly Added New Employee!");
    }
}
