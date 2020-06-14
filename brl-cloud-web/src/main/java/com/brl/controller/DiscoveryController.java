package com.brl.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.brl.dao.UserDao;
import com.brl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 模块:【discovery】
 * <p>
 * 开发: Bruce.Liu By 2020-06-14 16:35 Create
 */
@Controller
@RequestMapping("discovery")
public class DiscoveryController {

    @NacosInjected
    private NamingService namingService;


    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        String result = "Hi Get User";
        String userId = "15959276686";
        String key = "userKey:"+userId;
        if(redisTemplate.hasKey(key)){
            System.err.println("cache:"+redisTemplate.opsForValue().get(key));
            result+=" Cache ";
        }
        User u1 = userDao.getById(1L);
        User u2 = userDao.findByUserNameXmlSql("15959276686");

        result = result +"By Time:"+ System.currentTimeMillis();
        System.err.println(result);
        redisTemplate.opsForValue().set(key, result,60l , TimeUnit.SECONDS);

        return namingService.getAllInstances(serviceName);
    }
}
