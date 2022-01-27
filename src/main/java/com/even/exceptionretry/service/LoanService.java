package com.even.exceptionretry.service;

import com.even.exceptionretry.entity.Loan;
import com.even.exceptionretry.entity.RLoan;
import com.even.exceptionretry.util.NoGenerateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LoanService {

    @Autowired
    private RLoan rLoan;

    @Autowired
    private NoGenerateUtil noGenerateUtil;

    public Loan createLoan(Loan loan) {
        loan.setBillNo(noGenerateUtil.generateCustId("B"));
        return rLoan.save(loan);
    }


    public Loan findLoanByBillNo(String billNo){
        return rLoan.findByBillNo(billNo);
    }


    public Loan updateLoan(Loan loan, BigDecimal amt){
        loan.setReceiveAmt(loan.getReceiveAmt().add(amt));
        return rLoan.save(loan);
    }

}
