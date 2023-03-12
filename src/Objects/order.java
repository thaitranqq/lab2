/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Quang Thai
 */
public class order {
    private String orderId;
    private String customerID;
    private String productID;
    private int orderQuantity;
    private String orderDate;
    private boolean status;

    public order() {
    }

    public order(String orderId, String customerID, String productID, int orderQuantity, String orderDate, boolean status) {
        this.orderId = orderId;
        this.customerID = customerID;
        this.productID = productID;
        this.orderQuantity = orderQuantity;
        this.orderDate = orderDate;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getProductID() {
        return productID;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public String toString(){
        return getOrderId()+","+getCustomerID()+","+getProductID()+","+getOrderQuantity()+","+getOrderDate()+","+isStatus();
    }
    public void stringFormat(){
        System.out.printf("|%-7s|%-7s|%-7s|%-7s|%-15s|%-7s|%n",getOrderId(),getCustomerID(),getProductID(),getOrderQuantity(),getOrderDate(),isStatus());
    }
}
