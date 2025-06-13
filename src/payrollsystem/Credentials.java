/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.util.ArrayList;

/**
 *
 * @author Paul
 */
abstract class Credentials extends AccountDetails {
    private String userID, userPassword;
    
    AccountDetails accountDetails = new AccountDetails();
    
    Credentials(String id, String password){
        this.userID = id;
        this.userPassword = password;
    }
    
    ArrayList<ArrayList<String>> checkCredentials(){
        ArrayList<ArrayList<String>> tempData = new ArrayList<>();
        ArrayList<ArrayList<String>> dataList;
        accountDetails.setFilePath("CSVFiles//CredentialsDatabase.csv");
        accountDetails.retrivedDetails("credentials");
        dataList = accountDetails.getDataList();
        for(int i = 0; i < dataList.size(); i++){
            if(userID.equals(dataList.get(i).get(1)) && userPassword.equals(dataList.get(i).get(2))){
                tempData.add(dataList.get(i));
            }
        }
        return tempData;
    }
}
