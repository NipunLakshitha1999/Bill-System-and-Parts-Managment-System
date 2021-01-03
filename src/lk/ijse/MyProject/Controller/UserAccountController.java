/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.MyProject.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lk.ijse.MyProject.Model.UserAccountModel;
import lk.ijse.MyProject.db.DBConnection;

/**
 *
 * @author Nipun Lakshitha
 */
public class UserAccountController {

    public boolean AddUser(UserAccountModel userAccountModel) {
        boolean result = false;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO User VALUES(?,md5(?),?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, userAccountModel.getUserID());
            pstm.setString(2, userAccountModel.getPassowrd());
            pstm.setString(3, userAccountModel.getRole());
            result = pstm.executeUpdate() > 0;

            return result;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return result;
    }

    public boolean UpdateUser(UserAccountModel userAccountModel) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "UPDATE User SET Password=md5(?),Role=? WHERE UserID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, userAccountModel.getPassowrd());
            pstm.setString(2, userAccountModel.getRole());
            pstm.setString(3, userAccountModel.getUserID());

            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }

    public boolean deleteUser(String text) {
        boolean result=false;
        try {
            Connection connection=DBConnection.getInstance().getConnection();
            String sql="DELETE FROM User WHERE UserID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, text);
           
            result=pstm.executeUpdate()>0;
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
        
    }

}
