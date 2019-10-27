package com.lvat.SpringTest.accessingdatamysql.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Table(name = "orders", indexes = {@Index(name = "customer_number", columnList = "customer_number")})
@Entity(name = "Orders")
public class Orders implements Serializable {
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
//    private List<Products> productsList;
//    /***/
//    /*OR*/
    /***/
    @OneToMany(targetEntity = OrderDetails.class)
//    @JoinColumn(referencedColumnName = "order_number", name = "order_number", insertable = false, updatable = false)
    @JoinColumn(referencedColumnName = "order_number", name = "order_number")
    private List<OrderDetails> orderDetailsList;
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

    //    public List<Products> getProductsList() {
//        return productsList;
//    }
//
//    public void setProductsList(List<Products> productsList) {
//        this.productsList = productsList;
//    }
    @JsonIgnore
    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    @JsonIgnore
    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public List<Products> getProducts() {
        List<Products> productsList = new ArrayList<>();
        for (OrderDetails orderDetail : this.orderDetailsList) {
            productsList.add(orderDetail.getProduct());
        }
        return productsList;
    }
}