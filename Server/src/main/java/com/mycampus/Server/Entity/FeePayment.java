package com.mycampus.Server.Entity;

import javax.persistence.*;

@Entity
public class FeePayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Invoice_No")
    private Long invoiceNo;

    public Long getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(Long invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    @Override
    public String toString() {
        return "FeePayment{" +
                "invoiceNo=" + invoiceNo +
                '}';
    }
}
