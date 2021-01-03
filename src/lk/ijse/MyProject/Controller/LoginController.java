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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lk.ijse.MyProject.db.DBConnection;

/**
 *
 * @author Nipun Lakshitha
 */
public class LoginController {

    public String LoginUser(String userName, String password) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT Role FROM User WHERE UserID=? and Password=md5(?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, userName);
            pstm.setString(2, password);
            ResultSet set = pstm.executeQuery();
            if (set.next()) {
                return set.getString("Role");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return null;
    }

}
