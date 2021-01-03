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
public class UserAccountModel {
    private String UserID;
    private String Passowrd;
    private String Role;

    public UserAccountModel() {
    }

    public UserAccountModel(String UserID, String Passowrd, String Role) {
        this.UserID = UserID;
        this.Passowrd = Passowrd;
        this.Role = Role;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getPassowrd() {
        return Passowrd;
    }

    public void setPassowrd(String Passowrd) {
        this.Passowrd = Passowrd;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    @Override
    public String toString() {
        return "UserAccountModel{" + "UserID=" + UserID + ", Passowrd=" + Passowrd + ", Role=" + Role + '}';
    }
    
    
    
}
