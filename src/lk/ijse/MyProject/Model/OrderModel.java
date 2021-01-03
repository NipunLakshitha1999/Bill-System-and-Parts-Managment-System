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
public class OrderModel {
     private String OrderID;
    private String OrderDate;
    private String CusID;
    private String UserID;
    private ArrayList<OrderDetailModel> list;

    public OrderModel() {
    }

    public OrderModel(String OrderID, String OrderDate, String CusID, String UserID, ArrayList<OrderDetailModel> list) {
        this.OrderID = OrderID;
        this.OrderDate = OrderDate;
        this.CusID = CusID;
        this.UserID = UserID;
        this.list = list;
    }

   

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getCusID() {
        return CusID;
    }

    public void setCusID(String CusID) {
        this.CusID = CusID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public ArrayList<OrderDetailModel> getList() {
        return list;
    }

    public void setList(ArrayList<OrderDetailModel> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "OrderModel{" + "OrderID=" + OrderID + ", OrderDate=" + OrderDate + ", CusID=" + CusID + ", UserID=" + UserID + ", list=" + list + '}';
    }
    
    
}