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

import lk.ijse.MyProject.Model.ItemModel;
import lk.ijse.MyProject.db.DBConnection;

/**
 *
 * @author Nipun Lakshitha
 */
public class ItemDetail {

    public boolean AddItem(ItemModel detail) {

        boolean result = false;

        PreparedStatement pstm;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO Item VALUES(?,?,?,?)";
            pstm = connection.prepareStatement(sql);
            pstm.setObject(1, detail.getCode());
            pstm.setObject(2, detail.getName());
            pstm.setObject(3, detail.getUnitPrice());
            pstm.setObject(4, detail.getQTYOnHand());

            result = pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());

        }
//ex.loclaise
        return result;

    }

    public boolean UpdateItem(ItemModel update) {

        boolean result = false;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "UPDATE Item SET ItemName=?,UnitPrice=?,QTYOnHand=? WHERE ItemID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1, update.getName());
            pstm.setObject(2, update.getUnitPrice());
            pstm.setObject(3, update.getQTYOnHand());
            pstm.setObject(4, update.getCode());
            result = pstm.executeUpdate() > 0;

            return result;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return result;
    }

    public boolean DeleteItem(String id) {

        boolean result = false;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "DELETE FROM Item WHERE ItemID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1, id);
            result = pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return result;
    }

    public List<ItemModel> SearchItem(String name) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM Item WHERE ItemName LIKE '%" + name + "%'";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet set = pstm.executeQuery();

            List<ItemModel> list = new ArrayList<ItemModel>();

            while (set.next()) {
                // list.add(new ItemModel(set.getString("ItemID"), set.getString("ItemName"), set.getDouble("UnitPrice"), set.getInt("QTYOnHand")));
                list.add(new ItemModel(set.getString("ItemID"), set.getString("ItemName"), set.getDouble("UnitPrice"), set.getInt("QTYOnHand")));
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;

    }

    public List<ItemModel> getAllItem() {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM Item";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet set = pstm.executeQuery();

            List<ItemModel> list = new ArrayList<>();

            while (set.next()) {
                list.add(new ItemModel(set.getString("ItemID"), set.getString("ItemName"), set.getDouble("UnitPrice"), set.getInt("QTYOnHand")));
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;

    }

}
