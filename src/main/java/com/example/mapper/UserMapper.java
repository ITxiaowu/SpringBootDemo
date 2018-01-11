package com.example.mapper;

import com.example.dao.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getUsetList();
}