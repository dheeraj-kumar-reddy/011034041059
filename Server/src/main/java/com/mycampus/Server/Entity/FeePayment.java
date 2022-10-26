package com.mycampus.Server.Entity;

import javax.persistence.*;

@Entity
public class FeePayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Invoice_No")
    private Long invoiceNo;

    @Column(name = "username")
    private Long username;

    @Column(name = "Amount_Paid")
    private Long amountPaid;

    public Long getInvoiceNo() {
        return invoiceNo;
    }

    public Long getUsername() {
        return username;
    }

    public void setUsername(Long username) {
        this.username = username;
    }

    public Long getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Long amountPaid) {
        this.amountPaid = amountPaid;
    }

    public void setInvoiceNo(Long invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    @Override
    public String toString() {
        return "FeePayment{" +
                "invoiceNo=" + invoiceNo +
                ", username=" + username +
                ", amountPaid=" + amountPaid +
                '}';
    }
}
