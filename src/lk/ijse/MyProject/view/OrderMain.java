/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.MyProject.view;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.TreeSet;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lk.ijse.MyProject.Controller.CustomerController;
import lk.ijse.MyProject.Controller.CustomerPaymentController;
import lk.ijse.MyProject.Controller.ItemController;
import lk.ijse.MyProject.Controller.ItemDetail;
import lk.ijse.MyProject.Controller.ItemReturnController;
import lk.ijse.MyProject.Controller.MonthlyIncomeController;
import lk.ijse.MyProject.Controller.OrderController;
import lk.ijse.MyProject.Controller.SupBillController;
import lk.ijse.MyProject.Controller.SupplierController;
import lk.ijse.MyProject.Controller.UserAccountController;
import lk.ijse.MyProject.Controller.UserDetailController;
import lk.ijse.MyProject.Model.CustomerModel;
import lk.ijse.MyProject.Model.CustomerPaymentModel;
import lk.ijse.MyProject.Model.ItemModel;
import lk.ijse.MyProject.Model.ItemReturnModel;
import lk.ijse.MyProject.Model.MonthlyIncomeModel;
import lk.ijse.MyProject.Model.OrderDetailModel;
import lk.ijse.MyProject.Model.OrderModel;
import lk.ijse.MyProject.Model.ReportModel;
import lk.ijse.MyProject.Model.SupBillModel;
import lk.ijse.MyProject.Model.UserAccountModel;
import lk.ijse.MyProject.Model.UserDetailModel;
import lk.ijse.MyProject.Model.supplier;
import lk.ijse.MyProject.db.DBConnection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.log4j.BasicConfigurator;

/**
 *
 * @author Nipun Lakshitha
 */
public class OrderMain extends javax.swing.JFrame {

    /**
     * Creates new form OrderMain
     */
    Set<String> item = new TreeSet<>();
    String Role = null;
    String id = null;
    String path = null;
    public double totalAmount = 0;
    public double total = 0;
    public double billLastDiscount = 0;
    public double billLastAmount = 0;
    public double cusPay = 0;
    public double cusBalance = 0;
    public String billNo = null;
    public String billDate = null;
    public String billTime = null;

