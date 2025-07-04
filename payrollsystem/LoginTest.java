/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package payrollsystem;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
    
    public LoginTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        // Set up shared resources before all tests
    }

    @AfterClass
    public static void tearDownClass() {
        // Clean up shared resources after all tests
    }

    @Before
    public void setUp() {
        // Set up before each test
    }

    @After
    public void tearDown() {
        // Tear down after each test
    }

    /**
     * ✅ Test successful login (valid credentials).
     */
    @Test
    public void testCheckCredentialsSuccess() {
        System.out.println("checkCredentials - success");

        int testEmployeeID = 10001;
        String testPassword = "10001";

        Login instance = new Login(testEmployeeID, testPassword) {
            {
                this.accountDetails = new AccountDetails() {
                    @Override
                    ArrayList<ArrayList<String>> retrivedDetails(java.sql.PreparedStatement statement) {
                        ArrayList<ArrayList<String>> data = new ArrayList<>();
                        ArrayList<String> row = new ArrayList<>();
                        row.add("10001");         // employee_id
                        row.add("Garcia, Manuel III");    // full_name
                        row.add("Human Resource");// role
                        data.add(row);
                        return data;
                    }
                };
            }
        };

        ArrayList<ArrayList<String>> expected = new ArrayList<>();
        ArrayList<String> row = new ArrayList<>();
        row.add("10001");
        row.add("Garcia, Manuel III");
        row.add("Human Resource");
        expected.add(row);

        ArrayList<ArrayList<String>> result = instance.checkCredentials();
        assertEquals(expected, result);
    }

    /**
     *  Test failed login (invalid credentials).
     */
    @Test
    public void testCheckCredentialsFail() {
        System.out.println("checkCredentials - failure");

        int testEmployeeID = 9999; // non-existent user
        String testPassword = "wrongpass";

        Login instance = new Login(testEmployeeID, testPassword) {
            {
                this.accountDetails = new AccountDetails() {
                    @Override
                    ArrayList<ArrayList<String>> retrivedDetails(java.sql.PreparedStatement statement) {
                        return new ArrayList<>(); // simulate no match found
                    }
                };
            }
        };

        ArrayList<ArrayList<String>> result = instance.checkCredentials();
        assertTrue(result.isEmpty()); // Expect no results for wrong credentials
    }
}

