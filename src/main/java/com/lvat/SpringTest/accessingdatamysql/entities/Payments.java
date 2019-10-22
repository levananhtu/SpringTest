package com.lvat.SpringTest.accessingdatamysql.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lvat.SpringTest.accessingdatamysql.entities.keys.PaymentsKey;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Table(name = "payments")
@Entity(name = "Payments")
public class Payments implements Serializable {
    @EmbeddedId
    private PaymentsKey paymentsKey;

    @Column(name = "payment_date", nullable = false)
    private Calendar paymentDate;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @ManyToOne
//    @JoinColumn(name = "customer_number")
    @JoinColumn(referencedColumnName = "customer_number", name = "customer_number", insertable = false, updatable = false)
    private Customers customer;

    public Payments() {
    }

    public Payments(PaymentsKey paymentsKey, Calendar paymentDate, Double amount, Customers customer) {
        this.paymentsKey = paymentsKey;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.customer = customer;
    }

    public Payments(Long customerNumber, String checkNumber, Calendar paymentDate, Double amount, Customers customer) {
        this.paymentsKey = new PaymentsKey(customerNumber, checkNumber);
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.customer = customer;
    }

    public Calendar getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Calendar paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentsKey getPaymentsKey() {
        return paymentsKey;
    }

    public void setPaymentsKey(PaymentsKey paymentsKey) {
        this.paymentsKey = paymentsKey;
    }

    @JsonIgnore
    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }
}
