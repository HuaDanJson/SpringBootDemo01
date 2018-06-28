package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface UserInfoControl extends JpaRepository<UserInfo, Integer> {

    public List<UserInfo> findAllByUsername(String useName);

    public List<UserInfo> findAllByPwd(String pwd);

}
