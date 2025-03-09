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
    AccountDetails leave = new AccountDetails();
    AccountDetails overtime = new AccountDetails();
    AccountDetails balance = new AccountDetails();
    AccountDetails payroll = new AccountDetails();
    
    protected int indexAttendance;
    private String filePath;
    private String dateToday, timeNow;
    private String leaveDays;
    private int numberOfDaysLeave = 0;
    private String balanceVL, balanceSL;
    
    Employee(){
        super();
    }
    
    Employee(int employeeID, String filePath) {
        super();
        this.filePath = filePath;
    }
    
    void viewPersonalDetails(){
        accountDetails.setFilePath("CSVFiles//EmployeeDatabase.csv");
        accountDetails.retrivedDetails();
        accountDetails.userDetails();
    }
    
    //To view all personal attendance
    void viewEmployeeAttendance(){
        viewPersonalDetails();
        attendance.setFilePath("CSVFiles//AttendanceDatabase.csv");
        attendance.retrivedDetails();
    }
    
    //To view all Personal Leave Ledger
    void viewPersonalLeaveLedger(){
        leave.setFilePath("CSVFiles//LeaveRequests.csv");
        leave.retrivedDetails();
    }
    
    //To view
     void viewPersonalOvertime(){
        overtime.setFilePath("CSVFiles//OvertimeRequest.csv");
        overtime.retrivedDetails();
    }
     
     void leaveBalances(){
        balance.setFilePath("CSVFiles//LeaveBalances.csv");
        balance.retrivedDetails();
     }
     
     void leaveBalancesInformation(){
         leaveBalances();
         System.out.println("ID : "+accountDetails.getEmployeeID());
          System.out.println("Data : "+balance.getDataList());
         for(int i=1; i<balance.getDataList().size(); i++){
              System.out.println(1);
             if(balance.getDataList().get(i).get(0).equals(String.valueOf(accountDetails.getEmployeeID()))){
                 this.balanceVL = balance.getDataList().get(i).get(1);
                 this.balanceSL = balance.getDataList().get(i).get(2);
                 System.out.println("VL : "+balance.getDataList().get(i).get(1));
                System.out.println("SL : "+balance.getDataList().get(i).get(2));
             }
         }
     }
     
    // To format the Local Time and Date Now
    void localDateTimeNow(){
        LocalDate dateNow = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        this.dateToday = dateFormat.format(dateNow); 
        
        LocalTime time = LocalTime.now();
        this.timeNow = time.getHour()+":"+time.getMinute();
    }
  
    
    //To Validate Attendance first before adding it in CSV
    boolean validateAttendance(String date){
        for (int i=1; i<attendance.getDataList().size(); i++){
            if(Integer.parseInt(attendance.getDataList().get(i).get(0)) == accountDetails.getEmployeeID() && 
                    attendance.getDataList().get(i).get(1).equals(accountDetails.getLastName()+" "+accountDetails.getFirstName()) &&
                    attendance.getDataList().get(i).get(2).equals(date)) {
                
                this.indexAttendance = i;
                return true;
            }
        }
        return false;
    }
    
    //To record the login or time in of the employeee
    void userLogin(){
        viewEmployeeAttendance(); //calling the method
        localDateTimeNow(); // To format the date

        if(validateAttendance(getDateToday())){
            JOptionPane.showMessageDialog(null, "You already made your time-in!!");
        }else{
            String [] newAttendance = {String.valueOf(accountDetails.getEmployeeID()), accountDetails.getEmployeeCompleteName(), getDateToday() , getTimeNow(),"","No", "No"," "};
            ArrayList<String> data = new ArrayList<>();
            data.addAll(Arrays.asList(newAttendance));
            attendance.getDataList().add(data);
            attendance.addDetailsCSV();
        }
       attendance.getDataList().clear();
    }
    
    //To record the logout or time out of the employee
    void userLogout(){
        viewEmployeeAttendance(); //Calling the method    
        localDateTimeNow();
        if(validateAttendance(getDateToday())){
            if(attendance.getDataList().get(indexAttendance).size() == 6){
        
                attendance.getDataList().get(indexAttendance).add(5, getTimeNow());
                attendance.addDetailsCSV();
            }else if (attendance.getDataList().get(indexAttendance).size() > 5 || attendance.getDataList().get(indexAttendance).get(4).equals("")){
                System.out.println("I am inside");
                attendance.getDataList().get(indexAttendance).set(4, getTimeNow());
                attendance.addDetailsCSV();
            }
        }else{
            String [] newAttendance = {String.valueOf(accountDetails.getEmployeeID()), accountDetails.getEmployeeCompleteName(), getDateToday(), "",getTimeNow(),"No", "No",""};
            ArrayList<String> data = new ArrayList<>();
            data.addAll(Arrays.asList(newAttendance));
            attendance.getDataList().add(data);
            attendance.addDetailsCSV(); 
        }
        attendance.getDataList().clear();
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
    //To file new leave request
    boolean fileLeaveRequest(ArrayList<String> data){
        localDateTimeNow();
        viewPersonalLeaveLedger();
        
        data.add(2, getDateToday()); //To insert date filed in index 1 of the arraylist data 
        data.add("Pending");
        leave.getDataList().add(data);
        leave.addDetailsCSV(); //To add all data in the LeaveRequest CSV  
        
        data.clear(); //To empty or clear data in array list
        leave.getDataList().clear(); //To empty or clear all data list
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
    
    public void displayAllRequests(javax.swing.JTable requestTable) {
    // Initialize collections to store both types of requests
    ArrayList<ArrayList<String>> allRequests = new ArrayList<>();
    
    // Load leave requests
    AccountDetails leaveRequests = new AccountDetails();
    leaveRequests.setFilePath("CSVFiles//LeaveRequests.csv");
    leaveRequests.retrivedDetails();
    
    // Filter leave requests for the current employee
        for (int i = 1; i < leaveRequests.getDataList().size(); i++) {
            if (leaveRequests.getDataList().get(i).get(0).equals(String.valueOf(this.accountDetails.getEmployeeID()))) {
                ArrayList<String> requestData = new ArrayList<>();
                requestData.add(leaveRequests.getDataList().get(i).get(2)); // Date Filed
                requestData.add(leaveRequests.getDataList().get(i).get(3)); // Type of Request (Leave Type)
                requestData.add(leaveRequests.getDataList().get(i).get(4)); // Period From
                requestData.add(leaveRequests.getDataList().get(i).get(5)); // Period To
                requestData.add(leaveRequests.getDataList().get(i).get(8)); // Status
                allRequests.add(requestData);
            }
        }

        // Load overtime requests
        AccountDetails overtimeRequests = new AccountDetails();
        overtimeRequests.setFilePath("CSVFiles//OvertimeRequest.csv");
        overtimeRequests.retrivedDetails();

        // Filter overtime requests for the current employee
        for (int i = 1; i < overtimeRequests.getDataList().size(); i++) {
            if (overtimeRequests.getDataList().get(i).get(0).equals(String.valueOf(this.accountDetails.getEmployeeID()))) {
                ArrayList<String> requestData = new ArrayList<>();
                requestData.add(overtimeRequests.getDataList().get(i).get(2)); // Date Filed
                requestData.add("Overtime Request"); // Type of Request
                requestData.add(overtimeRequests.getDataList().get(i).get(4)); // Period From
                requestData.add(overtimeRequests.getDataList().get(i).get(5)); // Period To
                requestData.add(overtimeRequests.getDataList().get(i).get(8)); // Status
                allRequests.add(requestData);
            }
        }

        // Sort all requests by date filed (newest first)
        Collections.sort(allRequests, new Comparator<ArrayList<String>>() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

            @Override
            public int compare(ArrayList<String> request1, ArrayList<String> request2) {
                try {
                    // Compare dates in reverse order (newest first)
                    Date date1 = dateFormat.parse(request1.get(0));
                    Date date2 = dateFormat.parse(request2.get(0));
                    return date2.compareTo(date1);
                } catch (Exception e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        });

        // Clear existing table data
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) requestTable.getModel();
        model.setRowCount(0);

        // Populate table with sorted requests
        for (ArrayList<String> request : allRequests) {
            model.addRow(new Object[] {
                request.get(0),  // Date Filed
                request.get(1),  // Type of Request
                request.get(2),  // Period From
                request.get(3),  // Period To
                request.get(4)   // Status
            });
        }

        // Clear collections after use
        leaveRequests.getDataList().clear();
        overtimeRequests.getDataList().clear();   
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
                System.out.println(formattedDate); //To count the days of leave
            }
            // Move to the next day
            startDate.add(Calendar.DATE, 1);
        }
    }
    
    public boolean displayAttendanceRecords(javax.swing.JTable attendanceTable, Date fromDate, Date toDate) {
        
        viewPersonalDetails();

        // Load attendance data from CSV
        AccountDetails attendance = new AccountDetails();
        attendance.setFilePath("CSVFiles//AttendanceDatabase.csv");
        attendance.retrivedDetails();

        // Create date formatter for comparison
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        // Clear the table model
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) attendanceTable.getModel();
        model.setRowCount(0);

        boolean recordsFound = false;

        try {
            // If no date range specified, set default to current pay period (1-15 or 16-end) ACHK NABOBO AKO DITO
            if (fromDate == null && toDate == null) {
                Calendar today = Calendar.getInstance();
                int currentDay = today.get(Calendar.DAY_OF_MONTH);

                Calendar startCal = Calendar.getInstance();
                Calendar endCal = Calendar.getInstance();

                if (currentDay <= 15) {
                    // First half of the month (1-15)
                    startCal.set(Calendar.DAY_OF_MONTH, 1);
                    endCal.set(Calendar.DAY_OF_MONTH, 15);
                } else {
                    // Second half of the month (16-end)
                    startCal.set(Calendar.DAY_OF_MONTH, 16);
                    endCal.set(Calendar.DAY_OF_MONTH, endCal.getActualMaximum(Calendar.DAY_OF_MONTH));
                }

                fromDate = startCal.getTime();
                toDate = endCal.getTime();
            }

            // Filter attendance records based on employee ID and date range
            for (int i = 1; i < attendance.getDataList().size(); i++) {
                ArrayList<String> record = attendance.getDataList().get(i);

                // Check if this record belongs to the current employee
                if (String.valueOf(this.accountDetails.getEmployeeID()).equals(record.get(0))) {

                    // Parse the record date and check if it's within the date range
                    String recordDateStr = record.get(2);
                    Date recordDate = dateFormat.parse(recordDateStr);

                    // If date is within range
                    if ((fromDate == null && toDate == null) || 
                        (fromDate == null && recordDate.compareTo(toDate) <= 0) ||
                        (toDate == null && recordDate.compareTo(fromDate) >= 0) ||
                        (recordDate.compareTo(fromDate) >= 0 && recordDate.compareTo(toDate) <= 0)) {

                        // Add row to table
                        String login = record.size() > 3 ? record.get(3) : "";
                        String logout = record.size() > 4 ? record.get(4) : "";
                        String submitted = record.size() > 5 ? record.get(5) : "No";
                        String remarks = record.size() > 7 ? record.get(7) : "";

                        model.addRow(new Object[] {
                            recordDateStr,  // Date
                            login,          // Login
                            logout,         // Logout
                            submitted,      // Submitted to supervisor
                            remarks         // Remarks
                        });

                        recordsFound = true;
                    }
                }
            }

            // Sort the table by date (ascending)
            if (recordsFound && attendanceTable.getRowCount() > 0) {
                javax.swing.table.TableRowSorter<javax.swing.table.TableModel> sorter = 
                    new javax.swing.table.TableRowSorter<>(attendanceTable.getModel());
                attendanceTable.setRowSorter(sorter);

                // Sort by date column (index 0)
                java.util.List<javax.swing.RowSorter.SortKey> sortKeys = new ArrayList<>();
                sortKeys.add(new javax.swing.RowSorter.SortKey(0, javax.swing.SortOrder.ASCENDING));
                sorter.setSortKeys(sortKeys);
                sorter.sort();
            }

        } catch (Exception e) {
            System.out.println("Error displaying attendance records: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            // Clear collection after use
            attendance.getDataList().clear();
    }
    
    return recordsFound;

}
    public boolean displayLeaveLedger(javax.swing.JTable leaveTable) {
    //load personal details to ensure we have the employee ID
    viewPersonalDetails();
    
    // Load leave request data
    AccountDetails leaveRequests = new AccountDetails();
    leaveRequests.setFilePath("CSVFiles//LeaveRequests.csv");
    leaveRequests.retrivedDetails();
    
    // Clear the table model
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) leaveTable.getModel();
    model.setRowCount(0);
    
    boolean recordsFound = false;
    
    try {
        // Filter leave request records for the current employee
        for (int i = 1; i < leaveRequests.getDataList().size(); i++) {
            ArrayList<String> record = leaveRequests.getDataList().get(i);
            
            // Check if this record belongs to the current employee and is approved
            if (String.valueOf(this.accountDetails.getEmployeeID()).equals(record.get(0)) && 
                record.get(8).equalsIgnoreCase("Approved")) {
                
                // Get data from the record
                String dateField = record.get(2);   // Date Filed
                String leaveType = record.get(3);   // Type of Leave
                String fromDate = record.get(4);    // Period From
                String toDate = record.get(5);      // Period To
                String numDays = record.get(6);     // Number of Days
                String reason = record.get(7);      // Reason
                String status = record.get(8);      // Status
                
                // Add row to table with the correct columns
                model.addRow(new Object[] {
                    dateField,     // DATE FILED
                    leaveType,     // TYPE OF LEAVE
                    fromDate,      // FROM
                    toDate,        // TO
                    numDays,       // NUMBER OF DAYS
                    reason,        // REASON
                    status         // STATUS
                });
                
                recordsFound = true;
            }
        }
        
        // Sort the table by date (descending - newest first)
        if (recordsFound && leaveTable.getRowCount() > 0) {
            javax.swing.table.TableRowSorter<javax.swing.table.TableModel> sorter = 
                new javax.swing.table.TableRowSorter<>(leaveTable.getModel());
            leaveTable.setRowSorter(sorter);
            
            // Sort by date filed column (index 0)
            java.util.List<javax.swing.RowSorter.SortKey> sortKeys = new ArrayList<>();
            sortKeys.add(new javax.swing.RowSorter.SortKey(0, javax.swing.SortOrder.DESCENDING));
            sorter.setSortKeys(sortKeys);
            sorter.sort();
        }
        
    } catch (Exception e) {
        System.out.println("Error displaying leave ledger: " + e.getMessage());
        e.printStackTrace();
        return false;
    } finally {
        // Clear collection after use
        leaveRequests.getDataList().clear();
    }
    
    return recordsFound;
}

    public void updateLeaveBalanceLabels(javax.swing.JLabel lblVL, javax.swing.JLabel lblSL) {
        // Load personal details to ensure we have the employee ID
        viewPersonalDetails();
    
        // Load leave balances
        leaveBalancesInformation();

        // Update the labels with current balances
        lblVL.setText(getBalanceVL());
        lblSL.setText(getBalanceSL());
}
    ArrayList<ArrayList<String>> viewPersonalPayslip(Date dateFrom, Date dateTo, String id){
        //                String startFormatted = new SimpleDateFormat("MMM d").format(jDateFrom.getDate());
        String fromFormatted = new SimpleDateFormat("MM/dd/yyyy").format(dateFrom);
        String toFormatted = new SimpleDateFormat("MM/dd/yyyy").format(dateTo);
        String datePeriod = fromFormatted + " to " + toFormatted;
        System.out.println("Date period : "+datePeriod);
        ArrayList<ArrayList<String>> tempData = new ArrayList<>();
        int date = dateFrom.compareTo(dateTo);
        if(date > 0){
            JOptionPane.showMessageDialog(null, "Invalid Payroll Period");
        }else{
            payroll.setFilePath("CSVFiles//Payroll.csv");
            payroll.retrivedDetails();
            for(int i=0; i<payroll.getDataList().size(); i++){
                if(payroll.getDataList().get(i).get(0).equals(id) && payroll.getDataList().get(i).get(2).equals(datePeriod) && payroll.getDataList().get(i).get(13).equals("Approved")){
                    tempData.add(payroll.getDataList().get(i));
                    break;
                }
            }
        }
        return tempData;
    }    
    public void updateLeaveRequest() {
    
    }
    
    public void updateOvertimeRequest() {
    
    }
    
    public String getFilePath() {
        return filePath;
    }
    
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    String getDateToday(){
        return dateToday;
    }
    String getTimeNow(){
        return timeNow;
    }
    String getLeaveDays(){
        return leaveDays;
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