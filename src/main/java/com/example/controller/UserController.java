package com.example.controller;

import com.example.dao.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    //@GetMapping("/getUserList")
    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ResponseBody
    public List<User> getUserList(){
        //System.out.println("Test");
        return userMapper.getUsetList();
    }
}
