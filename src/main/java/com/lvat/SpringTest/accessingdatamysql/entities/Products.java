package com.lvat.SpringTest.accessingdatamysql.entities;

import javax.persistence.*;
import java.util.Collection;

public class Products {
    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private String quantityInStock;
    private String buyPrice;
    private String msrp;

    @ManyToMany
    @JoinTable(name = "orderdetails",
            inverseJoinColumns = {@JoinColumn(name = "order_number", nullable = false, table = "orderdetails")},
            joinColumns = {@JoinColumn(name = "product_code", nullable = false, table = "orderdetails")})
    private Collection<Orders> ordersCollection;

    @ManyToOne
    @JoinColumn(name = "product_line")
    private ProductLines lines;

    public Products() {
    }

    public Products(String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, String quantityInStock, String buyPrice, String msrp) {
        this.productCode = productCode;
        this.productName = productName;
        this.productLine = productLine;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.msrp = msrp;
    }

    public Products(String productName, String productLine, String productScale, String productVendor, String productDescription, String quantityInStock, String buyPrice, String msrp) {
        this.productName = productName;
        this.productLine = productLine;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.msrp = msrp;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(String quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    public String getMsrp() {
        return msrp;
    }

    public void setMsrp(String msrp) {
        this.msrp = msrp;
    }
}
