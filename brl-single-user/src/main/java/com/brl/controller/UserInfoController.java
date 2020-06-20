package com.brl.controller;

import com.brl.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 模块:【用户信息】
 * <p>
 * 开发: Bruce.Liu By 2020-06-20 16:28 Create
 */
@RestController
@RequestMapping(value = "/user/info")
public class UserInfoController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/getUserByAccount")
    private void getUserByAccount(@RequestParam(required = false) String account){
        userDao.findByUserNameXmlSql(account);
        System.err.println("getUserByAccount");
    }

    @GetMapping("/getUserById")
    private void getUserById(@RequestParam(required = false) Long userId){
        userDao.getById(userId);
        System.err.println("getUserById");
    }

}
