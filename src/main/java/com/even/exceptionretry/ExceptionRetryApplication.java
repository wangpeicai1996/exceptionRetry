package com.even.exceptionretry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 乐观锁重试机制测试
 */
@SpringBootApplication
public class ExceptionRetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExceptionRetryApplication.class, args);
    }

}
