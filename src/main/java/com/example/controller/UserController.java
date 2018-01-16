package com.example.controller;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    //日志对象
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 主页
     * @return
     */
    @RequestMapping("/index")
    public String helloHtml(){
        return "/index";
    }


    /**
     * 获取user对象
     * @return
     */
    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserList(){
        return userMapper.getUsetList();
    }

    /**
     * 跳往新增页面
     * @return
     */
    @RequestMapping(value = "/toAddUser", method = RequestMethod.GET)
    public String toAddUser(){
        return "/userAdd";
    }

    /**
     * 执行user对象新增
     * @param user user对象
     * @return
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody User user){
        // 操作执行后的标识符
        String resultStr = "";
        try {
            boolean addResult = userMapper.addUser(user);
            if(addResult){
                resultStr = "succcess";
            }else{
                resultStr = "fail";
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            resultStr = "exception";
        }
        return resultStr;
    }

    /**
     * 跳转至user修改页面
     * @return
     */
    @RequestMapping(value = "/toUserUpdate", method = RequestMethod.GET)
    public String toUserUpdate(){
        return "/userUpdate";
    }

    /**
     * 修改回显，获取user对象
     * @param userid user编号
     * @return
     */
    @RequestMapping(value = "/getUserByUserId", method = RequestMethod.POST)
    @ResponseBody
    public User getUserByUserId(int userid){
        User user =userMapper.getUsetById(userid);
        return user;
    }

    /**
     * 执行User编辑
     * @param user
     * @return
     */
    @RequestMapping(value="/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(@RequestParam(value = "user", required = false) User user){
        // 操作执行后的标识符
        String resultStr = "";

        try{
            boolean updateResult = false;//userMapper.updateUser(user);
            if(updateResult){// 修改成功
                resultStr = "succcess";
            }else{// 修改失败
                resultStr = "fail";
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            resultStr = "exception";
        }
        return resultStr;
    }
}