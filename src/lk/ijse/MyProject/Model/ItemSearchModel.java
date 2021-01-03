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
public class ItemSearchModel {
    private String code;
    private String name;
    private double UnitPrice;
    private int QTYOnHand;

    public ItemSearchModel() {
    }

    public ItemSearchModel(String code, String name, double UnitPrice, int QTYOnHand) {
        this.code = code;
        this.name = name;
        this.UnitPrice = UnitPrice;
        this.QTYOnHand = QTYOnHand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "ItemSearchModel{" + "code=" + code + ", name=" + name + ", UnitPrice=" + UnitPrice + ", QTYOnHand=" + QTYOnHand + '}';
    }
    

   
    
}
