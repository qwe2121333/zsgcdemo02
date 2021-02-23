package com.hzs.boot.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//@MapperScan(basePackages = {"com.hzs.boot.user.dao"})
public class ZsgcdemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZsgcdemoApplication.class, args);
    }

}
