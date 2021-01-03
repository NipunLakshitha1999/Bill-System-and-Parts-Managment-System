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
public class CustomerPaymentModel {

    private String OrderID;
    private double Total;
    private double LastDiscount;
    private double LastAmount;
    private double CustomerPay;
    private double CustomerBalance;

    public CustomerPaymentModel() {
    }

    public CustomerPaymentModel(String OrderID, double Total, double LastDiscount, double LastAmount, double CustomerPay, double CustomerBalance) {
        this.OrderID = OrderID;
        this.Total = Total;
        this.LastDiscount = LastDiscount;
        this.LastAmount = LastAmount;
        this.CustomerPay = CustomerPay;
        this.CustomerBalance = CustomerBalance;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public double getLastDiscount() {
        return LastDiscount;
    }

    public void setLastDiscount(double LastDiscount) {
        this.LastDiscount = LastDiscount;
    }

    public double getLastAmount() {
        return LastAmount;
    }

    public void setLastAmount(double LastAmount) {
        this.LastAmount = LastAmount;
    }

    public double getCustomerPay() {
        return CustomerPay;
    }

    public void setCustomerPay(double CustomerPay) {
        this.CustomerPay = CustomerPay;
    }

    public double getCustomerBalance() {
        return CustomerBalance;
    }

    public void setCustomerBalance(double CustomerBalance) {
        this.CustomerBalance = CustomerBalance;
    }

    @Override
    public String toString() {
        return "CustomerPaymentModel{" + "OrderID=" + OrderID + ", Total=" + Total + ", LastDiscount=" + LastDiscount + ", LastAmount=" + LastAmount + ", CustomerPay=" + CustomerPay + ", CustomerBalance=" + CustomerBalance + '}';
    }
    
    

}
