package com.example.demo.db;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface DBUsers extends JpaRepository<Users, Integer> {

    public List<Users> findByUsername(String userName);

    public List<Users> findByPwd(String password);

    public List<Users> findByAge(String userName);

}
