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
public class product {
    private String ProductID;
    private String productName;
    private String unit;
    private String origin;
    private float price;

    public product() {
    }

    public product(String ProductID, String productName, String unit, String origin, float price) {
        this.ProductID = ProductID;
        this.productName = productName;
        this.unit = unit;
        this.origin = origin;
        this.price = price;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductID() {
        return ProductID;
    }

    public String getProductName() {
        return productName;
    }

    public String getUnit() {
        return unit;
    }

    public String getOrigin() {
        return origin;
    }

    public float getPrice() {
        return price;
    }
    public void stringFormat(){
        System.out.printf("|%-7s|%-25s|%-25s|%-25s|%-12s|%n",ProductID,productName,unit,origin,price);
    }
}
