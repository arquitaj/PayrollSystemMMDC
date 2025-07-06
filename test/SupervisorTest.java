/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import payrollsystem.Supervisor;

/**
 *
 * @author Paul
 */
public class SupervisorTest {
    Supervisor supervisor = new Supervisor("10004");
    ArrayList <String> rowData = new ArrayList<>();
    
    public static void main(String[] args) throws ParseException {
        SupervisorTest test = new SupervisorTest();
        test.testEmployeeRequest();
        test.testApprovedEmployeeRequest();
        test.testDisapprovedEmployeeRequest();
        test.testGetDataForDTRTable();
        test.testForwardDTR();   
    }
       
    @Test
    public void testEmployeeRequest(){
        //Display all employee pending request for supervisor's approval
        supervisor.employeeRequest("All Request");
    }
    @Test
    public void testApprovedEmployeeRequest(){
        //Approval of request
        rowData.add("10034");
        rowData.add("Beatriz Santos");
        rowData.add("2025-06-20");
        rowData.add("Overtime");
        rowData.add("2025-06-26");
        rowData.add("2025-06-27");
        rowData.add("2.00");
        rowData.add("Overtime 2");
        rowData.add("Pending");
        supervisor.approvedEmployeeRequest(rowData);   
    }
    
    @Test
    public void testDisapprovedEmployeeRequest(){
        //Disapproval of request
        supervisor.disapprovedEmployeeRequest(rowData);
    }
    
    @Test
    public void testGetDataForDTRTable(){
        //Viewing of employee DTR for approval
        supervisor.getDataForDTRTable("Castro, John Rafael");
    }
    
    @Test
    public void testForwardDTR(){
         //Forwarding of DTR to payroll staff
        ArrayList<ArrayList<String>> details = new ArrayList<>();
        ArrayList <String> dtrRow = new ArrayList<>();
        dtrRow.add("10032");
        dtrRow.add("Castro John Rafael");
        dtrRow.add("2025-07-06");
        dtrRow.add("08:00:00");
        dtrRow.add("05:00:00");
        
        details.add(dtrRow);
        supervisor.forwardDTR(details);
    }
    
}
