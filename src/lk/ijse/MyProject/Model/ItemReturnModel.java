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
public class ItemReturnModel {
    private String IRID;
    private String OrderID;
    private String ItemID;
    private String ItemName;
    private double QTY;
    private double price;

    public ItemReturnModel() {
    }

    public ItemReturnModel(String IRID, String OrderID, String ItemID, String ItemName, double QTY, double price) {
        this.IRID = IRID;
        this.OrderID = OrderID;
        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.QTY = QTY;
        this.price = price;
    }

    public String getIRID() {
        return IRID;
    }

    public void setIRID(String IRID) {
        this.IRID = IRID;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public double getQTY() {
        return QTY;
    }

    public void setQTY(double QTY) {
        this.QTY = QTY;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemReturnModel{" + "IRID=" + IRID + ", OrderID=" + OrderID + ", ItemID=" + ItemID + ", ItemName=" + ItemName + ", QTY=" + QTY + ", price=" + price + '}';
    }

    
    
    
   
   
    
}
