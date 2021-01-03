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
public class ItemSearchController {
    
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
