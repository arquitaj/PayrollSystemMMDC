package payrollsystem;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import java.sql.*;
import javax.sql.rowset.serial.SerialBlob;

public class PdfGenerator extends DatabaseConnection{
    public void generatePayslipPDF(String employeeID, java.util.Date startDate, java.util.Date endDate){
        String filenameJrxml = System.getProperty("user.dir") + "\\src\\files\\PayrollSlip.jrxml";
        String exportDirectory = System.getProperty("user.dir") + String.format("\\src\\temp\\%s_%s-%s.pdf", employeeID, startDate, endDate);
        try{
            JasperDesign jasperDesign = JRXmlLoader.load(filenameJrxml);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            
            HashMap<String, Object> details = new HashMap<String, Object>();
            Object[] data = readEmployeeDetailsFromDB(employeeID, startDate, endDate);
//            for(int i = 0; i < data.length; i++){
//                System.out.println(i+1 + " " + data[i]);
//            }
            
            details.put("EMPLOYEE_ID", data[1]);
            details.put("EMPLOYEE_NAME", data[2].toString());
            details.put("POSITION", data[3].toString());
            details.put("PERIOD_FROM", data[4]);
            details.put("PERIOD_TO", data[5]);
            
            details.put("MONTHLY_RATE", data[6]);
            details.put("DAILY_RATE", data[7]);
            details.put("DAYS_WORKED", data[8]);
            details.put("OVERTIME", data[9]);
            
            details.put("RICE_SUBSIDY", data[11]);
            details.put("PHONE_ALLOWANCE", data[12]);
            details.put("CLOTHING_ALLOWANCE", data[13]);
            
            //WIP HashMap additions
            details.put("GROSS_INCOME", data[10]);
            details.put("TOTAL_BENEFITS", data[14]);
            details.put("SSS", data[15]);
            details.put("PHILHEALTH", data[17]);
            details.put("PAG_IBIG", data[16]);
            details.put("TAX", data[18]);
            details.put("TOTAL_DEDUCTIONS", (double)data[15] + (double)data[16] + (double)data[17] + (double)data[18]);
            details.put("TOTAL_NET_INCOME", data[19]);

            
            JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jasperReport, details, new JREmptyDataSource());
            insertPdfToDB(JasperExportManager.exportReportToPdf(jprint), startDate, endDate, Integer.parseInt(employeeID));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public Object[] readEmployeeDetailsFromDB(String employeeID, java.util.Date startDate, java.util.Date endDate){
        Object[] data = new Object[20];
        try{
            java.sql.Connection conn = this.getDBConnection();
            String query = "CALL generate_payslip_report(?, ?, ?);";
            CallableStatement statement = conn.prepareCall(query);
            statement.setInt(1, Integer.valueOf(employeeID));
            statement.setDate(2, new java.sql.Date(startDate.getTime()));
            statement.setDate(3, new java.sql.Date(endDate.getTime()));
            ResultSet result = statement.executeQuery();
            ResultSetMetaData metaData = result.getMetaData();
            while (result.next()) {
                data[0] = result.getString("Payslip Number");
                data[1] = result.getInt("Employee ID");
                data[2] = result.getString("Full Name");
                data[3] = result.getString("Position");
                data[4] = result.getDate("Period From");
                data[5] = result.getDate("Period To");
                data[6] = result.getDouble("Monthly Salary");
                data[7] = result.getDouble("Daily Rate");
                data[8] = Math.toIntExact(result.getLong("Days Worked"));
                data[9] = result.getDouble("Total Overtime");
                data[10] = result.getDouble("Gross Income");
                data[11] = result.getDouble("Rice Subsidy");
                data[12] = result.getDouble("Phone Allowance");
                data[13] = result.getDouble("Clothing Allowance");
                data[14] = result.getDouble("Total Allowances");
                data[15] = result.getDouble("SSS");
                data[16] = result.getDouble("Pag-IBIG");
                data[17] = result.getDouble("Philhealth");
                data[18] = result.getDouble("Withholding Tax");
                data[19] = result.getDouble("Take-home Pay");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
    
    private void insertPdfToDB(byte[] file, java.util.Date startDate, java.util.Date endDate, int employeeID){
        try{
            String query = "INSERT INTO payroll_system_db.payslip(employee_id, period_id, payslip_file) VALUES (?, (SELECT period_id FROM payroll_period WHERE period_from = ? AND period_to = ?), ?)";
            java.sql.Connection conn = this.getDBConnection();
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, employeeID);
            statement.setDate(2, new java.sql.Date(startDate.getTime()));
            statement.setDate(3, new java.sql.Date(endDate.getTime()));
            statement.setBlob(4, new SerialBlob(file));
            statement.execute();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
