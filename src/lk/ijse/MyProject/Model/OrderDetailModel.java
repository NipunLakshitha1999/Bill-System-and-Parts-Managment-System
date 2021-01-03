/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.MyProject.Model;

import java.util.ArrayList;

/**
 *
 * @author Nipun Lakshitha
 */
public class OrderDetailModel {
    private String OrderID;
    private String ItemID;
    private String ItemName;
    private double QTY;
    private double UnitPrice;
    private double Discount;
    private double price;

    public OrderDetailModel() {
    }

    public OrderDetailModel(String OrderID, String ItemID, String ItemName, double QTY, double UnitPrice, double Discount, double price) {
        this.OrderID = OrderID;
        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.QTY = QTY;
        this.UnitPrice = UnitPrice;
        this.Discount = Discount;
        this.price = price;
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

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double Discount) {
        this.Discount = Discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetailModel{" + "OrderID=" + OrderID + ", ItemID=" + ItemID + ", ItemName=" + ItemName + ", QTY=" + QTY + ", UnitPrice=" + UnitPrice + ", Discount=" + Discount + ", price=" + price + '}';
    }

    
    
}
