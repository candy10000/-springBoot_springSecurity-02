package com.tiantian.dao;


import com.tiantian.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (SysPermission)表数据库访问层
 *
 * @author makejava
 * @since 2019-07-14 18:49:34
 */
@Mapper
public interface SysPermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Select(" select p.*\n" +
            "        from Sys_User u\n" +
            "        LEFT JOIN sys_role_user sru on u.id= sru.Sys_User_id\n" +
            "        LEFT JOIN Sys_Role r on sru.Sys_Role_id=r.id\n" +
            "        LEFT JOIN Sys_permission_role spr on spr.role_id=r.id\n" +
            "        LEFT JOIN Sys_permission p on p.id =spr.permission_id\n" +
            "        where u.id=#{id}\n")
    List<SysPermission> queryByUserId(Integer id);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysPermission 实例对象
     * @return 对象列表
     */
    @Select("select * from Sys_permission")
    List<SysPermission> queryAll();



}