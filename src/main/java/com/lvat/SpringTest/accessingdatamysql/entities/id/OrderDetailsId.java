package com.lvat.SpringTest.accessingdatamysql.entities.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetailsId implements Serializable {
    @Column(name = "order_number", nullable = false)
    private Long orderNumber;

    @Column(name = "product_code", nullable = false)
    private String productCode;

    public OrderDetailsId() {
    }

    public OrderDetailsId(Long orderNumber, String productCode) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
