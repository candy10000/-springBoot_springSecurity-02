package com.tiantian;

import com.tiantian.dao.SysPermissionDao;
import com.tiantian.dao.SysUserDao;
import com.tiantian.entity.SysPermission;
import com.tiantian.entity.SysRole;
import com.tiantian.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringsecurityApplicationTests {


    @Autowired
    SysUserDao sysUserDao;

    @Autowired
    SysPermissionDao sysPermissionDao;



    @Test
    public void contextLoads() throws SQLException {

//        SysUser  user= sysUserDao.findByName("admin");
//        System.out.println(user.toString());
//        List<SysRole> role =  user.getRoles();
//        System.out.println(role.toString());
        List<SysPermission>  list = sysPermissionDao.queryAll();
        List<SysPermission>  permission = sysPermissionDao.queryByUserId(1);

        System.out.println("jj");

 }

}
