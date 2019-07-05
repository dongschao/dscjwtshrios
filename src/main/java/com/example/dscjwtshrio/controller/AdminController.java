package com.example.dscjwtshrio.controller;



import com.example.dscjwtshrio.model.ResultMap;
import com.example.dscjwtshrio.repository.UserRespository;
import com.example.dscjwtshrio.service.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description admin角色权限controller
 * @Date 2018-04-29
 * @Time 17:32
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final ResultMap resultMap;

    @Autowired
    public AdminController( ResultMap resultMap) {

        this.resultMap = resultMap;
    }
    @Autowired
    UserRespository respository;
    @Autowired
    private UserService service;
    @GetMapping("/getUser")
    @RequiresRoles("admin")
    public String getUser() {

//        List<String> list =  respository.findUser();
        return  "susscus";
    }

    /**
     * 封号操作
     */
//    @PostMapping("/banUser")
//    @RequiresRoles("admin")
//    public ResultMap updatePassword(String username) {
//        userMapper.banUser(username);
//        return resultMap.success().code(200).message("成功封号！");
//    }
}
