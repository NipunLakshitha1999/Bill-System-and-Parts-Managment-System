/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.MyProject.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lk.ijse.MyProject.Model.CustomerPaymentModel;
import lk.ijse.MyProject.db.DBConnection;

/**
 *
 * @author Nipun Lakshitha
 */
public class CustomerPaymentController {

    public void addCustomerPayment(CustomerPaymentModel customerPaymentModel) {
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            String sql="INSERT INTO CustomerPayment VALUES(?,?,?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1,customerPaymentModel.getOrderID());
            pstm.setDouble(2, customerPaymentModel.getTotal());
            pstm.setDouble(3, customerPaymentModel.getLastDiscount());
            pstm.setDouble(4, customerPaymentModel.getLastAmount());
            pstm.setDouble(5, customerPaymentModel.getCustomerPay());
            pstm.setDouble(6, customerPaymentModel.getCustomerBalance());
            
            pstm.executeUpdate();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex);
        }
    }
    
}
