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
public class ItemModel {
    
    private String Code;
    private String Name;
    private double UnitPrice;
    private int QTYOnHand;

    public ItemModel() {
    }

    public ItemModel(String Code, String Name, double UnitPrice, int QTYOnHand) {
        this.Code = Code;
        this.Name = Name;
        this.UnitPrice = UnitPrice;
        this.QTYOnHand = QTYOnHand;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getQTYOnHand() {
        return QTYOnHand;
    }

    public void setQTYOnHand(int QTYOnHand) {
        this.QTYOnHand = QTYOnHand;
    }

    @Override
    public String toString() {
        return "ItemModel{" + "Code=" + Code + ", Name=" + Name + ", UnitPrice=" + UnitPrice + ", QTYOnHand=" + QTYOnHand + '}';
    }

    
    
    
}
