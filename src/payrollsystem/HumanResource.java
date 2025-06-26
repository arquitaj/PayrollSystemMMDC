/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
import java.time.format.DateTimeFormatter;


public class HumanResource extends Employee{
    private String employeeID, selectedName;
    private ArrayList <String> fullName = new ArrayList<>();
    
    HumanResource(String employeeID){
        super();
        this.employeeID = employeeID;
    }
    
    ArrayList<ArrayList<String>> displayAllDetails(){
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT e.employee_id, e.last_name, e.first_name, e.birthdate, ad.street, ad.barangay, ad.municipality, ad.city, ad.province, ad.zipcode, \n" +
                        "e.phone_number, id.sss_number, id.philhealth_number, id.tin_number, id.pagibig_number, s.status_name, p.position_name, \n" +
                        "CONCAT(e.last_name, ', ', e.first_name) AS immediate_supervisor,\n" +
                        "sal.basic_salary, sal.rice_subsidy, sal.phone_allowance, sal.clothing_allowance \n" +
                        "FROM employees e JOIN employee_address ad ON e.employee_address_id = ad.employee_address_id \n" +
                        "JOIN compensation_details sal ON e.employee_id = sal.employee_id\n" +
                        "JOIN government_ids id ON e.employee_id = id.employee_id JOIN positions p ON e.position_id = p.position_id\n" +
                        "JOIN employee_statuses s ON e.status_id = s.status_id ORDER BY e.employee_id";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            data = accountDetails.retrivedDetails(statement);
        } catch (SQLException ex) {
            Logger.getLogger(HumanResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    private static int getIdFromLookup(Connection conn, String query) throws SQLException {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new SQLException("Lookup failed: " + query);
            }
        }
    }
    
