package com.even.exceptionretry.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RCustInfo extends JpaRepository<CustInfo,String> {
}
