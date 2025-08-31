/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package payrollsystem;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SupervisorTest {

    private Supervisor supervisor;

    @Before
    public void setUp() {
        // Use supervisor ID 
        supervisor = new Supervisor("1004");
    }

    @Test
    public void testSetSelectedName() {
        supervisor.setSelectedName("Manuel Garcia III");
        // No exception means pass (method is empty, can't assert state change)
    }

    @Test
    public void testEmployeeRequestWithEmptyInput() {
        ArrayList<ArrayList<String>> result = supervisor.employeeRequest("");
        assertNotNull(result);
    }

    @Test
    public void testEmployeeNamesNotNull() {
        ArrayList<ArrayList<String>> result = supervisor.employeeNames();
        assertNotNull(result);
    }

    @Test
    public void testGetDataForDTRTableWithDummyName() {
        ArrayList<ArrayList<String>> result = supervisor.getDataForDTRTable("Garcia, Manuel III");
        assertNotNull(result);
    }

    @Test
    public void testApprovedEmployeeRequestOvertime() {
        ArrayList<String> rowData = new ArrayList<>(Arrays.asList(
            "10001", "Manuel Garcia III", "2025-07-01", "Overtime", "2025-07-03", "2025-07-03", "1", "Extra work", "Pending"
        ));

        // This test only passes if database is properly set up.

        supervisor.approvedEmployeeRequest(rowData);
    }

    @Test
    public void testDisapprovedEmployeeRequestLeave() {
        ArrayList<String> rowData = new ArrayList<>(Arrays.asList(
            "10001", "Manuel Garcia III", "2025-07-01", "Sick Leave", "2025-07-03", "2025-07-03", "1", "Fever", "Pending"
        ));

        // Only run this if DB is connected and setup
        supervisor.disapprovedEmployeeRequest(rowData);
    }

    @Test
    public void testForwardDTRWithEmptyList() {
        ArrayList<ArrayList<String>> dtrRows = new ArrayList<>();
        supervisor.forwardDTR(dtrRows);
    }
}

