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
import lk.ijse.MyProject.Model.ItemReturnModel;
import lk.ijse.MyProject.Model.OrderDetailModel;
import lk.ijse.MyProject.db.DBConnection;

/**
 *
 * @author Nipun Lakshitha
 */
public class ItemReturnController {

    public List<OrderDetailModel> getAllDdetails(String id) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM Orderdetail WHERE OrderID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, id);
            List<OrderDetailModel> list = new ArrayList<>();
            ResultSet set = pstm.executeQuery();
            while (set.next()) {
                list.add(new OrderDetailModel(set.getString("OrderID"), set.getString("ItemID"),set.getString("ItemName"), set.getDouble("QTY"), set.getDouble("UnitPrice"), set.getDouble("Discount"), set.getDouble("Price")));

            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;

    }

    public String getItemName(String id) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT ItemName FROM Item WHERE ItemID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, id);
            ResultSet set = pstm.executeQuery();
            String name = null;
            if (set.next()) {
                name = set.getString("ItemName");
            }
            return name;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    public double getItemUnitPrice(String id) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT UnitPrice FROM Item WHERE ItemID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, id);
            ResultSet set = pstm.executeQuery();

            if (set.next()) {
                return set.getDouble("UnitPrice");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }

    public String getIRID() {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT IRID FROM ItemReturn ORDER BY  IRID DESC LIMIT 1 ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet set = pstm.executeQuery();
            if (set.next()) {
                return set.getString("IRID");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    public boolean isAdded(List<ItemReturnModel> model) {
        Connection connection = null;
        boolean set = false;
        try {
            connection = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO itemreturn VALUES (?,?,?,?,?,?)";
            connection.setAutoCommit(false);
            PreparedStatement pstm = connection.prepareStatement(sql);

            for (ItemReturnModel detail : model) {
                pstm.setString(1, detail.getIRID());
                pstm.setString(2, detail.getOrderID());
                pstm.setString(3, detail.getItemID());
                pstm.setString(4, detail.getItemName());
                pstm.setDouble(5, detail.getQTY());
                pstm.setDouble(6, detail.getPrice());
            }
            set = pstm.executeUpdate() > 0;
            if (set) {
                connection.commit();
                boolean isUpdate = false;
                for (ItemReturnModel detail : model) {
                    isUpdate = isUpdate(detail.getItemID(), detail.getQTY());
                }
                if (isUpdate) {
                    connection.commit();
                    boolean UpdateOrder = false;
                    for (ItemReturnModel order : model) {
                        UpdateOrder = UpdateOrder(order.getOrderID(), order.getItemID(), order.getQTY());
                    }
                    if (!UpdateOrder) {
                        connection.rollback();
                        return false;
                    }
                } else {
                    connection.rollback();
                    return false;
                }
            } else {
                connection.rollback();
                return false;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }

        return set;
    }

    public boolean isUpdate(String Itemcode, double qty) {

        boolean set = false;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "UPDATE Item SET QTYOnHand=QTYOnHand+? WHERE ItemID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setDouble(1, qty);
            pstm.setString(2, Itemcode);

            set = pstm.executeUpdate() > 0;
            return set;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return set;
    }

    public boolean UpdateOrder(String OrderID, String ItemID, double qty) {

        boolean result = false;

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "UPDATE Orderdetail SET QTY=QTY-? WHERE OrderID=? AND ItemID=? ";

            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setDouble(1, qty);
            pstm.setString(2, OrderID);
            pstm.setString(3, ItemID);

            result = pstm.executeUpdate() > 0;
            return result;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return result;
    }

    public double getUnitPrice(String OrderID, String ItemId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT UnitPrice FROM Orderdetail WHERE OrderID=? AND ItemID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, OrderID);
            pstm.setString(2, ItemId);
            List<Object> list = new ArrayList<>();

            ResultSet set = pstm.executeQuery();
            if (set.next()) {
                return set.getDouble("UnitPrice");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }

    public void UpdateItemQTY(String OrderID, String ItemId, double price) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "UPDATE Orderdetail SET Price=Price-? WHERE OrderID=? AND ItemID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setDouble(1, price);
            pstm.setString(2, OrderID);
            pstm.setString(3, ItemId);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

}
