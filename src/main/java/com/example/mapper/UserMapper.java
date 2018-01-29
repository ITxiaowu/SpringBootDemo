package com.example.mapper;

import com.example.model.User;
import com.example.util.PageModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * user mapper接口类
 *
 * @Author xierh
 * @Date 2018/1/18/018 17:39
 */
@Mapper
// 解决IDEA:Could not autowire. No beans of 'UserMapper' type found.
@Component(value = "UserMapper")
public interface UserMapper {
    /**
     * 获取所有对象的集合（分页）
     *
     * @return
     */
    List<User> getUsetList(PageModel<User> pageModel);
    // 分页对象  数据总条数
    int getUsetCount(PageModel<User> pageModel);

    /**
     * user对象新增
     *
     * @param user user对象
     * @return
     */
    boolean addUser(User user);

    /**
     * 根据编号查询user对象
     *
     * @param userid user编号
     * @return
     */
    User getUseById(@Param("userid") String userid);

    /**
     * 修改user对象
     *
     * @param user user对象
     * @return
     */
    boolean updateUser(User user);

    /**
     * 根据编号删除user对象
     *
     * @param userid user编号
     * @return
     */
    boolean deleteUseById(@Param("userid") String userid);
}