package com.tiantian.annotation;
import com.tiantian.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//com.tiantian.annotation.SysRoleAnnotationInterface.querySysRoleByName

import java.util.List;

@Mapper
public interface SysRoleAnnotationInterface {

    @Select("select * from sys_role where name = #{0}")
    public List<SysRole> querySysRoleByName();
}
