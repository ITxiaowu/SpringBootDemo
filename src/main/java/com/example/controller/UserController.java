package com.example.controller;

import com.example.bean.User;
import com.example.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
     * 修改回显，获取user对象
     * @param userid user编号
     * @param modelMap 回传的数据
     * @return
     */
    @RequestMapping(value = "/toUpdateUser", method = RequestMethod.GET)
    public String toUpdateUser(int userid,ModelMap modelMap){
        User user =userMapper.getUsetById(userid);
        modelMap.addAttribute("user",user);
        return "/userUpdate";
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