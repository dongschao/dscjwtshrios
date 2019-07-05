package com.example.dscjwtshrio.repository;

import com.example.dscjwtshrio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRespository extends JpaRepository<User,Long> {
    User findByUsername(String userName);
    @Transactional
//    @Modifying
    @Query(value = "SELECT role.permission FROM blog.user,blog.role where username = ?1 AND role.role = user.role", nativeQuery = true)
    String getRolePermission(String userName);

    @Transactional
    @Query(value = "SELECT role.username FROM blog.user", nativeQuery = true)
    String findUser();

}
