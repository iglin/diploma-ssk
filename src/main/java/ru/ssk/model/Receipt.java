package ru.ssk.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by user on 06.06.2016.
 */
@Entity
@Table(name = "receipt")
public class Receipt {
    @Id
    @Column(name = "receipt_num", unique = true)
    private Long number;
    @Column(name = "payment_purpose", nullable = false)
    private String paymentPurpose;
    @Column(name = "date", nullable = false)
    private Date date;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agreement_num", nullable = false, unique = true)
    private Agreement agreement;

    public Receipt() {
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    public void setPaymentPurpose(String paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public void setAgreement(Agreement agreement) {
        this.agreement = agreement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receipt receipt = (Receipt) o;

        if (number != null ? !number.equals(receipt.number) : receipt.number != null) return false;
        if (paymentPurpose != null ? !paymentPurpose.equals(receipt.paymentPurpose) : receipt.paymentPurpose != null)
            return false;
        return date != null ? date.equals(receipt.date) : receipt.date == null;

    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (paymentPurpose != null ? paymentPurpose.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}