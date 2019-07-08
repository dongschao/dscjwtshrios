package com.example.dscjwtshrio.controller;

import com.example.dscjwtshrio.model.ResultMap;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vip")
public class VipController {
    private final ResultMap resultMap;

    @Autowired
    public VipController( ResultMap resultMap) {

        this.resultMap = resultMap;
    }
    @GetMapping("/getVip")
//    @RequiresPermissions("vip")
    @RequiresPermissions(logical = Logical.OR, value = {"vip", "normal"})
    public ResultMap getMessage() {
        return resultMap.success().code(200).message("成功获得vip信息！");
    }

}
