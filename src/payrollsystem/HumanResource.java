/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.util.ArrayList;

public class HumanResource extends Employee{
    
    Employee employee = new Employee();
    HumanResource(){
        super();
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
}
