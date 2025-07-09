/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import payrollsystem.PayrollStaff;
import payrollsystem.PdfGenerator;

/**
 *
 * @author Paul
 */
public class PayrollStaffTest {
    PayrollStaff payrollStaff = new PayrollStaff("10002");
    PdfGenerator generatePDF = new PdfGenerator();
    
    public PayrollStaffTest() {
    }
    
    public static void main(String[] args) throws ParseException {
        PayrollStaffTest test = new PayrollStaffTest();
        test.testGeneratePayslip();
        test.testEmployeeNames();
        test.testGetDataForDTRTable();
        test.testSetSelectedName();
        test.testPdfGenerator();
        
    }

    @Test
    public void testGeneratePayslip() {
        payrollStaff.generatePayslip();
    }

    @Test
    public void testEmployeeNames() {
        payrollStaff.employeeNames();
    }

    @Test
    public void testGetDataForDTRTable() {
        payrollStaff.getDataForDTRTable("Aguilar, Delia");
    }

    
    @Test
    public void testSetSelectedName() {
        payrollStaff.setSelectedName("Aguilar, Delia");
    }
    
    @Test
    public void testPdfGenerator() throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        generatePDF.generatePayslipPDF("10003", formatter.parse("2024-06-01"), formatter.parse("2024-06-30"));
    }
      
}
