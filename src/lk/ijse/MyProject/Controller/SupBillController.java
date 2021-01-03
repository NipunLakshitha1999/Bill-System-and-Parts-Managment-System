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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lk.ijse.MyProject.Model.SupBillModel;
import lk.ijse.MyProject.db.DBConnection;

/**
 *
 * @author Nipun Lakshitha
 */
public class SupBillController {

    public String getSupBill() {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT SPID FROM Supplierpayment ORDER BY SPID DESC LIMIT 1";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet set = pstm.executeQuery();

            if (set.next()) {
                return set.getString("SPID");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;

    }

    public boolean AddToDB(List<SupBillModel> detail) {
        Connection connection = null;
        boolean set = false;
        try {
            connection = DBConnection.getInstance().getConnection();

            String sql = "INSERT INTO supplierpayment VALUES(?,?,?,?,?,?,?)";
            connection.setAutoCommit(false);

            PreparedStatement pstm = connection.prepareStatement(sql);

            for (SupBillModel datail : detail) {
                pstm.setString(1, datail.getSPID());
                pstm.setString(2, datail.getSupplierID());
                pstm.setString(3, datail.getSupBillDate());
                pstm.setString(4, datail.getItemID());
                pstm.setDouble(5, datail.getSupplyQTY());
                pstm.setDouble(6, datail.getUnitPrice());
                pstm.setDouble(7, datail.getPayment());
                set = pstm.executeUpdate() > 0;
            }

            return set;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        return false;

    }

}
