/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package payrollsystem;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {

    private Employee employee;

    @Before
    public void setUp() {
        employee = new Employee("10001"); // Use valid test ID
    }

    @Test
    public void testGetDateNow() {
        Date result = employee.getDateNow();
        assertNotNull("Date should not be null", result);

        long today = System.currentTimeMillis();
        long diff = Math.abs(result.getTime() - today);
        assertTrue("Should be today's date (±1 day)", diff < 86400000);
    }

    @Test
    public void testGetTime() {
        Time result = employee.getTime();
        assertNotNull("Time should not be null", result);

        String[] parts = result.toString().split(":");
        assertEquals("Time should have hours, minutes, and seconds", 3, parts.length);
    }

    @Test
    public void testCountNumberOfDays_ValidRange() {
        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.JULY, 1); // Tuesday
        Date from = new Date(cal.getTimeInMillis());
        cal.set(2025, Calendar.JULY, 5); // Saturday
        Date to = new Date(cal.getTimeInMillis());

        boolean result = employee.countNumberOfDays(from, to);

        assertTrue("Should return true for valid range", result);
        assertEquals("Should count 5 days (excluding Sunday)", 5, employee.getNumberOfDaysLeave());
    }

    @Test
    public void testCountNumberOfDays_SundayOnly() {
        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.JULY, 6); // Sunday
        Date from = new Date(cal.getTimeInMillis());
        Date to = new Date(cal.getTimeInMillis());

        boolean result = employee.countNumberOfDays(from, to);

        assertFalse("Should return false for Sunday only", result);
        assertEquals(0, employee.getNumberOfDaysLeave());
    }

    @Test
    public void testSetNumberOfDaysLeave() {
        employee.countNumberOfDays(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
        employee.setNumberOfDaysLeave();
        assertEquals("Leave days should reset to 0", 0, employee.getNumberOfDaysLeave());
    }

    @Test
    public void testGetBalanceVL() {
        // Default value is null unless populated by DB
        assertNull("Initial balanceVL should be null", employee.getBalanceVL());
    }

    @Test
    public void testGetBalanceSL() {
        // Default value is null unless populated by DB
        assertNull("Initial balanceSL should be null", employee.getBalanceSL());
    }

    @Test
    public void testViewPersonalDetails() {
        // Integration test - requires live DB
        // employee.viewPersonalDetails();
    }

    @Test
    public void testGetDataAllRequests() {
        ArrayList<ArrayList<String>> result = employee.getDataAllRequests();
        assertNotNull(result); // Ensure it doesn't crash
    }

    @Test
    public void testGetDTR() {
        java.util.Date now = new java.util.Date();
        ArrayList<ArrayList<String>> result = employee.getDTR(now, now);
        assertNotNull(result);
    }

    @Test
    public void testViewPersonalLeaveLedger() {
        ArrayList<ArrayList<String>> result = employee.viewPersonalLeaveLedger();
        assertNotNull(result);
    }

    @Test
    public void testFileOvertimeRequest() {
        // Should return false if DB not set up
        boolean result = employee.fileOvertimeRequest(1001, new java.util.Date(), new java.util.Date(), 1, "Testing");
        assertFalse(result); // Assuming DB is not live
    }

    @Test
    public void testFileLeaveRequest() {
        boolean result = employee.fileLeaveRequest(new java.util.Date(), new java.util.Date(), "Sick Leave", "1", "Test");
        assertFalse(result); // Assuming DB is not live
    }

    @Test
    public void testUserLogin() {
        // Only safe to call if DB exists
        // employee.userLogin();
    }

    @Test
    public void testUserLogout() {
        // Only safe to call if DB exists
        // employee.userLogout();
    }

    @Test
    public void testLeaveBalancesInformation() {
        // Only safe to call if DB exists
        // employee.leaveBalancesInformation();
    }

    @Test
    public void testUpdateLeaveRequest() {
        employee.updateLeaveRequest(); // No logic, so just call
    }

    @Test
    public void testUpdateOvertimeRequest() {
        employee.updateOvertimeRequest(); // No logic, so just call
    }
}
