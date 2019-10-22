package com.lvat.SpringTest.accessingdatamysql.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

@Table(name = "orders", indexes = {@Index(name = "customer_number", columnList = "customer_number")})
@Entity(name = "Orders")
public class Orders {
    @Id
    @Column(name = "order_number", nullable = false)
    private Long orderNumber;

    @Column(name = "order_date", nullable = false)
    private Calendar orderDate;

    @Column(name = "required_date", nullable = false)
    private Calendar requiredDate;

    @Column(name = "shipped_date")
    private Calendar shippedDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "comments")
    private String comments;

    @Column(name = "customer_number", nullable = false)
    private Integer customerNumber;

//    /***/
//    @ManyToMany
//    @JoinTable(name = "order_details",
//            joinColumns = {@JoinColumn(name = "order_number", nullable = false, table = "orderdetails")},
//            inverseJoinColumns = {@JoinColumn(name = "product_code", nullable = false, table = "orderdetails")})
//    private Collection<Products> productsCollection;
//    /***/
//    /*OR*/
    /***/
    @OneToMany(targetEntity = OrderDetails.class)
//    @JoinColumn(referencedColumnName = "order_number", name = "order_number", insertable = false, updatable = false)
    @JoinColumn(referencedColumnName = "order_number", name = "order_number")
    private Collection<OrderDetails> orderDetailsCollection;
    /***/

    @ManyToOne(targetEntity = Customers.class)
//    @JoinColumn(name = "customer_number",)
    @JoinColumn(referencedColumnName = "customer_number", name = "customer_number", insertable = false, updatable = false)
    private Customers customer;

    public Orders() {
    }

    public Orders(Long orderNumber, Calendar orderDate, Calendar requiredDate, Calendar shippedDate, String status, String comments, Integer customerNumber) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerNumber = customerNumber;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public Calendar getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Calendar requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Calendar getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Calendar shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

//    public Collection<Products> getProductsCollection() {
//        return productsCollection;
//    }
//
//    public void setProductsCollection(Collection<Products> productsCollection) {
//        this.productsCollection = productsCollection;
//    }

    public Collection<OrderDetails> getOrderDetailsCollection() {
        return orderDetailsCollection;
    }

    public void setOrderDetailsCollection(Collection<OrderDetails> orderDetailsCollection) {
        this.orderDetailsCollection = orderDetailsCollection;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Collection<Products> getProducts() {
        Collection<Products> productsCollection = new ArrayList<>();
        for (OrderDetails orderDetail : this.orderDetailsCollection) {
            productsCollection.add(orderDetail.getProduct());
        }
        return productsCollection;
    }
}