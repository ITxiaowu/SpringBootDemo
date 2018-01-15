package com.example.mapper;

import com.example.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 获取所有对象的集合
     * @return
     */
    List<User> getUsetList();

    /**
     * user对象新增
     * @param user user对象
     * @return
     */
    boolean addUser(User user);

    /**
     * 根据编号查询user对象
     * @param userid user编号
     * @return
     */
    User getUsetById(@Param("userid") Integer userid);
}