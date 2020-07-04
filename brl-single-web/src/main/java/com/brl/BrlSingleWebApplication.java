package com.brl;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableNacosDiscovery
@NacosPropertySource(dataId = "brl-cloud-base", autoRefreshed = true, type = ConfigType.YAML)
public class BrlSingleWebApplication implements CommandLineRunner {

    @NacosInjected
    private NamingService namingService;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private Integer serverPort;


    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        SpringApplication.run(BrlSingleWebApplication.class, args);
        log.info(">>>>>>>> brl-cloud-web 启动成功！耗时："+(System.currentTimeMillis() - s)+"ms");
    }

    @Override
    public void run(String... args) throws Exception {
        // 注册服务到Nacos(单体应用可以无需注册到nacos)
        namingService.registerInstance(applicationName, "127.0.0.1", serverPort);
    }
}
