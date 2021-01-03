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
import lk.ijse.MyProject.Model.UserDetailModel;
import lk.ijse.MyProject.db.DBConnection;

/**
 *
 * @author Nipun Lakshitha
 */
public class UserDetailController {

    public List<UserDetailModel> getUserDetail() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM UserDetail";
            PreparedStatement pstm = connection.prepareStatement(sql);

            List<UserDetailModel> list = new ArrayList<>();

            ResultSet set = pstm.executeQuery();

            while (set.next()) {
                list.add(new UserDetailModel(set.getString("Name"), set.getString("NIC"), set.getString("Address"), set.getInt("Contact"), set.getString("UserID")));
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;

    }

    public boolean SaveUser(UserDetailModel userDetailModel) {
        boolean result = false;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO UserDetail VALUES(?,?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, userDetailModel.getName());
            pstm.setString(2, userDetailModel.getNIC());
            pstm.setString(3, userDetailModel.getAddress());
            pstm.setInt(4, userDetailModel.getContact());
            pstm.setString(5, userDetailModel.getUserID());

            result = pstm.executeUpdate() > 0;
            return result;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return result;
    }

    public boolean UpdateUser(UserDetailModel userDetailModel) {
        boolean result = false;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "UPDATE UserDetail SET Name=?,NIC=?,Address=?,Contact=? WHERE UserID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, userDetailModel.getName());
            pstm.setString(2, userDetailModel.getNIC());
            pstm.setString(3, userDetailModel.getAddress());
            pstm.setInt(4, userDetailModel.getContact());
            pstm.setString(5, userDetailModel.getUserID());

            result = pstm.executeUpdate() > 0;

            return result;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return result;
    }

    public boolean DeleteUser(String id) {
        boolean result = false;
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "DELETE FROM UserDetail WHERE UserID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, id);

            result = pstm.executeUpdate() > 0;

            return result;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return result;
    }

    public List<UserDetailModel> SerchUser(String id) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "SELECT * FROM UserDetail WHERE UserID=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, id);
            ResultSet set = pstm.executeQuery();
            List<UserDetailModel> list = new ArrayList<>();

            while (set.next()) {
                list.add(new UserDetailModel(set.getString("Name"), set.getString("NIC"), set.getString("Address"), set.getInt("Contact"), set.getString("UserID")));
            }
            return list;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
}
