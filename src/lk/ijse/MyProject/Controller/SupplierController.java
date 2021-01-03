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
import lk.ijse.MyProject.Model.supplier;
import lk.ijse.MyProject.db.DBConnection;

/**
 *
 * @author Nipun Lakshitha
 */
public class SupplierController {

    public boolean AddItem(supplier detail) {

        boolean result = false;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO supplier VALUES(?,?,?,?,?);";
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1, detail.getSupplierID());
            pstm.setString(2, detail.getSupplierName());
            pstm.setInt(3, detail.getContact());
            pstm.setString(4, detail.getAddress());
            pstm.setString(5, detail.getEmail());
            result = pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return result;
    }

    public boolean UpdateItem(supplier supplier) {

        boolean result = false;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "UPDATE supplier SET SupplierName=?,Contact=?,Address=?,Email=? WHERE SupplierID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, supplier.getSupplierName());
            pstm.setInt(2, supplier.getContact());
            pstm.setString(3, supplier.getAddress());
            pstm.setString(4, supplier.getEmail());
            pstm.setString(5, supplier.getSupplierID());
            result = pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return result;
    }

    public boolean DeleteSupplier(String id) {

        boolean name = false;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "DELETE FROM supplier WHERE SupplierID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, id);
            name = pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return name;
    }

    public List<supplier> getAllSupplier() {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM Supplier";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet set = pstm.executeQuery();

            List<supplier> list = new ArrayList<>();

            while (set.next()) {
                list.add(new supplier(set.getString("SupplierName"), set.getString("SupplierID"), set.getInt("Contact"), set.getString("Address"), set.getString("Email")));
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    public List<supplier> SerachSupplier(String name) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM Supplier WHERE SupplierName LIKE '%" + name + "%'";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet set = pstm.executeQuery();

            List<supplier> list = new ArrayList<>();
            while (set.next()) {
                list.add(
                        new supplier(set.getString("SupplierName"), set.getString("SupplierID"), set.getInt("Contact"), set.getString("Address"), set.getString("Email")));

            }
            return list;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

}