    public OrderMain() {
        initComponents();
        getAllItemName();
        LoadDateAndTime();
        LoadOrderID();
        setBillNo();
        getAllItem();
        LoadLogin();
        LoadAllCusID();
        LoadAllItem();
        LoadAllCustomer();
        LoadAllSupplier();
        LoadDateTime();
        LoadIRID();
        LoadUser();
        LoadDateTimeSup();
        LoardLogin();
        getBillID();
        LoadMainDateAndTime();
        LoadLoginUser();

        String id = "ADMIN";
        String role = newLogin.LoginUser;

        if (role.equals(id)) {
            UserACC.setVisible(true);
            MonthlyIcome.setVisible(true);
            Item.setVisible(true);
        } else if (!role.equals(id)) {
            UserACC.setVisible(false);
            MonthlyIcome.setVisible(false);
            Item.setVisible(false);
        } else {
            UserACC.setVisible(false);
            MonthlyIcome.setVisible(false);
            Item.setVisible(false);
        }

        newItem.setVisible(false);
        CustomerPanel.setVisible(false);
        SupplierPanel.setVisible(false);
        SupBillPanel.setVisible(false);
        newItemReurnPanel.setVisible(false);
        newUserDeatilPanel.setVisible(false);
        MonthlyIncomePanel.setVisible(false);
        UserAccount.setVisible(false);
        ReportPanel.setVisible(false);
        backup.setVisible(false);

        Thread t = new Thread() {

            public void run() {
                while (true) {
                    DateFormat Time = new SimpleDateFormat("HH:mm:ss");
                    DateFormat date = new SimpleDateFormat("YYYY-MM-dd");
                    String TimeString = Time.format(new Date()).toString();
                    String dateString = date.format(new Date()).toString();
                    lblTime.setText(TimeString);
                    lblDate.setText(dateString);
                    txtBillDate.setText(dateString);
                    txtBillTime.setText(TimeString);
                    txtSupBillTime.setText(TimeString);
                    txtSupBillDate.setText(dateString);

                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                    }
                }
            }

        };
        t.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Side_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Home = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Customer = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Item = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Supplier = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        SupplierBill = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        ItemReturn = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        UserDetail = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        MonthlyIcome = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lblTime = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        HomePanel = new javax.swing.JPanel();
        order = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtBillDate = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnAddtoCart = new javax.swing.JButton();
        txtDiscount = new javax.swing.JTextField();
        txtItemCode = new javax.swing.JTextField();
        txtBillTime = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtQTYOnHand = new javax.swing.JTextField();
        btnPay = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        txtOrderId = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtUnitPrice = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtLastDiscount = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtLastAmount = new javax.swing.JTextField();
        CusIDCombo = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtQTY = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtBNo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();
        txtItemName = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        txtCustomerPayment = new javax.swing.JTextField();
        txtBalance = new javax.swing.JTextField();
        CustomerPanel = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        txtCustomerID = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtCustmoerName = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtCustomerAddress = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtCustomerContact = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        CustomerTable = new javax.swing.JTable();
        btnCusSave = new javax.swing.JButton();
        btnCusUpdate = new javax.swing.JButton();
        btnCusClear = new javax.swing.JButton();
        btnCusDelete = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        newItem = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        txt_QTYOnHand = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ItemTable = new javax.swing.JTable();
        btnItemSave = new javax.swing.JButton();
        btnItemUpdate = new javax.swing.JButton();
        btnItemDelete = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        btnItemClear = new javax.swing.JButton();
        txtItem_Code = new javax.swing.JTextField();
        txtItem_Name = new javax.swing.JTextField();
        txtItem_Price = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        SupplierPanel = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        SupplierTable = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        btnSupSave = new javax.swing.JButton();
        btnSupUpdate = new javax.swing.JButton();
        btnSupDelete = new javax.swing.JButton();
        btnSupClear = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        txtSupplierContact = new javax.swing.JTextField();
        txtSupplierName = new javax.swing.JTextField();
        txtSupplierId = new javax.swing.JTextField();
        txtSupplierAddress = new javax.swing.JTextField();
        txtSuppllierEmail = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        SupBillPanel = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        txtSupBillTime = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtSupplierUser = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txtSupBillDate = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txtSupID = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        txtSupName = new javax.swing.JTextField();
        txtItemQTY = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblItemId1 = new javax.swing.JLabel();
        txtItemName2 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txtItemPrice = new javax.swing.JTextField();
        btnSupBillAdd = new javax.swing.JButton();
        btnSupBillRest = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        SupTable = new javax.swing.JTable();
        jLabel55 = new javax.swing.JLabel();
        txtSupTotal = new javax.swing.JTextField();
        btnSupBillPay = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtSupBillNo = new javax.swing.JTextField();
        btnSupBillDelete = new javax.swing.JButton();
        newItemReurnPanel = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        txtReturnOrderID = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtReturnDate = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtReturnItemName = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        txReturntItemID = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        txtReturnQTY = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        txtIRID = new javax.swing.JTextField();
        btnItemReturnEnter = new javax.swing.JButton();
        btnItemReturnRest = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        ReturnTable = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();
        txtReturnTime = new javax.swing.JTextField();
        btnItemReturnAddToShop = new javax.swing.JButton();
        btnItemReturnDelete = new javax.swing.JButton();
        jLabel101 = new javax.swing.JLabel();
        txtReturnTable = new javax.swing.JTextField();
        newUserDeatilPanel = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        txtUser_ID = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        txtUserNIC = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        txtUserAddress = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        UserTable = new javax.swing.JTable();
        txtUserContact = new javax.swing.JTextField();
        btnUserSave = new javax.swing.JButton();
        btnUserUpdate = new javax.swing.JButton();
        btnUserDelete = new javax.swing.JButton();
        btnUserClear = new javax.swing.JButton();
        jLabel76 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        UserACC = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        MonthlyIncomePanel = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        txtFromYear = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        txtFromMonth = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        txtFromDate = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        txtToYear = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        txtToMonth = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        txtToDate = new javax.swing.JTextField();
        btnMonthlyIncomeClear = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        incomeTable = new javax.swing.JTable();
        lblIncome = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        btnMonthlyIncomeEnter = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        UserAccount = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        txtUserACCUserID = new javax.swing.JTextField();
        txtUserACCRole = new javax.swing.JTextField();
        btnUserAccAddUser = new javax.swing.JButton();
        btnUserAccClear = new javax.swing.JButton();
        btnUserAccUpdate = new javax.swing.JButton();
        btnUserAccDelete = new javax.swing.JButton();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        txtUserACCPassword = new javax.swing.JPasswordField();
        txtUserACCConfirmPassword = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        ReportPanel = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        txtRportFromYear = new javax.swing.JTextField();
        txtRportFromMonth = new javax.swing.JTextField();
        txtRportFromDate = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        txtRportToYear = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        txtRportToMonth = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        txtRportToDate = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        ReportTable = new javax.swing.JTable();
        btnReportEnter = new javax.swing.JButton();
        btnReportClear = new javax.swing.JButton();
        backup = new javax.swing.JPanel();
        txtPath = new javax.swing.JTextField();
        btnBackupBrows = new javax.swing.JButton();
        btnBackup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(106, 137, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Side_panel.setBackground(new java.awt.Color(12, 36, 97));
        Side_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu");
        Side_panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 69, 37));

        Home.setBackground(new java.awt.Color(30, 55, 153));
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeMouseClicked(evt);
            }
        });
        Home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\home-run.png")); // NOI18N
        jLabel5.setText("     Home");
        Home.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\home-run.png")); // NOI18N
        jLabel4.setText("     Home");
        Home.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        Side_panel.add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 230, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\menu (1).png")); // NOI18N
        Side_panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\menu (1).png")); // NOI18N
        Side_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 50, 50));

        Customer.setBackground(new java.awt.Color(30, 55, 153));
        Customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CustomerMouseEntered(evt);
            }
        });
        Customer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\customer.png")); // NOI18N
        jLabel6.setText("    Customer");
        Customer.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, -10, -1, 60));

        Side_panel.add(Customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 230, 40));

        Item.setBackground(new java.awt.Color(30, 55, 153));
        Item.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ItemMouseClicked(evt);
            }
        });
        Item.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\sale.png")); // NOI18N
        jLabel7.setText("    Item");
        Item.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        Side_panel.add(Item, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 230, 40));

        Supplier.setBackground(new java.awt.Color(30, 55, 153));
        Supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupplierMouseClicked(evt);
            }
        });
        Supplier.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\supplier.png")); // NOI18N
        jLabel8.setText("    Supplier");
        Supplier.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        Side_panel.add(Supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 230, 40));

        SupplierBill.setBackground(new java.awt.Color(30, 55, 153));
        SupplierBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupplierBillMouseClicked(evt);
            }
        });
        SupplierBill.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\bill.png")); // NOI18N
        jLabel9.setText("     Supplier Bill");
        SupplierBill.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        Side_panel.add(SupplierBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 230, 40));

        ItemReturn.setBackground(new java.awt.Color(30, 55, 153));
        ItemReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ItemReturnMouseClicked(evt);
            }
        });
        ItemReturn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\back.png")); // NOI18N
        jLabel10.setText("    Item Return");
        ItemReturn.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        Side_panel.add(ItemReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 230, 40));

        UserDetail.setBackground(new java.awt.Color(30, 55, 153));
        UserDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserDetailMouseClicked(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\icons8-user-30.png")); // NOI18N

        javax.swing.GroupLayout UserDetailLayout = new javax.swing.GroupLayout(UserDetail);
        UserDetail.setLayout(UserDetailLayout);
        UserDetailLayout.setHorizontalGroup(
            UserDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        UserDetailLayout.setVerticalGroup(
            UserDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Side_panel.add(UserDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 60, 50));

        MonthlyIcome.setBackground(new java.awt.Color(30, 55, 153));
        MonthlyIcome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MonthlyIcomeMouseClicked(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\wallet.png")); // NOI18N

        javax.swing.GroupLayout MonthlyIcomeLayout = new javax.swing.GroupLayout(MonthlyIcome);
        MonthlyIcome.setLayout(MonthlyIcomeLayout);
        MonthlyIcomeLayout.setHorizontalGroup(
            MonthlyIcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MonthlyIcomeLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );
        MonthlyIcomeLayout.setVerticalGroup(
            MonthlyIcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MonthlyIcomeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        Side_panel.add(MonthlyIcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 60, 50));

        jPanel2.setBackground(new java.awt.Color(30, 55, 153));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel102.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\interface (1).png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel102)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel102)
                .addContainerGap())
        );

        Side_panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 550, 60, 50));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Side_panel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, -1, -1));

        jPanel6.setBackground(new java.awt.Color(30, 55, 153));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });

        jLabel124.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\folder.png")); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel124)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel124)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Side_panel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 610, 60, 50));

        jPanel1.add(Side_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 680));

        jPanel11.setBackground(new java.awt.Color(12, 36, 97));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setText("jLabel98");
        jPanel11.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 30, -1, -1));

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("jLabel99");
        jPanel11.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, -1, -1));

        jLabel98.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\vehicle.png")); // NOI18N
        jPanel11.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jLabel99.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setText("BAJAJ");
        jPanel11.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(346, 18, -1, -1));

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setText("Three Wheel Center");
        jPanel11.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 30, -1, -1));

        jPanel3.setBackground(new java.awt.Color(30, 55, 153));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel103.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\signs (1).png")); // NOI18N
        jPanel3.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel11.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 50, 50));

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 1000, 70));

        HomePanel.setBackground(new java.awt.Color(106, 137, 204));
        HomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        order.setBackground(new java.awt.Color(106, 137, 204));
        order.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Bill No");
        order.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 11, -1, -1));

        txtBillDate.setEnabled(false);
        order.add(txtBillDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 11, 180, -1));

        btnDelete.setBackground(new java.awt.Color(194, 54, 22));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(194, 54, 22)));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        order.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 211, 107, 40));

        btnReset.setBackground(new java.awt.Color(10, 61, 98));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(10, 61, 98)));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        order.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 210, 107, 40));

        btnAddtoCart.setBackground(new java.awt.Color(51, 0, 255));
        btnAddtoCart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddtoCart.setForeground(new java.awt.Color(255, 255, 255));
        btnAddtoCart.setText("Add To Cart");
        btnAddtoCart.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 255)));
        btnAddtoCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddtoCartActionPerformed(evt);
            }
        });
        order.add(btnAddtoCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 135, 40));

        txtDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDiscountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiscountKeyReleased(evt);
            }
        });
        order.add(txtDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 161, 110, -1));
        order.add(txtItemCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 111, 180, -1));

        txtBillTime.setEnabled(false);
        order.add(txtBillTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 11, 170, -1));

        txtTotal.setBackground(new java.awt.Color(106, 137, 204));
        txtTotal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtTotal.setEnabled(false);
        order.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 140, 20));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("TOTAL");
        order.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Unit price");
        order.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 111, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Price");
        order.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Item Name");
        order.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 111, -1, -1));
        order.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 160, 140, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Item Code");
        order.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 111, -1, -1));
        order.add(txtQTYOnHand, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 161, 130, -1));

        btnPay.setBackground(new java.awt.Color(235, 47, 6));
        btnPay.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("PAY");
        btnPay.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(235, 47, 6)));
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });
        order.add(btnPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 471, 190, 80));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "QTY", "Unit Price", "Discount", "Price"
            }
        ));
        jScrollPane1.setViewportView(Table);

        order.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 291, 950, 160));

        txtOrderId.setEnabled(false);
        order.add(txtOrderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 61, 180, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Order ID");
        order.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 61, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Discount");
        order.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 161, -1, -1));
        order.add(txtUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 111, 170, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Bill Date");
        order.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 11, -1, -1));

        txtLastDiscount.setBackground(new java.awt.Color(106, 137, 204));
        txtLastDiscount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtLastDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLastDiscountKeyPressed(evt);
            }
        });
        order.add(txtLastDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, 140, 20));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("QTY");
        order.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 161, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("QTY On Hand");
        order.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 161, -1, -1));

        txtLastAmount.setBackground(new java.awt.Color(106, 137, 204));
        txtLastAmount.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtLastAmount.setEnabled(false);
        order.add(txtLastAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 210, 30));

        order.add(CusIDCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 61, 170, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Last Discount");
        order.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Customer");
        order.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 61, -1, -1));

        txtQTY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQTYKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQTYKeyReleased(evt);
            }
        });
        order.add(txtQTY, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 161, 110, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setText("FINAL AMOUNT");
        order.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("User ID");
        order.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 61, -1, -1));

        txtBNo.setEnabled(false);
        order.add(txtBNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 11, 180, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Bill Time");
        order.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 11, -1, -1));

        txtUserID.setEnabled(false);
        order.add(txtUserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 61, 180, -1));

        txtItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemNameActionPerformed(evt);
            }
        });
        txtItemName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtItemNameKeyPressed(evt);
            }
        });
        order.add(txtItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 240, -1));

        jLabel113.setBackground(new java.awt.Color(106, 137, 204));
        jLabel113.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel113.setText("BALANCE");
        order.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, -1, -1));

        jLabel114.setBackground(new java.awt.Color(106, 137, 204));
        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel114.setText("Customer Payment");
        order.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, -1, -1));

        txtCustomerPayment.setBackground(new java.awt.Color(106, 137, 204));
        txtCustomerPayment.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtCustomerPayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustomerPaymentKeyPressed(evt);
            }
        });
        order.add(txtCustomerPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 510, 210, -1));

        txtBalance.setBackground(new java.awt.Color(106, 137, 204));
        txtBalance.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtBalance.setEnabled(false);
        order.add(txtBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 550, 210, -1));

        HomePanel.add(order, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 590));

        jPanel1.add(HomePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 1000, 610));

        CustomerPanel.setBackground(new java.awt.Color(106, 137, 204));
        CustomerPanel.setPreferredSize(new java.awt.Dimension(1060, 587));
        CustomerPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CustomerPanelKeyPressed(evt);
            }
        });
        CustomerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("Customer ID");
        CustomerPanel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, -1));

        txtCustomerID.setBackground(new java.awt.Color(106, 137, 204));
        txtCustomerID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerIDActionPerformed(evt);
            }
        });
        txtCustomerID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustomerIDKeyPressed(evt);
            }
        });
        CustomerPanel.add(txtCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 200, 20));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("Customer Name");
        CustomerPanel.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, -1));

        txtCustmoerName.setBackground(new java.awt.Color(106, 137, 204));
        txtCustmoerName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtCustmoerName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustmoerNameKeyPressed(evt);
            }
        });
        CustomerPanel.add(txtCustmoerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 200, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("Customer Address");
        CustomerPanel.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, -1, -1));

        txtCustomerAddress.setBackground(new java.awt.Color(106, 137, 204));
        txtCustomerAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtCustomerAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustomerAddressKeyPressed(evt);
            }
        });
        CustomerPanel.add(txtCustomerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 200, 30));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setText("Customer Contact");
        CustomerPanel.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, -1));

        txtCustomerContact.setBackground(new java.awt.Color(106, 137, 204));
        txtCustomerContact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtCustomerContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCustomerContactActionPerformed(evt);
            }
        });
        txtCustomerContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustomerContactKeyPressed(evt);
            }
        });
        CustomerPanel.add(txtCustomerContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 276, 200, 20));

        CustomerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CstomerID", "Customer Name", "Customer Address", "Customer Contact"
            }
        ));
        CustomerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(CustomerTable);

        CustomerPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 710, 140));

        btnCusSave.setBackground(new java.awt.Color(39, 60, 117));
        btnCusSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCusSave.setForeground(new java.awt.Color(255, 255, 255));
        btnCusSave.setText("Save");
        btnCusSave.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(39, 60, 117)));
        btnCusSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusSaveActionPerformed(evt);
            }
        });
        CustomerPanel.add(btnCusSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, 80, 40));

        btnCusUpdate.setBackground(new java.awt.Color(64, 115, 158));
        btnCusUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCusUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnCusUpdate.setText("Update");
        btnCusUpdate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(64, 115, 158)));
        btnCusUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusUpdateActionPerformed(evt);
            }
        });
        CustomerPanel.add(btnCusUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 540, 80, 40));

        btnCusClear.setBackground(new java.awt.Color(60, 99, 130));
        btnCusClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCusClear.setForeground(new java.awt.Color(255, 255, 255));
        btnCusClear.setText("Clear");
        btnCusClear.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(60, 99, 130)));
        btnCusClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusClearActionPerformed(evt);
            }
        });
        CustomerPanel.add(btnCusClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 540, 80, 40));

        btnCusDelete.setBackground(new java.awt.Color(232, 65, 24));
        btnCusDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCusDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnCusDelete.setText("Delete");
        btnCusDelete.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(232, 65, 24)));
        btnCusDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusDeleteActionPerformed(evt);
            }
        });
        CustomerPanel.add(btnCusDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 540, 80, 40));

        jLabel38.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\serchSmall.png")); // NOI18N
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
        });
        CustomerPanel.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, -1, -1));

        jLabel80.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        CustomerPanel.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        jLabel81.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        CustomerPanel.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, -1));

        jLabel82.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        CustomerPanel.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, -1));

        jLabel83.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        CustomerPanel.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        jPanel1.add(CustomerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        newItem.setBackground(new java.awt.Color(106, 137, 204));
        newItem.setPreferredSize(new java.awt.Dimension(1061, 587));
        newItem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setText("Item Code");
        newItem.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        txt_QTYOnHand.setBackground(new java.awt.Color(106, 137, 204));
        txt_QTYOnHand.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_QTYOnHand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_QTYOnHandKeyPressed(evt);
            }
        });
        newItem.add(txt_QTYOnHand, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 260, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setText("Item Name");
        newItem.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setText("Selling Price");
        newItem.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, -1, -1));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setText("QTY On Hand");
        newItem.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, -1, -1));

        ItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ItemCode", "Item Name", "UnitPrice", "QTY On Hand"
            }
        ));
        ItemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ItemTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(ItemTable);

        newItem.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 790, 140));

        btnItemSave.setBackground(new java.awt.Color(39, 60, 117));
        btnItemSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnItemSave.setForeground(new java.awt.Color(255, 255, 255));
        btnItemSave.setText("Save");
        btnItemSave.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(39, 60, 117)));
        btnItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemSaveActionPerformed(evt);
            }
        });
        newItem.add(btnItemSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 520, 80, 40));

        btnItemUpdate.setBackground(new java.awt.Color(64, 115, 158));
        btnItemUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnItemUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnItemUpdate.setText("Update");
        btnItemUpdate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(64, 115, 158)));
        btnItemUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemUpdateActionPerformed(evt);
            }
        });
        newItem.add(btnItemUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, 70, 40));

        btnItemDelete.setBackground(new java.awt.Color(232, 65, 24));
        btnItemDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnItemDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnItemDelete.setText("Delete");
        btnItemDelete.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(232, 65, 24)));
        btnItemDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemDeleteActionPerformed(evt);
            }
        });
        newItem.add(btnItemDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 520, 81, 40));

        jLabel43.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\serchSmall.png")); // NOI18N
        jLabel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel43MouseClicked(evt);
            }
        });
        newItem.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, -1, -1));

        btnItemClear.setBackground(new java.awt.Color(56, 173, 169));
        btnItemClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnItemClear.setForeground(new java.awt.Color(255, 255, 255));
        btnItemClear.setText("Clear");
        btnItemClear.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(56, 173, 169)));
        btnItemClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemClearActionPerformed(evt);
            }
        });
        newItem.add(btnItemClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 520, 81, 40));

        txtItem_Code.setBackground(new java.awt.Color(106, 137, 204));
        txtItem_Code.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtItem_Code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtItem_CodeKeyPressed(evt);
            }
        });
        newItem.add(txtItem_Code, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 260, -1));

        txtItem_Name.setBackground(new java.awt.Color(106, 137, 204));
        txtItem_Name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtItem_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItem_NameActionPerformed(evt);
            }
        });
        txtItem_Name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtItem_NameKeyPressed(evt);
            }
        });
        newItem.add(txtItem_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 260, -1));

        txtItem_Price.setBackground(new java.awt.Color(106, 137, 204));
        txtItem_Price.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtItem_Price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtItem_PriceKeyPressed(evt);
            }
        });
        newItem.add(txtItem_Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 260, -1));

        jLabel84.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        newItem.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, -1));

        jLabel85.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        newItem.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        jLabel86.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        newItem.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        jLabel87.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        newItem.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, -1));

        jPanel1.add(newItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        SupplierPanel.setBackground(new java.awt.Color(106, 137, 204));
        SupplierPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Supplier ID");
        SupplierPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, 20));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Supplier Address");
        SupplierPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, -1, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("Supplier Email");
        SupplierPanel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("Supplier Contact");
        SupplierPanel.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, -1, -1));

        SupplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier Name", "Supplier ID", "Supplier Adddress", "Supplier Email", "Supplier Contact"
            }
        ));
        SupplierTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupplierTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(SupplierTable);

        SupplierPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 710, 90));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("Supplier Name");
        SupplierPanel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        btnSupSave.setBackground(new java.awt.Color(39, 60, 117));
        btnSupSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSupSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSupSave.setText("Save");
        btnSupSave.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(39, 60, 117)));
        btnSupSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupSaveActionPerformed(evt);
            }
        });
        SupplierPanel.add(btnSupSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 540, 80, 40));

        btnSupUpdate.setBackground(new java.awt.Color(64, 115, 158));
        btnSupUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSupUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnSupUpdate.setText("Update");
        btnSupUpdate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(64, 115, 158)));
        btnSupUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupUpdateActionPerformed(evt);
            }
        });
        SupplierPanel.add(btnSupUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 540, 70, 40));

        btnSupDelete.setBackground(new java.awt.Color(232, 65, 24));
        btnSupDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSupDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnSupDelete.setText("Delete");
        btnSupDelete.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(232, 65, 24)));
        btnSupDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupDeleteActionPerformed(evt);
            }
        });
        SupplierPanel.add(btnSupDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 540, 81, 40));

        btnSupClear.setBackground(new java.awt.Color(56, 173, 169));
        btnSupClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSupClear.setForeground(new java.awt.Color(255, 255, 255));
        btnSupClear.setText("Clear");
        btnSupClear.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(56, 173, 169)));
        btnSupClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupClearActionPerformed(evt);
            }
        });
        SupplierPanel.add(btnSupClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 540, 81, 40));

        jLabel44.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\serchSmall.png")); // NOI18N
        jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel44MouseClicked(evt);
            }
        });
        SupplierPanel.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 160, -1, -1));

        txtSupplierContact.setBackground(new java.awt.Color(106, 137, 204));
        txtSupplierContact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtSupplierContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSupplierContactKeyPressed(evt);
            }
        });
        SupplierPanel.add(txtSupplierContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 210, -1));

        txtSupplierName.setBackground(new java.awt.Color(106, 137, 204));
        txtSupplierName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtSupplierName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSupplierNameKeyPressed(evt);
            }
        });
        SupplierPanel.add(txtSupplierName, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 210, -1));

        txtSupplierId.setBackground(new java.awt.Color(106, 137, 204));
        txtSupplierId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtSupplierId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSupplierIdKeyPressed(evt);
            }
        });
        SupplierPanel.add(txtSupplierId, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 210, -1));

        txtSupplierAddress.setBackground(new java.awt.Color(106, 137, 204));
        txtSupplierAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtSupplierAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSupplierAddressKeyPressed(evt);
            }
        });
        SupplierPanel.add(txtSupplierAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 210, -1));

        txtSuppllierEmail.setBackground(new java.awt.Color(106, 137, 204));
        txtSuppllierEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtSuppllierEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSuppllierEmailKeyPressed(evt);
            }
        });
        SupplierPanel.add(txtSuppllierEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 210, -1));

        jLabel88.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        SupplierPanel.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, -1, -1));

        jLabel89.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        SupplierPanel.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, -1, 20));

        jLabel90.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        SupplierPanel.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        jLabel91.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        SupplierPanel.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, -1));

        jLabel92.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        SupplierPanel.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, -1, -1));

        jPanel1.add(SupplierPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        SupBillPanel.setBackground(new java.awt.Color(106, 137, 204));
        SupBillPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setText("Supplier Bill No");
        SupBillPanel.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, -1));

        txtSupBillTime.setEnabled(false);
        SupBillPanel.add(txtSupBillTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 140, -1));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText("User");
        SupBillPanel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        txtSupplierUser.setEnabled(false);
        SupBillPanel.add(txtSupplierUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 100, -1));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setText("Date");
        SupBillPanel.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, -1, -1));

        txtSupBillDate.setEnabled(false);
        txtSupBillDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupBillDateActionPerformed(evt);
            }
        });
        SupBillPanel.add(txtSupBillDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 130, -1));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setText("Time");
        SupBillPanel.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setText("Supplier ID");
        SupBillPanel.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, -1, -1));

        txtSupID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSupIDKeyPressed(evt);
            }
        });
        SupBillPanel.add(txtSupID, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, 100, -1));

        jLabel50.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\serchSmall.png")); // NOI18N
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });
        SupBillPanel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 130, -1, -1));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setText("Name");
        SupBillPanel.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, -1, -1));
        SupBillPanel.add(txtSupName, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, 130, -1));

        txtItemQTY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtItemQTYKeyPressed(evt);
            }
        });
        SupBillPanel.add(txtItemQTY, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 140, -1));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setText("QTY");
        SupBillPanel.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, -1));

        jLabel53.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\serchSmall.png")); // NOI18N
        jLabel53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel53MouseClicked(evt);
            }
        });
        SupBillPanel.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
        });
        SupBillPanel.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 140, -1));

        lblItemId1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblItemId1.setText("Item ID");
        SupBillPanel.add(lblItemId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, -1, -1));

        txtItemName2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtItemName2.setText("Item Name");
        SupBillPanel.add(txtItemName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, -1, -1));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel54.setText("Price");
        SupBillPanel.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, -1, -1));

        txtItemPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemPriceActionPerformed(evt);
            }
        });
        txtItemPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtItemPriceKeyPressed(evt);
            }
        });
        SupBillPanel.add(txtItemPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, 140, -1));

        btnSupBillAdd.setBackground(new java.awt.Color(10, 61, 98));
        btnSupBillAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSupBillAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnSupBillAdd.setText("ADD");
        btnSupBillAdd.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(10, 61, 98)));
        btnSupBillAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupBillAddActionPerformed(evt);
            }
        });
        SupBillPanel.add(btnSupBillAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 120, 30));

        btnSupBillRest.setBackground(new java.awt.Color(10, 61, 98));
        btnSupBillRest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSupBillRest.setForeground(new java.awt.Color(255, 255, 255));
        btnSupBillRest.setText("Reset");
        btnSupBillRest.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(10, 61, 98)));
        btnSupBillRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupBillRestActionPerformed(evt);
            }
        });
        SupBillPanel.add(btnSupBillRest, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 290, 120, 30));

        SupTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier ID", "Supplier Name", "Item ID", "Item Name", "QTY", "Unit Price", "price"
            }
        ));
        jScrollPane5.setViewportView(SupTable);

        SupBillPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 780, 180));

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel55.setText("TOTAL");
        SupBillPanel.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, -1, -1));

        txtSupTotal.setEnabled(false);
        SupBillPanel.add(txtSupTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, 203, -1));

        btnSupBillPay.setBackground(new java.awt.Color(255, 0, 51));
        btnSupBillPay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSupBillPay.setForeground(new java.awt.Color(255, 255, 255));
        btnSupBillPay.setText("pay");
        btnSupBillPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupBillPayActionPerformed(evt);
            }
        });
        SupBillPanel.add(btnSupBillPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 530, 200, 60));
        SupBillPanel.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 350, -1));

        txtSupBillNo.setEnabled(false);
        SupBillPanel.add(txtSupBillNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 140, -1));

        btnSupBillDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnSupBillDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSupBillDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnSupBillDelete.setText("Delete");
        btnSupBillDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupBillDeleteActionPerformed(evt);
            }
        });
        SupBillPanel.add(btnSupBillDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 120, 30));

        jPanel1.add(SupBillPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        newItemReurnPanel.setBackground(new java.awt.Color(106, 137, 204));
        newItemReurnPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel56.setText("OrderID");
        newItemReurnPanel.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, 20));

        txtReturnOrderID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtReturnOrderIDKeyPressed(evt);
            }
        });
        newItemReurnPanel.add(txtReturnOrderID, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 140, -1));

        jLabel57.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\serchSmall.png")); // NOI18N
        jLabel57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel57MouseClicked(evt);
            }
        });
        newItemReurnPanel.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, -1, -1));

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel58.setText("Return Date");
        newItemReurnPanel.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, -1, -1));

        txtReturnDate.setEnabled(false);
        newItemReurnPanel.add(txtReturnDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 140, -1));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setText("Item Name");
        newItemReurnPanel.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, -1, -1));

        txtReturnItemName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtReturnItemNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtReturnItemNameKeyReleased(evt);
            }
        });
        newItemReurnPanel.add(txtReturnItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 140, -1));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel60.setText("Return Time");
        newItemReurnPanel.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, -1, -1));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel61.setText("ItemID");
        newItemReurnPanel.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, -1));

        txReturntItemID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txReturntItemIDKeyPressed(evt);
            }
        });
        newItemReurnPanel.add(txReturntItemID, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 140, -1));

        jLabel62.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\serchSmall.png")); // NOI18N
        jLabel62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel62MouseClicked(evt);
            }
        });
        newItemReurnPanel.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, -1, -1));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel63.setText("QTY");
        newItemReurnPanel.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 180, -1, -1));

        txtReturnQTY.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtReturnQTYKeyPressed(evt);
            }
        });
        newItemReurnPanel.add(txtReturnQTY, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 180, 120, -1));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel64.setText("IR ID");
        newItemReurnPanel.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, -1, -1));

        txtIRID.setEnabled(false);
        newItemReurnPanel.add(txtIRID, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 140, -1));

        btnItemReturnEnter.setBackground(new java.awt.Color(0, 51, 204));
        btnItemReturnEnter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnItemReturnEnter.setForeground(new java.awt.Color(255, 255, 255));
        btnItemReturnEnter.setText("Enter");
        btnItemReturnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemReturnEnterActionPerformed(evt);
            }
        });
        newItemReurnPanel.add(btnItemReturnEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 100, 40));

        btnItemReturnRest.setBackground(new java.awt.Color(0, 0, 0));
        btnItemReturnRest.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnItemReturnRest.setForeground(new java.awt.Color(255, 255, 255));
        btnItemReturnRest.setText("Reset");
        btnItemReturnRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemReturnRestActionPerformed(evt);
            }
        });
        newItemReurnPanel.add(btnItemReturnRest, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 220, 100, 40));

        ReturnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IRID", "Order ID", "Item ID", "Item Name", "QTY", "Price"
            }
        ));
        jScrollPane6.setViewportView(ReturnTable);

        newItemReurnPanel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 770, 120));

        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderID", "ItemID", "QTY", "Unit Price", "Discount", "Price"
            }
        ));
        jScrollPane7.setViewportView(OrderTable);

        newItemReurnPanel.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 770, 110));

        txtReturnTime.setEnabled(false);
        newItemReurnPanel.add(txtReturnTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 120, -1));

        btnItemReturnAddToShop.setBackground(new java.awt.Color(235, 47, 6));
        btnItemReturnAddToShop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnItemReturnAddToShop.setForeground(new java.awt.Color(255, 255, 255));
        btnItemReturnAddToShop.setText("ADD TO SHOP");
        btnItemReturnAddToShop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemReturnAddToShopActionPerformed(evt);
            }
        });
        newItemReurnPanel.add(btnItemReturnAddToShop, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 520, 120, 50));

        btnItemReturnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnItemReturnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnItemReturnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnItemReturnDelete.setText("Delete");
        btnItemReturnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemReturnDeleteActionPerformed(evt);
            }
        });
        newItemReurnPanel.add(btnItemReturnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, -1, -1));

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel101.setText("Return Total");
        newItemReurnPanel.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 90, -1));

        txtReturnTable.setEnabled(false);
        newItemReurnPanel.add(txtReturnTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 540, 150, -1));

        jPanel1.add(newItemReurnPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 600));

        newUserDeatilPanel.setBackground(new java.awt.Color(106, 137, 204));
        newUserDeatilPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel71.setText("UserID");
        newUserDeatilPanel.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, 30));

        txtUser_ID.setBackground(new java.awt.Color(106, 137, 204));
        txtUser_ID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtUser_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUser_IDKeyPressed(evt);
            }
        });
        newUserDeatilPanel.add(txtUser_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 190, -1));

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel72.setText("Name");
        newUserDeatilPanel.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, 30));

        txtUserName.setBackground(new java.awt.Color(106, 137, 204));
        txtUserName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtUserName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserNameKeyPressed(evt);
            }
        });
        newUserDeatilPanel.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 190, -1));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel73.setText("N.I.C");
        newUserDeatilPanel.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, 30));

        txtUserNIC.setBackground(new java.awt.Color(106, 137, 204));
        txtUserNIC.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtUserNIC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserNICKeyPressed(evt);
            }
        });
        newUserDeatilPanel.add(txtUserNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 190, -1));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel74.setText("Address");
        newUserDeatilPanel.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, 30));

        txtUserAddress.setBackground(new java.awt.Color(106, 137, 204));
        txtUserAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtUserAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserAddressKeyPressed(evt);
            }
        });
        newUserDeatilPanel.add(txtUserAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 190, -1));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel75.setText("Contact");
        newUserDeatilPanel.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, -1, 30));

        UserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Name", "N.I.C", "Address", "Contact"
            }
        ));
        UserTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserTableMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(UserTable);

        newUserDeatilPanel.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, 700, 90));

        txtUserContact.setBackground(new java.awt.Color(106, 137, 204));
        txtUserContact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtUserContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserContactActionPerformed(evt);
            }
        });
        txtUserContact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserContactKeyPressed(evt);
            }
        });
        newUserDeatilPanel.add(txtUserContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, 190, -1));

        btnUserSave.setBackground(new java.awt.Color(39, 60, 117));
        btnUserSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUserSave.setForeground(new java.awt.Color(255, 255, 255));
        btnUserSave.setText("Save");
        btnUserSave.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(39, 60, 117)));
        btnUserSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserSaveActionPerformed(evt);
            }
        });
        newUserDeatilPanel.add(btnUserSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 550, 70, 40));

        btnUserUpdate.setBackground(new java.awt.Color(64, 115, 158));
        btnUserUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUserUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUserUpdate.setText("Update");
        btnUserUpdate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(64, 115, 158)));
        btnUserUpdate.setPreferredSize(new java.awt.Dimension(35, 19));
        btnUserUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserUpdateActionPerformed(evt);
            }
        });
        newUserDeatilPanel.add(btnUserUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 550, 70, 40));

        btnUserDelete.setBackground(new java.awt.Color(232, 65, 24));
        btnUserDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUserDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnUserDelete.setText("Delete");
        btnUserDelete.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(232, 65, 24)));
        btnUserDelete.setPreferredSize(new java.awt.Dimension(35, 23));
        btnUserDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserDeleteActionPerformed(evt);
            }
        });
        newUserDeatilPanel.add(btnUserDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 550, 70, 40));

        btnUserClear.setBackground(new java.awt.Color(60, 99, 130));
        btnUserClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUserClear.setForeground(new java.awt.Color(255, 255, 255));
        btnUserClear.setText("Clear");
        btnUserClear.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(60, 99, 130)));
        btnUserClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserClearActionPerformed(evt);
            }
        });
        newUserDeatilPanel.add(btnUserClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 550, 70, 40));

        jLabel76.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\serchSmall.png")); // NOI18N
        jLabel76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel76MouseClicked(evt);
            }
        });
        newUserDeatilPanel.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 100, 40, -1));

        jLabel93.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        newUserDeatilPanel.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, -1));

        jLabel94.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        newUserDeatilPanel.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, -1, -1));

        jLabel95.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        newUserDeatilPanel.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        jLabel96.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        newUserDeatilPanel.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));

        jLabel97.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        newUserDeatilPanel.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, -1, -1));

        UserACC.setBackground(new java.awt.Color(0, 51, 204));
        UserACC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserACCMouseClicked(evt);
            }
        });
        UserACC.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel104.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\social (2).png")); // NOI18N
        jLabel104.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel104MouseClicked(evt);
            }
        });
        UserACC.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        newUserDeatilPanel.add(UserACC, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, 70, 60));

        jPanel1.add(newUserDeatilPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 690));

        MonthlyIncomePanel.setBackground(new java.awt.Color(106, 137, 204));
        MonthlyIncomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel65.setText("Year From");
        MonthlyIncomePanel.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        jLabel66.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(204, 204, 204));
        jLabel66.setText("YYYY");
        MonthlyIncomePanel.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 40, -1));

        txtFromYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFromYearKeyPressed(evt);
            }
        });
        MonthlyIncomePanel.add(txtFromYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 90, -1));

        jLabel67.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(204, 204, 204));
        jLabel67.setText("MM");
        MonthlyIncomePanel.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 20, -1));

        txtFromMonth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFromMonthKeyPressed(evt);
            }
        });
        MonthlyIncomePanel.add(txtFromMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 50, -1));

        jLabel68.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(204, 204, 204));
        jLabel68.setText("DD");
        MonthlyIncomePanel.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 20, -1));

        txtFromDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFromDateKeyPressed(evt);
            }
        });
        MonthlyIncomePanel.add(txtFromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 50, -1));

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel69.setText("Year To");
        MonthlyIncomePanel.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        jLabel70.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(204, 204, 204));
        jLabel70.setText("YYYY");
        MonthlyIncomePanel.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 40, -1));

        txtToYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtToYearKeyPressed(evt);
            }
        });
        MonthlyIncomePanel.add(txtToYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 90, -1));

        jLabel77.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(204, 204, 204));
        jLabel77.setText("MM");
        MonthlyIncomePanel.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 30, -1));

        txtToMonth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtToMonthKeyPressed(evt);
            }
        });
        MonthlyIncomePanel.add(txtToMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 50, -1));

        jLabel78.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(204, 204, 204));
        jLabel78.setText("DD");
        MonthlyIncomePanel.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 20, -1));

        txtToDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtToDateKeyPressed(evt);
            }
        });
        MonthlyIncomePanel.add(txtToDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 50, -1));

        btnMonthlyIncomeClear.setBackground(new java.awt.Color(255, 0, 0));
        btnMonthlyIncomeClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMonthlyIncomeClear.setForeground(new java.awt.Color(255, 255, 255));
        btnMonthlyIncomeClear.setText("Clear");
        btnMonthlyIncomeClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonthlyIncomeClearActionPerformed(evt);
            }
        });
        MonthlyIncomePanel.add(btnMonthlyIncomeClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, 140, 40));

        incomeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderID", "CusID", "ItrmID", "QTY", "UnitPrice", "Discount", "Price"
            }
        ));
        jScrollPane8.setViewportView(incomeTable);

        MonthlyIncomePanel.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 730, 150));

        lblIncome.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblIncome.setText("income is");
        MonthlyIncomePanel.add(lblIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 70, -1));

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel79.setText("Monthly Income");
        MonthlyIncomePanel.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 500, -1, -1));

        btnMonthlyIncomeEnter.setBackground(new java.awt.Color(0, 51, 204));
        btnMonthlyIncomeEnter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMonthlyIncomeEnter.setForeground(new java.awt.Color(255, 255, 255));
        btnMonthlyIncomeEnter.setText("Enter");
        btnMonthlyIncomeEnter.setBorder(new javax.swing.border.MatteBorder(null));
        btnMonthlyIncomeEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonthlyIncomeEnterActionPerformed(evt);
            }
        });
        MonthlyIncomePanel.add(btnMonthlyIncomeEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 140, 40));

        jPanel4.setBackground(new java.awt.Color(0, 51, 204));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel115.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\analytics.png")); // NOI18N
        jPanel4.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        MonthlyIncomePanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 70, 60, 70));

        jPanel1.add(MonthlyIncomePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 660));

        UserAccount.setBackground(new java.awt.Color(106, 137, 204));
        UserAccount.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel105.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        UserAccount.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, -1));

        jLabel106.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        UserAccount.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, -1, -1));

        jLabel107.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        UserAccount.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, -1));

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel108.setText("User ID");
        UserAccount.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel109.setText("Confirm Password");
        UserAccount.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, -1));

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel110.setText("Role");
        UserAccount.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, -1, -1));

        txtUserACCUserID.setBackground(new java.awt.Color(106, 137, 204));
        txtUserACCUserID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtUserACCUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserACCUserIDActionPerformed(evt);
            }
        });
        txtUserACCUserID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserACCUserIDKeyPressed(evt);
            }
        });
        UserAccount.add(txtUserACCUserID, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 190, -1));

        txtUserACCRole.setBackground(new java.awt.Color(106, 137, 204));
        txtUserACCRole.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtUserACCRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserACCRoleActionPerformed(evt);
            }
        });
        UserAccount.add(txtUserACCRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 190, -1));

        btnUserAccAddUser.setBackground(new java.awt.Color(51, 0, 204));
        btnUserAccAddUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUserAccAddUser.setForeground(new java.awt.Color(255, 255, 255));
        btnUserAccAddUser.setText("Add Account");
        btnUserAccAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserAccAddUserActionPerformed(evt);
            }
        });
        UserAccount.add(btnUserAccAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(651, 390, 130, -1));

        btnUserAccClear.setBackground(new java.awt.Color(255, 0, 51));
        btnUserAccClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUserAccClear.setForeground(new java.awt.Color(255, 255, 255));
        btnUserAccClear.setText("Clear");
        btnUserAccClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserAccClearActionPerformed(evt);
            }
        });
        UserAccount.add(btnUserAccClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 120, -1));

        btnUserAccUpdate.setBackground(new java.awt.Color(51, 102, 255));
        btnUserAccUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUserAccUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUserAccUpdate.setText("Update");
        btnUserAccUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserAccUpdateActionPerformed(evt);
            }
        });
        UserAccount.add(btnUserAccUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 120, -1));

        btnUserAccDelete.setBackground(new java.awt.Color(153, 0, 51));
        btnUserAccDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUserAccDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnUserAccDelete.setText("Delete");
        btnUserAccDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserAccDeleteActionPerformed(evt);
            }
        });
        UserAccount.add(btnUserAccDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 120, -1));

        jLabel111.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel111.setText("Password");
        UserAccount.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        jLabel112.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nipun Lakshitha\\Downloads\\transportation.png")); // NOI18N
        UserAccount.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, -1, -1));

        txtUserACCPassword.setBackground(new java.awt.Color(106, 137, 204));
        txtUserACCPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtUserACCPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserACCPasswordKeyPressed(evt);
            }
        });
        UserAccount.add(txtUserACCPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 190, -1));

        txtUserACCConfirmPassword.setBackground(new java.awt.Color(106, 137, 204));
        txtUserACCConfirmPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtUserACCConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserACCConfirmPasswordActionPerformed(evt);
            }
        });
        txtUserACCConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserACCConfirmPasswordKeyPressed(evt);
            }
        });
        UserAccount.add(txtUserACCConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 190, -1));

        jCheckBox1.setBackground(new java.awt.Color(106, 137, 204));
        jCheckBox1.setText("Show Passowrd");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        UserAccount.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, -1, -1));

        jCheckBox2.setBackground(new java.awt.Color(106, 137, 204));
        jCheckBox2.setText("ShowPassword");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        UserAccount.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, -1, -1));

        jPanel1.add(UserAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 510));

        ReportPanel.setBackground(new java.awt.Color(106, 137, 204));
        ReportPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel116.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel116.setText("Year From");
        ReportPanel.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        txtRportFromYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRportFromYearKeyPressed(evt);
            }
        });
        ReportPanel.add(txtRportFromYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 90, -1));

        txtRportFromMonth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRportFromMonthKeyPressed(evt);
            }
        });
        ReportPanel.add(txtRportFromMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 50, -1));

        txtRportFromDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRportFromDateKeyPressed(evt);
            }
        });
        ReportPanel.add(txtRportFromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 50, -1));

        jLabel117.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(204, 204, 204));
        jLabel117.setText("YYYY");
        ReportPanel.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 40, -1));

        jLabel118.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(204, 204, 204));
        jLabel118.setText("MM");
        ReportPanel.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 20, -1));

        jLabel119.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(204, 204, 204));
        jLabel119.setText("DD");
        ReportPanel.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 20, -1));

        jLabel120.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel120.setText("Year To");
        ReportPanel.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        jLabel121.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(204, 204, 204));
        jLabel121.setText("YYYY");
        ReportPanel.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 40, -1));

        txtRportToYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRportToYearKeyPressed(evt);
            }
        });
        ReportPanel.add(txtRportToYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 90, -1));

        jLabel122.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(204, 204, 204));
        jLabel122.setText("MM");
        ReportPanel.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 30, -1));

        txtRportToMonth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRportToMonthKeyPressed(evt);
            }
        });
        ReportPanel.add(txtRportToMonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 50, -1));

        jLabel123.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(204, 204, 204));
        jLabel123.setText("DD");
        ReportPanel.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 20, -1));
        ReportPanel.add(txtRportToDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 50, -1));

        ReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Item ID", "QTY"
            }
        ));
        jScrollPane10.setViewportView(ReportTable);

        ReportPanel.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 650, 100));

        btnReportEnter.setBackground(new java.awt.Color(51, 51, 255));
        btnReportEnter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReportEnter.setForeground(new java.awt.Color(255, 255, 255));
        btnReportEnter.setText("Enter");
        btnReportEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportEnterActionPerformed(evt);
            }
        });
        ReportPanel.add(btnReportEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, -1, -1));

        btnReportClear.setBackground(new java.awt.Color(255, 0, 0));
        btnReportClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReportClear.setForeground(new java.awt.Color(255, 255, 255));
        btnReportClear.setText("Clear");
        btnReportClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportClearActionPerformed(evt);
            }
        });
        ReportPanel.add(btnReportClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, -1, -1));

        jPanel1.add(ReportPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 560));

        backup.setBackground(new java.awt.Color(106, 137, 204));
        backup.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        backup.add(txtPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 360, -1));

        btnBackupBrows.setBackground(new java.awt.Color(0, 51, 153));
        btnBackupBrows.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBackupBrows.setForeground(new java.awt.Color(255, 255, 255));
        btnBackupBrows.setText("Brows");
        btnBackupBrows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackupBrowsActionPerformed(evt);
            }
        });
        backup.add(btnBackupBrows, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 80, -1));

        btnBackup.setBackground(new java.awt.Color(0, 51, 255));
        btnBackup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBackup.setForeground(new java.awt.Color(255, 255, 255));
        btnBackup.setText("BackUp");
        btnBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackupActionPerformed(evt);
            }
        });
        backup.add(btnBackup, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        jPanel1.add(backup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemMouseClicked
        HomePanel.setVisible(false);
        newItem.setVisible(true);
        CustomerPanel.setVisible(false);
        SupplierPanel.setVisible(false);
        SupBillPanel.setVisible(false);
        newItemReurnPanel.setVisible(false);
        newUserDeatilPanel.setVisible(false);
        UserAccount.setVisible(false);
        MonthlyIncomePanel.setVisible(false);
        ReportPanel.setVisible(false);
        backup.setVisible(false);
    }//GEN-LAST:event_ItemMouseClicked

    private void CustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerMouseEntered

    private void CustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerMouseClicked
        HomePanel.setVisible(false);
        CustomerPanel.setVisible(true);
        newItem.setVisible(false);
        SupplierPanel.setVisible(false);
        SupBillPanel.setVisible(false);
        newItemReurnPanel.setVisible(false);
        newUserDeatilPanel.setVisible(false);
        MonthlyIncomePanel.setVisible(false);
        UserAccount.setVisible(false);
        ReportPanel.setVisible(false);
        backup.setVisible(false);
    }//GEN-LAST:event_CustomerMouseClicked

    private void HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseClicked
        newItem.setVisible(false);
        HomePanel.setVisible(true);
        CustomerPanel.setVisible(false);
        SupplierPanel.setVisible(false);
        SupBillPanel.setVisible(false);
        newItemReurnPanel.setVisible(false);
        newUserDeatilPanel.setVisible(false);
        MonthlyIncomePanel.setVisible(false);
        UserAccount.setVisible(false);
        ReportPanel.setVisible(false);
        backup.setVisible(false);


    }//GEN-LAST:event_HomeMouseClicked

    private void txtQTYKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQTYKeyReleased

