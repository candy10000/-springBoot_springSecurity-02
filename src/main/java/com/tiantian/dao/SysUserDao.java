package com.tiantian.dao;


import com.tiantian.entity.SysUser;
import org.apache.ibatis.annotations.*;

import javax.validation.groups.ConvertGroup;
import java.util.List;

/**
 * (SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2019-07-14 09:10:38
 */
@Mapper
public interface SysUserDao {


  @Results({
          @Result(column = "name",property = "roles",many = @Many(select = "com.tiantian.annotation.SysRoleAnnotationInterface.querySysRoleByName")),
  })
    @Select("     select u.*\n" +
            "            ,r.name\n" +
            "    from Sys_User u\n" +
            "    LEFT JOIN sys_role_user sru on u.id= sru.Sys_User_id\n" +
            "    LEFT JOIN Sys_Role r on sru.Sys_Role_id=r.id\n" +
            "    where username= #{username}")
    SysUser findByName(String username);

  @Insert("insert into sys_user(username,password) value(#{username},#{password})")
  int insert(SysUser user);


}