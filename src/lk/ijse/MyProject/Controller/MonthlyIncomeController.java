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
import lk.ijse.MyProject.Model.MonthlyIncomeModel;
import lk.ijse.MyProject.db.DBConnection;

/**
 *
 * @author Nipun Lakshitha
 */
public class MonthlyIncomeController {

    public List<MonthlyIncomeModel> getIncomeDetail(String date, String month) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "select c.OrderID,CusID,ItemID,QTY,UnitPrice,Discount,Price from Orderdetail o,CustomerOrder c where o.OrderID=c.OrderID AND c.OrderDate  BETWEEN ? AND ? ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, date);
            pstm.setString(2, month);
            ResultSet set = pstm.executeQuery();
            List<MonthlyIncomeModel> list = new ArrayList<>();

            while (set.next()) {
                list.add(new MonthlyIncomeModel(set.getString("OrderID"), set.getString("CusID"), set.getString("ItemID"), set.getDouble("QTY"), set.getDouble("UnitPrice"), set.getDouble("Discount"), set.getDouble("Price")));

            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }

    public double getMonthlyIncome(String from, String to) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT MONTHNAME(now()),SUM(o.Price-(s.UnitPrice*o.QTY)) as Incoume FROM orderdetail o,supplierpayment s,Item i,CustomerOrder c WHERE o.ItemID=i.ItemID AND i.ItemID=s.ItemID  AND c.OrderID=o.OrderID AND c.OrderDate  BETWEEN ? AND ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, from);
            pstm.setString(2, to);
            ResultSet set = pstm.executeQuery();

            if (set.next()) {
                return set.getDouble("Incoume");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }

}
