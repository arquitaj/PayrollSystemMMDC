/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.util.ArrayList;

/**
 *
 * @author Paul
 */
interface Payroll {
   void generatePayslip();
   ArrayList<ArrayList<String>> employeeNames();
   ArrayList<ArrayList<String>> getDataForDTRTable(String employeeName);
   int getEmployeeCount();
   void setSelectedName(String selectedName);
}
