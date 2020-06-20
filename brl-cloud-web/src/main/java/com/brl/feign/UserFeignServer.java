package com.brl.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 模块:【用户服务】
 * <p>
 * 开发: Bruce.Liu By 2020-06-20 17:10 Create
 */
//@FeignClient(name = "brl-cloud-user",value = "brl-cloud-user")
public interface UserFeignServer {

    @GetMapping("/getUserByAccount")
    void getUserByAccount(@RequestParam(required = false) String account);
}
