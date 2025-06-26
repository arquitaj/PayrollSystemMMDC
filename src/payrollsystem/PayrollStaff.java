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
 
    PayrollStaff(String employeeID){
        super();
        this.employeeID = employeeID;
    }

    @Override
    public double taxCalculation(double totalDeductions){
        double taxableIncome = perMonth - totalDeductions;
        double totalTax = 0;
        if(perMonth < 20832)
            totalTax = 0;
        else if(perMonth >= 20833 && perMonth < 33333)
            totalTax = (taxableIncome - 20833) * 0.20;
        else if(perMonth >= 33333 && perMonth < 66667)
            totalTax = ((taxableIncome - 33333) * 0.20) + 2500;
        else if(perMonth >= 66667 && perMonth < 166667)
            totalTax = ((taxableIncome - 66667) * 0.30) + 10833;
        else if(perMonth >= 166667 && perMonth < 666667)
            totalTax = ((taxableIncome - 166667) * 0.32) + 40833.33;
        else if(perMonth >= 666667)
            totalTax = ((taxableIncome - 666667) * 0.35) + 200833.33;
        
        return Math.round(totalTax * 100.0) / 100.0;
    }
    @Override
    public double sssCalculation(){
        double basicRange = 3250;
        double contribution = 22.50;
        int count = 0;
        
        while(grossPay > basicRange){
            basicRange += 500;
            count++;
        }
        double totalContribution = Math.round(((count * contribution) + 135) * 100.0) / 100.0;
        return totalContribution;
    }
    @Override
    public double philhealthCalculation(){
        return perMonth * PHILHEALTH_PERCENT;
    }
    @Override
    public double pagibigCalculation(){
//        double monthlyRate = (perHour * 8) * 21;
        double totalDeduction = 0;
        if(perMonth >= 1000 && perMonth <= 1500){
            totalDeduction = perMonth * 0.01;
        }if(perMonth > 1500){
            totalDeduction = perMonth * 0.02;
        }
        return Math.round(totalDeduction * 100.0) / 100.0;
    }
    @Override
    public double deductionCalculation(ArrayList<ArrayList<String>> perEmployeeAttendance){
        return 2;
    }
    @Override
    public double grossCalculation(ArrayList<ArrayList<String>> perEmployeeAttendance){
        for(int i=0; i<data.size(); i++){
            if(data.get(i).get(0).equals(perEmployeeAttendance.get(0).get(0))){
                this.riceSubsidy = Double.parseDouble(data.get(i).get(3)); //Rate per hour
                this.phoneAllowance = Double.parseDouble(data.get(i).get(4)); //Rate per hour
                this.clothingAllowance = Double.parseDouble(data.get(i).get(5)); //Rate per hour
                this.perHour = Double.parseDouble(data.get(i).get(6)); //Rate per hour 
                this.perMonth = Double.parseDouble(data.get(i).get(7));
            }
        }
        this.grossPay = (this.perHour * 8) * perEmployeeAttendance.size();
        return grossPay;
    }
    @Override
    public double benefitsCalculation(){
        return (riceSubsidy + phoneAllowance + clothingAllowance);
    }
    @Override
    public double netPayrollCalculations(double gross, double benefits, double overtime, double undertime, double totalDeductions){
        double netPay = (gross+benefits+overtime)-(undertime+totalDeductions);  
        return Math.round(netPay * 100.0) / 100.0; 
    }
    
    @Override
    public double overtimeCalculations(ArrayList<ArrayList<String>> perEmployeeAttendance){
        long minutesDifference = 0;
        for(int i=0; i<perEmployeeAttendance.size(); i++){
            if(perEmployeeAttendance.get(i).get(7).equals("With Approved Overtime")){
                String time1 = "17:00";
                String time2 = perEmployeeAttendance.get(i).get(4);

                // Convert strings to LocalTime
                LocalTime timeStart = LocalTime.parse(time1);
                LocalTime timeEnd = LocalTime.parse(time2);

                LocalTime cutOffTime = LocalTime.of(17, 0);
                if(timeEnd.isAfter(cutOffTime)){
                    Duration overtime = Duration.between(cutOffTime, timeEnd); // Calculate overtime duration
                    minutesDifference += overtime.toMinutes(); // Get overtime in minutes
                } 
            }
        }
 
        return Math.round((minutesDifference * (perHour/60)) * 100.0) / 100.0;
    }
    @Override
    public double undertimeCalculations(ArrayList<ArrayList<String>> perEmployeeAttendance){
        
        double minutesDifference = 0;
        String timeInMorning = "08:00";
        String timeOutAfternoon = "17:00";
        for(int i=0; i<perEmployeeAttendance.size(); i++){
            String employeeLogin = perEmployeeAttendance.get(i).get(3);
            String employeeLogout = perEmployeeAttendance.get(i).get(4);
            // Convert strings to LocalTime
            LocalTime timeStart = LocalTime.parse(timeInMorning);
            LocalTime timeEnd = LocalTime.parse(timeOutAfternoon);
            LocalTime employeeStart = LocalTime.parse(employeeLogin);
            LocalTime employeeEnd = LocalTime.parse(employeeLogout);

            // Compute undertime if actual time out is before 17:00
           if (employeeEnd.isBefore(timeEnd)) {
               Duration undertime = Duration.between(employeeEnd, timeEnd);
               minutesDifference += undertime.toMinutes(); // Convert to minutes
           }
           // Compute if the employee is late based on actual time in
           if (employeeStart.isAfter(timeStart)) {
               Duration lateTime = Duration.between(timeStart, employeeStart);
               minutesDifference += lateTime.toMinutes(); // Convert to minutes
           }
        }
         DecimalFormat df = new DecimalFormat("#.00");
        return Math.round((minutesDifference * (perHour/60)) * 100.0) / 100.0;
    }




    ArrayList<ArrayList<String>> employeeNames(){  
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
    
    
    
     ArrayList<ArrayList<String>> getDataForDTRTable(String employeeName){
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
     

   void setSelectedName(String selectedName){
       
   }
}

   






















     // Helper method to print all the days in the period
//     ArrayList<String> daysInPeriod(Date startDate, Date endDate, SimpleDateFormat sdf) {
//        ArrayList<String> payrollDates = new ArrayList<>();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(startDate);
//        
//        // Loop through each day in the period and print it
//        while (!calendar.getTime().after(endDate)) {
//            payrollDates.add(sdf.format(calendar.getTime()));
//            calendar.add(Calendar.DAY_OF_MONTH, 1); // Move to the next day
//        }
//        return payrollDates;
//    }
     
//    String computePayroll(){
//        employee.getDataList().clear();
//        ArrayList<String> payrollDates = new ArrayList<>();
//        data.clear();
//        employee.setFilePath("CSVFiles//EmployeeDatabase.csv");
//        employee.retrivedDetails();
//        for(int i=1; i<employee.getDataList().size(); i++){
//            ArrayList <String> listOfRate = new ArrayList<>();
//            listOfRate.add(employee.getDataList().get(i).get(0));  //To get the ID
//            listOfRate.add(employee.getDataList().get(i).get(1)+", "+employee.getDataList().get(i).get(2));  //To get the name
//            listOfRate.add(employee.getDataList().get(i).get(11));  //To get the Position
//            listOfRate.add(employee.getDataList().get(i).get(14)); //To get the rice subsidy
//            listOfRate.add(employee.getDataList().get(i).get(15)); //To get the Phone Allowance
//            listOfRate.add(employee.getDataList().get(i).get(16)); //To get the clothing allowance
//            listOfRate.add(employee.getDataList().get(i).get(18)); //To hourly rate
//            listOfRate.add(employee.getDataList().get(i).get(13)); //To monthly rate
//            data.add(listOfRate);
//        }
//        // Get the current date
//        Calendar calendar = Calendar.getInstance();
//        
//        // Define the date format
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//        Date startOfPeriod = null;
//        Date endOfPreviousMonth = null;
//
//        // Check if today is before or on the 15th
//        if (calendar.get(Calendar.DAY_OF_MONTH) <= 15) {
//            // Get the end of the previous month
//            calendar.set(Calendar.DAY_OF_MONTH, 1); // Set to the 1st of the current month
//            calendar.add(Calendar.DAY_OF_MONTH, -1); // Subtract 1 day to get the last day of the previous month
//            endOfPreviousMonth = calendar.getTime();
//            
//            // Set the date range from 16th to end of the previous month
//            calendar.set(Calendar.DAY_OF_MONTH, 16); // Start from 16th of the previous month
//            startOfPeriod = calendar.getTime();
//            payrollDates = daysInPeriod(startOfPeriod, endOfPreviousMonth, sdf);
//        } else {
//            // Get the date range from 1st to 15th of the current month
//            calendar.set(Calendar.DAY_OF_MONTH, 1); // Set to the 1st of the current month
//            startOfPeriod = calendar.getTime();
//            
//            calendar.set(Calendar.DAY_OF_MONTH, 15); // Set to 15th of the current month
//            endOfPreviousMonth = calendar.getTime();
//            payrollDates = daysInPeriod(startOfPeriod, endOfPreviousMonth, sdf);
//        }
//
//        employee.getDataList().clear(); //To clear the list before genrating another list of data from attendance.csv
//        employee.setFilePath("CSVFiles//AttendanceDatabase.csv");
//        employee.retrivedDetails();
//        ArrayList<ArrayList<String>> tempData = new ArrayList<>();
//        
//        for(int i=0; i<payrollDates.size(); i++){
//            for(int j=0; j<employee.getDataList().size(); j++){
//                if(payrollDates.get(i).equals(employee.getDataList().get(j).get(2)) && employee.getDataList().get(j).get(5).equals("Yes") && employee.getDataList().get(j).get(6).equals("Yes")){
//                    tempData.add(employee.getDataList().get(j));
//                }
//            }
//        }
//        
//        for(int i=0; i<data.size(); i++){
//            ArrayList<ArrayList<String>> perEmployeeAttendance = new ArrayList<>();
//            for(int j=0; j<tempData.size(); j++){
//                if(data.get(i).get(0).equals(tempData.get(j).get(0))){
//                    perEmployeeAttendance.add(tempData.get(j));
//                }
//            }
//            if(!perEmployeeAttendance.isEmpty()){
//                double gross = grossCalculation(perEmployeeAttendance);
//                double benefits = benefitsCalculation();
//                double overtime = overtimeCalculations(perEmployeeAttendance);
//                System.out.println("Overtime: "+overtime);
//                double undertime = undertimeCalculations(perEmployeeAttendance);
//                System.out.println("Undertime: "+undertime);
//                double sss = sssCalculation();
//                double philhealth = philhealthCalculation();
//                double pagibig = pagibigCalculation();
//                double tax = taxCalculation(sss+philhealth+pagibig);
//                double totalDeductions = sss + philhealth + pagibig + tax;
//                double netPay = netPayrollCalculations(gross, benefits, overtime, undertime, totalDeductions);
//                
//                
//                
//                employee.getDataList().clear();
//                employee.setFilePath("CSVFiles//Payroll.csv");
//                employee.retrivedDetails();
//                ArrayList<String> list = new ArrayList<>();
//                list.add(data.get(i).get(0));
//                list.add(perEmployeeAttendance.get(i).get(1));
//                list.add(sdf.format(startOfPeriod)+" to "+sdf.format(endOfPreviousMonth));
//                list.add(data.get(i).get(2));
//                list.add(String.valueOf(gross));
//                list.add(String.valueOf(benefits));
//                list.add(String.valueOf(overtime));
//                list.add(String.valueOf(undertime));
//                list.add(String.valueOf(sss));
//                list.add(String.valueOf(philhealth));
//                list.add(String.valueOf(pagibig));
//                list.add(String.valueOf(tax));
//                list.add(String.valueOf(netPay));
//                list.add("Pending");
//                
//                boolean isFound = false;
//                for(int b=0; b<employee.getDataList().size(); b++){
//                    if(employee.getDataList().get(b).get(0).equals(list.get(0)) && employee.getDataList().get(b).get(1).equals(list.get(1)) && employee.getDataList().get(b).get(2).equals(list.get(2))){
//                        isFound = true;
//                        break;
//                    }else{
//                        isFound = false;
//                    }
//                }
//                if(!isFound){
//                    employee.getDataList().add(list);
//                    employee.addDetailsCSV();
//                } 
//            }
//        }
//        
//         // Define the input date format (MM/dd/yyyy)
//        String startFormatted = new SimpleDateFormat("MMM d").format(startOfPeriod);
//        String endFormatted = new SimpleDateFormat("d").format(endOfPreviousMonth);
//        String dateRange = startFormatted + "-" + endFormatted + ", 2025";
//
//        return dateRange;
//    }
    
    
//    void getEmployeeNames(){  
//        getDataList().clear();
//        getNewData().clear();
//        fullName.clear();
//        setFilePath("CSVFiles//EmployeeDatabase.csv");
//        retrivedDetails();
//        for(int i=1; i<getDataList().size(); i++){
//            ArrayList <String> names = new ArrayList<>();
//            names.add(getDataList().get(i).get(0));
//            names.add(getDataList().get(i).get(1) + ", "+getDataList().get(i).get(2));
//            getIdAndNames().add(names);
//            fullName.add(getDataList().get(i).get(1) + ", "+getDataList().get(i).get(2));
//        }
//           
//        Collections.sort(fullName);
//        getNewData().add(fullName); 
//    }
       

//    ArrayList<ArrayList<String>> getDataForDTRTable(){
//        employee.getDataList().clear();
//        String id = "";
//        for(ArrayList<String> idName : getIdAndNames()){
//           if(idName.get(1).equals(getSelectedName())){
//               id = idName.get(0);
//           }
//        }
        
//        employee.setFilePath("CSVFiles//AttendanceDatabase.csv");
//        employee.retrivedDetails();
//        for(int i=1; i<employee.getDataList().size(); i++){
//            if(employee.getDataList().get(i).get(0).equals(id) && employee.getDataList().get(i).get(5).equals("Yes") && employee.getDataList().get(i).get(6).equals("Yes")){
//                employee.getDataList().get(i).remove(5);
//                employee.getDataList().get(i).remove(5);
//                data.add(employee.getDataList().get(i));
//            }
//        }
//        return data;
//    }
      
//    ArrayList<ArrayList<String>> getDataForPayrollTable(){
//        employee.getDataList().clear();
//        employee.setFilePath("CSVFiles//Payroll.csv");
//        employee.retrivedDetails();
//        for(int i=0; i<employee.getDataList().size(); i++){
//            if(!employee.getDataList().get(i).get(13).equals("Pending")){
//                employee.getDataList().remove(i);
//            }
//        }
//        return employee.getDataList();
//    }
    
//    ArrayList<ArrayList<String>> getApprovedDataForPayrollTable(Date jDateFrom, Date jDateTo){
//        ArrayList<ArrayList<String>> tempData = new ArrayList<>();
//        employee.getDataList().clear();
//        employee.setFilePath("CSVFiles//Payroll.csv");
//        int date = jDateFrom.compareTo(jDateTo);
//        if(date > 0){
//            JOptionPane.showMessageDialog(null, "Invalid Payroll Period");
//        }else{
//             String dateFrom = new SimpleDateFormat("MM/dd/yyyy").format(jDateFrom);
//             String dateTo = new SimpleDateFormat("MM/dd/yyyy").format(jDateTo);
//             String payrollPeriod = dateFrom+" to "+dateTo;
//            employee.retrivedDetails();
//            for(int i=0; i<employee.getDataList().size(); i++){
//                if(employee.getDataList().get(i).get(2).equals(payrollPeriod) && employee.getDataList().get(i).get(13).equals("Approved")){
//                    tempData.add(employee.getDataList().get(i));
//                }
//            }
//        }
//        if(tempData.isEmpty()){
//            JOptionPane.showMessageDialog(null, "No File Found!");
//        }
//        return tempData;
//    }
//    
//    void releasedPayroll(ArrayList<ArrayList<String>> tempData){
//        employee.getDataList().clear();
//        employee.setFilePath("CSVFiles//Payroll.csv");
//        employee.retrivedDetails();
//        for(int i=0; i<tempData.size(); i++){
//            for(int j=0; j<employee.getDataList().size(); j++){
//                if(tempData.get(i).get(0).equals(employee.getDataList().get(j).get(0)) && tempData.get(i).get(1).equals(employee.getDataList().get(j).get(1)) &&
//                        tempData.get(i).get(2).equals(employee.getDataList().get(j).get(2)) && tempData.get(i).get(3).equals(employee.getDataList().get(j).get(13))){
//                    employee.getDataList().get(j).set(13, "Approved");
//                    break;
//                }
//            }
//        }
//        employee.addDetailsCSV();
//    }
//        
//   void setSelectedName(String selectedName){
//       this.selectedName = selectedName;
//   }
//   String getSelectedName(){
//       return this.selectedName;
//   }
   
//}
