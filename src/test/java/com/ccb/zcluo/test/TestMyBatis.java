package com.ccb.zcluo.test;

import javax.annotation.Resource;

import com.ccb.zcluo.controller.UserController;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.ccb.zcluo.User;
import com.ccb.zcluo.service.IUserService;
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

/**
 * Created by luozc-kf1b on 2016/3/31.
 */
public class TestMyBatis {
    private static Logger logger = Logger.getLogger(TestMyBatis.class);

    @Resource(name = "userService")
    private IUserService userService;

    @Resource
    private UserController userController;



    @Test
    public void test(){
        User user = userService.getUserById(2);
        // System.out.println(user.getUserName());
        // logger.info("值："+user.getUserName());

        logger.info(JSON.toJSONString(user));
    }
}
