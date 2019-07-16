package com.tiantian.service;

import com.tiantian.dao.SysPermissionDao;
import com.tiantian.dao.SysUserDao;
import com.tiantian.entity.SysPermission;

import com.tiantian.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    SysUserDao sysUserDao;

    @Autowired
    SysPermissionDao permissionDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = sysUserDao.findByName(s);

        if (user != null){
        List<SysPermission> permissions = permissionDao.queryByUserId(user.getId());
        List<SimpleGrantedAuthority> authorities = new ArrayList();
        //add user right to authorities

        for (SysPermission permission:permissions){
            if (permission != null && permission.getName() != null){
                SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName()) ;
                authorities.add(grantedAuthority);
            }
        }
            return new User(user.getUsername(),user.getPassword(),authorities);
        }else {
            throw  new UsernameNotFoundException("user not exist");
        }

    }
}
