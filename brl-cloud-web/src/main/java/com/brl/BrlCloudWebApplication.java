package com.brl;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableNacosDiscovery
@NacosPropertySource(dataId = "brl-cloud-base", autoRefreshed = true, type = ConfigType.YAML)
public class BrlCloudWebApplication {

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        SpringApplication.run(BrlCloudWebApplication.class, args);
        log.info(">>>>>>>> 启动成功！耗时："+(System.currentTimeMillis() - s)+"ms");
    }

}
