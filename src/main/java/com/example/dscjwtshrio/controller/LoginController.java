package com.example.dscjwtshrio.controller;

import com.example.dscjwtshrio.model.ResultMap;
import com.example.dscjwtshrio.model.User;
import com.example.dscjwtshrio.service.UserService;
import com.example.dscjwtshrio.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2018-04-29
 * @Time 13:20
 */
@RestController
public class LoginController {
//    private final UserMapper userMapper;
    private final ResultMap resultMap;
//
    @Autowired
    public LoginController( ResultMap resultMap) {

        this.resultMap = resultMap;
    }
@Autowired
private UserService service;
    @PostMapping("/login")
    public ResultMap login(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        User user=service.findByuUserName(username);
        String realPassword = user.getPassword();
        if (realPassword == null) {
            return resultMap.fail().code(401).message("用户名错误");
        } else if (!realPassword.equals(password)) {
            return resultMap.fail().code(401).message("密码错误");
        } else {
            return resultMap.success().code(200).message(JWTUtil.createToken(username));
        }
    }

    @RequestMapping(path = "/unauthorized/{message}")
    public ResultMap unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        return resultMap.success().code(401).message(message);
    }
}
