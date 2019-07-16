package com.tiantian.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2019-07-14 09:10:36
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = 639346616864218614L;
    
    private Integer id;
    private String username;
    private String password;
    private List<SysRole> roles;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}