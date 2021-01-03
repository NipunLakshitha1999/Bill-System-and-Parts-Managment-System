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
import lk.ijse.MyProject.Model.OrderDetailModel;
import lk.ijse.MyProject.Model.OrderModel;
import lk.ijse.MyProject.Model.ReportModel;
import lk.ijse.MyProject.db.DBConnection;

/**
 *
 * @author Nipun Lakshitha
 */
public class OrderController {

    public String getOrderID() {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT OrderID FROM CustomerOrder ORDER BY OrderID DESC LIMIT 1";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet set = pstm.executeQuery();

            if (set.next()) {
                return set.getString("OrderID");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;

    }

    public List<String> getAllCusID() {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT CusID FROM Customer";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet set = pstm.executeQuery();
            List<String> list = new ArrayList<>();

            while (set.next()) {
                list.add(set.getString(1));
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;

    }

    public boolean SaveCustomer(OrderModel name) throws SQLException {
        Connection connection = null;

        boolean result;
        try {
            connection = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO CustomerOrder values(?,?,?,?)";
            connection.setAutoCommit(false);
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, name.getOrderID());
            pstm.setString(2, name.getOrderDate());
            pstm.setString(3, name.getCusID());
            pstm.setString(4, name.getUserID());

            result = pstm.executeUpdate() > 0;
            if (result) {
                boolean set = setOrderDetail(name.getList());
                if (set) {
                    connection.commit();
                    return true;
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
            connection.setAutoCommit(true);
        }
        return false;

    }

    public boolean setOrderDetail(ArrayList<OrderDetailModel> detail) {
        for (OrderDetailModel model : detail) {
            boolean InsertOrderDetail = InsertOrderDetail(model);
            if (!InsertOrderDetail) {
                return false;
            }
        }
        return true;
    }

    private boolean InsertOrderDetail(OrderDetailModel model) {

        boolean result = false;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO Orderdetail VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, model.getOrderID());
            pstm.setString(2, model.getItemID());
            pstm.setString(3, model.getItemName());
            pstm.setDouble(4, model.getQTY());
            pstm.setDouble(5, model.getUnitPrice());
            pstm.setDouble(6, model.getDiscount());
            pstm.setDouble(7, model.getPrice());

            result = pstm.executeUpdate() > 0;
            if (result) {
                boolean updateStock = updateStock(model.getItemID(), model.getQTY());
                if (!updateStock) {
                    result = false;
                }
            }
            return result;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return result;
    }

    private boolean updateStock(String itemCode, double Qty) {

        boolean set = false;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "UPDATE Item SET QTYOnHand=QTYOnHand-? WHERE ItemID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setDouble(1, Qty);
            pstm.setString(2, itemCode);

            set = pstm.executeUpdate() > 0;

            return set;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return set;
    }

   

    public Iterable<ReportModel> getReport(String from, String to) {
      try {
            Connection connection=DBConnection.getInstance().getConnection();
            String sql="select Item.ItemName,Orderdetail.ItemID,SUM(Orderdetail.QTY) FROM Item,Orderdetail,CustomerOrder WHERE Item.ItemID=Orderdetail.ItemID AND CustomerOrder.OrderID=Orderdetail.OrderID AND CustomerOrder.OrderDate BETWEEN ? AND ? GROUP BY Orderdetail.ItemID  ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, from);
            pstm.setString(2, to);
            ResultSet set = pstm.executeQuery();
            List<ReportModel> list=new ArrayList<>();
            
            while(set.next()){
            list.add(new ReportModel(set.getString("ItemName"),set.getString("ItemID"),set.getDouble("SUM(Orderdetail.QTY)")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
