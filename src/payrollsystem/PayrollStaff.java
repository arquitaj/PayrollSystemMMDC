/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.sql.*;
import java.text.DecimalFormat;
import java.time.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;
import payrollsystem.Supervisor;

/**
 *
 * @author Paul
 */
public class PayrollStaff extends Employee implements Payroll{
    private final String employeeID;
    
    private ArrayList<ArrayList<String>> data = new ArrayList<>();
    private String selectedName;
    private double perHour, perMonth, riceSubsidy, phoneAllowance, clothingAllowance, grossPay;
    private double totalTaxContribution, totalSSSContribution, totalPagibigContribution, totalPhilhealthContribution;
    
    public PayrollStaff(String employeeID){
        super();
        this.employeeID = employeeID;
    }
    

    @Override
    public void generatePayslip(){
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT employee_id FROM employees ORDER BY employee_id";
            PreparedStatement statement = conn.prepareStatement(sql);
            data = accountDetails.retrivedDetails(statement);
        } catch (SQLException ex) {
            Logger.getLogger(PayrollStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }


    @Override
    public ArrayList<ArrayList<String>> employeeNames(){  
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT CONCAT(last_name, ', ',first_name) AS full_name FROM employees ORDER BY last_name";
            PreparedStatement statement = conn.prepareStatement(sql);
            data = accountDetails.retrivedDetails(statement);
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Supervisor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
    
    
    
    @Override
     public ArrayList<ArrayList<String>> getDataForDTRTable(String employeeName){
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        try {
            String sql = "SELECT e.employee_id, CONCAT(e.last_name, ' ', e.first_name) AS full_name, " +
                    "ar.attendance_date, ar.login, ar.logout, rs.status " +
                    "FROM attendance_records ar " +
                    "JOIN employees e ON ar.employee_id = e.employee_id " +
                    "JOIN request_status rs ON ar.request_status_id = rs.request_status_id " +
                    "WHERE CONCAT(e.last_name, ', ', e.first_name) = ? AND rs.status = ? ORDER BY attendance_date";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, employeeName);
            statement.setString(2, "Approved");
            data = accountDetails.retrivedDetails(statement);
        } catch (SQLException ex) {
            Logger.getLogger(Supervisor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }
     
     
    public int getEmployeeCount(){
        int count = 0;
        try{
            String query = "SELECT COUNT(employee_id) FROM employees;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                count = result.getInt(1);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return count;
    }
        
   @Override
   public void setSelectedName(String selectedName){
       
   }
}

   