/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;
import java.sql.SQLException;
import java.util.ArrayList;

//Method that create abstract method
abstract class Credentials extends AccountDetails {
    abstract public ArrayList<ArrayList<String>> checkCredentials() throws SQLException;        //Abstract method
}
