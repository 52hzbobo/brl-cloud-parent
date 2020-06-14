package com.brl.dao;

import com.brl.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 模块:【类模块名称】
 * <p>
 * 开发: Bruce.Liu By 2018/11/12 上午8:26 Create
 */
@Mapper
public interface UserDao {

    @Select("select * from brl_user where user_id = #{userId}")
    User getById(@Param("userId") Long userId);

    User findByUserNameXmlSql(@Param("userName") String userName);
}
