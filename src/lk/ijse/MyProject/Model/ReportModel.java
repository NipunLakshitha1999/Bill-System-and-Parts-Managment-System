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
public class ReportModel {
    private String ItemName;
    private String ItemID;
    private double QTY;

    public ReportModel() {
    }

    public ReportModel(String ItemName, String ItemID, double QTY) {
        this.ItemName = ItemName;
        this.ItemID = ItemID;
        this.QTY = QTY;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }

    public double getQTY() {
        return QTY;
    }

    public void setQTY(double QTY) {
        this.QTY = QTY;
    }

    @Override
    public String toString() {
        return "ReportModel{" + "ItemName=" + ItemName + ", ItemID=" + ItemID + ", QTY=" + QTY + '}';
    }
    
    
}
