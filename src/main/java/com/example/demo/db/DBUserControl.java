package com.example.demo.db;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
class DBUserControl {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DBUsers dbUsers;

    @PostMapping("/register22")
    private Users register(@Valid @RequestBody Users users) {
        return dbUsers.save(users);
    }

    @GetMapping("/getAllUser")
    public List<Users> getAllUser() {
        logger.info("DBUserControl getAllUser()");
        return dbUsers.findAll();
    }

    @GetMapping("/getUserInfo/{userId}")
    public Optional<Users> getUserInfo(@PathVariable Integer userId) {
        logger.info("DBUserControl getUserInfo()");
        return dbUsers.findById(userId);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users userInfo) {
        logger.info("DBUserControl getAllUser()");
        if (userInfo != null) {
            List<Users> userInfoList = dbUsers.findByUsername(userInfo.getUsername());
            if (userInfoList != null && userInfoList.size() > 0) {
                Users userInfo1 = userInfoList.get(0);
                if (userInfo1.getPwd().equals(userInfo.getPwd())) {
                    return "success";
                }
            }
        }
        return "failed";
    }

    @PostMapping("/update")
    public Users update(@RequestBody Users userInfo) {
        logger.info("DBUserControl update()");
        return dbUsers.save(userInfo);
    }
}