    ArrayList<ArrayList<String>> nextEmployeeID(){
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT MAX(employee_id + 1) AS greatest_employee_id FROM employees";
            PreparedStatement statement = conn.prepareStatement(sql);
            data = accountDetails.retrivedDetails(statement);
        } catch (SQLException ex) {
            Logger.getLogger(HumanResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    Boolean addEmployeeDetails(ArrayList<String> data){
        boolean isSuccess = false;
        try {
            // 1. Insert into employee_address
            String insertAddress = "INSERT INTO employee_address(street, barangay, municipality, city, province, zipcode) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement psAddress = conn.prepareStatement(insertAddress, Statement.RETURN_GENERATED_KEYS);
            psAddress.setString(1, data.get(5));
            psAddress.setString(2, data.get(6));
            psAddress.setString(3, data.get(7));
            psAddress.setString(4, data.get(8));
            psAddress.setString(5, data.get(9));
            psAddress.setInt(6, Integer.parseInt(data.get(10)));
            psAddress.executeUpdate();
            ResultSet rsAddress = psAddress.getGeneratedKeys();
                if (rsAddress.next()) {
                    int addressId = rsAddress.getInt(1);

                    // 2. Get status_id and position_id
                    int statusId = getIdFromLookup(conn, "SELECT status_id FROM employee_statuses WHERE status_name = 'Regular'");
                    int positionId = getIdFromLookup(conn, "SELECT position_id FROM positions WHERE position_name = 'Account Manager'");

                    // 3. Insert into employees
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                    LocalDate parsedDate = LocalDate.parse(data.get(3), formatter);
                    String insertEmployee = "INSERT INTO employees(status_id, position_id, immediate_supervisor, employee_address_id, first_name, last_name, birthdate, phone_number) " +
                                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement psEmployee = conn.prepareStatement(insertEmployee, Statement.RETURN_GENERATED_KEYS)) {
                        psEmployee.setInt(1, statusId);
                        psEmployee.setInt(2, positionId);
                        psEmployee.setInt(3, Integer.parseInt(data.get(21))); // Supervisor ID
                        psEmployee.setInt(4, addressId);
                        psEmployee.setString(5, data.get(1));
                        psEmployee.setString(6, data.get(2));
                        psEmployee.setDate(7, java.sql.Date.valueOf(parsedDate));
                        psEmployee.setString(8, data.get(4));
                        psEmployee.executeUpdate();
                        
                        ResultSet rsEmp = psEmployee.getGeneratedKeys();
                         if (rsEmp.next()) {
                            int employeeId = rsEmp.getInt(1);

                            // 4. Insert into compensation_details
                            String insertComp = "INSERT INTO compensation_details(employee_id, basic_salary, rice_subsidy, phone_allowance, clothing_allowance, hourly_rate) " +
                                                "VALUES (?, ?, ?, ?, ?, ?)";
                            try (PreparedStatement psComp = conn.prepareStatement(insertComp)) {
                                psComp.setInt(1, employeeId);
                                psComp.setDouble(2, Double.parseDouble(data.get(10)));
                                psComp.setDouble(3, Double.parseDouble(data.get(11)));
                                psComp.setDouble(4, Double.parseDouble(data.get(12)));
                                psComp.setDouble(5, Double.parseDouble(data.get(13)));
                                psComp.setDouble(6, Double.parseDouble(data.get(10))/2);
                                psComp.executeUpdate();
                            }

                            // 5. Insert into government_ids
                            String insertGov = "INSERT INTO government_ids(employee_id, sss_number, philhealth_number, tin_number, pagibig_number) " +
                                               "VALUES (?, ?, ?, ?, ?)";
                            try (PreparedStatement psGov = conn.prepareStatement(insertGov)) {
                                psGov.setInt(1, employeeId);
                                psGov.setString(2, data.get(15));
                                psGov.setInt(3, Integer.parseInt(data.get(16)));
                                psGov.setString(4, data.get(17));
                                psGov.setInt(5, Integer.parseInt(data.get(18)) );
                                psGov.executeUpdate();
                            }
                        }
                    }
                }
                isSuccess = true;
                JOptionPane.showMessageDialog(null, "Successfuly Added New Employee!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(HumanResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSuccess;
    }
    
     ArrayList<ArrayList<String>> retrievedEmploymentStatus(String request){
            ArrayList<ArrayList<String>> data = new ArrayList<>();
            String sql;
        try {
            if(request.equals("status")){
                sql = "SELECT status_name FROM employee_statuses";
            }else{
                sql = "SELECT position_name FROM positions";
            }
           
            PreparedStatement statement = conn.prepareStatement(sql);
            data = accountDetails.retrivedDetails(statement);

        } catch (SQLException ex) {
            Logger.getLogger(HumanResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
     }
     
     ArrayList<ArrayList<String>> retrievedAllCredentials(){
            ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT cr.employee_id, concat(e.last_name, ', ',first_name) as full_name, cr.role " +
                         "FROM credentials cr JOIN employees e ON cr.employee_id = e.employee_id order by employee_id";
            
            PreparedStatement statement = conn.prepareStatement(sql);
            data = accountDetails.retrivedDetails(statement);
        } catch (SQLException ex) {
            Logger.getLogger(HumanResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
     }
     
    Boolean addNewCredentials(ArrayList<String> data){
        boolean isSuccess = false;
        try {
            String sql = "INSERT INTO credentials (employee_id, employee_password, role) "
                    + " VALUES (?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(data.get(0)));
            statement.setString(2, data.get(1));
            statement.setString(3, data.get(2));
            int update = statement.executeUpdate();
            if(update > 0){
                isSuccess = true;
                JOptionPane.showMessageDialog(null, "Successfuly Added New Credentials!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HumanResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isSuccess;
    }
     
    boolean validateDateBirthday(Date dateBirthday){
        boolean isValid = true;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateBirthday);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int days = calendar.get(Calendar.DATE);

        
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        int currentDay = currentDate.getDayOfMonth();
        
        int legalAge = 18;
        int yearDifference = currentYear - year;
        int monthDifference = currentMonth - month;
        int daysDifference = currentDay -days;
        
        if(yearDifference >= legalAge){   // if  5 >= 5;
            if(yearDifference == legalAge){ // 5==5
                if(currentMonth >= month){    // 3>=3
                    if(currentMonth == month){ //3==3
                        if(currentDay >= days) //21 >= 20
                            isValid = true;
                        else
                            isValid = false;
                    }
                }else
                  isValid = true;  
                
            }
        }else
            isValid = false;
        
        return isValid;
    }

    
//    String nextID(){
//        int tempID = 0;
//        employee.getDataList().clear();
//        employee.setFilePath("CSVFiles//EmployeeDatabase.csv");
//        employee.retrivedDetails();
//        employee.getDataList();
//        for(int i=1; i<employee.getDataList().size(); i++){
//            if(tempID < Integer.parseInt(employee.getDataList().get(i).get(0))){
//                tempID = Integer.parseInt(employee.getDataList().get(i).get(0));
//            }
//        }
//        return String.valueOf(tempID+1);
//    }
    
//    boolean addDetails(ArrayList<String> tempData){
//         boolean isComplete = true;
//        for(String info : tempData){
//            if(info.equals("")){
//                JOptionPane.showMessageDialog(null, "Please Complete All The Details!");
//                isComplete = false;
//                break;
//            }
//        }
//        if(isComplete){
//            boolean isValid = true;
//            employee.getDataList().clear();
//            employee.setFilePath("CSVFiles//EmployeeDatabase.csv");
//            employee.retrivedDetails();
//            for(int i=1; i<employee.getDataList().size(); i++){
//                if(employee.getDataList().get(i).get(1).equals(tempData.get(2)) && employee.getDataList().get(i).get(2).equals(tempData.get(1))){
//                    isValid = false;
//                    isComplete = false;
//                    JOptionPane.showMessageDialog(null, "Cannot Be Add New Employee Due To Employee Already Exist!");
//                    break;
//                }
//            }
//            if(isValid){
//                employee.getDataList().add(tempData);
//                employee.addDetailsCSV();
//                JOptionPane.showMessageDialog(null, "Successfuly Added New Employee!");
//            }
//        }
//        return isComplete;
//    }
//    
//    void updateDetails(){
//        
//    }
//    void deleteDetails(){
//        
//    }
//    
//    ArrayList<ArrayList<String>> allCredentials(){
//        employee.getDataList().clear();
//        employee.setFilePath("CSVFiles//CredentialsDatabase.csv");
//        employee.retrivedDetails();
//        ArrayList<ArrayList<String>> tempData = new ArrayList<>();
//        for(int i=1; i<employee.getDataList().size(); i++){
//            employee.getDataList().get(i).remove(2);
//            tempData.add(employee.getDataList().get(i));
//        }
//        
//        return tempData;
//    }

    


//    ArrayList<ArrayList<String>> displayAllCredentials(){
//        employee.getDataList().clear();
//        employee.setFilePath("CSVFiles//CredentialsDatabase.csv");
//        employee.retrivedDetails();
//        employee.getDataList().remove(0);
//        return employee.getDataList();
//    }
//    
//
//    void getEmployeeNames(){  
//        employee.getDataList().clear();
//        employee.getNewData().clear();
//        fullName.clear();
//        employee.setFilePath("CSVFiles//EmployeeDatabase.csv");
//        employee.retrivedDetails();
//        for(int i=1; i<employee.getDataList().size(); i++){
//            ArrayList <String> names = new ArrayList<>();
//            names.add(employee.getDataList().get(i).get(0));
//            names.add(employee.getDataList().get(i).get(1) + " "+employee.getDataList().get(i).get(2));
//            getIdAndNames().add(names);
//            fullName.add(employee.getDataList().get(i).get(1) + " "+employee.getDataList().get(i).get(2));
//        }
//           
//        Collections.sort(fullName);
//        getNewData().add(fullName); 
//    }
//    
//    String getID(){
//        employee.getDataList().clear();
//        String id = "";
//        for(ArrayList<String> idName : getIdAndNames()){
//           if(idName.get(1).equals(getSelectedName())){
//               id = idName.get(0);
//           }
//        }
//        return id;
//    }
//    
//    boolean addNewCredentials(ArrayList<String> tempData){
//        boolean isValid = true;
//        for(String info : tempData){
//            if(info.equals("")){
//                isValid = false;
//                break;
//            }
//        }
//        if(!isValid){
//            JOptionPane.showMessageDialog(null, "Please Provide All The Necessary Information!");
//            isValid = false;
//        }else{
//            employee.getDataList().clear();
//            employee.setFilePath("CSVFiles//CredentialsDatabase.csv");
//            employee.retrivedDetails();
//            for(int i=1; i<employee.getDataList().size(); i++){
//                if(tempData.get(0).equals(employee.getDataList().get(i).get(0)) && tempData.get(3).equals(employee.getDataList().get(i).get(3))){
//                    JOptionPane.showMessageDialog(null, "Cannot Be Add New Credentials Due To Employee Already Exist With The Same Role!");
//                    isValid = false;
//                    break;
//                }
//            }
//            if(isValid){
//                employee.getDataList().add(tempData);
//                employee.addDetailsCSV();
//                JOptionPane.showMessageDialog(null, "New Credentials Added!");
//            }
//        }
//        return isValid;
//    }
   void setSelectedName(String selectedName){
       this.selectedName = selectedName;
   }
      
   String getSelectedName(){
       return this.selectedName;
   } 
}
