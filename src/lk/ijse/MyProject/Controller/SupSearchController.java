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
public class SupSearchController {
    
    public List<supplier> getAllSupDetail() {
        
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM Supplier";
            PreparedStatement pstm = connection.prepareStatement(sql);
            List<supplier> list = new ArrayList<>();
            ResultSet set = pstm.executeQuery();
            while (set.next()) {
                list.add(new supplier(set.getString("supplierName"), set.getString("supplierID"), set.getInt("contact"), set.getString("address"), set.getString("email")));
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
        
    }
    
}
