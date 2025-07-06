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
import payrollsystem.HumanResource;


public class HumanResourceTest {
     SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
     HumanResource humanResource = new HumanResource("10010");
     
     public static void main(String[] args) throws ParseException {
       HumanResourceTest test = new HumanResourceTest();
       test.testDisplayAllDetails();
       test.testAddEmployeeDetails();
       test.testRetrievedAllCredentials();
       test.testAddNewCredentials();
    }
     
    @Test
    public void testDisplayAllDetails(){
        //Viewing of all employee details
        humanResource.displayAllDetails();
    }
    
    @Test
    public void testAddEmployeeDetails() throws ParseException{
        //Adding of New Employee
        String dateStr = formatter.format(formatter.parse("01/01/1998"));
        ArrayList<String> tempData = new ArrayList<>();
        tempData.add("10035");              //index 0
        tempData.add("Law");                //1
        tempData.add("Sabin");              //2
        tempData.add(dateStr);              //3
        tempData.add("09090909090");        //4
        tempData.add("Bayabas");            //5
        tempData.add("Talomo");             //6
        tempData.add("Davao");              //7
        tempData.add("Davao City");         //8
        tempData.add("Davao del Sur");      //9
        tempData.add("8000");               //10
        tempData.add("50000.00");           //11
        tempData.add("10000.00");           //12
        tempData.add("10000.00");           //13
        tempData.add("10000.00");           //14
        tempData.add("11-2222222-3");       //15 Sss No.
        tempData.add("123456789123");       //16 philhealth No.
        tempData.add("111-222-333-000");    //17 TIN No.
        tempData.add("998877445566");       //18 Pagibig No.
        tempData.add("Sales & Marketing");  //19
        tempData.add("Regular");            //20
        tempData.add("10004");              //21
        
        humanResource.addEmployeeDetails(tempData);
    }
    
    @Test
    public void testRetrievedAllCredentials(){
        //Viewing of all employee credentials
        humanResource.retrievedAllCredentials();
    }
    
    @Test
    public void testAddNewCredentials(){
        //Adding of credentials
        ArrayList<String> data = new ArrayList<>();
        data.add("10035");  //Employee ID
        data.add("10035");  //Password
        data.add("Employee"); //Employee Role
        humanResource.addNewCredentials(data);
    }
  
    
}
