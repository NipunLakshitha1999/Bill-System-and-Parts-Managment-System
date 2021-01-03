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
public class UserDetailModel {
    private String Name;
    private String NIC;
    private String Address;
    private int contact;
    private String UserID;

    public UserDetailModel() {
    }

    public UserDetailModel(String Name, String NIC, String Address, int contact, String UserID) {
        this.Name = Name;
        this.NIC = NIC;
        this.Address = Address;
        this.contact = contact;
        this.UserID = UserID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    @Override
    public String toString() {
        return "UserDetailModel{" + "Name=" + Name + ", NIC=" + NIC + ", Address=" + Address + ", contact=" + contact + ", UserID=" + UserID + '}';
    }
    
    
    
}

