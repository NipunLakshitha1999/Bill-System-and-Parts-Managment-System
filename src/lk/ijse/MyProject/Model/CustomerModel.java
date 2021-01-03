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
public class CustomerModel {
    private String CusID;
    private String CusName;
    private String CusAddress;
    private int CusContact;

    public CustomerModel() {
    }

    public CustomerModel(String CusID, String CusName, String CusAddress, int CusContact) {
        this.CusID = CusID;
        this.CusName = CusName;
        this.CusAddress = CusAddress;
        this.CusContact = CusContact;
    }

    public String getCusID() {
        return CusID;
    }

    public void setCusID(String CusID) {
        this.CusID = CusID;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String CusName) {
        this.CusName = CusName;
    }

    public String getCusAddress() {
        return CusAddress;
    }

    public void setCusAddress(String CusAddress) {
        this.CusAddress = CusAddress;
    }

    public int getCusContact() {
        return CusContact;
    }

    public void setCusContact(int CusContact) {
        this.CusContact = CusContact;
    }

    @Override
    public String toString() {
        return "CustomerModel{" + "CusID=" + CusID + ", CusName=" + CusName + ", CusAddress=" + CusAddress + ", CusContact=" + CusContact + '}';
    }
    
    

   

   
}
