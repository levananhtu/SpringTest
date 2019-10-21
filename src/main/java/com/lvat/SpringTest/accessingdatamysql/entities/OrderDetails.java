package com.lvat.SpringTest.accessingdatamysql.entities;

import com.lvat.SpringTest.accessingdatamysql.entities.id.OrderDetailsId;

import javax.persistence.*;

@Entity(name = "OrderDetails")
@Table(name = "order_details", indexes = {@Index(name = "product_code", columnList = "product_code")})
public class OrderDetails {
    @EmbeddedId
    private OrderDetailsId orderDetailsId;

    @Column(name = "quantity_ordered", nullable = false)
    private Long quantityOrdered;

    @Column(name = "price_each", nullable = false)
    private Double priceEach;

    @Column(name = "order_line_number", nullable = false)
    private Integer orderLineNumber;

    public OrderDetails() {
    }

    public OrderDetails(OrderDetailsId orderDetailsId, Long quantityOrdered, Double priceEach, Integer orderLineNumber) {
        this.orderDetailsId = orderDetailsId;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    public OrderDetailsId getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(OrderDetailsId orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
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
}
// **