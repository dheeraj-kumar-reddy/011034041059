package com.mycampus.Server.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Fee")
public class FeePayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Invoice_No")
    private Long invoiceNo;

    @Column(name = "username")
    private Long username;

    @Column(name = "Amount_Paid")
    private Long amountPaid;

    @Column(name = "Payment_Date")
    private long paymentDate;

    @Column(name = "Payment_status")
    private int paymentStatus;

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

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

    public long getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(long paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "FeePayment{" +
                "invoiceNo=" + invoiceNo +
                ", username=" + username +
                ", amountPaid=" + amountPaid +
                ", paymentDate=" + paymentDate +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
