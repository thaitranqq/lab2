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
public class customer {
    private String customerID;
    private String customerName;
    private String customerAddress;
    private String customerPhone;

    public customer() {
    }

    public customer(String customerID, String customerName, String customerAddress, String customerPhone) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    public void stringFormat(){
        System.out.printf("|%-7s|%-25s|%-25s|%-10s|%n",customerID,customerName,customerAddress,customerPhone);
    }
    public String toString(){
        return getCustomerID()+","+getCustomerName()+","+getCustomerAddress()+","+getCustomerPhone();
    }
    public void stringFormatUpdate(){
        System.out.printf("%s%s%n%s%s%n%s%s%n%s%s%n%s%n","1.Customer Id:",getCustomerID(),"2.Name:",getCustomerName(),"3.Address:",getCustomerAddress(),"4.Phone:",getCustomerPhone(),"5.Quit");
    }
}
