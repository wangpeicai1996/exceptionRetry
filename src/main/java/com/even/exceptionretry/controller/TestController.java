package com.even.exceptionretry.controller;

import com.even.exceptionretry.annotation.Retry;
import com.even.exceptionretry.entity.CustInfo;
import com.even.exceptionretry.entity.Loan;
import com.even.exceptionretry.service.CustService;
import com.even.exceptionretry.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class TestController {

    @Autowired
    private CustService custService;
    @Autowired
    private LoanService loanService;


    @RequestMapping("/cust/{custName}/{certType}/{certNo}")
    public CustInfo addUser(@PathVariable String custName, @PathVariable String certType, @PathVariable String certNo) {
        return custService.createCust(custName, certType, certNo);
    }


    @RequestMapping("/loan")
    public Loan addLoan(@RequestBody Loan loan) {
        return loanService.createLoan(loan);
    }

    /**
     * ObjectOptimisticLockingFailureException 乐观锁异常
     *
     * @param billNo
     * @param amt
     * @return
     */

    @RequestMapping("/receive")
    @Retry(value = 10)
    public String receive(@RequestParam String billNo, @RequestParam BigDecimal amt) {
        System.out.println("开始扣款");
        if (amt.compareTo(BigDecimal.ZERO) < 0) {
            return "还款金额不合法";
        }
        Loan loan = loanService.findLoanByBillNo(billNo);
        if (loan == null) {
            return "借据不存在";
        } else {
            loanService.updateLoan(loan, amt);
            return "还款成功";
        }
    }

}
