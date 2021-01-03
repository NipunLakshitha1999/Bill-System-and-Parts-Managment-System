/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.MyProject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nipun Lakshitha
 */
public class DBConnection {
    private static DBConnection dbconnection;
    private Connection connection;
    
    private DBConnection(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost/parts";
            String UserName="root";
            String Password="root";
            
            connection = DriverManager.getConnection(url,UserName,Password);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DBConnection getInstance(){
    return(null==dbconnection)?(dbconnection=new DBConnection()):(dbconnection);
    }
    public Connection getConnection(){
    return connection;
    }
    
}
