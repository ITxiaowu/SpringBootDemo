package com.example.model;

/**
 * user对象实体
 *
 * @Author xierh
 * @Date 2018/1/18/018 17:42
 */
public class User {
    private String userid;

    private String username;

    private Integer userage;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }
}