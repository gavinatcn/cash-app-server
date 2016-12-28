/**
 * Created by gavin on 2016/12/26.
 */

package com.yumi.cash.app.server;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yumi.cash.app.server.dal*")
@SpringBootApplication
public class CashAppServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CashAppServerApplication.class, args);
    }

}
