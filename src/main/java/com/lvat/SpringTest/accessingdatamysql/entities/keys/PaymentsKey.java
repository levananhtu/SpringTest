package com.lvat.SpringTest.accessingdatamysql.entities.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PaymentsKey implements Serializable {
    @Column(name = "customer_number", nullable = false)
    private Long customerNumber;

    @Column(name = "check_number", nullable = false)
    private String checkNumber;

    public PaymentsKey() {
    }

    public PaymentsKey(Long customerNumber, String checkNumber) {
        this.customerNumber = customerNumber;
        this.checkNumber = checkNumber;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }
}
