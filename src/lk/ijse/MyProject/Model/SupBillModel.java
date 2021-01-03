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
public class SupBillModel {
    private String SPID;
    private String SupplierID;
    private String SupBillDate;
    private String ItemID;
    private double SupplyQTY;
    private double unitPrice;
    private double Payment;

    public SupBillModel() {
    }

    public SupBillModel(String SPID, String SupplierID, String SupBillDate, String ItemID, double SupplyQTY, double unitPrice, double Payment) {
        this.SPID = SPID;
        this.SupplierID = SupplierID;
        this.SupBillDate = SupBillDate;
        this.ItemID = ItemID;
        this.SupplyQTY = SupplyQTY;
        this.unitPrice = unitPrice;
        this.Payment = Payment;
    }

    public String getSPID() {
        return SPID;
    }

    public void setSPID(String SPID) {
        this.SPID = SPID;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String SupplierID) {
        this.SupplierID = SupplierID;
    }

    public String getSupBillDate() {
        return SupBillDate;
    }

    public void setSupBillDate(String SupBillDate) {
        this.SupBillDate = SupBillDate;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }

    public double getSupplyQTY() {
        return SupplyQTY;
    }

    public void setSupplyQTY(double SupplyQTY) {
        this.SupplyQTY = SupplyQTY;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getPayment() {
        return Payment;
    }

    public void setPayment(double Payment) {
        this.Payment = Payment;
    }

    @Override
    public String toString() {
        return "SupBillModel{" + "SPID=" + SPID + ", SupplierID=" + SupplierID + ", SupBillDate=" + SupBillDate + ", ItemID=" + ItemID + ", SupplyQTY=" + SupplyQTY + ", unitPrice=" + unitPrice + ", Payment=" + Payment + '}';
    }

   
    
}
