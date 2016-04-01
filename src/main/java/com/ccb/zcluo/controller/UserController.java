package com.ccb.zcluo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ccb.zcluo.User;
import com.ccb.zcluo.service.IUserService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;

/**
 * Created by luozc-kf1b on 2016/4/1.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request,Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model.addAttribute("user",user);
        return "showUser";
    }
    @ResponseBody
    @RequestMapping("/showName")
    public JSONPObject getName(HttpServletRequest request, String callbackParam){
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        return new JSONPObject(callbackParam,user);


    }

}
