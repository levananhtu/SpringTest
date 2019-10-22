package com.lvat.SpringTest.accessingdatamysql.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Table(name = "products",
        indexes = {@Index(name = "product_line", columnList = "product_line")})
@Entity(name = "Products")
public class Products {
    @Id
    @Column(name = "product_code", nullable = false)
    private String productCode;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_line", nullable = false)
    private String productLine;

    @Column(name = "product_scale", nullable = false)
    private String productScale;

    @Column(name = "product_vendor", nullable = false)
    private String productVendor;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "quantity_in_stock", nullable = false)
    private String quantityInStock;

    @Column(name = "buy_price", nullable = false)
    private String buyPrice;

    @Column(name = "MSRP", nullable = false)
    private String msrp;

//    /***/
//    @ManyToMany
//    @JoinTable(name = "order_details",
//            inverseJoinColumns = {@JoinColumn(name = "order_number", nullable = false, table = "orderdetails")},
//            joinColumns = {@JoinColumn(name = "product_code", nullable = false, table = "orderdetails")})
//    private Collection<Orders> ordersCollection;
//    /***/
//    /*OR*/
    /***/
    @OneToMany(targetEntity = OrderDetails.class)
//    @JoinColumn(referencedColumnName = "product_code", name = "product_code", insertable = false, updatable = false)
    @JoinColumn(referencedColumnName = "product_code", name = "product_code")
    private Collection<OrderDetails> orderDetailsCollection;
    /***/

    @ManyToOne
//    @JoinColumn(name = "product_line")
    @JoinColumn(referencedColumnName = "product_line", name = "product_line", insertable = false, updatable = false)
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

//    public Collection<Orders> getOrdersCollection() {
//        return ordersCollection;
//    }
//
//    public void setOrdersCollection(Collection<Orders> ordersCollection) {
//        this.ordersCollection = ordersCollection;
//    }

    public Collection<OrderDetails> getOrderDetailsCollection() {
        return orderDetailsCollection;
    }

    public void setOrderDetailsCollection(Collection<OrderDetails> orderDetailsCollection) {
        this.orderDetailsCollection = orderDetailsCollection;
    }

    public ProductLines getLines() {
        return lines;
    }

    public void setLines(ProductLines lines) {
        this.lines = lines;
    }

    public Collection<Orders> getOrders() {
        Collection<Orders> ordersCollection = new ArrayList<>();
        for (OrderDetails orderDetail :
                this.orderDetailsCollection) {
            ordersCollection.add(orderDetail.getOrder());
        }
        return ordersCollection;
    }
}
