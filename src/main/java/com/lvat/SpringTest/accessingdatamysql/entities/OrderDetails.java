package com.lvat.SpringTest.accessingdatamysql.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lvat.SpringTest.accessingdatamysql.entities.keys.OrderDetailsKey;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "OrderDetails")
@Table(name = "order_details", indexes = {@Index(name = "product_code", columnList = "product_code")})
public class OrderDetails implements Serializable {
    @EmbeddedId
    private OrderDetailsKey orderDetailsKey;

    @Column(name = "quantity_ordered", nullable = false)
    private Long quantityOrdered;

    @Column(name = "price_each", nullable = false)
    private Double priceEach;

    @Column(name = "order_line_number", nullable = false)
    private Integer orderLineNumber;

    @ManyToOne
    @JoinColumn(referencedColumnName = "order_number", name = "order_number", insertable = false, updatable = false)
    @JsonBackReference
    private Orders order;

    @ManyToOne
    @JoinColumn(referencedColumnName = "product_code", name = "product_code", insertable = false, updatable = false)
    @JsonBackReference
    private Products product;

    public OrderDetails() {
    }

    public OrderDetails(OrderDetailsKey orderDetailsKey, Long quantityOrdered, Double priceEach, Integer orderLineNumber) {
        this.orderDetailsKey = orderDetailsKey;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    public OrderDetails(Long orderNumber, String productCode, Long quantityOrdered, Double priceEach, Integer orderLineNumber) {
        this.orderDetailsKey = new OrderDetailsKey(orderNumber, productCode);
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    public OrderDetailsKey getOrderDetailsKey() {
        return orderDetailsKey;
    }

    public void setOrderDetailsKey(OrderDetailsKey orderDetailsKey) {
        this.orderDetailsKey = orderDetailsKey;
    }

    public Long getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Long quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public Double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(Double priceEach) {
        this.priceEach = priceEach;
    }

    public Integer getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(Integer orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

//    @JsonIgnore
    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

//    @JsonIgnore
    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }
}
