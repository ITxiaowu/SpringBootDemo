package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
// 解决IDEA:Could not autowire. No beans of 'UserMapper' type found.
@Component(value = "UserMapper")
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
    User getUseById(@Param("userid") Integer userid);

    /**
     * 修改user对象
     * @param user user对象
     * @return
     */
    boolean updateUser(User user);

    /**
     * 根据编号删除user对象
     * @param userid user编号
     * @return
     */
    boolean deleteUseById(@Param("userid") Integer userid);
}