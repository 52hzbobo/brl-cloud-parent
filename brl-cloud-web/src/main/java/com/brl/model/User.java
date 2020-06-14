package com.brl.model;

import lombok.Data;

import java.util.Date;

/**
 * 模块:【用户主表】
 * <p>
 * 开发: Bruce.Liu By 2018/11/12 上午8:23 Create
 */
@Data
public class User {

    private Long userId ;

    private String userName ;

    private String password ;

    private Date createTime ;

}
