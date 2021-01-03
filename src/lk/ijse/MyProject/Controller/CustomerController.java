/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.MyProject.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lk.ijse.MyProject.Model.CustomerModel;
import lk.ijse.MyProject.Model.CustomerPaymentModel;
import lk.ijse.MyProject.db.DBConnection;

/**
 *
 * @author Nipun Lakshitha
 */
public class CustomerController {

    public boolean AddCustomer(CustomerModel cutomer) {
        boolean isAdd = false;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO customer VALUES(?,?,?,?)";

            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, cutomer.getCusID());
            pstm.setString(2, cutomer.getCusName());
            pstm.setString(3, cutomer.getCusAddress());
            pstm.setInt(4, cutomer.getCusContact());

            isAdd = pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return isAdd;
    }

    public boolean UpdateCustomer(CustomerModel customer) {

        boolean name = false;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "UPDATE Customer SET CusName=?,Address=?,Contact=? WHERE CusID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, customer.getCusName());
            pstm.setString(2, customer.getCusAddress());
            pstm.setInt(3, customer.getCusContact());
            pstm.setString(4, customer.getCusID());

            name = pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return name;
    }

    public boolean CustomerDelete(String code) {

        boolean name = false;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "DELETE FROM Customer WHERE CusID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, code);

            name = pstm.executeUpdate() > 0;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return name;

    }

    public List<CustomerModel> getAllCustomer() {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM Customer";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet set = pstm.executeQuery();
            List<CustomerModel> list = new ArrayList<>();
            while (set.next()) {
                list.add(new CustomerModel(set.getString(1), set.getString(2), set.getString(3), set.getInt(4)));
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return null;
    }

    public List<CustomerModel> SearchCustomer(String id) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM Customer WHERE CusID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, id);
            ResultSet set = pstm.executeQuery();
            List<CustomerModel> list = new ArrayList<>();

            while (set.next()) {
                list.add(new CustomerModel(set.getString("CusID"), set.getString("CusName"), set.getString("Address"), set.getInt("Contact")));
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

   

}
