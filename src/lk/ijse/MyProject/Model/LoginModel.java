/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.MyProject.Model;

/**
 *
 * @author Nipun Lakshitha
 */
public class LoginModel {
    private String UserID;
    private String Password;
    private String Role;

    public LoginModel(String UserID, String Password, String Role) {
        this.UserID = UserID;
        this.Password = Password;
        this.Role = Role;
    }

    public LoginModel() {
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    @Override
    public String toString() {
        return "LoginModel{" + "UserID=" + UserID + ", Password=" + Password + ", Role=" + Role + '}';
    }
    
}
