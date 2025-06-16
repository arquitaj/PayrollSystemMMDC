/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.util.ArrayList;

public class Login extends Credentials {
    private int id;
    private String password;
    
    Login(int id, String password){
        this.id = id;
        this.password = password;
        super(id, password);
    }
    
    ArrayList<ArrayList<String>> getDataFromDatabase(){
        String sql = "SELECT * FROM credentials WHERE employee_id = ? AND employee_password = ?";
        return super.getDataFromDatabase(sql);
    }
   
}
