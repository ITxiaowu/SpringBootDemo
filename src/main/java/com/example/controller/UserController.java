package com.example.controller;

import com.example.exception.Bean.ExceptionBean;
import com.example.exception.Bean.MyException;
import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.util.PageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * user对象控制层
 *
 * @Author xierh
 * @Date 2018/1/18/018 17:28
 */
@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    //日志对象
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    /***
     * 跳往主页
     *
     * @return
     * @throws MyException
     */
    @RequestMapping("/index")
    public String index() throws MyException {
        // 测试异常处理(errorCode可设置成固定的常量)
        // int a = 1/0;
        // throw new MyException (1001,"发生错误了....");

        return "/index";
    }

    /***
     * 获取user对象
     *
     * @param pageNo 当前页
     * @return
     */
    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    @ResponseBody
    public ModelMap getUserList(int pageNo){
        PageModel<User> pageModel = new PageModel<User>();
        pageModel.setPageNo(pageNo);
        pageModel.setTotalCount(userMapper.getUsetCount(pageModel));
        List<User> userList = userMapper.getUsetList(pageModel);

        ModelMap modelMap = new ModelMap();
        modelMap.put("userList",userList);
        modelMap.put("totlePage",pageModel.getTotalPage());
        return modelMap;
    }

    /***
     * 跳往新增页面
     *
     * @return
     */
    @RequestMapping(value = "/toAddUser", method = RequestMethod.GET)
    public String toAddUser(){
        return "/userAdd";
    }

    /**
     * 执行user对象新增
     *
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
     *
     * @return
     */
    @RequestMapping(value = "/toUserUpdate", method = RequestMethod.GET)
    public String toUserUpdate(){
        return "/userUpdate";
    }

    /**
     * 修改回显，获取user对象
     *
     * @param userid user编号
     * @return
     */
    @RequestMapping(value = "/getUserByUserId", method = RequestMethod.POST)
    @ResponseBody
    public User getUserByUserId(int userid){
        User user =userMapper.getUseById(userid);
        return user;
    }

    /**
     * 执行User编辑
     *
     * @param user
     * @return
     */
    @RequestMapping(value="/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(@RequestBody User user){
        // 操作执行后的标识符
        String resultStr = "";

        try{
            boolean updateResult = userMapper.updateUser(user);
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

    /**
     * 执行User删除
     *
     * @param userid user编号
     * @return
     */
    @RequestMapping(value="/deleteUser",method = RequestMethod.GET)
    @ResponseBody
    public String deleteUser(int userid){
        // 操作执行后的标识符
        String resultStr = "";

        try{
            boolean deleteResult = userMapper.deleteUseById(userid);
            if(deleteResult){// 删除成功
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