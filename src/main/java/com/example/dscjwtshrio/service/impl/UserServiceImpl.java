package com.example.dscjwtshrio.service.impl;

import com.example.dscjwtshrio.model.User;
import com.example.dscjwtshrio.repository.UserRespository;
import com.example.dscjwtshrio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRespository respository;
    @Override
    public User findByuUserName(String userName) {
        User user=respository.findByUsername(userName);

        return user;
    }

    @Override
    public String getRolePermission(String userName) {

        return respository.getRolePermission(userName);

    }

    @Override
    public List<String> getUser() {
        respository.findAll();
        return null;
    }
}
