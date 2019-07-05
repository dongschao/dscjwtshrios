package com.example.dscjwtshrio.service;

import com.example.dscjwtshrio.model.User;

import java.util.List;

public interface UserService {
    public User findByuUserName(String userName);
    String getRolePermission(String userName);
    List<String>getUser();
}
