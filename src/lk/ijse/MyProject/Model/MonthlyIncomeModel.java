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
public class MonthlyIncomeModel {
    private String OrderID;
    private String CusID;
    private String ItemID;
    private double qty;
    private double unitPrice;
    private double Discount;
    private double price;

    public MonthlyIncomeModel(String OrderID, String CusID, String ItemID, double qty, double unitPrice, double Discount, double price) {
        this.OrderID = OrderID;
        this.CusID = CusID;
        this.ItemID = ItemID;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.Discount = Discount;
        this.price = price;
    }

    public MonthlyIncomeModel() {
    }

    public MonthlyIncomeModel(String Year, String month) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getCusID() {
        return CusID;
    }

    public void setCusID(String CusID) {
        this.CusID = CusID;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
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
        return "MonthlyIncomeModel{" + "OrderID=" + OrderID + ", CusID=" + CusID + ", ItemID=" + ItemID + ", qty=" + qty + ", unitPrice=" + unitPrice + ", Discount=" + Discount + ", price=" + price + '}';
    }
    
    
}
