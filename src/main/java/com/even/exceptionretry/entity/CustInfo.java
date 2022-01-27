package com.even.exceptionretry.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cust_info", schema = "qol", catalog = "")
public class CustInfo {

    private String custId;
    private String custName;
    private String certType;
    private String certNo;

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustInfo custInfo = (CustInfo) o;
        return Objects.equals(custId, custInfo.custId) && Objects.equals(custName, custInfo.custName) && Objects.equals(certType, custInfo.certType) && Objects.equals(certNo, custInfo.certNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custId, custName, certType, certNo);
    }
}
