package com.even.exceptionretry.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RLoan extends JpaRepository<Loan,String> {

    public Loan findByBillNo(String billNo);
}