//        char c = evt.getKeyChar();
//        if (Character.isLetter(c)) {
//            txtQTY.setEditable(false);
//            txtDiscount.setEditable(false);
//            JOptionPane.showMessageDialog(rootPane, "PLZ EnterNumber");
//        } else {
//            txtQTY.setEditable(true);
//            txtDiscount.setEditable(true);
//        }
        //      if (!txtQTY.getText().isEmpty() && QTY <= q) {
//                double price = Double.parseDouble(txtUnitPrice.getText());
//                double qty = Double.parseDouble(txtQTY.getText());
//
//                double tot = (double) (qty * price);
//                txtDiscount.setEditable(true);
//                // txtPrice.setText(Double.toString(tot));
//
//            } else {
//                txtQTY.setText(Integer.toString(q));
//            }
//        }

    }//GEN-LAST:event_txtQTYKeyReleased

    private void txtQTYKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQTYKeyPressed
        char c = evt.getKeyChar();
        try {

            if (Character.isLetter(c)) {
                txtQTY.setEditable(false);
                txtDiscount.setEditable(false);
            } else {

                txtQTY.setEditable(true);
                txtDiscount.setEditable(true);

            }
            String id = txtItemCode.getText();
            int q = new ItemController().getItemQTY(id);
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

                double QTY = Double.parseDouble(txtQTY.getText());

                if (QTY <= q) {
                    txtDiscount.requestFocus();
                } else {
                    txtQTY.setText(Integer.toString(q));
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }


    }//GEN-LAST:event_txtQTYKeyPressed

    private void txtLastDiscountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastDiscountKeyPressed
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtLastDiscount.setEditable(false);
            txtLastAmount.setText("");
        } else {
            txtLastDiscount.setEditable(true);

        }

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCustomerPayment.requestFocus();
            billNo = txtBNo.getText();
            billDate = txtBillDate.getText();
            billTime = txtBillTime.getText();
            if (txtLastDiscount.getText().isEmpty()) {

            } else {
                double discount = Double.parseDouble(txtLastDiscount.getText());

                double tot = totalAmount;
                double amount = tot - (tot * discount / 100);
                txtLastAmount.setText(Double.toString(amount));

            }
        }

    }//GEN-LAST:event_txtLastDiscountKeyPressed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed

        if (txtTotal.getText().trim().length() > 0 && txtLastAmount.getText().trim().length() > 0 && txtLastDiscount.getText().trim().length() > 0) {

            String Orderid = txtOrderId.getText();
            String OrderDate = txtBillDate.getText();
            String CusID = CusIDCombo.getSelectedItem().toString();

            double Total = totalAmount;
            double LastDiscount = Double.parseDouble(txtLastDiscount.getText());
            double LastAmount = Double.parseDouble(txtLastAmount.getText());
            double CusPay = Double.parseDouble(txtCustomerPayment.getText());
            double Balance = Double.parseDouble(txtBalance.getText());
            String userID = txtUserID.getText();

            // ArrayList<OrderDetailModel> list1 = new ArrayList<>();
            ArrayList<OrderDetailModel> list1 = new ArrayList<>();

            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                String code = model.getValueAt(i, 0).toString();
                String name = model.getValueAt(i, 1).toString();
                double qty = Double.parseDouble(model.getValueAt(i, 2).toString());
                double unitPrice = Double.parseDouble(model.getValueAt(i, 3).toString());
                double discount = Double.parseDouble(model.getValueAt(i, 4).toString());
                double lastAmount = Double.parseDouble(model.getValueAt(i, 5).toString());
                list1.add(new OrderDetailModel(Orderid, code, name, qty, unitPrice, discount, lastAmount));

            }

            boolean isAdded;
            try {

                isAdded = new OrderController().SaveCustomer(new OrderModel(Orderid, OrderDate, CusID, userID, list1));
                if (isAdded) {
                    new CustomerPaymentController().addCustomerPayment(new CustomerPaymentModel(Orderid, Total, LastDiscount, LastAmount, CusPay, Balance));
                    JOptionPane.showMessageDialog(rootPane, "BILL CREATED");
                    txtItemName.setText("");
                    txtItemCode.setText("");
                    txtUnitPrice.setText("");
                    txtQTYOnHand.setText("");
                    txtQTY.setText("");
                    txtPrice.setText("");
                    txtDiscount.setText("");
                    model.setRowCount(0);
                    txtLastDiscount.setText("");
                    txtLastAmount.setText("");
                    txtTotal.setText("");
                    txtCustomerPayment.setText("");
                    txtBalance.setText("");

                } else {
                    JOptionPane.showMessageDialog(rootPane, "CAN'T CREATE BILL");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "PLZ ENTER ITEM AND LAST DISCOUNT");
        }

        calculateTotal();
        getBill();
        LoadDateAndTime();
        LoadOrderID();


    }//GEN-LAST:event_btnPayActionPerformed

    private void txtDiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscountKeyReleased

    }//GEN-LAST:event_txtDiscountKeyReleased

    private void txtDiscountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscountKeyPressed
        char c = evt.getKeyChar();
        try {
            if (Character.isLetter(c)) {
                txtDiscount.setEditable(false);
                txtPrice.setText("");
            } else {
                txtDiscount.setEditable(true);
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

                    if (txtDiscount.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(rootPane, "PLZ INSERT DISCOUNT FOR ITEM");
                    } else {
                        double p = Double.parseDouble(txtUnitPrice.getText());
                        double q = Double.parseDouble(txtQTY.getText());
                        double price = p * q;
                        double dis = Double.parseDouble(txtDiscount.getText());
                        // double cal=dis/100;
                        double tot = price - (price * dis / 100);
                        //double tot = (double) price - cal1;

                        txtPrice.setText(Double.toString(tot));
                        txtLastAmount.requestFocus();
                    }

                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }//GEN-LAST:event_txtDiscountKeyPressed

    private void btnAddtoCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddtoCartActionPerformed
        try {
            if (txtQTY.getText().trim().length() > 0 && txtDiscount.getText().trim().length() > 0) {
                DefaultTableModel model = (DefaultTableModel) Table.getModel();

                double qty = Double.parseDouble(txtQTY.getText());
                double unitprice = Double.parseDouble(txtUnitPrice.getText());
                double discount = Double.parseDouble(txtDiscount.getText());
                double total = (double) (qty * unitprice) - (double) (qty * unitprice * discount / 100);

                int RowIndex = isAlreadyExists(txtItemCode.getText());
                if (RowIndex == -1) {
                    Object[] RowData = {txtItemCode.getText(), txtItemName.getText(), qty, unitprice, txtDiscount.getText(), total};
                    model.addRow(RowData);
                } else {
                    qty += (Double) model.getValueAt(RowIndex, 2);
                    total = (double) (qty * unitprice) - (double) (qty * unitprice * discount / 100);
                    Table.setValueAt(qty, RowIndex, 2);
                    Table.setValueAt(total, RowIndex, 5);

                }

                calculateTotal();
            } else {
                JOptionPane.showMessageDialog(rootPane, "PLZ INPUTE QTY AND DISCOUNT");

            }

        } catch (NumberFormatException e) {
        }

        txtItemName.setText("");
        txtItemCode.setText("");
        txtUnitPrice.setText("");
        txtQTYOnHand.setText("");
        txtQTY.setText("");
        txtPrice.setText("");
        txtDiscount.setText("");
        // DefaultTableModel model = (DefaultTableModel) Table.getModel();
    }//GEN-LAST:event_btnAddtoCartActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtItemName.setText("");
        txtItemCode.setText("");
        txtUnitPrice.setText("");
        txtQTYOnHand.setText("");
        txtQTY.setText("");
        txtPrice.setText("");
        txtDiscount.setText("");
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setRowCount(0);
        txtBalance.setText("");
        txtLastDiscount.setText("");
        txtLastAmount.setText("");
        calculateTotal();
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtCustomerContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerContactActionPerformed

    private void CustomerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerTableMouseClicked
        int rowIndex = CustomerTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) CustomerTable.getModel();
        txtCustomerID.setText(model.getValueAt(rowIndex, 0).toString());
        txtCustmoerName.setText(model.getValueAt(rowIndex, 1).toString());
        txtCustomerAddress.setText(model.getValueAt(rowIndex, 2).toString());
        txtCustomerContact.setText(model.getValueAt(rowIndex, 3).toString());
    }//GEN-LAST:event_CustomerTableMouseClicked

    private void btnCusSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusSaveActionPerformed
        if (txtCustomerID.getText().trim().length() > 0 && txtCustmoerName.getText().length() > 0 && txtCustomerAddress.getText().length() > 0 && txtCustomerContact.getText().length() > 0) {
            String CusID = txtCustomerID.getText();
            String CusName = txtCustmoerName.getText();
            String CusAddress = txtCustomerAddress.getText();
            int CusContact = Integer.parseInt(txtCustomerContact.getText());
            boolean detail = false;
            detail = new CustomerController().AddCustomer(new CustomerModel(CusID, CusName, CusAddress, CusContact));
            if (detail == true) {
                JOptionPane.showMessageDialog(rootPane, "CUSTOMER SAVED");
            } else {
                JOptionPane.showMessageDialog(rootPane, "CUSTOMER NOT SAVED TRY AGAIN");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "INSERT ALL DETAILS");
        }
        LoadAllCustomer();
        txtCustmoerName.setText("");
        txtCustomerID.setText("");
        txtCustomerAddress.setText("");
        txtCustomerContact.setText("");
    }//GEN-LAST:event_btnCusSaveActionPerformed

    private void btnCusUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusUpdateActionPerformed
        try {
            if (txtCustomerID.getText().trim().length() > 0) {
                String CusID = txtCustomerID.getText();
                String CusName = txtCustmoerName.getText();
                String CusAddress = txtCustomerAddress.getText();
                int CusContact = Integer.parseInt(txtCustomerContact.getText());
                boolean update = false;

                update = new CustomerController().UpdateCustomer(new CustomerModel(CusID, CusName, CusAddress, CusContact));
                if (update == true) {
                    JOptionPane.showMessageDialog(rootPane, "CUSTOMER UPDATED");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "CUSTOMER NOT UPDATED TRY AGAIN");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "PLZ INSERT CUSTOMER ID");
            }
            LoadAllCustomer();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }//GEN-LAST:event_btnCusUpdateActionPerformed

    private void btnCusDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusDeleteActionPerformed
        if (txtCustomerID.getText().trim().length() > 0) {
            String CusID = txtCustomerID.getText();
            boolean delete = false;

            delete = new CustomerController().CustomerDelete(CusID);
            if (delete == true) {
                JOptionPane.showMessageDialog(rootPane, "CUSTOMER DELETED ");
            } else {
                JOptionPane.showMessageDialog(rootPane, "CUSTOMER NOT DELETED TRY AGAIN");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "PLZ INSERT CUSTOMER ID");
        }
        LoadAllCustomer();
    }//GEN-LAST:event_btnCusDeleteActionPerformed

    private void ItemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemTableMouseClicked
        int rowIndex = ItemTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) ItemTable.getModel();
        txtItem_Code.setText(model.getValueAt(rowIndex, 0).toString());
        txtItem_Name.setText(model.getValueAt(rowIndex, 1).toString());
        txtItem_Price.setText(model.getValueAt(rowIndex, 2).toString());
        txt_QTYOnHand.setText(model.getValueAt(rowIndex, 3).toString());
    }//GEN-LAST:event_ItemTableMouseClicked

    private void btnItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemSaveActionPerformed
        if (txt_QTYOnHand.getText().trim().length() > 0 && txtItem_Name.getText().length() > 0 && txtItem_Price.getText().length() > 0 && txtItem_Code.getText().length() > 0) {
            String itemCode = txtItem_Code.getText();
            String itemName = txtItem_Name.getText();
            double unitPrice = Double.parseDouble(txtItem_Price.getText());

            boolean detail = false;
            int qty = Integer.parseInt(txt_QTYOnHand.getText());

            //detail = new ItemDetail().AddItem(new Item(itemCode, itemName, unitPrice, qty));
            detail = new ItemDetail().AddItem(new ItemModel(itemCode, itemName, unitPrice, qty));
            if (detail == true) {
                JOptionPane.showMessageDialog(rootPane, "ITEM SAVED");
            } else {
                JOptionPane.showMessageDialog(rootPane, "ITEM NOT SAVED TRY AGAIN");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "INSERT ALL DETAILS");
        }
        LoadAllItem();
        txtItem_Code.setText("");
        txtItem_Name.setText("");
        txtItem_Price.setText("");
        txt_QTYOnHand.setText("");
    }//GEN-LAST:event_btnItemSaveActionPerformed

    private void btnItemUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemUpdateActionPerformed
        if (txtItem_Code.getText().trim().length() > 0) {
            String itemCode = txtItem_Code.getText();
            String itemName = txtItem_Name.getText();
            double unitPrice = Double.parseDouble(txtItem_Price.getText());
            int qty = Integer.parseInt(txt_QTYOnHand.getText());

            boolean update = false;
            update = new ItemDetail().UpdateItem(new ItemModel(itemCode, itemName, unitPrice, qty));

            if (update == true) {
                JOptionPane.showMessageDialog(rootPane, "ITEM UPDATED");
            } else {
                JOptionPane.showMessageDialog(rootPane, "ITEM NOT UPADATED TRY AGAIN");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "PLZ INSERT ITEM ID");
        }
        LoadAllItem();
    }//GEN-LAST:event_btnItemUpdateActionPerformed

    private void btnItemDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemDeleteActionPerformed
        if (txtItem_Code.getText().trim().length() > 0) {
            String itemCode = txtItem_Code.getText();

            boolean delete = new ItemDetail().DeleteItem(itemCode);

            if (delete == true) {
                JOptionPane.showMessageDialog(rootPane, "ITEM DELETED");
            } else {
                JOptionPane.showMessageDialog(rootPane, "ITEM NOT DELETED TRY AGAIN");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "PLZ INSERT ITEM ID");
        }
        LoadAllItem();
    }//GEN-LAST:event_btnItemDeleteActionPerformed

    private void jLabel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseClicked
        for (ItemModel s : new ItemDetail().SearchItem(txtItem_Name.getText())) {
            txtItem_Code.setText(s.getCode());
            txtItem_Name.setText(s.getName());
            txtItem_Price.setText(Double.toString(s.getUnitPrice()));
            txt_QTYOnHand.setText(Integer.toString(s.getQTYOnHand()));
        }
    }//GEN-LAST:event_jLabel43MouseClicked

    private void SupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierMouseClicked
        HomePanel.setVisible(false);
        SupplierPanel.setVisible(true);
        newItem.setVisible(false);
        CustomerPanel.setVisible(false);
        SupBillPanel.setVisible(false);
        newItemReurnPanel.setVisible(false);
        newUserDeatilPanel.setVisible(false);
        MonthlyIncomePanel.setVisible(false);
        UserAccount.setVisible(false);
        ReportPanel.setVisible(false);
        backup.setVisible(false);
    }//GEN-LAST:event_SupplierMouseClicked

    private void txtSupBillDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupBillDateActionPerformed

    }//GEN-LAST:event_txtSupBillDateActionPerformed

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        new SupBillSearch(this).setVisible(true);
    }//GEN-LAST:event_jLabel50MouseClicked

    private void txtItemQTYKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItemQTYKeyPressed
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtItemQTY.setEditable(false);
        } else {
            txtItemQTY.setEditable(true);
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                txtItemPrice.requestFocus();
            }
        }
    }//GEN-LAST:event_txtItemQTYKeyPressed

    private void jLabel53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseClicked
        new ItemSearch(this).setVisible(true);
    }//GEN-LAST:event_jLabel53MouseClicked

    private void txtItemPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItemPriceActionPerformed

    private void txtItemPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItemPriceKeyPressed
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtItemPrice.setEditable(false);
        } else {
            txtItemPrice.setEditable(true);
        }
    }//GEN-LAST:event_txtItemPriceKeyPressed

    private void btnSupBillAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupBillAddActionPerformed
        if (txtItemQTY.getText().trim().length() > 0 && txtItemPrice.getText().trim().length() > 0) {
            DefaultTableModel model = (DefaultTableModel) SupTable.getModel();

            double qty = Double.parseDouble(txtItemQTY.getText());
            double price = Double.parseDouble(txtItemPrice.getText());
            double tot = qty * price;

            int RowIndex = isAlreadyExitsSupplier(txtId.getText());

            if (RowIndex == -1) {
                model.addRow(new Object[]{txtSupID.getText(), txtSupName.getText(), txtId.getText(), txtName.getText(), qty, price, tot});
            } else {
                qty += (double) model.getValueAt(RowIndex, 4);
                tot = qty * price;
                SupTable.setValueAt(tot, RowIndex, 6);
                SupTable.setValueAt(qty, RowIndex, 4);
            }
            calculateSupBillTotal();
        } else {
            JOptionPane.showMessageDialog(rootPane, "PLZ ALL DETAILS");
        }
        txtId.setText("");
        txtName.setText("");
        txtItemQTY.setText("");
        txtItemPrice.setText("");
    }//GEN-LAST:event_btnSupBillAddActionPerformed

    private void btnSupBillRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupBillRestActionPerformed
        txtId.setText("");
        txtName.setText("");
        txtSupID.setText("");
        txtSupName.setText("");
        txtItemQTY.setText("");
        txtItemPrice.setText("");
    }//GEN-LAST:event_btnSupBillRestActionPerformed

    private void btnSupBillPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupBillPayActionPerformed
        String billNo = txtSupBillNo.getText();
        String date = txtSupBillDate.getText();

        List<SupBillModel> list = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) SupTable.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {

            String SupID = model.getValueAt(i, 0).toString();
            String ItemID = model.getValueAt(i, 2).toString();
            double qty = Double.parseDouble(model.getValueAt(i, 4).toString());
            double unitprice = Double.parseDouble(model.getValueAt(i, 5).toString());
            double payment = Double.parseDouble(model.getValueAt(i, 6).toString());

            list.add(new SupBillModel(billNo, SupID, date, ItemID, qty, unitprice, payment));
        }
        boolean isAded = new SupBillController().AddToDB(list);

        if (isAded) {
            JOptionPane.showMessageDialog(rootPane, "BILL CREATED");
            getSupBill();
        } else {
            JOptionPane.showMessageDialog(rootPane, "BILL NOT CREATED");
        }
        getBillID();
        LoadDateTimeSup();
        txtId.setText("");
        txtName.setText("");
        txtSupID.setText("");
        txtSupName.setText("");
        txtItemQTY.setText("");
        txtItemPrice.setText("");
        model.setRowCount(0);
    }//GEN-LAST:event_btnSupBillPayActionPerformed

    private void SupplierBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierBillMouseClicked
        HomePanel.setVisible(false);
        CustomerPanel.setVisible(false);
        SupplierPanel.setVisible(false);
        newItem.setVisible(false);
        SupBillPanel.setVisible(true);
        newItemReurnPanel.setVisible(false);
        newUserDeatilPanel.setVisible(false);
        MonthlyIncomePanel.setVisible(false);
        UserAccount.setVisible(false);
        ReportPanel.setVisible(false);
        backup.setVisible(false);
    }//GEN-LAST:event_SupplierBillMouseClicked

    private void jLabel57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel57MouseClicked
        String id = txtReturnOrderID.getText().toString();
        DefaultTableModel model = (DefaultTableModel) OrderTable.getModel();
        model.setRowCount(0);

        for (OrderDetailModel detail : new ItemReturnController().getAllDdetails(id)) {
            model.addRow(new Object[]{detail.getOrderID(), detail.getItemID(), detail.getQTY(), detail.getUnitPrice(), detail.getDiscount(), detail.getPrice()});
        }
    }//GEN-LAST:event_jLabel57MouseClicked

    private void jLabel62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel62MouseClicked
        String id = txReturntItemID.getText();
        String name = new ItemReturnController().getItemName(id);
        txtReturnItemName.setText(name);

    }//GEN-LAST:event_jLabel62MouseClicked

    private void btnItemReturnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemReturnEnterActionPerformed
        if (txtReturnOrderID.getText().trim().length() > 0 && txReturntItemID.getText().trim().length() > 0 && txtReturnQTY.getText().trim().length() > 0) {
            DefaultTableModel model = (DefaultTableModel) ReturnTable.getModel();

            String id = txReturntItemID.getText();
            double price = new ItemReturnController().getItemUnitPrice(id);
            double qty = Double.parseDouble(txtReturnQTY.getText());

            double tot = qty * price;

            int rowIndex = isAlreadyExitsReturn(txReturntItemID.getText());

            if (rowIndex == -1) {
                Object[] rowData = {txtIRID.getText(), txtReturnOrderID.getText(), txReturntItemID.getText(), txtReturnItemName.getText(), qty, tot};
                model.addRow(rowData);
            } else {
                qty += (double) model.getValueAt(rowIndex, 4);
                tot = qty * price;
                model.setValueAt(qty, rowIndex, 4);
                model.setValueAt(tot, rowIndex, 5);

            }
            calculateReturnTotal();
            txReturntItemID.setText("");
            txtReturnQTY.setText("");
            txtReturnItemName.setText("");
            txtReturnOrderID.setText("");
        } else {
            JOptionPane.showMessageDialog(rootPane, "INSERT ALL DETAILS");
        }
    }//GEN-LAST:event_btnItemReturnEnterActionPerformed

    private void btnItemReturnRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemReturnRestActionPerformed

        txReturntItemID.setText("");
        txtReturnQTY.setText("");
        txtReturnItemName.setText("");
        txtReturnOrderID.setText("");

    }//GEN-LAST:event_btnItemReturnRestActionPerformed

    private void btnItemReturnAddToShopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemReturnAddToShopActionPerformed

        DefaultTableModel model = (DefaultTableModel) ReturnTable.getModel();
        List<ItemReturnModel> list = new ArrayList<>();
        double amount = 0;
        for (int i = 0; i < ReturnTable.getRowCount(); i++) {
            String IRID = model.getValueAt(i, 0).toString();
            String OrderID = model.getValueAt(i, 1).toString();
            String ItemId = model.getValueAt(i, 2).toString();
            String ItemName = model.getValueAt(i, 3).toString();

            double Unitprice = new ItemReturnController().getUnitPrice(OrderID, ItemId);

            double qty = (double) model.getValueAt(i, 4);
            amount = qty * Unitprice;

            new ItemReturnController().UpdateItemQTY(OrderID, ItemId, amount);
            double price = (double) model.getValueAt(i, 5);

            list.add(new ItemReturnModel(IRID, OrderID, ItemId, ItemName, qty, price));

        }

        boolean isAdded = new ItemReturnController().isAdded(list);

        if (isAdded == true) {
            JOptionPane.showMessageDialog(rootPane, "SUCCESSFULLY ADDED TO SHOP");
        } else {
            JOptionPane.showMessageDialog(rootPane, "CAN'T ADDED TO SHOP");
        }
        LoadDateTime();
        LoadIRID();
        DefaultTableModel model2 = (DefaultTableModel) OrderTable.getModel();
        model.setRowCount(0);
        model2.setRowCount(0);
        txReturntItemID.setText("");
        txtReturnQTY.setText("");
        txtReturnItemName.setText("");
        txtReturnOrderID.setText("");


    }//GEN-LAST:event_btnItemReturnAddToShopActionPerformed

    private void ItemReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemReturnMouseClicked
        HomePanel.setVisible(false);
        CustomerPanel.setVisible(false);
        newItem.setVisible(false);
        SupplierPanel.setVisible(false);
        SupBillPanel.setVisible(false);
        newItemReurnPanel.setVisible(true);
        newUserDeatilPanel.setVisible(false);
        MonthlyIncomePanel.setVisible(false);
        UserAccount.setVisible(false);
        ReportPanel.setVisible(false);
        backup.setVisible(false);
    }//GEN-LAST:event_ItemReturnMouseClicked

    private void UserDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserDetailMouseClicked
        HomePanel.setVisible(false);
        newUserDeatilPanel.setVisible(true);
        newItem.setVisible(false);
        CustomerPanel.setVisible(false);
        SupplierPanel.setVisible(false);
        SupBillPanel.setVisible(false);
        newItemReurnPanel.setVisible(false);
        MonthlyIncomePanel.setVisible(false);
        UserAccount.setVisible(false);
        ReportPanel.setVisible(false);
        backup.setVisible(false);


    }//GEN-LAST:event_UserDetailMouseClicked

    private void UserTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) UserTable.getModel();

        int rowIndex = UserTable.getSelectedRow();

        txtUser_ID.setText(model.getValueAt(rowIndex, 0).toString());
        txtUserName.setText(model.getValueAt(rowIndex, 1).toString());
        txtUserNIC.setText(model.getValueAt(rowIndex, 2).toString());
        txtUserAddress.setText(model.getValueAt(rowIndex, 3).toString());
        txtUserContact.setText(model.getValueAt(rowIndex, 4).toString());
    }//GEN-LAST:event_UserTableMouseClicked

    private void txtUserContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserContactActionPerformed

    private void btnUserSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserSaveActionPerformed
        if (txtUser_ID.getText().trim().length() > 0 && txtUserName.getText().trim().length() > 0 && txtUserAddress.getText().trim().length() > 0 && txtUserContact.getText().trim().length() > 0 && txtUserNIC.getText().trim().length() > 0) {
            String name = txtUserName.getText();
            String ID = txtUser_ID.getText();
            String NIC = txtUserNIC.getText();
            String Address = txtUserAddress.getText();
            int Contact = Integer.parseInt(txtUserContact.getText());

            boolean isSave = new UserDetailController().SaveUser(new UserDetailModel(name, NIC, Address, Contact, ID));

            if (isSave) {
                JOptionPane.showMessageDialog(rootPane, "USER SAVED");
            } else {
                JOptionPane.showMessageDialog(rootPane, "USER NOT SAVED");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "INSERT ALL DETAILS");
        }
        LoadUser();
        txtUser_ID.setText("");
        txtUserName.setText("");
        txtUserAddress.setText("");
        txtUserContact.setText("");
        txtUserNIC.setText("");
    }//GEN-LAST:event_btnUserSaveActionPerformed

    private void btnUserUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserUpdateActionPerformed
        if (txtUser_ID.getText().trim().length() > 0) {
            String name = txtUserName.getText();
            String ID = txtUser_ID.getText();
            String NIC = txtUserNIC.getText();
            String Address = txtUserAddress.getText();
            int Contact = Integer.parseInt(txtUserContact.getText());

            boolean isUpdate = new UserDetailController().UpdateUser(new UserDetailModel(name, NIC, Address, Contact, ID));

            if (isUpdate) {
                JOptionPane.showMessageDialog(rootPane, "USER UPDATED");
            } else {
                JOptionPane.showMessageDialog(rootPane, "USER NOT UPDATED");
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "PLZ INSERT UserID");
        }
        LoadUser();
    }//GEN-LAST:event_btnUserUpdateActionPerformed

    private void btnUserDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserDeleteActionPerformed
        if (txtUser_ID.getText().trim().length() > 0) {
            String id = txtUser_ID.getText();
            boolean isDelete = new UserDetailController().DeleteUser(id);

            if (isDelete) {
                JOptionPane.showMessageDialog(rootPane, "USER DELETED");
            } else {
                JOptionPane.showMessageDialog(rootPane, "USER NOT DELETED");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "PLZ INSERT UserID");
        }
        LoadUser();
    }//GEN-LAST:event_btnUserDeleteActionPerformed

    private void jLabel76MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel76MouseClicked
        if (txtUser_ID.getText().trim().length() > 0) {
            String id = txtUser_ID.getText();
            for (UserDetailModel detail : new UserDetailController().SerchUser(id)) {
                txtUserName.setText(detail.getName());
                txtUserNIC.setText(detail.getNIC());
                txtUserAddress.setText(detail.getAddress());
                txtUserContact.setText(Integer.toString(detail.getContact()));
            }
        }
    }//GEN-LAST:event_jLabel76MouseClicked

    private void btnMonthlyIncomeClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonthlyIncomeClearActionPerformed
        DefaultTableModel model = (DefaultTableModel) incomeTable.getModel();
        model.setRowCount(0);
        txtFromDate.setText("");
        txtFromMonth.setText("");
        txtFromYear.setText("");
        txtToYear.setText("");
        txtToMonth.setText("");
        txtToDate.setText("");


    }//GEN-LAST:event_btnMonthlyIncomeClearActionPerformed

    private void MonthlyIcomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MonthlyIcomeMouseClicked
        HomePanel.setVisible(false);
        MonthlyIncomePanel.setVisible(true);
        newItem.setVisible(false);
        CustomerPanel.setVisible(false);
        SupplierPanel.setVisible(false);
        SupBillPanel.setVisible(false);
        newItemReurnPanel.setVisible(false);
        newUserDeatilPanel.setVisible(false);
        UserAccount.setVisible(false);
        ReportPanel.setVisible(false);
        backup.setVisible(false);

    }//GEN-LAST:event_MonthlyIcomeMouseClicked

    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
        if (txtCustomerID.getText().trim().length() > 0) {
            String id = txtCustomerID.getText();
            for (CustomerModel detail : new CustomerController().SearchCustomer(id)) {
                txtCustmoerName.setText(detail.getCusName());
                txtCustomerAddress.setText(detail.getCusAddress());
                txtCustomerContact.setText(Integer.toString(detail.getCusContact()));
            }
        }
    }//GEN-LAST:event_jLabel38MouseClicked

    private void jLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseClicked
        for (supplier sup : new SupplierController().SerachSupplier(txtSupplierName.getText().toString())) {

            //txtSupplierName.setText(sup.getSupplierName().toString());
            txtSupplierId.setText(sup.getSupplierID().toString());
            txtSupplierContact.setText(Integer.toString(sup.getContact()));
            txtSupplierAddress.setText(sup.getAddress());
            txtSuppllierEmail.setText(sup.getEmail());
        }
    }//GEN-LAST:event_jLabel44MouseClicked

    private void btnSupDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupDeleteActionPerformed
        boolean delete = new SupplierController().DeleteSupplier(txtSupplierId.getText().toString());

        if (delete == true) {
            JOptionPane.showMessageDialog(rootPane, "SUPPLIER DELETED");
        } else {
            JOptionPane.showMessageDialog(rootPane, "SUPPLIER NOT DELETED TRY AGAIN");
        }
        LoadAllSupplier();
    }//GEN-LAST:event_btnSupDeleteActionPerformed

    private void btnSupUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupUpdateActionPerformed
        try {
            String supplierName = txtSupplierName.getText();
            String supplierID = txtSupplierId.getText();
            int contact = Integer.parseInt(txtSupplierContact.getText());
            String address = txtSupplierAddress.getText();
            String email = txtSuppllierEmail.getText();
            boolean detail = new SupplierController().UpdateItem(new supplier(supplierName, supplierID, contact, address, email));
            if (detail == true) {
                JOptionPane.showMessageDialog(rootPane, "SUPPLIER UPDATED");
            } else {
                JOptionPane.showMessageDialog(rootPane, "SUPPLIER NOT UPDATED TRY AGAIN");
            }
            DefaultTableModel model = (DefaultTableModel) SupplierTable.getModel();

            LoadAllSupplier();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }

    }//GEN-LAST:event_btnSupUpdateActionPerformed

    private void btnSupSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupSaveActionPerformed
        String supplierName = txtSupplierName.getText();
        String supplierID = txtSupplierId.getText();
        int contact = Integer.parseInt(txtSupplierContact.getText());
        String address = txtSupplierAddress.getText();
        String email = txtSuppllierEmail.getText();

        boolean detail = new SupplierController().AddItem(new supplier(supplierName, supplierID, contact, address, email));

        if (detail == true) {
            JOptionPane.showMessageDialog(rootPane, "SUPPLIER SAVED");
        } else {
            JOptionPane.showMessageDialog(rootPane, "SUPPLIER NOT SAVED TRY AGAIN");
        }
        LoadAllSupplier();
    }//GEN-LAST:event_btnSupSaveActionPerformed

    private void SupplierTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) SupplierTable.getModel();
        int rowIndex = SupplierTable.getSelectedRow();

        txtSupplierName.setText(model.getValueAt(rowIndex, 0).toString());
        txtSupplierId.setText(model.getValueAt(rowIndex, 1).toString());
        txtSupplierAddress.setText(model.getValueAt(rowIndex, 2).toString());
        txtSuppllierEmail.setText(model.getValueAt(rowIndex, 3).toString());
        txtSupplierContact.setText(model.getValueAt(rowIndex, 4).toString());
    }//GEN-LAST:event_SupplierTableMouseClicked

    private void txtCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCustomerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCustomerIDActionPerformed

    private void CustomerPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CustomerPanelKeyPressed

    }//GEN-LAST:event_CustomerPanelKeyPressed

    private void txtCustomerIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerIDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCustmoerName.requestFocus();
        }
    }//GEN-LAST:event_txtCustomerIDKeyPressed

    private void txtCustmoerNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustmoerNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCustomerAddress.requestFocus();
        }
    }//GEN-LAST:event_txtCustmoerNameKeyPressed

    private void txtCustomerAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerAddressKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCustomerContact.requestFocus();
        }
    }//GEN-LAST:event_txtCustomerAddressKeyPressed

    private void txtCustomerContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerContactKeyPressed
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtCustomerContact.setEditable(false);
        } else {
            txtCustomerContact.setEditable(true);
        }
    }//GEN-LAST:event_txtCustomerContactKeyPressed

    private void btnCusClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusClearActionPerformed
        txtCustmoerName.setText("");
        txtCustomerID.setText("");
        txtCustomerAddress.setText("");
        txtCustomerContact.setText("");
    }//GEN-LAST:event_btnCusClearActionPerformed

    private void txtItem_CodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItem_CodeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtItem_Name.requestFocus();
        }
    }//GEN-LAST:event_txtItem_CodeKeyPressed

    private void txtItem_NameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItem_NameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtItem_Price.requestFocus();
        }
    }//GEN-LAST:event_txtItem_NameKeyPressed

    private void txtItem_PriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItem_PriceKeyPressed
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtItem_Price.setEditable(false);
        } else {
            txtItem_Price.setEditable(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_QTYOnHand.requestFocus();
        }
    }//GEN-LAST:event_txtItem_PriceKeyPressed

    private void txt_QTYOnHandKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_QTYOnHandKeyPressed
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txt_QTYOnHand.setEditable(false);
        } else {
            txt_QTYOnHand.setEditable(true);
        }
    }//GEN-LAST:event_txt_QTYOnHandKeyPressed

    private void btnItemClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemClearActionPerformed
        txtItem_Code.setText("");
        txtItem_Name.setText("");
        txtItem_Price.setText("");
        txt_QTYOnHand.setText("");
    }//GEN-LAST:event_btnItemClearActionPerformed

    private void txtSupplierNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSupplierNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtSupplierAddress.requestFocus();
        }
    }//GEN-LAST:event_txtSupplierNameKeyPressed

    private void txtSupplierAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSupplierAddressKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtSuppllierEmail.requestFocus();
        }
    }//GEN-LAST:event_txtSupplierAddressKeyPressed

    private void txtSuppllierEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSuppllierEmailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtSupplierContact.requestFocus();
        }
    }//GEN-LAST:event_txtSuppllierEmailKeyPressed

    private void txtSupplierContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSupplierContactKeyPressed
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            txtSupplierContact.setEditable(false);
        } else {
            txtSupplierContact.setEditable(true);
        }

    }//GEN-LAST:event_txtSupplierContactKeyPressed

    private void btnSupClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupClearActionPerformed
        txtSupplierId.setText("");
        txtSupplierName.setText("");
        txtSupplierAddress.setText("");
        txtSupplierContact.setText("");
        txtSuppllierEmail.setText("");
    }//GEN-LAST:event_btnSupClearActionPerformed

    private void txtSupplierIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSupplierIdKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtSupplierName.requestFocus();
        }
    }//GEN-LAST:event_txtSupplierIdKeyPressed

    private void txtUser_IDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUser_IDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtUserName.requestFocus();
        }
    }//GEN-LAST:event_txtUser_IDKeyPressed

    private void txtUserNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtUserNIC.requestFocus();
        }
    }//GEN-LAST:event_txtUserNameKeyPressed

    private void txtUserNICKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserNICKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtUserAddress.requestFocus();
        }
    }//GEN-LAST:event_txtUserNICKeyPressed

    private void txtUserAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserAddressKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtUserContact.requestFocus();
        }
    }//GEN-LAST:event_txtUserAddressKeyPressed

    private void txtUserContactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserContactKeyPressed
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtUserContact.setEditable(false);
        } else {
            txtUserContact.setEditable(true);
        }
    }//GEN-LAST:event_txtUserContactKeyPressed

    private void btnUserClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserClearActionPerformed
        txtUser_ID.setText("");
        txtUserName.setText("");
        txtUserAddress.setText("");
        txtUserContact.setText("");
        txtUserNIC.setText("");
    }//GEN-LAST:event_btnUserClearActionPerformed

    private void txtReturnItemNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReturnItemNameKeyReleased
