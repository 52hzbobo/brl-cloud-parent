package com.brl.web;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySource(dataId = "brl-cloud-base", autoRefreshed = true)
public class BrlCloudWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrlCloudWebApplication.class, args);
    }

}
