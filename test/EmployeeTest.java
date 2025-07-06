/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import payrollsystem.AccountDetails;
import payrollsystem.Employee;


public class EmployeeTest {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Employee employee = new Employee("10003");
    
    public static void main(String[] args) throws ParseException {
        EmployeeTest test = new EmployeeTest();
        test.testViewPersonalDetails();
        test.testFileLeaveRequest();
        test.testFileOvertimeRequest();
        test.testGetDTR();
        test.testViewPersonalLeaveLedger();
        test.testDownloadPayslip();
        test.testUserLogin();
        test.testUserLogin();
    }
    
    @Test
    public void testViewPersonalDetails(){ 
        //Testing for viewing of personal details
        employee.viewPersonalDetails();
    }
    
    @Test
    public void testFileLeaveRequest() throws ParseException{
        //Testing for Adding of Leave Request
        employee.fileLeaveRequest(formatter.parse("2025-07-01"), formatter.parse("2025-07-02"), "Vacation Leave", 2, "Just want to rest");
    }
    
    @Test
    public void testFileOvertimeRequest() throws ParseException{
        //Testing for Adding of Overtime Request
        employee.fileOvertimeRequest(formatter.parse("2025-07-03"), formatter.parse("2025-07-04"), 2, "Just want to overtime");
    }
    
    @Test
    public void testGetDTR() throws ParseException{
        //Testing for viewing of DTR
        employee.getDTR(formatter.parse("2024-06-01"), formatter.parse("2025-07-31"));
    }
    
    @Test
    public void testViewPersonalLeaveLedger(){   
        //Testing for Viewing for Leave Ledger
        employee.viewPersonalLeaveLedger();
    }
    
    @Test
    public void testDownloadPayslip() throws ParseException{
        //Testing for downloading of payslip
        employee.downloadPayslip(formatter.parse("2024-06-01"), formatter.parse("2024-06-30"));
    }
    
    @Test
    public void testUserLogin(){
        //Attendance Time-in
        employee.userLogin();
    }
     
    @Test
    public void testUserLogout(){
        //Attendance Time-out
        employee.userLogout();
    }
}