//        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
//        txtQTY2.requestFocus();
//        }
    }//GEN-LAST:event_txtReturnItemNameKeyReleased

    private void txtReturnQTYKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReturnQTYKeyPressed
//       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
//        txtQTY2.requestFocus();
//        }

        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            txtReturnQTY.setEditable(false);
        } else {
            txtReturnQTY.setEditable(true);
        }
    }//GEN-LAST:event_txtReturnQTYKeyPressed

    private void txtReturnItemNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReturnItemNameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReturnItemNameKeyPressed

    private void txReturntItemIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txReturntItemIDKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtReturnQTY.requestFocus();
        }
    }//GEN-LAST:event_txReturntItemIDKeyPressed

    private void txtReturnOrderIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtReturnOrderIDKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txReturntItemID.requestFocus();
        }


    }//GEN-LAST:event_txtReturnOrderIDKeyPressed

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtItemQTY.requestFocus();
        }
    }//GEN-LAST:event_txtIdKeyPressed

    private void txtSupIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSupIDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtId.requestFocus();
        }
    }//GEN-LAST:event_txtSupIDKeyPressed

    private void txtFromYearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFromYearKeyPressed
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            txtFromYear.setEditable(false);
        } else {

            txtFromYear.setEditable(true);
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                txtFromMonth.requestFocus();
            }
        }

    }//GEN-LAST:event_txtFromYearKeyPressed

    private void txtFromMonthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFromMonthKeyPressed
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            txtFromMonth.setEditable(false);
        } else {

            txtFromMonth.setEditable(true);
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                txtFromDate.requestFocus();
            }
        }
    }//GEN-LAST:event_txtFromMonthKeyPressed

    private void txtFromDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFromDateKeyPressed
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            txtFromDate.setEditable(false);
        } else {

            txtFromDate.setEditable(true);
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                txtToYear.requestFocus();
            }
        }
    }//GEN-LAST:event_txtFromDateKeyPressed

    private void txtToYearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtToYearKeyPressed
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            txtToYear.setEditable(false);
        } else {

            txtToYear.setEditable(true);
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                txtToMonth.requestFocus();
            }
        }
    }//GEN-LAST:event_txtToYearKeyPressed

    private void txtToMonthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtToMonthKeyPressed
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            txtToMonth.setEditable(false);
        } else {

            txtToMonth.setEditable(true);
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                txtToDate.requestFocus();
            }
        }
    }//GEN-LAST:event_txtToMonthKeyPressed

    private void txtItem_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItem_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtItem_NameActionPerformed

    private void btnMonthlyIncomeEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonthlyIncomeEnterActionPerformed
        if (txtFromYear.getText().trim().length() > 0 && txtFromMonth.getText().trim().length() > 0 && txtFromDate.getText().trim().length() > 0 && txtToYear.getText().trim().length() > 0 && txtToMonth.getText().trim().length() > 0 && txtToDate.getText().trim().length() > 0) {
            String from = txtFromYear.getText() + "-" + txtFromMonth.getText() + "-" + txtFromDate.getText();
            String to = txtToYear.getText() + "-" + txtToMonth.getText() + "-" + txtToDate.getText();
            DefaultTableModel model = (DefaultTableModel) incomeTable.getModel();

            for (MonthlyIncomeModel detail : new MonthlyIncomeController().getIncomeDetail(from, to)) {
                model.addRow(new Object[]{detail.getOrderID(), detail.getCusID(), detail.getItemID(), detail.getQty(), detail.getUnitPrice(), detail.getDiscount(), detail.getPrice()});
            }
            Double tot = new MonthlyIncomeController().getMonthlyIncome(from, to);

            lblIncome.setText(Double.toString(tot));
        } else {
            JOptionPane.showMessageDialog(rootPane, "INSERT ALL DETAILS");
        }
    }//GEN-LAST:event_btnMonthlyIncomeEnterActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) Table.getModel();

        if (Table.getSelectedRowCount() == 1) {
            model.removeRow(Table.getSelectedRow());
        } else {
            if (Table.getSelectedRowCount() == 0) {
                JOptionPane.showMessageDialog(rootPane, "PLZ SELECT ROW");
            } else {
                JOptionPane.showMessageDialog(rootPane, "INSERT DATA TO TABLE");
            }
        }
        calculateTotal();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSupBillDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupBillDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) SupTable.getModel();

        if (SupTable.getSelectedRowCount() == 1) {
            model.removeRow(SupTable.getSelectedRow());
        } else {
            if (SupTable.getSelectedRowCount() == 0) {
                JOptionPane.showMessageDialog(rootPane, "PLZ SELECT ROW");
            } else {
                JOptionPane.showMessageDialog(rootPane, "PLZ INSERT DATA TO TABLE");
            }
        }
        calculateSupBillTotal();

    }//GEN-LAST:event_btnSupBillDeleteActionPerformed

    private void btnItemReturnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemReturnDeleteActionPerformed
        DefaultTableModel model = (DefaultTableModel) ReturnTable.getModel();

        if (ReturnTable.getSelectedRowCount() == 1) {
            model.removeRow(ReturnTable.getSelectedRow());
        } else {
            if (ReturnTable.getSelectedRow() == 0) {
                JOptionPane.showMessageDialog(rootPane, "PLZ SELECT ROW");
            } else {
                JOptionPane.showMessageDialog(rootPane, "PLZ INSERT DATA TO TABLE");
            }
        }
        calculateReturnTotal();
    }//GEN-LAST:event_btnItemReturnDeleteActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        new Calander().setVisible(true);
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        this.dispose();
        new newLogin().setVisible(true);
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jLabel104MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel104MouseClicked

    }//GEN-LAST:event_jLabel104MouseClicked

    private void txtUserACCRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserACCRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserACCRoleActionPerformed

    private void btnUserAccAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAccAddUserActionPerformed
        if (txtUserACCUserID.getText().trim().length() > 0 && txtUserACCPassword.getText().trim().length() > 0 && txtUserACCConfirmPassword.getText().trim().length() > 0 && txtUserACCRole.getText().trim().length() > 0) {
            if (txtUserACCPassword.getText().equals(txtUserACCConfirmPassword.getText())) {
                String password = txtUserACCConfirmPassword.getText();
                boolean isSave = new UserAccountController().AddUser(new UserAccountModel(txtUserACCUserID.getText(), password, txtUserACCRole.getText()));

                if (isSave) {
                    JOptionPane.showMessageDialog(rootPane, "IS SAVE");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "NOT SAVE");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "PASSWORD AND CONFIRMPASSWORD NOT MATCH");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "INSERT ALL DETAILS");
        }
    }//GEN-LAST:event_btnUserAccAddUserActionPerformed

    private void btnUserAccUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAccUpdateActionPerformed
        if (txtUserACCUserID.getText().trim().length() > 0) {
            String Cpassword = txtUserACCConfirmPassword.getText();
            String password = txtUserACCPassword.getText();
            if (!Cpassword.equals(password)) {
                JOptionPane.showMessageDialog(rootPane, "PASSOWRD NOT MATCHED");
            } else {
                password = txtUserACCConfirmPassword.getText();
                System.out.println(password);
                System.out.println(txtUserACCRole.getText());
                System.out.println(txtUserACCUserID.getText());
                boolean isUpdate = new UserAccountController().UpdateUser(new UserAccountModel(txtUserACCUserID.getText(), password, txtUserACCRole.getText()));

                if (isUpdate) {
                    JOptionPane.showMessageDialog(rootPane, "IS UPDATE");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "NOT UPDATE");
                }
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "INSERT USER ID");
        }
    }//GEN-LAST:event_btnUserAccUpdateActionPerformed

    private void txtUserACCUserIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserACCUserIDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtUserACCPassword.requestFocus();
        }
    }//GEN-LAST:event_txtUserACCUserIDKeyPressed

    private void btnUserAccClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAccClearActionPerformed
        txtUserACCUserID.setText("");
        txtUserACCConfirmPassword.setText("");
        txtUserACCPassword.setText("");
        txtUserACCRole.setText("");
    }//GEN-LAST:event_btnUserAccClearActionPerformed

    private void btnUserAccDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAccDeleteActionPerformed
        if (txtUserACCUserID.getText().trim().length() > 0) {
            String Cpassword = txtUserACCConfirmPassword.getText();

            boolean isDelete = new UserAccountController().deleteUser(txtUserACCUserID.getText());
            if (isDelete) {
                JOptionPane.showMessageDialog(rootPane, "IS DELETE");
            } else {
                JOptionPane.showMessageDialog(rootPane, "NOT DELETE");
            }

        }
    }//GEN-LAST:event_btnUserAccDeleteActionPerformed

    private void UserACCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserACCMouseClicked

        UserAccount.setVisible(true);
        //UserAccount.setVisible(false);
        HomePanel.setVisible(false);
        newItem.setVisible(false);
        CustomerPanel.setVisible(false);
        SupplierPanel.setVisible(false);
        SupBillPanel.setVisible(false);
        newItemReurnPanel.setVisible(false);
        newUserDeatilPanel.setVisible(false);
        MonthlyIncomePanel.setVisible(false);
        ReportPanel.setVisible(false);
        backup.setVisible(false);

    }//GEN-LAST:event_UserACCMouseClicked

    private void txtUserACCUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserACCUserIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserACCUserIDActionPerformed

    private void txtCustomerPaymentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerPaymentKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double payment = Double.parseDouble(txtCustomerPayment.getText());
            cusPay = Double.parseDouble(txtCustomerPayment.getText());
            double LastAmount = Double.parseDouble(txtLastAmount.getText());

            double balance = payment - LastAmount;
            txtBalance.setText(Double.toString(balance));
            cusBalance = balance;
            billLastAmount = LastAmount;

            billLastDiscount = Double.parseDouble(txtLastDiscount.getText());

            System.out.println(billLastDiscount);
        }
    }//GEN-LAST:event_txtCustomerPaymentKeyPressed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        ReportPanel.setVisible(true);
        UserAccount.setVisible(false);
        HomePanel.setVisible(false);
        newItem.setVisible(false);
        CustomerPanel.setVisible(false);
        SupplierPanel.setVisible(false);
        SupBillPanel.setVisible(false);
        newItemReurnPanel.setVisible(false);
        newUserDeatilPanel.setVisible(false);
        MonthlyIncomePanel.setVisible(false);
        backup.setVisible(false);


    }//GEN-LAST:event_jPanel4MouseClicked

    private void txtRportFromYearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRportFromYearKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtRportFromMonth.requestFocus();
        }
    }//GEN-LAST:event_txtRportFromYearKeyPressed

    private void txtRportFromMonthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRportFromMonthKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtRportFromDate.requestFocus();
        }
    }//GEN-LAST:event_txtRportFromMonthKeyPressed

    private void txtRportFromDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRportFromDateKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtRportToYear.requestFocus();
        }
    }//GEN-LAST:event_txtRportFromDateKeyPressed

    private void txtRportToYearKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRportToYearKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtRportToMonth.requestFocus();
        }
    }//GEN-LAST:event_txtRportToYearKeyPressed

    private void txtRportToMonthKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRportToMonthKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtRportToDate.requestFocus();
        }
    }//GEN-LAST:event_txtRportToMonthKeyPressed

    private void btnReportEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportEnterActionPerformed
        String from = txtRportFromYear.getText() + "-" + txtRportFromMonth.getText() + "-" + txtRportFromDate.getText();
        String to = txtRportToYear.getText() + "-" + txtRportToMonth.getText() + "-" + txtRportToDate.getText();

        DefaultTableModel model = (DefaultTableModel) ReportTable.getModel();
        model.setRowCount(0);
        for (ReportModel detail : new OrderController().getReport(from, to)) {
            model.addRow(new Object[]{detail.getItemName(), detail.getItemID(), detail.getQTY()});
        }
    }//GEN-LAST:event_btnReportEnterActionPerformed

    private void txtItemNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItemNameKeyPressed
        String name = txtItemName.getText();
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            new ListTable(this, name).setVisible(true);

        }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtQTY.requestFocus();

        }
        LoadAllCusID();
    }//GEN-LAST:event_txtItemNameKeyPressed

    private void txtItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemNameActionPerformed
        ItemModel model = new ItemController().getItem(txtItemName.getText().toString());
        if (model != null) {
            txtItemCode.setText(model.getCode());
            txtUnitPrice.setText(Double.toString(model.getUnitPrice()));
            txtQTYOnHand.setText(Integer.toString(model.getQTYOnHand()));
        }
    }//GEN-LAST:event_txtItemNameActionPerformed

    private void btnBackupBrowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupBrowsActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        String date = new SimpleDateFormat("YYYY-MM-dd").format(new Date());

        try {
            File file = fc.getSelectedFile();
            path = file.getAbsolutePath();
            path = path.replace('\\', '/');
            path = path + "_" + date + ".sql";

            txtPath.setText(path);
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnBackupBrowsActionPerformed

    private void btnBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupActionPerformed
        Process p = null;

        if (txtPath.getText().trim().length() > 0) {
            try {
                Runtime runtime = Runtime.getRuntime();
                p = runtime.exec("C:/Program Files/MySQL/MySQL Server 8.0/bin/mysqldump.exe -uroot -proot  -B parts -r" + path);

                int processComplete = p.waitFor();

                if (processComplete == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Success");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Success");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "PLZ SELECT PATH");
        }
    }//GEN-LAST:event_btnBackupActionPerformed

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        backup.setVisible(true);
        HomePanel.setVisible(false);
        newItem.setVisible(false);
        CustomerPanel.setVisible(false);
        SupplierPanel.setVisible(false);
        SupBillPanel.setVisible(false);
        newItemReurnPanel.setVisible(false);
        newUserDeatilPanel.setVisible(false);
        MonthlyIncomePanel.setVisible(false);
        UserAccount.setVisible(false);
        ReportPanel.setVisible(false);


    }//GEN-LAST:event_jPanel6MouseClicked

    private void btnReportClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportClearActionPerformed
        DefaultTableModel model = (DefaultTableModel) ReportTable.getModel();
        model.setRowCount(0);
        txtRportFromYear.setText("");
        txtRportFromMonth.setText("");
        txtRportFromDate.setText("");
        txtRportToYear.setText("");
        txtRportToMonth.setText("");
        txtRportToDate.setText("");
    }//GEN-LAST:event_btnReportClearActionPerformed

    private void txtToDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtToDateKeyPressed
        char c = evt.getKeyChar();

        if (Character.isLetter(c)) {
            txtToDate.setEditable(false);
        } else {

            txtToDate.setEditable(true);
        }
    }//GEN-LAST:event_txtToDateKeyPressed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            txtUserACCPassword.setEchoChar((char) 0);
        } else {
            txtUserACCPassword.setEchoChar(('*'));
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if (jCheckBox2.isSelected()) {
            txtUserACCConfirmPassword.setEchoChar((char) 0);
        } else {
            txtUserACCConfirmPassword.setEchoChar(('*'));
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void txtUserACCPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserACCPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtUserACCConfirmPassword.requestFocus();
        }
    }//GEN-LAST:event_txtUserACCPasswordKeyPressed

    private void txtUserACCConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserACCConfirmPasswordActionPerformed

    }//GEN-LAST:event_txtUserACCConfirmPasswordActionPerformed

    private void txtUserACCConfirmPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserACCConfirmPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtUserACCRole.requestFocus();
        }
    }//GEN-LAST:event_txtUserACCConfirmPasswordKeyPressed

    /*
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
            java.util.logging.Logger.getLogger(OrderMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CusIDCombo;
    private javax.swing.JPanel Customer;
    private javax.swing.JPanel CustomerPanel;
    private javax.swing.JTable CustomerTable;
    private javax.swing.JPanel Home;
    public javax.swing.JPanel HomePanel;
    private javax.swing.JPanel Item;
    private javax.swing.JPanel ItemReturn;
    private javax.swing.JTable ItemTable;
    private javax.swing.JPanel MonthlyIcome;
    private javax.swing.JPanel MonthlyIncomePanel;
    private javax.swing.JTable OrderTable;
    private javax.swing.JPanel ReportPanel;
    private javax.swing.JTable ReportTable;
    private javax.swing.JTable ReturnTable;
    private javax.swing.JPanel Side_panel;
    private javax.swing.JPanel SupBillPanel;
    private javax.swing.JTable SupTable;
    private javax.swing.JPanel Supplier;
    private javax.swing.JPanel SupplierBill;
    private javax.swing.JPanel SupplierPanel;
    private javax.swing.JTable SupplierTable;
    private javax.swing.JTable Table;
    private javax.swing.JPanel UserACC;
    private javax.swing.JPanel UserAccount;
    private javax.swing.JPanel UserDetail;
    private javax.swing.JTable UserTable;
    private javax.swing.JPanel backup;
    private javax.swing.JButton btnAddtoCart;
    private javax.swing.JButton btnBackup;
    private javax.swing.JButton btnBackupBrows;
    private javax.swing.JButton btnCusClear;
    private javax.swing.JButton btnCusDelete;
    private javax.swing.JButton btnCusSave;
    private javax.swing.JButton btnCusUpdate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnItemClear;
    private javax.swing.JButton btnItemDelete;
    private javax.swing.JButton btnItemReturnAddToShop;
    private javax.swing.JButton btnItemReturnDelete;
    private javax.swing.JButton btnItemReturnEnter;
    private javax.swing.JButton btnItemReturnRest;
    private javax.swing.JButton btnItemSave;
    private javax.swing.JButton btnItemUpdate;
    private javax.swing.JButton btnMonthlyIncomeClear;
    private javax.swing.JButton btnMonthlyIncomeEnter;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnReportClear;
    private javax.swing.JButton btnReportEnter;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSupBillAdd;
    private javax.swing.JButton btnSupBillDelete;
    private javax.swing.JButton btnSupBillPay;
    private javax.swing.JButton btnSupBillRest;
    private javax.swing.JButton btnSupClear;
    private javax.swing.JButton btnSupDelete;
    private javax.swing.JButton btnSupSave;
    private javax.swing.JButton btnSupUpdate;
    private javax.swing.JButton btnUserAccAddUser;
    private javax.swing.JButton btnUserAccClear;
    private javax.swing.JButton btnUserAccDelete;
    private javax.swing.JButton btnUserAccUpdate;
    private javax.swing.JButton btnUserClear;
    private javax.swing.JButton btnUserDelete;
    private javax.swing.JButton btnUserSave;
    private javax.swing.JButton btnUserUpdate;
    private javax.swing.JTable incomeTable;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblIncome;
    private static javax.swing.JLabel lblItemId1;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel newItem;
    private javax.swing.JPanel newItemReurnPanel;
    private javax.swing.JPanel newUserDeatilPanel;
    private javax.swing.JPanel order;
    private javax.swing.JTextField txReturntItemID;
    private javax.swing.JTextField txtBNo;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtBillDate;
    private javax.swing.JTextField txtBillTime;
    private javax.swing.JTextField txtCustmoerName;
    private javax.swing.JTextField txtCustomerAddress;
    private javax.swing.JTextField txtCustomerContact;
    private javax.swing.JTextField txtCustomerID;
    private javax.swing.JTextField txtCustomerPayment;
    private javax.swing.JTextField txtDiscount;
    private javax.swing.JTextField txtFromDate;
    private javax.swing.JTextField txtFromMonth;
    private javax.swing.JTextField txtFromYear;
    private javax.swing.JTextField txtIRID;
    private static javax.swing.JTextField txtId;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtItemName;
    private static javax.swing.JLabel txtItemName2;
    private javax.swing.JTextField txtItemPrice;
    private javax.swing.JTextField txtItemQTY;
    private javax.swing.JTextField txtItem_Code;
    private javax.swing.JTextField txtItem_Name;
    private javax.swing.JTextField txtItem_Price;
    private javax.swing.JTextField txtLastAmount;
    private javax.swing.JTextField txtLastDiscount;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOrderId;
    private javax.swing.JTextField txtPath;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQTY;
    private javax.swing.JTextField txtQTYOnHand;
    private javax.swing.JTextField txtReturnDate;
    private javax.swing.JTextField txtReturnItemName;
    private javax.swing.JTextField txtReturnOrderID;
    private javax.swing.JTextField txtReturnQTY;
    private javax.swing.JTextField txtReturnTable;
    private javax.swing.JTextField txtReturnTime;
    private javax.swing.JTextField txtRportFromDate;
    private javax.swing.JTextField txtRportFromMonth;
    private javax.swing.JTextField txtRportFromYear;
    private javax.swing.JTextField txtRportToDate;
    private javax.swing.JTextField txtRportToMonth;
    private javax.swing.JTextField txtRportToYear;
    private javax.swing.JTextField txtSupBillDate;
    private javax.swing.JTextField txtSupBillNo;
    private javax.swing.JTextField txtSupBillTime;
    private javax.swing.JTextField txtSupID;
    private javax.swing.JTextField txtSupName;
    private javax.swing.JTextField txtSupTotal;
    private javax.swing.JTextField txtSupplierAddress;
    private javax.swing.JTextField txtSupplierContact;
    private javax.swing.JTextField txtSupplierId;
    private javax.swing.JTextField txtSupplierName;
    private javax.swing.JTextField txtSupplierUser;
    private javax.swing.JTextField txtSuppllierEmail;
    private javax.swing.JTextField txtToDate;
    private javax.swing.JTextField txtToMonth;
    private javax.swing.JTextField txtToYear;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUnitPrice;
    private javax.swing.JPasswordField txtUserACCConfirmPassword;
    private javax.swing.JPasswordField txtUserACCPassword;
    private javax.swing.JTextField txtUserACCRole;
    private javax.swing.JTextField txtUserACCUserID;
    private javax.swing.JTextField txtUserAddress;
    private javax.swing.JTextField txtUserContact;
    private javax.swing.JTextField txtUserID;
    private javax.swing.JTextField txtUserNIC;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtUser_ID;
    private javax.swing.JTextField txt_QTYOnHand;
    // End of variables declaration//GEN-END:variables

    private int isAlreadyExists(String id) {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            String temp = model.getValueAt(i, 0).toString();
            if (temp.equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    private void calculateTotal() {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        double temp = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            temp += (double) model.getValueAt(i, 5);

        }

        totalAmount = temp;
        txtTotal.setText(Double.toString(temp) + "/=");
    }

    private void getAllItemName() {
        for (String name : new ItemController().getAllItems()) {
            item.add(name);
        }
    }

    private void LoadDateAndTime() {
//        Date d1 = new Date();
//        SimpleDateFormat format1 = new SimpleDateFormat("YYYY-MM-dd");
//        txtBillDate.setText(format1.format(d1));
//        
//        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
//        txtBillTime.setText(format2.format(d1));
    }

    private void LoadOrderID() {
        String OrderId = new OrderController().getOrderID();
        //System.out.println(OrderId);
        if (OrderId != null) {
            String[] temparr = OrderId.split("O");
            int tempNumber = Integer.parseInt(temparr[1]);
            tempNumber += 1;

            if (tempNumber < 10) {
                txtOrderId.setText("O00" + tempNumber);
            } else if (tempNumber < 100) {
                txtOrderId.setText("O0" + tempNumber);
            } else {
                txtOrderId.setText("O" + tempNumber);
            }

        } else {
            txtOrderId.setText("O001");
        }
    }

    private void setBillNo() {
        String BillNo = new OrderController().getOrderID();
        if (BillNo != null) {
            String[] temp = BillNo.split("O");
            int tempNo = Integer.parseInt(temp[1]);
            tempNo += 1;

            if (tempNo < 10) {
                txtBNo.setText("B00" + tempNo);
            } else if (tempNo < 100) {
                txtBNo.setText("B0" + tempNo);
            } else {
                txtBNo.setText("B" + tempNo);
            }

        } else {
            txtBNo.setText("B001");
        }
    }

    private void getAllItem() {

    }

    private void LoadLogin() {
        //txtUserID.setText(Login.LoginUser.toString());
    }

    private void LoadAllCusID() {
        for (String temp : new OrderController().getAllCusID()) {
            CusIDCombo.addItem(temp);
        }
    }

    private void LoadAllItem() {
        DefaultTableModel model = (DefaultTableModel) ItemTable.getModel();
        model.setRowCount(0);
        for (ItemModel item : new ItemDetail().getAllItem()) {
            model.addRow(new Object[]{
                item.getCode(),
                item.getName(),
                item.getUnitPrice(),
                item.getQTYOnHand()
            });
        }
    }

    private void LoadAllCustomer() {

        DefaultTableModel model = (DefaultTableModel) CustomerTable.getModel();
        model.setRowCount(0);

        for (CustomerModel cus : new CustomerController().getAllCustomer()) {
            model.addRow(new Object[]{cus.getCusID(), cus.getCusName(), cus.getCusAddress(), cus.getCusContact()});
        }
    }

    private void LoadAllSupplier() {
        DefaultTableModel model = (DefaultTableModel) SupplierTable.getModel();
        model.setRowCount(0);
        for (supplier sup : new SupplierController().getAllSupplier()) {
            model.addRow(new Object[]{sup.getSupplierName(), sup.getSupplierID(), sup.getAddress(), sup.getEmail(), sup.getContact()});
        }
    }

    private int isAlreadyExitsSupplier(String text) {
        DefaultTableModel model = (DefaultTableModel) SupTable.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            String temp = model.getValueAt(i, 2).toString();
            if (temp.equalsIgnoreCase(text)) {
                return i;
            }
        }
        return -1;
    }

    void setSupValue(String supID) {
        txtSupID.setText(supID);
    }

    void setSupName(String supName) {
        txtSupName.setText(supName);
    }

    void SetValue(String itemId) {
        txtId.setText(itemId);
    }

    void SetItemName(String itemName) {
        txtName.setText(itemName);
    }

    private void LoadDateTime() {
        Date date = new Date();

        SimpleDateFormat format1 = new SimpleDateFormat("YYYY-MM-dd");
        txtReturnDate.setText(format1.format(date));

        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
        txtReturnTime.setText(format2.format(date));
    }

    private void LoadIRID() {
        String id = new ItemReturnController().getIRID();
        if (id != null) {
            String[] temp = id.split("R");
            int tempNo = Integer.parseInt(temp[1]);
            tempNo += 1;

            if (tempNo < 10) {
                txtIRID.setText("IR00" + tempNo);
            } else if (tempNo < 100) {
                txtIRID.setText("IR0" + tempNo);
            } else {
                txtIRID.setText("IR" + tempNo);
            }

        } else {
            txtIRID.setText("IR001");
        }
    }

    private int isAlreadyExitsReturn(String text) {
        DefaultTableModel model = (DefaultTableModel) ReturnTable.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            String temp = ReturnTable.getValueAt(i, 2).toString();

            if (temp.equalsIgnoreCase(text)) {
                return i;
            }
        }
        return -1;
    }

    private void LoadUser() {
        DefaultTableModel model = (DefaultTableModel) UserTable.getModel();
        model.setRowCount(0);

        for (UserDetailModel User : new UserDetailController().getUserDetail()) {
            model.addRow(new Object[]{User.getUserID(), User.getName(), User.getNIC(), User.getAddress(), User.getContact()});
        }
    }

    private void LoardLogin() {
        // txtSupplierUser.setText(Login.LoginUser.toString());
    }

    private void getBillID() {
        String BillNo = new SupBillController().getSupBill();

        if (BillNo != null) {
            String[] temp = BillNo.split("P");
            int temNo = Integer.parseInt(temp[1]);
            temNo++;
            if (temNo < 10) {
                txtSupBillNo.setText("SP00" + temNo);
            } else if (temNo < 100) {
                txtSupBillNo.setText("SP0" + temNo);
            } else {
                txtSupBillNo.setText("SP" + temNo);
            }
        } else {
            txtSupBillNo.setText("SP001");
        }
    }

    private void LoadDateTimeSup() {
//        Date date = new Date();
//
//        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
//        txtSupDate.setText(format.format(date));
//
//        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
//        txtSupBillTime.setText(format1.format(date));
    }

    private void LoadMainDateAndTime() {
        Date date = new Date();

        SimpleDateFormat format1 = new SimpleDateFormat("YYYY-MM-dd");
        lblDate.setText(format1.format(date));

        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
        lblTime.setText(format2.format(date));
    }

    private void LoadLoginUser() {
        txtUserID.setText(newLogin.LoginUser.toString());
        txtSupplierUser.setText(newLogin.LoginUser.toString());
    }

    void ItemName(String itemName) {
        txtItemName.setText(itemName);
    }

    private void calculateSupBillTotal() {
        DefaultTableModel model = (DefaultTableModel) SupTable.getModel();
        double temp = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            temp += (double) model.getValueAt(i, 6);

        }

        txtSupTotal.setText(Double.toString(temp) + "/=");
    }

    private void calculateReturnTotal() {
        DefaultTableModel model = (DefaultTableModel) ReturnTable.getModel();
        double temp = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            temp += (double) model.getValueAt(i, 5);
        }
        txtReturnTable.setText(temp + " /=");
    }

    private void getBill() {

        try {
            BasicConfigurator.configure();
            Connection connection = DBConnection.getInstance().getConnection();
            System.out.println("Connection hri");
//            String[] temp = txtOrderId.getText().split("O");
//            int tempNo = Integer.parseInt(temp[1]);
//            String OrderID = null;
//            tempNo = tempNo - 1;
//            if (tempNo < 10) {
//                OrderID = "O00" + tempNo;
//            } else if (tempNo < 100) {
//                OrderID = "O0" + tempNo;
//            } else {
//                OrderID = "O" + tempNo;
//            }
            InputStream stream = new FileInputStream("E:/oop/MyProject/src/lk/ijse/MyProject/view/newReport.jrxml");
            JasperReport ja = JasperCompileManager.compileReport(stream);

            System.out.println("path eka hri");
            Map<String, Object> map = new HashMap<>();

            map.put("OrderID", txtOrderId.getText());
            System.out.println(txtOrderId.getText());

            JasperPrint jp = JasperFillManager.fillReport(ja, map, connection);
            System.out.println("****************************");
            JasperViewer.viewReport(jp, false);

        } catch (NullPointerException | JRException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getSupBill() {
        try {
            BasicConfigurator.configure();
            Connection connection = DBConnection.getInstance().getConnection();
            System.out.println("Connection hri");
            InputStream stream = new FileInputStream("E:/oop/MyProject/src/lk/ijse/MyProject/view/SupplierBill.jrxml");
            JasperReport ja = JasperCompileManager.compileReport(stream);

            System.out.println("path eka hri");
            Map<String, Object> map = new HashMap<>();

            map.put("SPID", txtSupBillNo.getText());
            System.out.println(txtOrderId.getText());

            JasperPrint jp = JasperFillManager.fillReport(ja, map, connection);
            System.out.println("****************************");
            JasperViewer.viewReport(jp, false);

        } catch (NullPointerException | JRException e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
