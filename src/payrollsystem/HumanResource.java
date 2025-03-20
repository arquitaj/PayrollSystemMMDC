/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class HumanResource extends Employee{
    Employee employee = new Employee();
    private String employeeID, selectedName;
    private ArrayList <String> fullName = new ArrayList<>();
    
    HumanResource(String employeeID){
        super();
        this.employeeID = employeeID;
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
        return String.valueOf(tempID+1);
    }
    
    boolean addDetails(ArrayList<String> tempData){
         boolean isComplete = true;
        for(String info : tempData){
            if(info.equals("")){
                JOptionPane.showMessageDialog(null, "Please Complete All The Details!");
                isComplete = false;
                break;
            }
        }
        if(isComplete){
            boolean isValid = true;
            employee.getDataList().clear();
            employee.setFilePath("CSVFiles//EmployeeDatabase.csv");
            employee.retrivedDetails();
            for(int i=1; i<employee.getDataList().size(); i++){
                if(employee.getDataList().get(i).get(1).equals(tempData.get(2)) && employee.getDataList().get(i).get(2).equals(tempData.get(1))){
                    isValid = false;
                    isComplete = false;
                    JOptionPane.showMessageDialog(null, "Cannot Be Add New Employee Due To Employee Already Exist!");
                    break;
                }
            }
            if(isValid){
                employee.getDataList().add(tempData);
                employee.addDetailsCSV();
                JOptionPane.showMessageDialog(null, "Successfuly Added New Employee!");
            }
        }
        return isComplete;
    }
    
    void updateDetails(){
        
    }
    void deleteDetails(){
        
    }
    
    void addNewCredentials(){
        
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
        return employee.getDataList();
    }
    

    void getEmployeeNames(){  
        employee.getDataList().clear();
        employee.getNewData().clear();
        fullName.clear();
        employee.setFilePath("CSVFiles//EmployeeDatabase.csv");
        employee.retrivedDetails();
        for(int i=1; i<employee.getDataList().size(); i++){
            ArrayList <String> names = new ArrayList<>();
            names.add(employee.getDataList().get(i).get(0));
            names.add(employee.getDataList().get(i).get(1) + " "+employee.getDataList().get(i).get(2));
            getIdAndNames().add(names);
            fullName.add(employee.getDataList().get(i).get(1) + " "+employee.getDataList().get(i).get(2));
        }
           
        Collections.sort(fullName);
        getNewData().add(fullName); 
    }
    
    String getID(){
        employee.getDataList().clear();
        String id = "";
        for(ArrayList<String> idName : getIdAndNames()){
           if(idName.get(1).equals(getSelectedName())){
               id = idName.get(0);
           }
        }
        return id;
    }
    
    boolean addNewCredentials(ArrayList<String> tempData){
        boolean isValid = true;
        for(String info : tempData){
            if(info.equals("")){
                isValid = false;
                break;
            }
        }
        if(!isValid){
            JOptionPane.showMessageDialog(null, "Please Provide All The Necessary Information!");
            isValid = false;
        }else{
            employee.getDataList().clear();
            employee.setFilePath("CSVFiles//CredentialsDatabase.csv");
            employee.retrivedDetails();
            for(int i=1; i<employee.getDataList().size(); i++){
                if(tempData.get(0).equals(employee.getDataList().get(i).get(0)) && tempData.get(3).equals(employee.getDataList().get(i).get(3))){
                    JOptionPane.showMessageDialog(null, "Cannot Be Add New Credentials Due To Employee Already Exist With The Same Role!");
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                employee.getDataList().add(tempData);
                employee.addDetailsCSV();
                JOptionPane.showMessageDialog(null, "New Credentials Added!");
            }
        }
        return isValid;
    }
   void setSelectedName(String selectedName){
       this.selectedName = selectedName;
   }
      
   String getSelectedName(){
       return this.selectedName;
   } 
}
