/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Paul
 */
interface Payroll {
   void generatePayslip();
   ArrayList<ArrayList<String>> employeeNames();
   ArrayList<ArrayList<String>> getDataForDTRTable(String employeeName);
   ArrayList<ArrayList<String>> getEmployeeWithAttendance(Date AttendanceFrom, Date AttendanceTo);
   void setSelectedName(String selectedName);
   
}
