/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package payrollsystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Paul
 */
public class HumanResourceGUI extends javax.swing.JFrame {

    HumanResource humanResource = new HumanResource();
    ArrayList<String> data = new ArrayList<>(); //To hold as storage
    SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("MM/dd/yyyy");
    public HumanResourceGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sideBarPanel = new javax.swing.JPanel();
        btnPersonalDetails = new javax.swing.JButton();
        btnRequestPort = new javax.swing.JButton();
        btnDTR = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnLeaveLedger = new javax.swing.JButton();
        btnLeaveLedger1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblNameSidebar = new javax.swing.JLabel();
        lblName5 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        lblIDSidebar = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        btnAllEmployees = new javax.swing.JButton();
        btnAllCredentials = new javax.swing.JButton();
        mainTabbed = new javax.swing.JTabbedPane();
        panelMotorPH = new javax.swing.JPanel();
        tabbedPersonalDetails = new javax.swing.JPanel();
        panelPersonalDetails = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblBasicSalary = new javax.swing.JLabel();
        lblRiceSubsidy = new javax.swing.JLabel();
        lblPhoneAllowances = new javax.swing.JLabel();
        lblClothingAllowanes = new javax.swing.JLabel();
        txtBasicSalary = new javax.swing.JTextField();
        txtRiceSubsidy = new javax.swing.JTextField();
        txtPhoneAllowance = new javax.swing.JTextField();
        txtClothingAllowance = new javax.swing.JTextField();
        lblBiMonthlyRate = new javax.swing.JLabel();
        txtBiMonthlyRate = new javax.swing.JTextField();
        lblHourlyRate = new javax.swing.JLabel();
        txtHourlyRate = new javax.swing.JTextField();
        panelPersonalDetails1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblEmpID = new javax.swing.JLabel();
        lblFName = new javax.swing.JLabel();
        lblLName = new javax.swing.JLabel();
        lblBDay = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhoneNum = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtFName = new javax.swing.JTextField();
        txtLName = new javax.swing.JTextField();
        txtBDay = new javax.swing.JTextField();
        txtPhoneNum = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaAddress = new javax.swing.JTextArea();
        panelPersonalDetails2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblPhilNum = new javax.swing.JLabel();
        lblSSSNum = new javax.swing.JLabel();
        lblTINNum = new javax.swing.JLabel();
        lblPagIbigNum = new javax.swing.JLabel();
        txtPhilNum = new javax.swing.JTextField();
        txtSSSNum = new javax.swing.JTextField();
        txtTINNum = new javax.swing.JTextField();
        txtPagIbigNum = new javax.swing.JTextField();
        panelPersonalDetails3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblPosition = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblSupervisor = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtSupervisor = new javax.swing.JTextField();
        tabbedRequest = new javax.swing.JPanel();
        panelTypeRequest = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblRequestType = new javax.swing.JLabel();
        comboTypeRequest = new javax.swing.JComboBox<>();
        tabbedInsideRequest = new javax.swing.JTabbedPane();
        panelAllRequest = new javax.swing.JPanel();
        lblAllRequest = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableAllRequest = new javax.swing.JTable();
        jSeparator6 = new javax.swing.JSeparator();
        btnUpdate = new javax.swing.JButton();
        btnCancel2 = new javax.swing.JButton();
        panelLeaveRequestDetails = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtReason = new javax.swing.JTextArea();
        dateTo = new com.toedter.calendar.JDateChooser();
        dateFrom = new com.toedter.calendar.JDateChooser();
        lblMyName1 = new javax.swing.JLabel();
        txtDaysNumber = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lblSLBalance = new javax.swing.JLabel();
        lblVLBalance = new javax.swing.JLabel();
        lblSL = new javax.swing.JLabel();
        lblVL = new javax.swing.JLabel();
        lblLeaveBalances = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        lblID = new javax.swing.JLabel();
        lblMyName = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblEmpID1 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        comboLeaveType = new javax.swing.JComboBox<>();
        panelOvertimeRequest = new javax.swing.JPanel();
        lblEmpID2 = new javax.swing.JLabel();
        lblID1 = new javax.swing.JLabel();
        lblName1 = new javax.swing.JLabel();
        lblMyName2 = new javax.swing.JLabel();
        dateFromOvertime = new com.toedter.calendar.JDateChooser();
        dateToOvertime = new com.toedter.calendar.JDateChooser();
        lblMyName3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtReasonOvertime = new javax.swing.JTextArea();
        btnSubmit1 = new javax.swing.JButton();
        btnCancel1 = new javax.swing.JButton();
        lblLeaveBalances1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        tabbedDTR = new javax.swing.JPanel();
        panelDTR = new javax.swing.JPanel();
        tableDTR = new javax.swing.JScrollPane();
        jTableAllRequest2 = new javax.swing.JTable();
        dateFrom2 = new com.toedter.calendar.JDateChooser();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        lblPeriod = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        btnSubmitToSepervisor = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        lblName2 = new javax.swing.JLabel();
        lblMyName4 = new javax.swing.JLabel();
        lblEmpID3 = new javax.swing.JLabel();
        lblID2 = new javax.swing.JLabel();
        tabbedLeaveLedger = new javax.swing.JPanel();
        panelLeaveLedger = new javax.swing.JPanel();
        tableDTR1 = new javax.swing.JScrollPane();
        jTableAllRequest3 = new javax.swing.JTable();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        lblSL1 = new javax.swing.JLabel();
        lblSLBalance1 = new javax.swing.JLabel();
        lblVL1 = new javax.swing.JLabel();
        lblVLBalance1 = new javax.swing.JLabel();
        lblMyName5 = new javax.swing.JLabel();
        lblName3 = new javax.swing.JLabel();
        lblEmpID4 = new javax.swing.JLabel();
        lblID3 = new javax.swing.JLabel();
        lblLeaveBalances2 = new javax.swing.JLabel();
        tabbedPayslip = new javax.swing.JPanel();
        panelPayslip = new javax.swing.JPanel();
        jSeparator12 = new javax.swing.JSeparator();
        lblMyName6 = new javax.swing.JLabel();
        lblName4 = new javax.swing.JLabel();
        lblEmpID5 = new javax.swing.JLabel();
        lblID4 = new javax.swing.JLabel();
        dateFrom3 = new com.toedter.calendar.JDateChooser();
        dateTo3 = new com.toedter.calendar.JDateChooser();
        btnReport = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblName7 = new javax.swing.JLabel();
        lblName8 = new javax.swing.JLabel();
        lblName9 = new javax.swing.JLabel();
        lblName10 = new javax.swing.JLabel();
        lblName11 = new javax.swing.JLabel();
        lblName12 = new javax.swing.JLabel();
        lblName13 = new javax.swing.JLabel();
        lblName14 = new javax.swing.JLabel();
        lblName15 = new javax.swing.JLabel();
        lblName16 = new javax.swing.JLabel();
        lblName17 = new javax.swing.JLabel();
        lblName19 = new javax.swing.JLabel();
        lblName21 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        lblGross = new javax.swing.JLabel();
        lblBenefits = new javax.swing.JLabel();
        lblOvertime = new javax.swing.JLabel();
        lblUndertime = new javax.swing.JLabel();
        lblSSS = new javax.swing.JLabel();
        lblPhilHealth = new javax.swing.JLabel();
        lblPagIbig = new javax.swing.JLabel();
        lblTax = new javax.swing.JLabel();
        lblNetPay = new javax.swing.JLabel();
        lblPayrollPeriod1 = new javax.swing.JLabel();
        lblPositon = new javax.swing.JLabel();
        tabbedAllEmployees = new javax.swing.JPanel();
        panelTypeRequest1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        tabbedInsideRequest1 = new javax.swing.JTabbedPane();
        panelAllRequest1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableEmployees = new javax.swing.JTable();
        jSeparator16 = new javax.swing.JSeparator();
        btnAdd = new javax.swing.JButton();
        lblAllRequest3 = new javax.swing.JLabel();
        lblAllRequest4 = new javax.swing.JLabel();
        tabbedAllCredentials = new javax.swing.JPanel();
        panelTypeRequest2 = new javax.swing.JPanel();
        tabbedInsideRequest2 = new javax.swing.JTabbedPane();
        panelAllRequest2 = new javax.swing.JPanel();
        lblAllRequest2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableCredentials = new javax.swing.JTable();
        jSeparator17 = new javax.swing.JSeparator();
        btnUpdate2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LabelMotorPH.png"))); // NOI18N
        jPanel8.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 300, 70));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 110, 90));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout.png"))); // NOI18N
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 30, -1, 50));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1750, 100));

        sideBarPanel.setBackground(new java.awt.Color(255, 204, 102));

        btnPersonalDetails.setText("PERSONAL DETAILS");
        btnPersonalDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonalDetailsActionPerformed(evt);
            }
        });

        btnRequestPort.setText("MY PERSONAL REQUEST");
        btnRequestPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestPortActionPerformed(evt);
            }
        });

        btnDTR.setText("MY PERSONAL DTR");
        btnDTR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDTRActionPerformed(evt);
            }
        });

        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnLeaveLedger.setText("LEAVE LEDGER");
        btnLeaveLedger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaveLedgerActionPerformed(evt);
            }
        });

        btnLeaveLedger1.setText("PAYSLIP");
        btnLeaveLedger1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaveLedger1ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clock.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setText("8:00 AM");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/employee.png"))); // NOI18N

        lblNameSidebar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNameSidebar.setText("John Paul Arquita");

        lblName5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName5.setText("No.");

        jSeparator13.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator13.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator14.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator14.setForeground(new java.awt.Color(255, 255, 255));

        lblIDSidebar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblIDSidebar.setText("10001");

        jSeparator15.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator15.setForeground(new java.awt.Color(255, 255, 255));

        btnAllEmployees.setText(">>VIEW ALL EMPLOYEES");
        btnAllEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllEmployeesActionPerformed(evt);
            }
        });

        btnAllCredentials.setText(">>VIEW ALL CREDENTIALS");
        btnAllCredentials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllCredentialsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideBarPanelLayout = new javax.swing.GroupLayout(sideBarPanel);
        sideBarPanel.setLayout(sideBarPanelLayout);
        sideBarPanelLayout.setHorizontalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarPanelLayout.createSequentialGroup()
                        .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(sideBarPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel5)))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarPanelLayout.createSequentialGroup()
                        .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNameSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(sideBarPanelLayout.createSequentialGroup()
                                .addComponent(lblName5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIDSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43))))
            .addGroup(sideBarPanelLayout.createSequentialGroup()
                .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sideBarPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator14))
                    .addGroup(sideBarPanelLayout.createSequentialGroup()
                        .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarPanelLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(btnPersonalDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(sideBarPanelLayout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(sideBarPanelLayout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel6))
                            .addGroup(sideBarPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnRequestPort, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(sideBarPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnLeaveLedger1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(sideBarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLeaveLedger, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAllEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDTR, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAllCredentials, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sideBarPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator13)
                    .addContainerGap()))
            .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sideBarPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator15)
                    .addContainerGap()))
        );
        sideBarPanelLayout.setVerticalGroup(
            sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNameSidebar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName5)
                    .addComponent(lblIDSidebar))
                .addGap(36, 36, 36)
                .addComponent(btnPersonalDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRequestPort, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDTR, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLeaveLedger, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLeaveLedger1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAllEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAllCredentials, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sideBarPanelLayout.createSequentialGroup()
                    .addGap(158, 158, 158)
                    .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(599, Short.MAX_VALUE)))
            .addGroup(sideBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarPanelLayout.createSequentialGroup()
                    .addContainerGap(420, Short.MAX_VALUE)
                    .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(337, 337, 337)))
        );

        jPanel1.add(sideBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, 760));

        javax.swing.GroupLayout panelMotorPHLayout = new javax.swing.GroupLayout(panelMotorPH);
        panelMotorPH.setLayout(panelMotorPHLayout);
        panelMotorPHLayout.setHorizontalGroup(
            panelMotorPHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1510, Short.MAX_VALUE)
        );
        panelMotorPHLayout.setVerticalGroup(
            panelMotorPHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );

        mainTabbed.addTab("tab6", panelMotorPH);

        tabbedPersonalDetails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));

        panelPersonalDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salaries and Allowances", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N

        lblBasicSalary.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBasicSalary.setText("Basic Salary :");

        lblRiceSubsidy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRiceSubsidy.setText("Rice Subsidy: ");

        lblPhoneAllowances.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPhoneAllowances.setText("Phone Allowances: ");

        lblClothingAllowanes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblClothingAllowanes.setText("Clothing Allowances: ");

        txtBasicSalary.setEditable(false);
        txtBasicSalary.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBasicSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBasicSalaryActionPerformed(evt);
            }
        });

        txtRiceSubsidy.setEditable(false);
        txtRiceSubsidy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtRiceSubsidy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRiceSubsidyActionPerformed(evt);
            }
        });

        txtPhoneAllowance.setEditable(false);
        txtPhoneAllowance.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPhoneAllowance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneAllowanceActionPerformed(evt);
            }
        });

        txtClothingAllowance.setEditable(false);
        txtClothingAllowance.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtClothingAllowance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClothingAllowanceActionPerformed(evt);
            }
        });

        lblBiMonthlyRate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBiMonthlyRate.setText("BiMonthly Rate:");

        txtBiMonthlyRate.setEditable(false);
        txtBiMonthlyRate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lblHourlyRate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHourlyRate.setText("Hourly Rate:");

        txtHourlyRate.setEditable(false);
        txtHourlyRate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblBasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(lblBiMonthlyRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(36, 36, 36)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblHourlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHourlyRate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(txtBiMonthlyRate, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBasicSalary, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblClothingAllowanes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPhoneAllowances, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRiceSubsidy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhoneAllowance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(txtClothingAllowance, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtRiceSubsidy, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(6, 6, 6))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBasicSalary)
                    .addComponent(txtBasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBiMonthlyRate)
                    .addComponent(txtBiMonthlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHourlyRate)
                    .addComponent(txtHourlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRiceSubsidy)
                    .addComponent(txtRiceSubsidy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhoneAllowances)
                    .addComponent(txtPhoneAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClothingAllowanes)
                    .addComponent(txtClothingAllowance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelPersonalDetailsLayout = new javax.swing.GroupLayout(panelPersonalDetails);
        panelPersonalDetails.setLayout(panelPersonalDetailsLayout);
        panelPersonalDetailsLayout.setHorizontalGroup(
            panelPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        panelPersonalDetailsLayout.setVerticalGroup(
            panelPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalDetailsLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPersonalDetails1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal Details", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N

        lblEmpID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmpID.setText("Employee ID:");

        lblFName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFName.setText("First Name:");

        lblLName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblLName.setText("Last Name:");

        lblBDay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBDay.setText("Birthday:");

        lblAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblAddress.setText("Address: ");

        lblPhoneNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPhoneNum.setText("Phone No.");

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtFName.setEditable(false);
        txtFName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtLName.setEditable(false);
        txtLName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtBDay.setEditable(false);
        txtBDay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtPhoneNum.setEditable(false);
        txtPhoneNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        textAreaAddress.setEditable(false);
        textAreaAddress.setColumns(20);
        textAreaAddress.setRows(5);
        jScrollPane1.setViewportView(textAreaAddress);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblFName)
                        .addGap(25, 25, 25)
                        .addComponent(txtFName))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblPhoneNum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblBDay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblLName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblAddress))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtLName)
                            .addComponent(txtBDay)
                            .addComponent(txtPhoneNum))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFName)
                    .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLName)
                    .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBDay)
                    .addComponent(txtBDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPhoneNum)
                    .addComponent(txtPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddress)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPersonalDetails1Layout = new javax.swing.GroupLayout(panelPersonalDetails1);
        panelPersonalDetails1.setLayout(panelPersonalDetails1Layout);
        panelPersonalDetails1Layout.setHorizontalGroup(
            panelPersonalDetails1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalDetails1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPersonalDetails1Layout.setVerticalGroup(
            panelPersonalDetails1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalDetails1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPersonalDetails2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Government IDs", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N

        lblPhilNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPhilNum.setText("PhilHealth No.");

        lblSSSNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSSSNum.setText("SSS No.");

        lblTINNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTINNum.setText("TIN No.");

        lblPagIbigNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPagIbigNum.setText("PagIbig No.");

        txtPhilNum.setEditable(false);
        txtPhilNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSSSNum.setEditable(false);
        txtSSSNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTINNum.setEditable(false);
        txtTINNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtPagIbigNum.setEditable(false);
        txtPagIbigNum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPagIbigNum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(lblTINNum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTINNum, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(txtPagIbigNum)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSSSNum)
                            .addComponent(lblPhilNum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhilNum)
                            .addComponent(txtSSSNum))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPhilNum)
                    .addComponent(txtPhilNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSSSNum)
                    .addComponent(txtSSSNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTINNum)
                    .addComponent(txtTINNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPagIbigNum)
                    .addComponent(txtPagIbigNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPersonalDetails2Layout = new javax.swing.GroupLayout(panelPersonalDetails2);
        panelPersonalDetails2.setLayout(panelPersonalDetails2Layout);
        panelPersonalDetails2Layout.setHorizontalGroup(
            panelPersonalDetails2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalDetails2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPersonalDetails2Layout.setVerticalGroup(
            panelPersonalDetails2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalDetails2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPersonalDetails3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employment Details", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N

        lblPosition.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPosition.setText("Position: ");

        lblStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblStatus.setText("Status:");

        lblSupervisor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSupervisor.setText("Supervisor:");

        txtPosition.setEditable(false);
        txtPosition.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPositionActionPerformed(evt);
            }
        });

        txtStatus.setEditable(false);
        txtStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSupervisor.setEditable(false);
        txtSupervisor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupervisorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSupervisor, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(lblPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(txtSupervisor)
                    .addComponent(txtPosition))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosition)
                    .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupervisor)
                    .addComponent(txtSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelPersonalDetails3Layout = new javax.swing.GroupLayout(panelPersonalDetails3);
        panelPersonalDetails3.setLayout(panelPersonalDetails3Layout);
        panelPersonalDetails3Layout.setHorizontalGroup(
            panelPersonalDetails3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalDetails3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPersonalDetails3Layout.setVerticalGroup(
            panelPersonalDetails3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonalDetails3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabbedPersonalDetailsLayout = new javax.swing.GroupLayout(tabbedPersonalDetails);
        tabbedPersonalDetails.setLayout(tabbedPersonalDetailsLayout);
        tabbedPersonalDetailsLayout.setHorizontalGroup(
            tabbedPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabbedPersonalDetailsLayout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(panelPersonalDetails1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(panelPersonalDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(panelPersonalDetails2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(panelPersonalDetails3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        tabbedPersonalDetailsLayout.setVerticalGroup(
            tabbedPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedPersonalDetailsLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(tabbedPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelPersonalDetails1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPersonalDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPersonalDetails2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPersonalDetails3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(252, Short.MAX_VALUE))
        );

        mainTabbed.addTab("Personal Details", tabbedPersonalDetails);

        panelTypeRequest.setBackground(new java.awt.Color(255, 255, 255));
        panelTypeRequest.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NEW REQUEST", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 102, 0))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRequestType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRequestType.setText("Request Type :");
        jPanel2.add(lblRequestType, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 16, 108, -1));

        comboTypeRequest.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All Request", "Leave Application", "Overtime Application" }));
        comboTypeRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTypeRequestActionPerformed(evt);
            }
        });
        jPanel2.add(comboTypeRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 12, 198, 31));

        tabbedInsideRequest.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        panelAllRequest.setBackground(new java.awt.Color(255, 255, 255));

        lblAllRequest.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAllRequest.setText("ALL REQUEST");

        jTableAllRequest.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableAllRequest.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableAllRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DATE FILED", "TYPE OF REQUEST", "PERIOD FROM", "PERIOD TO", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAllRequest.setColumnSelectionAllowed(true);
        jTableAllRequest.setRowHeight(25);
        jTableAllRequest.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTableAllRequest);

        jSeparator6.setBackground(new java.awt.Color(255, 204, 153));

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel2.setText("CANCEL");
        btnCancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAllRequestLayout = new javax.swing.GroupLayout(panelAllRequest);
        panelAllRequest.setLayout(panelAllRequestLayout);
        panelAllRequestLayout.setHorizontalGroup(
            panelAllRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAllRequestLayout.createSequentialGroup()
                .addGroup(panelAllRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAllRequestLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAllRequestLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequestLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAllRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequestLayout.createSequentialGroup()
                        .addComponent(lblAllRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(274, 274, 274))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequestLayout.createSequentialGroup()
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelAllRequestLayout.setVerticalGroup(
            panelAllRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAllRequestLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblAllRequest)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAllRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        tabbedInsideRequest.addTab("", panelAllRequest);

        panelLeaveRequestDetails.setBackground(new java.awt.Color(255, 255, 255));

        txtReason.setColumns(20);
        txtReason.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtReason.setRows(5);
        txtReason.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reason", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N
        jScrollPane2.setViewportView(txtReason);

        dateTo.setBackground(new java.awt.Color(255, 255, 255));
        dateTo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "To", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N
        dateTo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateToPropertyChange(evt);
            }
        });

        dateFrom.setBackground(new java.awt.Color(255, 255, 255));
        dateFrom.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "From", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51)))); // NOI18N
        dateFrom.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateFromPropertyChange(evt);
            }
        });

        lblMyName1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMyName1.setText("Inclusive Dates");

        txtDaysNumber.setEditable(false);
        txtDaysNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDaysNumber.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Number of Working Days Applied For", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 102))); // NOI18N
        txtDaysNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDaysNumberActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        lblSLBalance.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSLBalance.setText("30.30");

        lblVLBalance.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVLBalance.setText("20.20");

        lblSL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSL.setText("Sick Leave Leave (SL) :");

        lblVL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblVL.setText("Vacation Leave (VL) :");

        lblLeaveBalances.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLeaveBalances.setText("Leave Balances as of this Date");

        jSeparator3.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator1.setBackground(new java.awt.Color(255, 204, 153));

        lblID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblID.setText("123");

        lblMyName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMyName.setText("John Paul Arquita");

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName.setText("Name :");

        lblEmpID1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmpID1.setText("Employee ID:");

        btnSubmit.setText("SUBMIT");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        comboLeaveType.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboLeaveType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Vacation Leave", "Sick Leave" }));
        comboLeaveType.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Type of Leave", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N

        javax.swing.GroupLayout panelLeaveRequestDetailsLayout = new javax.swing.GroupLayout(panelLeaveRequestDetails);
        panelLeaveRequestDetails.setLayout(panelLeaveRequestDetailsLayout);
        panelLeaveRequestDetailsLayout.setHorizontalGroup(
            panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmpID1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMyName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104)
                        .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                                .addComponent(lblSL, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblSLBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                                .addComponent(lblVL, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblVLBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeaveRequestDetailsLayout.createSequentialGroup()
                        .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDaysNumber)
                                        .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblMyName1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dateTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboLeaveType, 0, 233, Short.MAX_VALUE))))
                        .addGap(78, 78, 78))))
            .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(lblLeaveBalances, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelLeaveRequestDetailsLayout.setVerticalGroup(
            panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeaveRequestDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLeaveBalances)
                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                        .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmpID1)
                            .addComponent(lblID))
                        .addGap(13, 13, 13)
                        .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMyName)
                            .addComponent(lblName)))
                    .addGroup(panelLeaveRequestDetailsLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVLBalance)
                            .addComponent(lblVL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSLBalance)
                            .addComponent(lblSL))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDaysNumber)
                    .addComponent(comboLeaveType, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(lblMyName1)
                .addGap(9, 9, 9)
                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateTo, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(dateFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLeaveRequestDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tabbedInsideRequest.addTab("", panelLeaveRequestDetails);

        panelOvertimeRequest.setBackground(new java.awt.Color(255, 255, 255));

        lblEmpID2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmpID2.setText("Employee ID:");

        lblID1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblID1.setText("10001");

        lblName1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName1.setText("Name :");

        lblMyName2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMyName2.setText("John Paul Arquita");

        dateFromOvertime.setBackground(new java.awt.Color(255, 255, 255));
        dateFromOvertime.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "From", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51)))); // NOI18N

        dateToOvertime.setBackground(new java.awt.Color(255, 255, 255));
        dateToOvertime.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "To", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N

        lblMyName3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMyName3.setText("Inclusive Dates*");

        txtReasonOvertime.setColumns(20);
        txtReasonOvertime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtReasonOvertime.setRows(5);
        txtReasonOvertime.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reason", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N
        jScrollPane3.setViewportView(txtReasonOvertime);

        btnSubmit1.setText("SUBMIT");
        btnSubmit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmit1ActionPerformed(evt);
            }
        });

        btnCancel1.setText("CANCEL");
        btnCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel1ActionPerformed(evt);
            }
        });

        lblLeaveBalances1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLeaveBalances1.setText("Overtime Request");

        jSeparator4.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator5.setBackground(new java.awt.Color(255, 204, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel1.setText("*Please be informed that the overtime period is from 5:01pm to 9:00pm only.");

        javax.swing.GroupLayout panelOvertimeRequestLayout = new javax.swing.GroupLayout(panelOvertimeRequest);
        panelOvertimeRequest.setLayout(panelOvertimeRequestLayout);
        panelOvertimeRequestLayout.setHorizontalGroup(
            panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                .addGap(429, 429, 429)
                .addComponent(dateToOvertime, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addGap(75, 75, 75))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOvertimeRequestLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLeaveBalances1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
            .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                        .addComponent(btnSubmit1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                        .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmpID2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMyName2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                            .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dateFromOvertime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblMyName3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(73, 73, 73)))
            .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jSeparator4)
                    .addGap(2, 2, 2)))
            .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelOvertimeRequestLayout.setVerticalGroup(
            panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblLeaveBalances1)
                .addGap(37, 37, 37)
                .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpID2)
                    .addComponent(lblID1))
                .addGap(13, 13, 13)
                .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMyName2)
                    .addComponent(lblName1))
                .addGap(60, 60, 60)
                .addComponent(dateToOvertime, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
            .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(lblMyName3)
                    .addGap(9, 9, 9)
                    .addComponent(dateFromOvertime, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(28, 28, 28)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(168, Short.MAX_VALUE)))
            .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                    .addGap(151, 151, 151)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(413, Short.MAX_VALUE)))
            .addGroup(panelOvertimeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelOvertimeRequestLayout.createSequentialGroup()
                    .addGap(451, 451, 451)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(113, Short.MAX_VALUE)))
        );

        tabbedInsideRequest.addTab("", panelOvertimeRequest);

        javax.swing.GroupLayout panelTypeRequestLayout = new javax.swing.GroupLayout(panelTypeRequest);
        panelTypeRequest.setLayout(panelTypeRequestLayout);
        panelTypeRequestLayout.setHorizontalGroup(
            panelTypeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTypeRequestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelTypeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelTypeRequestLayout.createSequentialGroup()
                    .addComponent(tabbedInsideRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 711, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panelTypeRequestLayout.setVerticalGroup(
            panelTypeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTypeRequestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(614, Short.MAX_VALUE))
            .addGroup(panelTypeRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTypeRequestLayout.createSequentialGroup()
                    .addGap(0, 59, Short.MAX_VALUE)
                    .addComponent(tabbedInsideRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout tabbedRequestLayout = new javax.swing.GroupLayout(tabbedRequest);
        tabbedRequest.setLayout(tabbedRequestLayout);
        tabbedRequestLayout.setHorizontalGroup(
            tabbedRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedRequestLayout.createSequentialGroup()
                .addGap(337, 337, 337)
                .addComponent(panelTypeRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(450, Short.MAX_VALUE))
        );
        tabbedRequestLayout.setVerticalGroup(
            tabbedRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedRequestLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(panelTypeRequest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        mainTabbed.addTab("Request Port", tabbedRequest);

        panelDTR.setBackground(new java.awt.Color(255, 255, 255));
        panelDTR.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "YOUR DAILY TIME RECORD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 102, 0))); // NOI18N

        jTableAllRequest2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableAllRequest2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DATE", "LOGIN", "LOGOUT", "REMARKS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAllRequest2.setColumnSelectionAllowed(true);
        jTableAllRequest2.setRowHeight(25);
        jTableAllRequest2.getTableHeader().setReorderingAllowed(false);
        tableDTR.setViewportView(jTableAllRequest2);

        dateFrom2.setBackground(new java.awt.Color(255, 255, 255));
        dateFrom2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "From", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51)))); // NOI18N

        jDateChooser3.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "To", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N

        lblPeriod.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPeriod.setText("Period :");

        jSeparator7.setBackground(new java.awt.Color(255, 204, 153));

        btnSubmitToSepervisor.setText("SUBMIT");
        btnSubmitToSepervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitToSepervisorActionPerformed(evt);
            }
        });

        jSeparator8.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));

        lblName2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName2.setText("Name :");

        lblMyName4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMyName4.setText("John Paul Arquita");

        lblEmpID3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmpID3.setText("Employee ID:");

        lblID2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblID2.setText("10001");

        javax.swing.GroupLayout panelDTRLayout = new javax.swing.GroupLayout(panelDTR);
        panelDTR.setLayout(panelDTRLayout);
        panelDTRLayout.setHorizontalGroup(
            panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator7)
            .addGroup(panelDTRLayout.createSequentialGroup()
                .addGroup(panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDTRLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnSubmitToSepervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDTRLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmpID3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMyName4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelDTRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDTRLayout.createSequentialGroup()
                        .addGap(0, 39, Short.MAX_VALUE)
                        .addGroup(panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelDTRLayout.createSequentialGroup()
                                .addComponent(lblPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dateFrom2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDTRLayout.createSequentialGroup()
                                .addComponent(tableDTR, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))))
                    .addComponent(jSeparator8)))
        );
        panelDTRLayout.setVerticalGroup(
            panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDTRLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpID3)
                    .addComponent(lblID2))
                .addGap(13, 13, 13)
                .addGroup(panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMyName4)
                    .addComponent(lblName2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateFrom2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPeriod, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(tableDTR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSubmitToSepervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout tabbedDTRLayout = new javax.swing.GroupLayout(tabbedDTR);
        tabbedDTR.setLayout(tabbedDTRLayout);
        tabbedDTRLayout.setHorizontalGroup(
            tabbedDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedDTRLayout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(panelDTR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(267, Short.MAX_VALUE))
        );
        tabbedDTRLayout.setVerticalGroup(
            tabbedDTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabbedDTRLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(panelDTR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        mainTabbed.addTab("tab3", tabbedDTR);

        panelLeaveLedger.setBackground(new java.awt.Color(255, 255, 255));
        panelLeaveLedger.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "YOUR LEAVE LEDGER HISTORY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 102, 0))); // NOI18N

        jTableAllRequest3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableAllRequest3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PERIOD", "PARTICULARS", "EARNED VL", "DEDUCTION VL", "BALANCE VL", "EARNED SL", "DEDUCTION SL", "BALANCE SL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAllRequest3.setRowHeight(25);
        jTableAllRequest3.getTableHeader().setReorderingAllowed(false);
        tableDTR1.setViewportView(jTableAllRequest3);

        jSeparator9.setBackground(new java.awt.Color(255, 204, 153));

        jSeparator11.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator11.setForeground(new java.awt.Color(255, 255, 255));

        lblSL1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSL1.setText("Sick Leave Leave (SL) :");

        lblSLBalance1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSLBalance1.setText("30.30");

        lblVL1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblVL1.setText("Vacation Leave (VL) :");

        lblVLBalance1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblVLBalance1.setText("20.20");

        lblMyName5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMyName5.setText("John Paul Arquita");

        lblName3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName3.setText("Name :");

        lblEmpID4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmpID4.setText("Employee ID:");

        lblID3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblID3.setText("10001");

        lblLeaveBalances2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLeaveBalances2.setText("LEAVE LEDGER");

        javax.swing.GroupLayout panelLeaveLedgerLayout = new javax.swing.GroupLayout(panelLeaveLedger);
        panelLeaveLedger.setLayout(panelLeaveLedgerLayout);
        panelLeaveLedgerLayout.setHorizontalGroup(
            panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator9)
            .addGroup(panelLeaveLedgerLayout.createSequentialGroup()
                .addComponent(jSeparator11)
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeaveLedgerLayout.createSequentialGroup()
                .addGap(0, 47, Short.MAX_VALUE)
                .addComponent(tableDTR1, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeaveLedgerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmpID4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblID3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMyName5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(180, 180, 180)
                .addGroup(panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLeaveLedgerLayout.createSequentialGroup()
                        .addComponent(lblSL1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSLBalance1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLeaveLedgerLayout.createSequentialGroup()
                        .addComponent(lblVL1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblVLBalance1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(215, 215, 215))
            .addGroup(panelLeaveLedgerLayout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(lblLeaveBalances2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLeaveLedgerLayout.setVerticalGroup(
            panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeaveLedgerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblLeaveBalances2)
                .addGap(22, 22, 22)
                .addGroup(panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLeaveLedgerLayout.createSequentialGroup()
                        .addGroup(panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmpID4)
                            .addComponent(lblID3))
                        .addGap(13, 13, 13)
                        .addGroup(panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMyName5)
                            .addComponent(lblName3)))
                    .addGroup(panelLeaveLedgerLayout.createSequentialGroup()
                        .addGroup(panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVLBalance1)
                            .addComponent(lblVL1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSLBalance1)
                            .addComponent(lblSL1))))
                .addGap(21, 21, 21)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tableDTR1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout tabbedLeaveLedgerLayout = new javax.swing.GroupLayout(tabbedLeaveLedger);
        tabbedLeaveLedger.setLayout(tabbedLeaveLedgerLayout);
        tabbedLeaveLedgerLayout.setHorizontalGroup(
            tabbedLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedLeaveLedgerLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(panelLeaveLedger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        tabbedLeaveLedgerLayout.setVerticalGroup(
            tabbedLeaveLedgerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabbedLeaveLedgerLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(panelLeaveLedger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        mainTabbed.addTab("tab4", tabbedLeaveLedger);

        panelPayslip.setBackground(new java.awt.Color(255, 255, 255));
        panelPayslip.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "YOUR PERSONAL PAYSLIP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 102, 0))); // NOI18N

        jSeparator12.setBackground(new java.awt.Color(255, 204, 153));
        jSeparator12.setForeground(new java.awt.Color(255, 255, 255));

        lblMyName6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMyName6.setText("N/A");

        lblName4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName4.setText("Name :");

        lblEmpID5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEmpID5.setText("Employee ID:");

        lblID4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblID4.setText("N/A");

        dateFrom3.setBackground(new java.awt.Color(255, 255, 255));
        dateFrom3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "From", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51)))); // NOI18N

        dateTo3.setBackground(new java.awt.Color(255, 255, 255));
        dateTo3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "To", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 153, 51))); // NOI18N

        btnReport.setText("Generate");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        lblName7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName7.setText("Payroll Period : ");

        lblName8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName8.setText("Position :");

        lblName9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName9.setText("Gross Income : ");

        lblName10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName10.setText("Add :");

        lblName11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName11.setText("Overtime");

        lblName12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName12.setText("Undertime");

        lblName13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName13.setText("SSS");

        lblName14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName14.setText("PhilHealth");

        lblName15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName15.setText("PagIbig");

        lblName16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName16.setText("Tax");

        lblName17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName17.setText("Benefits/Allowances");

        lblName19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName19.setText("Less :");

        lblName21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblName21.setText("Net Pay");

        lblGross.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGross.setText("0.00");

        lblBenefits.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBenefits.setText("0.00");

        lblOvertime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblOvertime.setText("0.00");

        lblUndertime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUndertime.setText("0.00");

        lblSSS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSSS.setText("0.00");

        lblPhilHealth.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPhilHealth.setText("0.00");

        lblPagIbig.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPagIbig.setText("0.00");

        lblTax.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTax.setText("0.00");

        lblNetPay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNetPay.setText("0.00");

        lblPayrollPeriod1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPayrollPeriod1.setText("N/A");

        lblPositon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPositon.setText("N/A");

        javax.swing.GroupLayout panelPayslipLayout = new javax.swing.GroupLayout(panelPayslip);
        panelPayslip.setLayout(panelPayslipLayout);
        panelPayslipLayout.setHorizontalGroup(
            panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator12)
            .addGroup(panelPayslipLayout.createSequentialGroup()
                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPayslipLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel7))
                    .addGroup(panelPayslipLayout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(dateFrom3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dateTo3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReport))
                    .addGroup(panelPayslipLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelPayslipLayout.createSequentialGroup()
                                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblName9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblName7))
                                    .addComponent(lblName8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPositon, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPayrollPeriod1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelPayslipLayout.createSequentialGroup()
                                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEmpID5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblName4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelPayslipLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(lblMyName6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelPayslipLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lblID4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panelPayslipLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelPayslipLayout.createSequentialGroup()
                                        .addComponent(lblName10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblName11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblName17, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelPayslipLayout.createSequentialGroup()
                                        .addComponent(lblName19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22)
                                        .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblName12, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblName13, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblName14, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblName15, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblName16, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblName21, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelPayslipLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(panelPayslipLayout.createSequentialGroup()
                                                        .addGap(90, 90, 90)
                                                        .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(lblUndertime, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblSSS, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblPhilHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblPagIbig, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblTax, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblOvertime, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblBenefits, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lblGross, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(panelPayslipLayout.createSequentialGroup()
                                                        .addGap(91, 91, 91)
                                                        .addComponent(lblNetPay, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(24, 24, 24))
                                            .addGroup(panelPayslipLayout.createSequentialGroup()
                                                .addGap(62, 62, 62)
                                                .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 33, Short.MAX_VALUE)))))))))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        panelPayslipLayout.setVerticalGroup(
            panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPayslipLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateTo3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateFrom3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(28, 28, 28)
                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpID5)
                    .addComponent(lblID4))
                .addGap(13, 13, 13)
                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMyName6)
                    .addComponent(lblName4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName7)
                    .addComponent(lblPayrollPeriod1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName8)
                    .addComponent(lblPositon))
                .addGap(18, 18, 18)
                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName9)
                    .addComponent(lblGross))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName10)
                    .addComponent(lblName17)
                    .addComponent(lblBenefits))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName11)
                    .addComponent(lblOvertime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPayslipLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panelPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName12)
                            .addComponent(lblName19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblName13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblName14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblName15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblName16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblName21))
                    .addGroup(panelPayslipLayout.createSequentialGroup()
                        .addComponent(lblUndertime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSSS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPhilHealth)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPagIbig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTax)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNetPay)))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout tabbedPayslipLayout = new javax.swing.GroupLayout(tabbedPayslip);
        tabbedPayslip.setLayout(tabbedPayslipLayout);
        tabbedPayslipLayout.setHorizontalGroup(
            tabbedPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedPayslipLayout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(panelPayslip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(306, Short.MAX_VALUE))
        );
        tabbedPayslipLayout.setVerticalGroup(
            tabbedPayslipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedPayslipLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(panelPayslip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        mainTabbed.addTab("tab5", tabbedPayslip);

        panelTypeRequest1.setBackground(new java.awt.Color(255, 255, 255));
        panelTypeRequest1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ALL EMPLOYEE DETAILS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 102, 0))); // NOI18N
        panelTypeRequest1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabbedInsideRequest1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        panelAllRequest1.setBackground(new java.awt.Color(255, 255, 255));

        jTableEmployees.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableEmployees.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "LAST NAME", "FIRST NAME", "BIRTHDAY", "ADDRESS", "PHONE #", "SSS #", "PHILHEALTH #", "TINE #", "PAGIBIG #", "STATUS", "POSITION", "IMMEDIATE SUPERVISOR", "BASIC SALARY", "RICE SUBSIDY", "PHONE ALLOWANC", "CLOTHING ALLOWANCE", "SEMI-MONTHLY", "HOURLY RATE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEmployees.setColumnSelectionAllowed(true);
        jTableEmployees.setRowHeight(25);
        jTableEmployees.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTableEmployees);
        jTableEmployees.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jSeparator16.setBackground(new java.awt.Color(255, 204, 153));

        btnAdd.setText("ADD NEW EMPLOYEE");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblAllRequest3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        lblAllRequest4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAllRequest4.setText("ALL EMPLOYEE DETAILS");

        javax.swing.GroupLayout panelAllRequest1Layout = new javax.swing.GroupLayout(panelAllRequest1);
        panelAllRequest1.setLayout(panelAllRequest1Layout);
        panelAllRequest1Layout.setHorizontalGroup(
            panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAllRequest1Layout.createSequentialGroup()
                .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequest1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequest1Layout.createSequentialGroup()
                                .addGap(528, 528, 528)
                                .addComponent(lblAllRequest3)
                                .addGap(18, 18, 18)
                                .addComponent(lblAllRequest4)
                                .addGap(0, 723, Short.MAX_VALUE))
                            .addComponent(jSeparator16)))
                    .addGroup(panelAllRequest1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5))
                    .addGroup(panelAllRequest1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAllRequest1Layout.setVerticalGroup(
            panelAllRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAllRequest1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblAllRequest4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAllRequest3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        tabbedInsideRequest1.addTab("", panelAllRequest1);

        javax.swing.GroupLayout panelTypeRequest1Layout = new javax.swing.GroupLayout(panelTypeRequest1);
        panelTypeRequest1.setLayout(panelTypeRequest1Layout);
        panelTypeRequest1Layout.setHorizontalGroup(
            panelTypeRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTypeRequest1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(tabbedInsideRequest1)
        );
        panelTypeRequest1Layout.setVerticalGroup(
            panelTypeRequest1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTypeRequest1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedInsideRequest1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout tabbedAllEmployeesLayout = new javax.swing.GroupLayout(tabbedAllEmployees);
        tabbedAllEmployees.setLayout(tabbedAllEmployeesLayout);
        tabbedAllEmployeesLayout.setHorizontalGroup(
            tabbedAllEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedAllEmployeesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTypeRequest1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        tabbedAllEmployeesLayout.setVerticalGroup(
            tabbedAllEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabbedAllEmployeesLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(panelTypeRequest1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        mainTabbed.addTab("tab7", tabbedAllEmployees);

        panelTypeRequest2.setBackground(new java.awt.Color(255, 255, 255));
        panelTypeRequest2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ALL EMPLOYEE CREDENTIALS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 18), new java.awt.Color(255, 102, 0))); // NOI18N

        tabbedInsideRequest2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        panelAllRequest2.setBackground(new java.awt.Color(255, 255, 255));

        lblAllRequest2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAllRequest2.setText("ALL EMPLOYEE CREDENTIALS");

        jTableCredentials.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableCredentials.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableCredentials.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "PASSWORD", "ROLE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCredentials.setColumnSelectionAllowed(true);
        jTableCredentials.setRowHeight(25);
        jTableCredentials.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jTableCredentials);
        jTableCredentials.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jSeparator17.setBackground(new java.awt.Color(255, 204, 153));

        btnUpdate2.setText("ADD NEW CREDENTIALS");
        btnUpdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAllRequest2Layout = new javax.swing.GroupLayout(panelAllRequest2);
        panelAllRequest2.setLayout(panelAllRequest2Layout);
        panelAllRequest2Layout.setHorizontalGroup(
            panelAllRequest2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAllRequest2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
            .addGroup(panelAllRequest2Layout.createSequentialGroup()
                .addGroup(panelAllRequest2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAllRequest2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnUpdate2))
                    .addGroup(panelAllRequest2Layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(lblAllRequest2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAllRequest2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 957, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAllRequest2Layout.setVerticalGroup(
            panelAllRequest2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAllRequest2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblAllRequest2)
                .addGap(45, 45, 45)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        tabbedInsideRequest2.addTab("", panelAllRequest2);

        javax.swing.GroupLayout panelTypeRequest2Layout = new javax.swing.GroupLayout(panelTypeRequest2);
        panelTypeRequest2.setLayout(panelTypeRequest2Layout);
        panelTypeRequest2Layout.setHorizontalGroup(
            panelTypeRequest2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedInsideRequest2, javax.swing.GroupLayout.PREFERRED_SIZE, 962, Short.MAX_VALUE)
        );
        panelTypeRequest2Layout.setVerticalGroup(
            panelTypeRequest2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedInsideRequest2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout tabbedAllCredentialsLayout = new javax.swing.GroupLayout(tabbedAllCredentials);
        tabbedAllCredentials.setLayout(tabbedAllCredentialsLayout);
        tabbedAllCredentialsLayout.setHorizontalGroup(
            tabbedAllCredentialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabbedAllCredentialsLayout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(panelTypeRequest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(278, Short.MAX_VALUE))
        );
        tabbedAllCredentialsLayout.setVerticalGroup(
            tabbedAllCredentialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabbedAllCredentialsLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(panelTypeRequest2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        mainTabbed.addTab("tab8", tabbedAllCredentials);

        jPanel1.add(mainTabbed, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 1510, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1746, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdate2ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        NewEmployeeGUI newEmployeeGUI = new NewEmployeeGUI();
        newEmployeeGUI.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        // TODO add your handling code here:
        ArrayList<ArrayList<String>> tempData = humanResource.viewPersonalPayslip(dateFrom3.getDate(), dateTo3.getDate(), lblIDSidebar.getText());
        System.out.println(tempData);
        if(tempData.isEmpty()){
            JOptionPane.showMessageDialog(null, "No Payroll Found!");
            lblID4.setText("N/A");
            lblMyName6.setText("N/A");
            lblPayrollPeriod1.setText("N/A");
            lblPositon.setText("N/A");
            lblGross.setText("0.00");
            lblBenefits.setText("0.00");
            lblOvertime.setText("0.00");
            lblUndertime.setText("0.00");
            lblSSS.setText("0.00");
            lblPhilHealth.setText("0.00");
            lblPagIbig.setText("0.00");
            lblTax.setText("0.00");
            lblNetPay.setText("0.00");
        }else{
            lblID4.setText(tempData.get(0).get(0));
            lblMyName6.setText(tempData.get(0).get(1));
            lblPayrollPeriod1.setText(tempData.get(0).get(2));
            lblPositon.setText(tempData.get(0).get(3));
            lblGross.setText(tempData.get(0).get(4));
            lblBenefits.setText(tempData.get(0).get(5));
            lblOvertime.setText(tempData.get(0).get(6));
            lblUndertime.setText(tempData.get(0).get(7));
            lblSSS.setText(tempData.get(0).get(8));
            lblPhilHealth.setText(tempData.get(0).get(9));
            lblPagIbig.setText(tempData.get(0).get(10));
            lblTax.setText(tempData.get(0).get(11));
            lblNetPay.setText(tempData.get(0).get(12));
        }
        tempData.clear();
    }//GEN-LAST:event_btnReportActionPerformed

    private void btnSubmitToSepervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitToSepervisorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubmitToSepervisorActionPerformed

    private void btnCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancel1ActionPerformed

    private void btnSubmit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmit1ActionPerformed
        // TODO add your handling code here:
                if(dateToOvertime.getDate() != null && dateFromOvertime.getDate() != null && !txtReasonOvertime.getText().trim().isEmpty()){
                        if(humanResource.countNumberOfDays(dateFromOvertime.getDate(), dateToOvertime.getDate())){
                                data.add(String.valueOf(humanResource.getEmployeeID()));
                                data.add(humanResource.accountDetails.getEmployeeCompleteName());
                                data.add(dateFormat.format(dateFromOvertime.getDate()));
                                data.add(dateFormat.format(dateToOvertime.getDate()));
                                data.add(txtReasonOvertime.getText());
                                if(humanResource.fileOvertimeRequest(data)){
                                        dateFromOvertime.setDate(null);
                                        dateToOvertime.setDate(null);
                                        txtReasonOvertime.setText(null);
                                        humanResource.setNumberOfDaysLeave();
                                    }
                            }
                    }else{
                        JOptionPane.showMessageDialog(null, "Provide all the neccessary details for overtime!!");
                    }
    }//GEN-LAST:event_btnSubmit1ActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        comboTypeRequest.setSelectedIndex(0);
        tabbedInsideRequest.setSelectedIndex(0);
        txtDaysNumber.setText(null);
        comboLeaveType.setSelectedIndex(0);
        dateFrom.setDate(null);
        dateTo.setDate(null);
        txtReason.setText(null);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        if (comboLeaveType.getSelectedIndex() == 0 || dateFrom.getDate() == null || dateTo.getDate() == null || txtReason.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please provide all the necessary details for filing of Leave Request!");
            return;
        }else if(txtDaysNumber.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Error date of leave!");
            return;
        }

        data.add(String.valueOf(humanResource.getEmployeeID()));
        data.add(humanResource.accountDetails.getEmployeeCompleteName());
        data.add(comboLeaveType.getSelectedItem().toString());
        data.add(dateFormat.format(dateTo.getDate()));
        data.add(txtDaysNumber.getText());
        data.add(txtReason.getText());

        if(humanResource.fileLeaveRequest(data)){
            txtDaysNumber.setText(null);
            comboLeaveType.setSelectedIndex(0);
            dateFrom.setDate(null);
            dateTo.setDate(null);
            txtReason.setText(null);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtDaysNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDaysNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDaysNumberActionPerformed

    private void dateFromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateFromPropertyChange
        // TODO add your handling code here:
        if(dateTo.getDate() != null && dateFrom.getDate() != null){
            if(humanResource.countNumberOfDays(dateFrom.getDate(), dateTo.getDate())){
                txtDaysNumber.setText(String.valueOf(humanResource.getNumberOfDaysLeave()));
                humanResource.setNumberOfDaysLeave();
            }else{
                humanResource.setNumberOfDaysLeave();
                txtDaysNumber.setText(String.valueOf(humanResource.getNumberOfDaysLeave()));
            }
        }
    }//GEN-LAST:event_dateFromPropertyChange

    private void dateToPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateToPropertyChange
        // TODO add your handling code here:
        if(dateFrom.getDate() != null && dateTo.getDate() != null){
            if(humanResource.countNumberOfDays(dateFrom.getDate(), dateTo.getDate())){
                txtDaysNumber.setText(String.valueOf(humanResource.getNumberOfDaysLeave()));
                humanResource.setNumberOfDaysLeave();
            }else{
                humanResource.setNumberOfDaysLeave();
                txtDaysNumber.setText(String.valueOf(humanResource.getNumberOfDaysLeave()));
            }
        }
    }//GEN-LAST:event_dateToPropertyChange

    private void btnCancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancel2ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void comboTypeRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTypeRequestActionPerformed
        // TODO add your handling code here:
        String selectedItem = comboTypeRequest.getSelectedItem().toString();

        if(selectedItem.equals("All Request")) {
            tabbedInsideRequest.setSelectedIndex(0);
        } else if(selectedItem.equals("Leave Application")) {
            tabbedInsideRequest.setSelectedIndex(1);

            humanResource.leaveBalancesInformation();
            lblID.setText(String.valueOf(humanResource.accountDetails.getEmployeeID()));
            lblMyName.setText(humanResource.accountDetails.getEmployeeCompleteName());
            lblVLBalance.setText(humanResource.getBalanceVL());
            lblSLBalance.setText(humanResource.getBalanceSL());

        } else {
            tabbedInsideRequest.setSelectedIndex(2);
        }
    }//GEN-LAST:event_comboTypeRequestActionPerformed

    private void txtSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupervisorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupervisorActionPerformed

    private void txtPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPositionActionPerformed

    private void txtClothingAllowanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClothingAllowanceActionPerformed

    }//GEN-LAST:event_txtClothingAllowanceActionPerformed

    private void txtPhoneAllowanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneAllowanceActionPerformed

    }//GEN-LAST:event_txtPhoneAllowanceActionPerformed

    private void txtRiceSubsidyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRiceSubsidyActionPerformed

    }//GEN-LAST:event_txtRiceSubsidyActionPerformed

    private void txtBasicSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBasicSalaryActionPerformed

    }//GEN-LAST:event_txtBasicSalaryActionPerformed

    private void btnAllCredentialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllCredentialsActionPerformed
        // TODO add your handling code here:
        mainTabbed.setSelectedIndex(7);
        humanResource.setTableData(humanResource.displayAllCredentials());
        humanResource.setTableSize(4);
        humanResource.displayDataTable(jTableCredentials);
    }//GEN-LAST:event_btnAllCredentialsActionPerformed

    private void btnAllEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllEmployeesActionPerformed
        // TODO add your handling code here:
        mainTabbed.setSelectedIndex(6);
        humanResource.setTableData(humanResource.displayAllDetails());
        humanResource.setTableSize(19);
        humanResource.displayDataTable(jTableEmployees);
    }//GEN-LAST:event_btnAllEmployeesActionPerformed

    private void btnLeaveLedger1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaveLedger1ActionPerformed
        // TODO add your handling code here:
        mainTabbed.setSelectedIndex(5);
    }//GEN-LAST:event_btnLeaveLedger1ActionPerformed

    private void btnLeaveLedgerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaveLedgerActionPerformed
        // TODO add your handling code here:
        mainTabbed.setSelectedIndex(4);
    }//GEN-LAST:event_btnLeaveLedgerActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        humanResource.userLogin();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        humanResource.userLogout();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnDTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDTRActionPerformed
        // TODO add your handling code here:
        mainTabbed.setSelectedIndex(3);
    }//GEN-LAST:event_btnDTRActionPerformed

    private void btnRequestPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestPortActionPerformed
        // TODO add your handling code here:.
        mainTabbed.setSelectedIndex(2);

        humanResource.viewPersonalDetails();

        comboTypeRequest.setSelectedIndex(0);
        tabbedInsideRequest.setSelectedIndex(0);
    }//GEN-LAST:event_btnRequestPortActionPerformed

    private void btnPersonalDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonalDetailsActionPerformed
        // TODO add your handling code here:
        mainTabbed.setSelectedIndex(1);
        humanResource.viewPersonalDetails();
        txtID.setText(String.valueOf(humanResource.accountDetails.getEmployeeID()));
        txtFName.setText(humanResource.accountDetails.getFirstName());
        txtLName.setText(humanResource.accountDetails.getLastName());
        txtBDay.setText(humanResource.accountDetails.getBirthday());
        txtPhoneNum.setText(humanResource.accountDetails.getPhoneNumber());
        textAreaAddress.setText(humanResource.accountDetails.getAddress());
        txtBasicSalary.setText(String.valueOf(humanResource.accountDetails.getBasicSalary()));
        txtBiMonthlyRate.setText(String.valueOf(humanResource.accountDetails.getSemiBasicSalary()));
        txtHourlyRate.setText(String.valueOf(humanResource.accountDetails.getHourlyRate()));
        txtRiceSubsidy.setText(String.valueOf(humanResource.accountDetails.getRiceSubsidy()));
        txtPhoneAllowance.setText(String.valueOf(humanResource.accountDetails.getRiceSubsidy()));
        txtClothingAllowance.setText(String.valueOf(humanResource.accountDetails.getClothingAllowance()));
        txtPhilNum.setText(humanResource.accountDetails.getPhilHealthNumber());
        txtSSSNum.setText(humanResource.accountDetails.getPhilHealthNumber());
        txtTINNum.setText(humanResource.accountDetails.getTinNumber());
        txtPagIbigNum.setText(humanResource.accountDetails.getPagibigNumber());
        txtPosition.setText(humanResource.accountDetails.getPosition());
        txtStatus.setText(humanResource.accountDetails.getStatus());
        txtSupervisor.setText(humanResource.accountDetails.getSupervisor());
    }//GEN-LAST:event_btnPersonalDetailsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HumanResourceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HumanResourceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HumanResourceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HumanResourceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HumanResourceGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAllCredentials;
    private javax.swing.JButton btnAllEmployees;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancel1;
    private javax.swing.JButton btnCancel2;
    private javax.swing.JButton btnDTR;
    private javax.swing.JButton btnLeaveLedger;
    private javax.swing.JButton btnLeaveLedger1;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPersonalDetails;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnRequestPort;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnSubmit1;
    private javax.swing.JButton btnSubmitToSepervisor;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate2;
    private javax.swing.JComboBox<String> comboLeaveType;
    private javax.swing.JComboBox<String> comboTypeRequest;
    private com.toedter.calendar.JDateChooser dateFrom;
    private com.toedter.calendar.JDateChooser dateFrom2;
    private com.toedter.calendar.JDateChooser dateFrom3;
    private com.toedter.calendar.JDateChooser dateFromOvertime;
    private com.toedter.calendar.JDateChooser dateTo;
    private com.toedter.calendar.JDateChooser dateTo3;
    private com.toedter.calendar.JDateChooser dateToOvertime;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTableAllRequest;
    private javax.swing.JTable jTableAllRequest2;
    private javax.swing.JTable jTableAllRequest3;
    private javax.swing.JTable jTableCredentials;
    private javax.swing.JTable jTableEmployees;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAllRequest;
    private javax.swing.JLabel lblAllRequest2;
    private javax.swing.JLabel lblAllRequest3;
    private javax.swing.JLabel lblAllRequest4;
    private javax.swing.JLabel lblBDay;
    private javax.swing.JLabel lblBasicSalary;
    private javax.swing.JLabel lblBenefits;
    private javax.swing.JLabel lblBiMonthlyRate;
    private javax.swing.JLabel lblClothingAllowanes;
    private javax.swing.JLabel lblEmpID;
    private javax.swing.JLabel lblEmpID1;
    private javax.swing.JLabel lblEmpID2;
    private javax.swing.JLabel lblEmpID3;
    private javax.swing.JLabel lblEmpID4;
    private javax.swing.JLabel lblEmpID5;
    private javax.swing.JLabel lblFName;
    private javax.swing.JLabel lblGross;
    private javax.swing.JLabel lblHourlyRate;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblID1;
    private javax.swing.JLabel lblID2;
    private javax.swing.JLabel lblID3;
    private javax.swing.JLabel lblID4;
    private javax.swing.JLabel lblIDSidebar;
    private javax.swing.JLabel lblLName;
    private javax.swing.JLabel lblLeaveBalances;
    private javax.swing.JLabel lblLeaveBalances1;
    private javax.swing.JLabel lblLeaveBalances2;
    private javax.swing.JLabel lblMyName;
    private javax.swing.JLabel lblMyName1;
    private javax.swing.JLabel lblMyName2;
    private javax.swing.JLabel lblMyName3;
    private javax.swing.JLabel lblMyName4;
    private javax.swing.JLabel lblMyName5;
    private javax.swing.JLabel lblMyName6;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblName10;
    private javax.swing.JLabel lblName11;
    private javax.swing.JLabel lblName12;
    private javax.swing.JLabel lblName13;
    private javax.swing.JLabel lblName14;
    private javax.swing.JLabel lblName15;
    private javax.swing.JLabel lblName16;
    private javax.swing.JLabel lblName17;
    private javax.swing.JLabel lblName19;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblName21;
    private javax.swing.JLabel lblName3;
    private javax.swing.JLabel lblName4;
    private javax.swing.JLabel lblName5;
    private javax.swing.JLabel lblName7;
    private javax.swing.JLabel lblName8;
    private javax.swing.JLabel lblName9;
    private javax.swing.JLabel lblNameSidebar;
    private javax.swing.JLabel lblNetPay;
    private javax.swing.JLabel lblOvertime;
    private javax.swing.JLabel lblPagIbig;
    private javax.swing.JLabel lblPagIbigNum;
    private javax.swing.JLabel lblPayrollPeriod1;
    private javax.swing.JLabel lblPeriod;
    private javax.swing.JLabel lblPhilHealth;
    private javax.swing.JLabel lblPhilNum;
    private javax.swing.JLabel lblPhoneAllowances;
    private javax.swing.JLabel lblPhoneNum;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblPositon;
    private javax.swing.JLabel lblRequestType;
    private javax.swing.JLabel lblRiceSubsidy;
    private javax.swing.JLabel lblSL;
    private javax.swing.JLabel lblSL1;
    private javax.swing.JLabel lblSLBalance;
    private javax.swing.JLabel lblSLBalance1;
    private javax.swing.JLabel lblSSS;
    private javax.swing.JLabel lblSSSNum;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblSupervisor;
    private javax.swing.JLabel lblTINNum;
    private javax.swing.JLabel lblTax;
    private javax.swing.JLabel lblUndertime;
    private javax.swing.JLabel lblVL;
    private javax.swing.JLabel lblVL1;
    private javax.swing.JLabel lblVLBalance;
    private javax.swing.JLabel lblVLBalance1;
    private javax.swing.JTabbedPane mainTabbed;
    private javax.swing.JPanel panelAllRequest;
    private javax.swing.JPanel panelAllRequest1;
    private javax.swing.JPanel panelAllRequest2;
    private javax.swing.JPanel panelDTR;
    private javax.swing.JPanel panelLeaveLedger;
    private javax.swing.JPanel panelLeaveRequestDetails;
    private javax.swing.JPanel panelMotorPH;
    private javax.swing.JPanel panelOvertimeRequest;
    private javax.swing.JPanel panelPayslip;
    private javax.swing.JPanel panelPersonalDetails;
    private javax.swing.JPanel panelPersonalDetails1;
    private javax.swing.JPanel panelPersonalDetails2;
    private javax.swing.JPanel panelPersonalDetails3;
    private javax.swing.JPanel panelTypeRequest;
    private javax.swing.JPanel panelTypeRequest1;
    private javax.swing.JPanel panelTypeRequest2;
    private javax.swing.JPanel sideBarPanel;
    private javax.swing.JPanel tabbedAllCredentials;
    private javax.swing.JPanel tabbedAllEmployees;
    private javax.swing.JPanel tabbedDTR;
    private javax.swing.JTabbedPane tabbedInsideRequest;
    private javax.swing.JTabbedPane tabbedInsideRequest1;
    private javax.swing.JTabbedPane tabbedInsideRequest2;
    private javax.swing.JPanel tabbedLeaveLedger;
    private javax.swing.JPanel tabbedPayslip;
    private javax.swing.JPanel tabbedPersonalDetails;
    private javax.swing.JPanel tabbedRequest;
    private javax.swing.JScrollPane tableDTR;
    private javax.swing.JScrollPane tableDTR1;
    private javax.swing.JTextArea textAreaAddress;
    private javax.swing.JTextField txtBDay;
    private javax.swing.JTextField txtBasicSalary;
    private javax.swing.JTextField txtBiMonthlyRate;
    private javax.swing.JTextField txtClothingAllowance;
    private javax.swing.JTextField txtDaysNumber;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtHourlyRate;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLName;
    private javax.swing.JTextField txtPagIbigNum;
    private javax.swing.JTextField txtPhilNum;
    private javax.swing.JTextField txtPhoneAllowance;
    private javax.swing.JTextField txtPhoneNum;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextArea txtReason;
    private javax.swing.JTextArea txtReasonOvertime;
    private javax.swing.JTextField txtRiceSubsidy;
    private javax.swing.JTextField txtSSSNum;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtSupervisor;
    private javax.swing.JTextField txtTINNum;
    // End of variables declaration//GEN-END:variables
}
