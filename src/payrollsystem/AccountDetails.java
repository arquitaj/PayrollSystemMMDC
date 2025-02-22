/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package payrollsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul
 */
public class AccountDetails {
    private ArrayList<ArrayList<String>> dataList = new ArrayList<>();
    private String filePath;
    private int employeeID = 123;
    private String firstName, lastName, birthday, address, phoneNumber, sssNumber, philHealthNumber, tinNumber, pagibigNumber, status, position, supervisor;
    private double basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, semiBasicSalary, hourlyRate;
    private Object name = "John";
    AccountDetails(){
        
    }
  
    void retrivedDetails(){
        String line; 
        try (BufferedReader reader = new BufferedReader(new FileReader(getFilePath()))) {
            while ((line = reader.readLine()) != null){
                String[] datas = line.split(",");
                ArrayList<String> row = new ArrayList<>();
                row.addAll(Arrays.asList(datas));
                this.dataList.add(row);
            } 
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    void userDetails(){
        for(ArrayList<String> data : dataList){
            if(data.get(0).equals(String.valueOf(getEmployeeID()))){
                this.lastName = data.get(1);
                this.firstName = data.get(2); 
                this.birthday = data.get(3);
                this.address = data.get(4);
                this.phoneNumber = data.get(5);
                this.sssNumber = data.get(6);
                this.philHealthNumber = data.get(7);
                this.tinNumber = data.get(8);
                this.pagibigNumber = data.get(9);
                this.status = data.get(10);
                this.position = data.get(11);
                this.supervisor = data.get(12);
                this.basicSalary = Double.parseDouble(data.get(13));
                this.riceSubsidy = Double.parseDouble(data.get(14));
                this.phoneAllowance = Double.parseDouble(data.get(15));
                this.clothingAllowance = Double.parseDouble(data.get(16));
                this.semiBasicSalary = Double.parseDouble(data.get(17));
                this.hourlyRate = Double.parseDouble(data.get(18));
            }
        }
    }
    
    void addDetailsCSV(){
        try(BufferedWriter writer = new BufferedWriter (new FileWriter (getFilePath()))){
                for(int i=0; i<getDataList().size(); i++){
                    for(int j=0; j<getDataList().get(i).size(); j++){
                        writer.write(getDataList().get(i).get(j)+",");
//                        if(j<this.dataList.get(i).size()-1)
//                            writer.newLine();
                    }
                    if(i<getDataList().size()-1)
                        writer.newLine();
                }
                writer.close();
                JOptionPane.showMessageDialog(null, "Successfuly Added");
            }catch(IOException e){
                e.printStackTrace();
            }
    }
    
    void printDetails(){
        for(ArrayList <String> data : getDataList())
            System.out.println(data);
    }

    public ArrayList<ArrayList<String>> getDataList() {
        return dataList;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSssNumber() {
        return sssNumber;
    }

    public String getPhilHealthNumber() {
        return philHealthNumber;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public String getPagibigNumber() {
        return pagibigNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getPosition() {
        return position;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getRiceSubsidy() {
        return riceSubsidy;
    }

    public double getPhoneAllowance() {
        return phoneAllowance;
    }

    public double getClothingAllowance() {
        return clothingAllowance;
    }

    public double getSemiBasicSalary() {
        return semiBasicSalary;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public String getBirthday() {
        return birthday;
    }
    
    public void setFilePath(String path){
        this.filePath = path;
    }
}
