package com.example.demo.db;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
class DBUserControl {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DBUsers dbUsers;

    @PostMapping("/register22")
    private Users register(@Valid @RequestBody Users users) {
        return dbUsers.save(users);
    }
}
