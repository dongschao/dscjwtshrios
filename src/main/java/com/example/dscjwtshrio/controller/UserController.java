package com.example.dscjwtshrio.controller;


import com.example.dscjwtshrio.model.ResultMap;
import com.example.dscjwtshrio.model.User;
import com.example.dscjwtshrio.service.UserService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description user角色权限controller
 * @Date 2018-04-09
 * @Time 17:12
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final ResultMap resultMap;

    @Autowired
    public UserController( ResultMap resultMap) {

        this.resultMap = resultMap;
    }
    @Autowired
    private UserService service;
    /**
     * 拥有 user, admin 角色的用户可以访问下面的页面
     */
    @GetMapping("/getMessage")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    public ResultMap getMessage() {
        return resultMap.success().code(200).message("成功获得信息！");
    }
//
//    @PostMapping("/updatePassword")
//    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
//    public ResultMap updatePassword(String username, String oldPassword, String newPassword) {
//        User user=service.findByuUserName(username);
//        String dataBasePassword = user.getPassword();
//        if (dataBasePassword.equals(oldPassword)) {
//            userMapper.updatePassword(username, newPassword);
//        } else {
//            return resultMap.fail().message("密码错误！");
//        }
//        return resultMap.success().code(200).message("成功获得信息！");
//    }

    /**
     * 拥有 vip 权限可以访问该页面
     */
    @GetMapping("/getVipMessage")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    @RequiresPermissions("vip")
    public ResultMap getVipMessage() {
        return resultMap.success().code(200).message("成功获得 vip 信息！");
    }
}
