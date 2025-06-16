/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class Employee extends AccountDetails {
    
    AccountDetails accountDetails = new AccountDetails();
    AccountDetails attendance = new AccountDetails();
    AccountDetails overtime = new AccountDetails();
    AccountDetails balance = new AccountDetails();
    AccountDetails payroll = new AccountDetails();
    AccountDetails dbConnection = new AccountDetails();
    
    
    private int employeeID;
    protected int indexAttendance;
    private String filePath;
    private String leaveDays;
    private int numberOfDaysLeave = 0;
    private String balanceVL, balanceSL;
    
    Employee(){
        super();
    }
    
   
    void viewPersonalDetails(String employeeID){
        this.employeeID = Integer.parseInt(employeeID);
//        accountDetails.getDataList().clear();
//        accountDetails.setFilePath("CSVFiles//EmployeeDatabase.csv");
//        accountDetails.retrivedDetails();
//        accountDetails.userDetails(employeeID);
        String sql = "SELECT e.employee_id, e.first_name, e.last_name, e.birthdate, e.phone_number,ad.street, ad.barangay, ad.city, ad.province, ad.zipcode,\n" +
"    sal.basic_salary, sal.rice_subsidy, sal.phone_allowance, sal.clothing_allowance,id.philhealth_number, id.sss_number, id.tin_number, id.pagibig_number,\n" +
"    p.position_name, s.status_name FROM employees e JOIN employee_address ad ON e.employee_address_id = ad.employee_address_id JOIN compensation_details sal ON e.employee_id = sal.employee_id\n" +
"    JOIN government_ids id ON e.employee_id = id.employee_id JOIN positions p ON e.position_id = p.position_id JOIN employee_statuses s ON e.status_id = s.status_id WHERE e.employee_id = ?";
        accountDetails.retrivedUserDetails(this.employeeID, sql);
    }
    
    //To view
     void viewPersonalOvertime(){
        overtime.setFilePath("CSVFiles//OvertimeRequest.csv");
        overtime.retrivedDetails();
    }

     
     void leaveBalancesInformation(){
         accountDetails.getDataList().clear();
         accountDetails.setFilePath("CSVFiles//LeaveBalances.csv");
         accountDetails.retrivedDetails();
         for(int i=1; i<accountDetails.getDataList().size(); i++){
             if(accountDetails.getDataList().get(i).get(0).equals(accountDetails.getEmployeeID())){
                 this.balanceVL = accountDetails.getDataList().get(i).get(1);
                 this.balanceSL = accountDetails.getDataList().get(i).get(2);
             }
         }
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
    
    ArrayList<ArrayList<String>> getDataAllRequests() {
        accountDetails.getDataList().clear();
        ArrayList<ArrayList<String>> tempData = new ArrayList<>();
        accountDetails.setFilePath("CSVFiles//LeaveRequests.csv");
        accountDetails.retrivedDetails("employees");
        for(int i=0; i<accountDetails.getDataList().size(); i++){
            if(accountDetails.getDataList().get(i).get(0).equals(accountDetails.getEmployeeID()) && accountDetails.getDataList().get(i).get(8).equals("Pending")){
                ArrayList<String> data = new ArrayList<>();
                data.add(accountDetails.getDataList().get(i).get(2)); // Date Filed
                data.add(accountDetails.getDataList().get(i).get(3)); // Type of Request (Leave Type)
                data.add(accountDetails.getDataList().get(i).get(4)); // Period From
                data.add(accountDetails.getDataList().get(i).get(5)); // Period To
                data.add(accountDetails.getDataList().get(i).get(6)); // Number of days
                data.add(accountDetails.getDataList().get(i).get(7)); // Reason
                data.add(accountDetails.getDataList().get(i).get(8)); // Status
                tempData.add(data);
            }
        }

        accountDetails.getDataList().clear();
        accountDetails.setFilePath("CSVFiles//OvertimeRequest.csv");
        accountDetails.retrivedDetails();
        for(int i=0; i<accountDetails.getDataList().size(); i++){
            if(accountDetails.getDataList().get(i).get(0).equals(accountDetails.getEmployeeID()) && accountDetails.getDataList().get(i).get(8).equals("Pending")){
                ArrayList<String> data = new ArrayList<>();
                data.add(accountDetails.getDataList().get(i).get(2)); // Date Filed
                data.add(accountDetails.getDataList().get(i).get(3)); // Type of Request (Leave Type)
                data.add(accountDetails.getDataList().get(i).get(4)); // Period From
                data.add(accountDetails.getDataList().get(i).get(5)); // Period To
                data.add(accountDetails.getDataList().get(i).get(6)); // Number of days
                data.add(accountDetails.getDataList().get(i).get(7)); // Reason
                data.add(accountDetails.getDataList().get(i).get(8)); // Status
                tempData.add(data);
            }
        }
        return tempData;
    }
    
    void viewPersonalDTR(Date dateFrom, Date dateTo){
         SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
 
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.setTime(dateFrom);
        endDate.setTime(dateTo);
        while(!startDate.after(endDate)){
            Date currentDate = startDate.getTime();
            if (startDate.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                String formattedDate = formatter.format(currentDate);
            }
            // Move to the next day
            startDate.add(Calendar.DATE, 1);
        }
    }
    
    ArrayList<ArrayList<String>> getDataAllDTR(Date fromDate, Date toDate) {
        accountDetails.getDataList().clear();
        accountDetails.setFilePath("CSVFiles//AttendanceDatabase.csv");
        accountDetails.retrivedDetails();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar start = Calendar.getInstance();
        start.setTime(fromDate);
        
        Calendar end = Calendar.getInstance();
        end.setTime(toDate);
        ArrayList<ArrayList<String>> tempData = new ArrayList<>();
        // Loop through each day from fromDate to toDate
        while (!start.after(end)) {
            // Print the current date in your desired format (e.g., "MMM d, yyyy")
            for(int i=1; i<accountDetails.getDataList().size(); i++){
                if(accountDetails.getDataList().get(i).get(0).equals(accountDetails.getEmployeeID()) 
                        && accountDetails.getDataList().get(i).get(2).equals(dateFormat.format(start.getTime()))){
                    ArrayList<String> data = new ArrayList<>();
                    data.add(accountDetails.getDataList().get(i).get(2));
                    data.add(accountDetails.getDataList().get(i).get(3));
                    data.add(accountDetails.getDataList().get(i).get(4));
                    data.add(accountDetails.getDataList().get(i).get(5));
                    data.add(accountDetails.getDataList().get(i).get(7));
                    tempData.add(data);
                    break;
                }
            }
            // Increment the day by one
            start.add(Calendar.DAY_OF_MONTH, 1);
        }
        
        
        
        return tempData;
}
    ArrayList<ArrayList<String>> allApprovedPersonalLeaveLedger() {
        //load personal details to ensure we have the employee ID
        accountDetails.getDataList().clear();
        accountDetails.setFilePath("CSVFiles//LeaveRequests.csv");
        accountDetails.retrivedDetails();
        ArrayList<ArrayList<String>> tempData = new ArrayList<>();
        for(int i=1; i<accountDetails.getDataList().size(); i++){

            if(accountDetails.getDataList().get(i).get(0).equals(accountDetails.getEmployeeID()) && accountDetails.getDataList().get(i).get(8).equals("Approved")){
                String [] list = {accountDetails.getDataList().get(i).get(2), accountDetails.getDataList().get(i).get(3),accountDetails.getDataList().get(i).get(4),
                        accountDetails.getDataList().get(i).get(5),accountDetails.getDataList().get(i).get(6), accountDetails.getDataList().get(i).get(7), 
                        accountDetails.getDataList().get(i).get(8)
                };
                ArrayList<String> row = new ArrayList<>();
                row.addAll(Arrays.asList(list));
                tempData.add(row);
            }
        }
    return tempData;
}

    public void updateLeaveBalanceLabels(javax.swing.JLabel lblVL, javax.swing.JLabel lblSL) {
        // Load personal details to ensure we have the employee ID
    
        // Load leave balances
        leaveBalancesInformation();

        // Update the labels with current balances
        lblVL.setText(getBalanceVL());
        lblSL.setText(getBalanceSL());
}
    ArrayList<ArrayList<String>> viewPersonalPayslip(Date dateFrom, Date dateTo, String id){
        accountDetails.getDataList().clear();
        ArrayList<ArrayList<String>> tempData = new ArrayList<>();
        if(dateFrom == null || dateTo == null){
            JOptionPane.showMessageDialog(null, "Please Provide Payroll Period!");
        }else{
            String fromFormatted = new SimpleDateFormat("MM/dd/yyyy").format(dateFrom);
            String toFormatted = new SimpleDateFormat("MM/dd/yyyy").format(dateTo);
            String datePeriod = fromFormatted + " to " + toFormatted;
            int date = dateFrom.compareTo(dateTo);
            if(date > 0){
                JOptionPane.showMessageDialog(null, "Invalid Payroll Period");
            }else{
                accountDetails.setFilePath("CSVFiles//Payroll.csv");
                accountDetails.retrivedDetails();
                for(int i=0; i<accountDetails.getDataList().size(); i++){
                    if(accountDetails.getDataList().get(i).get(0).equals(id) && accountDetails.getDataList().get(i).get(2).equals(datePeriod) && accountDetails.getDataList().get(i).get(13).equals("Approved")){
                        tempData.add(accountDetails.getDataList().get(i));
                        break;
                    }
                }
            }
        }
        return tempData;
    }    
    
    void forwardDTRToSupervisor(ArrayList<ArrayList <String>> tempData){
        accountDetails.getDataList().clear();
        accountDetails.setFilePath("CSVFiles//AttendanceDatabase.csv");
        accountDetails.retrivedDetails();
        for(int i=0; i<tempData.size(); i++){
            for(int j=0; j<accountDetails.getDataList().size(); j++){
                if(accountDetails.getDataList().get(j).get(0).equals(accountDetails.getEmployeeID()) && tempData.get(i).get(0).equals(accountDetails.getDataList().get(j).get(2)) &&
                       tempData.get(i).get(1).equals(accountDetails.getDataList().get(j).get(5)) ){
                    accountDetails.getDataList().get(j).set(5, "Yes");
                    break;
                }
            }
        }
        accountDetails.addDetailsCSV();
    }
        
    public void updateLeaveRequest() {
    
    }
    
    public void updateOvertimeRequest() {
    
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