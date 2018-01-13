package com.example.controller;

import com.example.dao.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/index")
    public String helloHtml(){
        return "/index";
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserList(){
        return userMapper.getUsetList();
    }

    @RequestMapping(value = "/toAddUser", method = RequestMethod.GET)
    public String toAddUser(){
        return "/userAdd";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String updateUser(int userid,ModelMap modelMap){
        User user =userMapper.getUsetById(userid);
        modelMap.addAttribute("user",user);
        return "/userUpdate";
    }
}