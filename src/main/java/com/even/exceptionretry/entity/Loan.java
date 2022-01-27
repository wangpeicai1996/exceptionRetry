package com.even.exceptionretry.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Loan {
    private String billNo;
    private String custId;
    private String custName;
    private String certType;
    private String certNo;
    @JsonFormat(pattern = "yyyyMMdd")
    private Date lendingDate;
    private BigDecimal lendingAmt;
    private BigDecimal receiveAmt;
    private Integer version;


    @Id
    @Column(name = "bill_no")
    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    @Basic
    @Column(name = "cust_id")
    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    @Basic
    @Column(name = "cust_name")
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Basic
    @Column(name = "cert_type")
    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    @Basic
    @Column(name = "cert_no")
    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    @Basic
    @Column(name = "lending_date")
    public Date getLendingDate() {
        return lendingDate;
    }

    public void setLendingDate(Date lendingDate) {
        this.lendingDate = lendingDate;
    }

    @Basic
    @Column(name = "lending_amt")
    public BigDecimal getLendingAmt() {
        return lendingAmt;
    }

    public void setLendingAmt(BigDecimal lendingAmt) {
        this.lendingAmt = lendingAmt;
    }

    @Basic
    @Column(name = "version")
    @Version
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return version == loan.version && Objects.equals(billNo, loan.billNo) && Objects.equals(custId, loan.custId) && Objects.equals(custName, loan.custName) && Objects.equals(certType, loan.certType) && Objects.equals(certNo, loan.certNo) && Objects.equals(lendingDate, loan.lendingDate) && Objects.equals(lendingAmt, loan.lendingAmt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billNo, custId, custName, certType, certNo, lendingDate, lendingAmt, version);
    }

    @Basic
    @Column(name = "receiveAmt")
    public BigDecimal getReceiveAmt() {
        return receiveAmt;
    }

    public void setReceiveAmt(BigDecimal receiveAmt) {
        this.receiveAmt = receiveAmt;
    }
}
