package com.lvat.SpringTest.accessingdatamysql.entities;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collection;

@Table(name = "orders", indexes = {@Index(name = "customer_number", columnList = "customer_number", unique = false)})
@Entity(name = "Orders")
public class Orders {
    @Id()
    @GeneratedValue
    private Long orderNumber;

    @Column(nullable = false)
    private Calendar orderDate;

    @Column(nullable = false)
    private Calendar requiredDate;

    @Column
    private Calendar shippedDate;

    @Column(nullable = false)
    private String status;

    @Column
    private String comments;

    @Column(nullable = false)
    private Integer customerNumber;

    @ManyToMany
    @JoinTable(name = "orderdetails",
            joinColumns = {@JoinColumn(name = "order_number", nullable = false, table = "orderdetails")},
            inverseJoinColumns = {@JoinColumn(name = "product_code", nullable = false, table = "orderdetails")})
    private Collection<Products> productsCollection;

    @OneToMany(mappedBy = "orders")
    private Collection<OrderDetails> orderDetailsCollection;

    @ManyToOne
    @JoinColumn(name = "customer_number")
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

    public Orders(Calendar orderDate, Calendar requiredDate, Calendar shippedDate, String status, String comments, Integer customerNumber) {
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
}
