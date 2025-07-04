/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

package payrollsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HumanResourceTest {

    private HumanResource hr;

    @Before
    public void setUp() {
        // Initialize a HumanResource employee ID
        hr = new HumanResource("10001");
    }

    @Test
    public void testValidateDateBirthday_LegalAge() {
        // 18 years ago from today
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -18);
        Date birthday = cal.getTime();

        boolean result = hr.validateDateBirthday(birthday);
        assertTrue("Should be valid for 18 years old", result);
    }

    @Test
    public void testValidateDateBirthday_Underage() {
        // 10 years old (underage)
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -10);
        Date birthday = cal.getTime();

        boolean result = hr.validateDateBirthday(birthday);
        assertFalse("Should be invalid for under 18", result);
    }

    @Test
    public void testSetAndGetSelectedName() {
        String testName = "Lim Antonio";
        hr.setSelectedName(testName);
        assertEquals("Selected name should match", testName, hr.getSelectedName());
    }

    @Test
    public void testRetrievedEmploymentStatus_Status() {
        ArrayList<ArrayList<String>> result = hr.retrievedEmploymentStatus("status");
        assertNotNull("Employment status should not be null", result);
        // You can check sample value only if database is populated
    }

    @Test
    public void testRetrievedAllCredentials() {
        ArrayList<ArrayList<String>> result = hr.retrievedAllCredentials();
        assertNotNull("Retrieved credentials should not be null", result);
    }

    // You can write tests for these if you mock database:
    @Test
    public void testDisplayAllDetails_NotNull() {
        ArrayList<ArrayList<String>> result = hr.displayAllDetails();
        assertNotNull("Employee details should not be null", result);
    }

    @Test
    public void testNextEmployeeID_NotNull() {
        ArrayList<ArrayList<String>> result = hr.nextEmployeeID();
        assertNotNull("Next Employee ID result should not be null", result);
    }
}

