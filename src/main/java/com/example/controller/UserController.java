package com.example.controller;

import com.example.model.User;
import com.example.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
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
        return  userMapper.getUsetList();
    }
}
