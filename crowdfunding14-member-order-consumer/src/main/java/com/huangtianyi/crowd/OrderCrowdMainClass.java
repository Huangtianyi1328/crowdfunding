package com.huangtianyi.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 启用Feign客户端功能
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OrderCrowdMainClass {
    public static void main(String[] args) {
        SpringApplication.run(OrderCrowdMainClass.class, args);
    }
}
