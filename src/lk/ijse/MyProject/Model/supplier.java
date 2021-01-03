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
public class supplier {
    private String supplierName;
    private String supplierID;
    private int contact;
    private String address;
    private String  email;

    /**
     * @return the supplierName
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param supplierName the supplierName to set
     */
    public supplier(String supplierName, String supplierID, int contact, String address, String email) {
        this.supplierName = supplierName;
        this.supplierID = supplierID;
        this.contact = contact;
        this.address = address;
        this.email = email;
    }

    public supplier() {
    }

    @Override
    public String toString() {
        return "supplier{" + "supplierName=" + supplierName + ", supplierID=" + supplierID + ", contact=" + contact + ", address=" + address + ", email=" + email + '}';
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * @return the supplierID
     */
    public String getSupplierID() {
        return supplierID;
    }

    /**
     * @param supplierID the supplierID to set
     */
    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    /**
     * @return the contact
     */
    public int getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(int contact) {
        this.contact = contact;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    

   

   
}
