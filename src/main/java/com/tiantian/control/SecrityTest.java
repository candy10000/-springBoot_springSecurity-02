package com.tiantian.control;

import com.tiantian.dao.SysUserDao;
import com.tiantian.entity.Msg;
import com.tiantian.entity.SysUser;
import com.tiantian.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SecrityTest {

    @Autowired
    SysUserDao sysUserDao;

    @RequestMapping("/index")
    public String index(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息", "管理员");
        model.addAttribute("msg", msg);
        return "index";
    }


    @ResponseBody
    @RequestMapping("/test1")
    public String test1() {

        return "masg test1";
    }

    @RequestMapping("/reg")
    public String register(HttpServletRequest request ){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        password = MD5Util.encode(password);

        System.out.println("password"+password+"username"+username);
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setPassword(password);
        sysUserDao.insert(sysUser);
        return "login";
    }


    @ResponseBody
    @RequestMapping("/test")
    public String test() {

        return "masg test";
    }

    @RequestMapping("/login")
    public String userLogin() {
        return "login";
    }
}
