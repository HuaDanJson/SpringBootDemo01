package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DBGirl extends JpaRepository<Girl, Integer> {

    public List<Girl> findByCupSize(String cupSize);

    public List<Girl> findByAge(int age);


}
