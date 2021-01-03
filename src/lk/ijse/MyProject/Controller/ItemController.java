/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.MyProject.Controller;

import static java.lang.reflect.Array.set;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lk.ijse.MyProject.Model.ItemModel;
import lk.ijse.MyProject.db.DBConnection;

/**
 *
 * @author Nipun Lakshitha
 */
public class ItemController {

    public ItemModel getItem(String name) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM Item WHERE ItemName=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, name);

            ResultSet set = pstm.executeQuery();

            if (set.next()) {
                return new ItemModel(set.getString("ItemID"), set.getString("ItemName"), set.getDouble("UnitPrice"), set.getInt("QTYOnHand"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    public Set<String> getAllItems() {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT ItemName FROM Item";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet set = pstm.executeQuery();
            Set<String> list = new TreeSet<>();
            while (set.next()) {
                list.add(set.getString("ItemName"));
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;

    }

    

    public boolean UpdateStoke(ItemModel item) {

        boolean update = false;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "UPDATE Item SET QTYOnHand=QTYOnHand-? WHERE ItemID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, item.getQTYOnHand());
            pstm.setString(2, item.getCode());
            update = pstm.executeUpdate() > 0;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }

    public void UpdateStoke(ArrayList<ItemModel> list2) {
        for (ItemModel item : list2) {
            UpdateStoke(item);
        }
    }

    public int getItemQTY(String id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT QTYOnHand FROM Item WHERE ItemID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, id);
            ResultSet set = pstm.executeQuery();

            if (set.next()) {
                return set.getInt("QTYOnHand");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }

    public List<ItemModel> getItemName(String name) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM Item WHERE ItemName LIKE '%" + name + "%'";
            PreparedStatement pstm = connection.prepareStatement(sql);
            List<ItemModel> list = new ArrayList<>();
//            pstm.setString(1, name);
            ResultSet set = pstm.executeQuery();
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
