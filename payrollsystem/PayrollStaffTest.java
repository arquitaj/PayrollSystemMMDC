/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package payrollsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.junit.*;
import static org.junit.Assert.*;

public class PayrollStaffTest {

    private PayrollStaff payrollStaff;

    @Before
    public void setUp() {
        payrollStaff = new PayrollStaff("10002");
        // Injecting test values manually using test access or reflections is preferred in real test scenarios.
        
    }

    @Test
    public void testTaxCalculation() {
        // perMonth = 40000, deductions = 3000
        TestUtils.setPrivateField(payrollStaff, "perMonth", 40000.0);
        double totalDeductions = 3000.0;
        double result = payrollStaff.taxCalculation(totalDeductions);
        double expectedTax = ((37000 - 33333) * 0.20) + 2500;
        assertEquals(expectedTax, result, 0.01);
    }

    @Test
    public void testSssCalculation() {
        TestUtils.setPrivateField(payrollStaff, "grossPay", 10000.0);
        double result = payrollStaff.sssCalculation();
        double expected = Math.round(((13 * 22.50) + 135) * 100.0) / 100.0;
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void testPhilhealthCalculation() {
        TestUtils.setPrivateField(payrollStaff, "perMonth", 30000.0);
        double result = payrollStaff.philhealthCalculation();
        double expected = 30000.0 * Payroll.PHILHEALTH_PERCENT;
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void testPagibigCalculation() {
        TestUtils.setPrivateField(payrollStaff, "perMonth", 5000.0);
        double result = payrollStaff.pagibigCalculation();
        double expected = 5000.0 * 0.02;
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void testDeductionCalculation() {
        ArrayList<ArrayList<String>> dummy = new ArrayList<>();
        double result = payrollStaff.deductionCalculation(dummy);
        assertEquals(2.0, result, 0.0);
    }

    @Test
    public void testGrossCalculation() {
        ArrayList<ArrayList<String>> attendance = new ArrayList<>();
        attendance.add(new ArrayList<>(Collections.singletonList("101")));

        ArrayList<ArrayList<String>> data = new ArrayList<>();
        data.add(new ArrayList<>(Arrays.asList("10001", "Garcia", "Manuel III", "1000", "500", "300", "100", "30000")));
        TestUtils.setPrivateField(payrollStaff, "data", data);

        double result = payrollStaff.grossCalculation(attendance);
        double expected = 100.0 * 8 * 1;
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void testBenefitsCalculation() {
        TestUtils.setPrivateField(payrollStaff, "riceSubsidy", 1000.0);
        TestUtils.setPrivateField(payrollStaff, "phoneAllowance", 500.0);
        TestUtils.setPrivateField(payrollStaff, "clothingAllowance", 250.0);
        double result = payrollStaff.benefitsCalculation();
        assertEquals(1750.0, result, 0.01);
    }

    @Test
    public void testNetPayrollCalculations() {
        double result = payrollStaff.netPayrollCalculations(30000, 2000, 500, 400, 1000);
        assertEquals(31500.0, result, 0.01);
    }

    @Test
    public void testOvertimeCalculations() {
        ArrayList<ArrayList<String>> attendance = new ArrayList<>();
        attendance.add(new ArrayList<>(Arrays.asList("10001", "Manuel Garcia III", "2025-07-01", "08:00", "18:30", "Approved", "", "With Approved Overtime")));
        TestUtils.setPrivateField(payrollStaff, "perHour", 100.0);

        double result = payrollStaff.overtimeCalculations(attendance);
        assertEquals(150.0, result, 0.01); // 90 minutes OT * (100/60)
    }

    @Test
    public void testUndertimeCalculations() {
        ArrayList<ArrayList<String>> attendance = new ArrayList<>();
        attendance.add(new ArrayList<>(Arrays.asList("10001", "Manuel Garcia III", "2025-07-01", "08:30", "16:00")));
        TestUtils.setPrivateField(payrollStaff, "perHour", 120.0);

        double result = payrollStaff.undertimeCalculations(attendance);
        assertEquals(180.0, result, 0.01); // 30 min late + 60 min early = 90 min * (120/60)
    }

    @Test
    public void testSetSelectedName() {
        payrollStaff.setSelectedName("Manuel Garcia III");
        // No assertion, but we check for exception or crash
    }


}
