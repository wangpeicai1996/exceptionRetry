package com.even.exceptionretry.service;

import com.even.exceptionretry.entity.CustInfo;
import com.even.exceptionretry.entity.RCustInfo;
import com.even.exceptionretry.util.NoGenerateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustService {

    @Autowired
    private RCustInfo rCustInfo;
    @Autowired
    private NoGenerateUtil noGenerateUtil;

    public CustInfo createCust(String custName, String certType, String certNo) {
        CustInfo custInfo = new CustInfo();
        custInfo.setCustId(noGenerateUtil.generateCustId(certType));
        custInfo.setCustName(custName);
        custInfo.setCertType(certType);
        custInfo.setCertNo(certNo);
        CustInfo result = rCustInfo.save(custInfo);
        return result;
    }

}
